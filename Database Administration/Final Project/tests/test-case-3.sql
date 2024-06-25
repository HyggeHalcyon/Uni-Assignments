EXEC "HumanResources"."sp_HIRE_CANDIDATE"
    @JobCandidateID = 9,
    @DepartmentID = 1,
    @ShiftID = 1,
    @NationalIDNumber = '12345a789',
    @MaritalStatus = 'M',
    @Gender = 'M',
    @SalariedFlag = 1,
    @VacationHours = 40,
    @SickLeaveHours = 40,
    @HireDate = '2020-01-01',
    @BirthDate = '1990-01-01',
    @Salary = 175,
    @PayFrequency = 1;