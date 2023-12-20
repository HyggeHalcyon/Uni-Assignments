-- check 1
ALTER TABLE
  country 
ADD 
  CONSTRAINT CHK_NoSameCode2 
CHECK(
    Code <> Code2
)
