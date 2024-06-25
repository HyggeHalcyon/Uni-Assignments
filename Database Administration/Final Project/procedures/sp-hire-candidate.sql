CREATE OR ALTER PROCEDURE "HumanResources"."sp_HIRE_CANDIDATE"
    -- Candidate
    @JobCandidateID INT,

    -- DepartmentHistory
    @DepartmentID INT,
    @ShiftID INT,
    
    -- Employee 
    @NationalIDNumber NVARCHAR(15),
    @MaritalStatus NVARCHAR(1), -- M = Married, S = Single
    @Gender NVARCHAR(1),        -- M = Male, F = Female
    @SalariedFlag INT,          -- Job classification. 0 = Hourly, not exempt from collective bargaining. 1 = Salaried, exempt from collective bargaining.
    @VacationHours SMALLINT, 
    @SickLeaveHours SMALLINT,
    @HireDate DATE,
    @BirthDate DATE,

    -- PayHistory
    @Salary MONEY,
    @PayFrequency TINYINT       -- 1 = Salary received monthly, 2 = Salary received biweekly 
AS
BEGIN
    DECLARE 
        @BusinessEntityID INT,
        @AddressID INT,
        @Street NVARCHAR(50),
        @City NVARCHAR(50),
        @PostalCode NVARCHAR(15),
        @StateCode NVARCHAR(2),
        @FirstName NVARCHAR(50),
        @MiddleName NVARCHAR(50),
        @LastName NVARCHAR(50),
        @Suffix NVARCHAR(50),
        @Email NVARCHAR(50),
        @LoginID NVARCHAR(50),
        @JobTitle NVARCHAR(50);
    
    BEGIN TRANSACTION;
    BEGIN TRY
        WITH XMLNAMESPACES(
            'http://schemas.microsoft.com/sqlserver/2004/07/adventure-works/Resume' AS ns
        )
        SELECT 
            @FirstName = JC.Resume.value('(/ns:Resume/ns:Name/ns:Name.First)[1]', 'NVARCHAR(50)'),
            @MiddleName = JC.Resume.value('(/ns:Resume/ns:Name/ns:Name.Middle)[1]', 'NVARCHAR(50)'),
            @LastName = JC.Resume.value('(/ns:Resume/ns:Name/ns:Name.Last)[1]', 'NVARCHAR(50)'),
            @Suffix = JC.Resume.value('(/ns:Resume/ns:Name/ns:Name.Suffix)[1]', 'NVARCHAR(50)'),
            @Email = JC.Resume.value('(/ns:Resume/ns:EMail)[1]', 'NVARCHAR(50)'),
            @StateCode = JC.Resume.value('(/ns:Resume/ns:Address/ns:Addr.Location/ns:Location/ns:Loc.State)[1]', 'NVARCHAR(2)'),
            @City = JC.Resume.value('(/ns:Resume/ns:Address/ns:Addr.Location/ns:Location/ns:Loc.City)[1]', 'NVARCHAR(50)'),
            @Street = JC.Resume.value('(/ns:Resume/ns:Address/ns:Addr.Street)[1]', 'NVARCHAR(50)'),
            @PostalCode = JC.Resume.value('(/ns:Resume/ns:Address/ns:Addr.PostalCode)[1]', 'NVARCHAR(15)'),
            @JobTitle = JC.Resume.value('(/ns:Resume/ns:Employment/ns:Emp.JobTitle)[1]', 'NVARCHAR(50)')
        FROM 
            HumanResources.JobCandidate AS JC
        WHERE 
            JC.JobCandidateID = @JobCandidateID;

        -- new business entity
        INSERT INTO "Person"."BusinessEntity"
        DEFAULT VALUES;
        SET @BusinessEntityID = SCOPE_IDENTITY();

        INSERT INTO "Person"."Person"
            ("BusinessEntityID", "FirstName", "MiddleName", "LastName", "Suffix", "PersonType")
        VALUES
            (@BusinessEntityID, @FirstName, @MiddleName, @LastName, @Suffix, 'EM');

        -- insert email bruv
        INSERT INTO "Person"."EmailAddress"
            ("BusinessEntityID", "EmailAddress")
        VALUES
            (@BusinessEntityID, @Email);
        
        -- insert Address
        INSERT INTO "Person"."Address"
            ("AddressLine1", "City", "StateProvinceID", "PostalCode")
        VALUES
            (
                @Street, 
                @City, 
                (SELECT "StateProvinceID" FROM "Person"."StateProvince" WHERE "StateProvinceCode" = @StateCode), 
                @PostalCode
            );
        SET @AddressID = SCOPE_IDENTITY();

        -- link address
        INSERT INTO "Person"."BusinessEntityAddress"
            ("BusinessEntityID", "AddressID", "AddressTypeID")
        VALUES
            (@BusinessEntityID, @AddressID, 2); -- 2 = Home

        SET @LoginID = 'adventure-works\\' + @FirstName + '.' + @LastName
        INSERT INTO "HumanResources"."Employee"
            ("BusinessEntityID", "NationalIDNumber", "LoginID", "JobTitle", "BirthDate", "MaritalStatus", "Gender", "HireDate", "SalariedFlag", "VacationHours", "SickLeaveHours", "CurrentFlag")
        VALUES
            (
                @BusinessEntityID, 
                @NationalIDNumber, 
                @LoginID, 
                @JobTitle, 
                @BirthDate, 
                @MaritalStatus,
                @Gender,
                @HireDate,
                @SalariedFlag,
                @VacationHours,
                @SickLeaveHours,
                1 -- active 
            );

        INSERT INTO "HumanResources"."EmployeeDepartmentHistory"
            ("BusinessEntityID", "DepartmentID", "ShiftID", "StartDate")
        VALUES
            (@BusinessEntityID, @DepartmentID, @ShiftID, @HireDate);

        INSERT INTO "HumanResources"."EmployeePayHistory"
            ("BusinessEntityID", "RateChangeDate", "Rate", "PayFrequency")
        VALUES
            (@BusinessEntityID, GETDATE(), @Salary, @PayFrequency);

        UPDATE "HumanResources"."JobCandidate"
        SET "BusinessEntityID" = @BusinessEntityID
        WHERE "JobCandidateID" = @JobCandidateID;

        COMMIT TRANSACTION;
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0 ROLLBACK TRANSACTION;  
        DECLARE @ErrorMessage NVARCHAR(4000), @ErrorState INT;

        SELECT 
            @ErrorMessage = ERROR_MESSAGE(),
            @ErrorState = ERROR_STATE();

        -- Throw the error again to propagate it
        THROW 77777, @ErrorMessage, @ErrorState;
    END CATCH;
END;