-- Insert dummy data for "Pekerja" table
INSERT INTO "Pekerja" ("NIK", "Nama", "kelamin", "No_HP", "Alamat", "updated_at")
VALUES
  ('1234567890123456', 'John Doe', 'Pria', '081234567890', 'Jl. Example 123', now()),
  ('2345678901234567', 'Jane Doe', 'Wanita', '082345678901', 'Jl. Sample 456', now()),
  ('3456789012345678', 'Bob Johnson', 'Pria', '083456789012', 'Jl. Test 789', now()),
  ('4567890123456789', 'Alice Smith', 'Wanita', '084567890123', 'Jl. Dummy 456', now()),
  ('5678901234567890', 'Charlie Brown', 'Pria', '085678901234', 'Jl. Data 789', now()),
  ('6789012345678901', 'Diana Miller', 'Wanita', '086789012345', 'Jl. Sample 012', now()),
  ('7890123456789012', 'Eva Johnson', 'Wanita', '087890123456', 'Jl. Test 345', now()),
  ('8901234567890123', 'Frank Miller', 'Pria', '088901234567', 'Jl. Example 678', now());

-- Insert dummy data for "Pengurus" table
INSERT INTO "Pengurus" ("NIK", "Posisi", "Jabatan", "updated_at")
VALUES
  ('1234567890123456', 'Eksekutif', 'Ketua', now()),
  ('2345678901234567', 'Organisasi', 'Anggota', now()),
  ('3456789012345678', 'Bendahara', 'Wakil', now()),
  ('4567890123456789', 'Sekretaris', 'Anggota', now()),
  ('5678901234567890', 'Pelayanan Sosial', 'Ketua', now()),
  ('6789012345678901', 'Pendidikan dan Penyuluhan', 'Wakil', now()),
  ('7890123456789012', 'Ilmiah', 'Anggota', now()),
  ('8901234567890123', 'Umum', 'Ketua', now());

-- Insert dummy data for "Volunteer" table
INSERT INTO "Volunteer" ("NIK", "Pendidikan", "Motivasi")
VALUES
  ('1234567890123456', 'Sarjana', 'I want to contribute to the community'),
  ('2345678901234567', 'Diploma', 'I love volunteering'),
  ('3456789012345678', 'Magister', 'Passionate about helping others'),
  ('4567890123456789', 'SMA', 'Excited to make a difference'),
  ('5678901234567890', 'Doktor', 'Committed to community service'),
  ('6789012345678901', 'Sarjana', 'Eager to contribute my skills'),
  ('7890123456789012', 'SMK', 'Inspired to give back'),
  ('8901234567890123', 'Diploma', 'Dedicated to making a positive impact');

-- Insert dummy data for "Pasien" table
INSERT INTO "Pasien" ("NIK", "Nama", "Tempat_Lahir", "Tanggal_Lahir", "Nomor_BPJS", "Kelas_BJPS", "Alamat_Provinsi", "Alamat_Kota", "Diagnosa", "Tindakan", "updated_at")
VALUES
  ('3456789012345678', 'Alice Smith', 'Jakarta', '1990-01-15', '1234567890123', '2', 'DKI Jakarta', 'Jakarta Barat', 'Fever', 'Rest', now()),
  ('4567890123456789', 'Bob Johnson', 'Surabaya', '1985-05-20', '9876543210987', '1', 'Jawa Timur', 'Surabaya', 'Headache', 'Medication', now()),
  ('5678901234567890', 'Charlie Brown', 'Bandung', '1998-08-30', '5432109876543', '3', 'Jawa Barat', 'Bandung', 'Cough', 'Fluids', now()),
  ('6789012345678901', 'Diana Miller', 'Medan', '1982-03-10', '8765432109876', '2', 'Sumatera Utara', 'Medan', 'Fatigue', 'Rest', now()),
  ('7890123456789012', 'Eva Johnson', 'Yogyakarta', '1995-12-25', '3210987654321', '1', 'DI Yogyakarta', 'Yogyakarta', 'Sore throat', 'Medication', now()),
  ('8901234567890123', 'Frank Miller', 'Makassar', '1980-07-05', '6543210987654', '3', 'Sulawesi Selatan', 'Makassar', 'Muscle pain', 'Rest', now());

-- Insert dummy data for "Pendamping" table
INSERT INTO "Pendamping" ("NIK", "Pasien", "Nama", "Hubungan", "Surat_Rujukan", "created_at")
VALUES
  ('1111222233334444', '3456789012345678', 'David Brown', 'Saudara', 'SR123', now()),
  ('2222333344445555', '4567890123456789', 'Emma Johnson', 'Teman', 'SR456', now()),
  ('3333444455556666', '5678901234567890', 'George Smith', 'Orang tua', 'SR789', now()),
  ('4444555566667777', '6789012345678901', 'Hannah Miller', 'Lain-Lain', 'SRABC', now()),
  ('5555666677778888', '7890123456789012', 'Isaac Miller', 'Saudara', 'SRXYZ', now()),
  ('6666777788889999', '8901234567890123', 'Julia Brown', 'Teman', 'SR123ABC', now());

-- Insert dummy data for "Tipe_Kamar" table
INSERT INTO "Tipe_Kamar" ("ID", "Nama", "Harga")
VALUES
  ('123e4567-e89b-12d3-a456-426614174003', 'Standard', 500000),
  ('234e5678-e89b-12d3-a456-426614174004', 'Deluxe', 1000000),
  ('345e6789-e89b-12d3-a456-426614174005', 'Suite', 1500000);

-- Insert dummy data for "Kamar" table
INSERT INTO "Kamar" ("Nomor", "Pasien", "Ditempati", "Tipe", "updated_at")
VALUES
  (1, '3456789012345678', true, '123e4567-e89b-12d3-a456-426614174003', now()),
  (2, '4567890123456789', true, '234e5678-e89b-12d3-a456-426614174004', now()),
  (3, '5678901234567890', true, '345e6789-e89b-12d3-a456-426614174005', now()),
  (4, '6789012345678901', true, '123e4567-e89b-12d3-a456-426614174003', now()),
  (5, '7890123456789012', true, '234e5678-e89b-12d3-a456-426614174004', now()),
  (6, '8901234567890123', true, '345e6789-e89b-12d3-a456-426614174005', now());

-- Insert dummy data for "Kunjungan" table
INSERT INTO "Kunjungan" ("ID", "Kamar", "Masuk", "Keluar")
VALUES
  ('123e4567-e89b-12d3-a456-426614174001', 1, '2023-01-01', '2023-01-03'),
  ('234e5678-e89b-12d3-a456-426614174002', 2, '2023-01-02', '2023-01-04'),
  ('345e6789-e89b-12d3-a456-426614174003', 3, '2023-01-03', '2023-01-05'),
  ('456e7890-e89b-12d3-a456-426614174004', 1, '2023-01-04', '2023-01-06'),
  ('567e8901-e89b-12d3-a456-426614174005', 2, '2023-01-05', '2023-01-07'),
  ('678e9012-e89b-12d3-a456-426614174006', 3, '2023-01-06', '2023-01-08'),
  ('789e0123-e89b-12d3-a456-426614174007', 1, '2023-01-07', '2023-01-09'),
  ('890e1234-e89b-12d3-a456-426614174008', 2, '2023-01-08', '2023-01-10');

-- Insert dummy data for "Donatur" table
INSERT INTO "Donatur" ("NIK", "Alamat", "Nama")
VALUES
  ('1111222233334444', 'Jl. Donator 789', 'Karen Smith'),
  ('2222333344445555', 'Jl. Generous 456', 'Larry Johnson'),
  ('3333444455556666', 'Jl. Kindhearted 123', 'Megan Brown'),
  ('4444555566667777', 'Jl. Benevolent 987', 'Oscar Miller'),
  ('5555666677778888', 'Jl. Philanthropist 654', 'Penelope Williams'),
  ('6666777788889999', 'Jl. Charitable 321', 'Quincy Davis'),
  ('7777888899990000', 'Jl. Giving 567', 'Rita Taylor'),
  ('8888999900001111', 'Jl. Compassionate 890', 'Steve Wilson');

-- Insert dummy data for "Donasi_Tunai" table
INSERT INTO "Donasi_Tunai" ("ID", "Donatur", "Jumlah", "created_at")
VALUES
  ('345e6789-e89b-12d3-a456-426614174005', '1111222233334444', 1000000, now()),
  ('456e7890-e89b-12d3-a456-426614174006', '2222333344445555', 500000, now()),
  ('567e8901-e89b-12d3-a456-426614174007', '3333444455556666', 1500000, now()),
  ('678e9012-e89b-12d3-a456-426614174008', '4444555566667777', 2000000, now()),
  ('789e0123-e89b-12d3-a456-426614174009', '5555666677778888', 800000, now()),
  ('890e1234-e89b-12d3-a456-426614174010', '6666777788889999', 1200000, now()),
  ('901e2345-e89b-12d3-a456-426614174011', '7777888899990000', 600000, now()),
  ('012e3456-e89b-12d3-a456-426614174012', '8888999900001111', 900000, now());

-- Insert dummy data for "Donasi_Harta" table
INSERT INTO "Donasi_Harta" ("ID", "Donatur", "Nama_Barang", "Jumlah_Barang", "created_at")
VALUES
  ('123e4567-e89b-12d3-a456-426614174013', '1111222233334444', 'Clothes', 50, now()),
  ('234e5678-e89b-12d3-a456-426614174014', '2222333344445555', 'Books', 100, now()),
  ('345e6789-e89b-12d3-a456-426614174015', '3333444455556666', 'Toys', 30, now()),
  ('456e7890-e89b-12d3-a456-426614174016', '4444555566667777', 'Electronics', 20, now()),
  ('567e8901-e89b-12d3-a456-426614174017', '5555666677778888', 'Furniture', 10, now()),
  ('678e9012-e89b-12d3-a456-426614174018', '6666777788889999', 'Appliances', 15, now()),
  ('789e0123-e89b-12d3-a456-426614174019', '7777888899990000', 'Jewelry', 5, now()),
  ('890e1234-e89b-12d3-a456-426614174020', '8888999900001111', 'Artwork', 8, now());

-- ON UPDATE TRIGGER TESTING 
UPDATE "Kamar"
SET "Ditempati" = false
WHERE "Nomor" IN (4, 5, 6);