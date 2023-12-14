-- Trigger 1
CREATE TRIGGER TRG_CacheOldGNP
    BEFORE UPDATE ON country
    FOR EACH ROW
BEGIN
    SET NEW.`GNPOld` = OLD.`GNP`;
END

-- Trigger 2
CREATE TRIGGER TRG_PopulationCeilingCheck
    BEFORE INSERT ON city
    FOR EACH ROW
BEGIN
    DECLARE current_sum_population INT;
    DECLARE error_message VARCHAR(255);

    SELECT SUM(`Population`) INTO current_sum_population
    FROM city 
    WHERE `CountryCode` = NEW.`CountryCode`;

    SET error_message  = CONCAT(
        'Population of ', 
        NEW.`Name`, 
        ' is too large'
    );

    IF current_sum_population + NEW.`Population` > (
        SELECT `Population` 
        FROM country 
        WHERE `Code` = NEW.`CountryCode`
    ) THEN
        SIGNAL SQLSTATE '45000' 
            SET MESSAGE_TEXT = error_message;
    END IF;
END

-- TEST TRIGGER-2 FAILED
INSERT INTO world.city VALUES (4081, 'Test City', 'ABW', 'Test District', 1000000);

-- TEST TRIGGER-2 SUCCESS
INSERT INTO world.city VALUES (4080, 'Test City', 'ABW', 'Test District', 100);
