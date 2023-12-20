-- View 1
CREATE VIEW officialLanguage AS 
SELECT 
  C.`Name` AS `Country Name`, 
  CL.`Language` AS `Official Language`, 
  CL.`percentage` AS `% speaking` 
FROM 
  country C 
JOIN 
  countrylanguage CL ON C.`code` = CL.`countryCode` 
WHERE 
  CL.`isOfficial` = 'T';

-- View 2
CREATE VIEW continentOverview AS
SELECT 
  C.`Continent`, 
  COUNT(DISTINCT C.`Name`) AS `# of Countries`, 
  COUNT(DISTINCT CL.`Language`) AS `# of Languages` 
FROM 
  country C 
JOIN 
  countrylanguage CL ON C.`code` = CL.`countryCode` 
GROUP BY 
  C.`Continent`;

-- View 3
CREATE VIEW countryPop AS
SELECT 
  C.`Name` AS `Country Name`,
  Ct.`Name` AS `Capital City`,
  C.`Population` AS `Population`,
  Ct.`Population` AS `Known City Population`
FROM 
  city Ct
JOIN 
  country C ON C.`Capital` = Ct.`ID`