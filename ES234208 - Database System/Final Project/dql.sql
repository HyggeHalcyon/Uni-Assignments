-- Retrieve all workers with their positions:
SELECT 
  "Nama", 
  "Posisi" 
FROM 
  "Pekerja" 
  JOIN "Pengurus" ON "Pekerja"."NIK" = "Pengurus"."NIK";

-- Retrieve all volunteers and their motivations:
SELECT 
  "Nama", 
  "Motivasi" 
FROM 
  "Volunteer" 
  JOIN "Pekerja" ON "Volunteer"."NIK" = "Pekerja"."NIK";

-- Retrieve information about patients and their diagnoses:
SELECT 
  "Nama", 
  "Diagnosa", 
  "Tindakan" 
FROM 
  "Pasien";

-- Retrieve the list of donors and their donation amounts:
SELECT 
  "Nama", 
  "Jumlah" 
FROM 
  "Donatur" 
  JOIN "Donasi_Tunai" ON "Donatur"."NIK" = "Donasi_Tunai"."Donatur";

-- Retrieve the list of rooms with their occupancy status and type:
SELECT 
  "Nomor", 
  "Ditempati", 
  "Nama" as "Tipe_Kamar" 
FROM 
  "Kamar" 
  JOIN "Tipe_Kamar" ON "Kamar"."Tipe" = "Tipe_Kamar"."ID";

-- Retrieve the list of visitors and their relationships with patients:
SELECT 
  "Nama", 
  "Hubungan" 
FROM 
  "Pendamping";

-- Retrieve the details of cash donations with donor information:
SELECT 
  "Donatur"."Nama" as "Donor_Name", 
  "Jumlah", 
  "created_at" 
FROM 
  "Donasi_Tunai" 
  JOIN "Donatur" ON "Donasi_Tunai"."Donatur" = "Donatur"."NIK";
  
-- Retrieve the details of inpatient visits, including room information:
SELECT 
  "Kunjungan"."ID", 
  "Pasien"."Nama" as "Patient_Name", 
  "Masuk", 
  "Keluar", 
  "Kamar"."Nomor" as "Room_Number", 
  "Tipe_Kamar"."Nama" as "Room_Type" 
FROM 
  "Kunjungan" 
  JOIN "Kamar" ON "Kunjungan"."Kamar" = "Kamar"."Nomor" 
  JOIN "Tipe_Kamar" ON "Kamar"."Tipe" = "Tipe_Kamar"."ID" 
  JOIN "Pasien" ON "Kamar"."Pasien" = "Pasien"."NIK";
