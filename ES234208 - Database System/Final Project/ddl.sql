DROP TYPE IF EXISTS "Posisi" CASCADE;
CREATE TYPE "Posisi" AS ENUM (
  'Eksekutif', 
  'Bendahara', 
  'Sekretaris', 
  'Organisasi', 
  'Pelayanan Sosial', 
  'Pendidikan dan Penyuluhan', 
  'Ilmiah', 
  'Umum'
);

DROP TYPE IF EXISTS "Hubungan" CASCADE;
CREATE TYPE "Hubungan" AS ENUM (
  'Pasutri', 
  'Teman', 
  'Saudara', 
  'Orang tua', 
  'Lain-Lain'
);

DROP TYPE IF EXISTS "Jabatan" CASCADE;
CREATE TYPE "Jabatan" AS ENUM (
    'Ketua', 
    'Wakil',
    'Anggota'
);

DROP TYPE IF EXISTS "BPJS" CASCADE;
CREATE TYPE "BPJS" AS ENUM (
    '1', 
    '2', 
    '3'
);

DROP TYPE IF EXISTS "Pendidikan" CASCADE;
CREATE TYPE "Pendidikan" AS ENUM (
  'Doktor', 
  'Magister', 
  'Sarjana', 
  'Diploma', 
  'SMA', 
  'SMK', 
  'SMP', 
  'SD'
);

DROP TYPE IF EXISTS "Kelamin" CASCADE;
CREATE TYPE "Kelamin" AS ENUM (
    'Pria', 
    'Wanita'
);

DROP TABLE IF EXISTS "Pekerja" CASCADE;
CREATE TABLE "Pekerja" (
  "NIK" CHAR(16) PRIMARY KEY, 
  "Nama" VARCHAR(64), 
  "kelamin" "Kelamin", 
  "No_HP" CHAR(13), 
  "Alamat" VARCHAR(255), 
  "updated_at" timestamp, 
  "created_at" timestamp default current_timestamp
);

DROP TABLE IF EXISTS "Pengurus" CASCADE;
CREATE TABLE "Pengurus" (
  "NIK" CHAR(16) UNIQUE, 
  "Posisi" "Posisi", 
  "Jabatan" "Jabatan", 
  "updated_at" timestamp
);

DROP TABLE IF EXISTS "Volunteer" CASCADE;
CREATE TABLE "Volunteer" (
  "NIK" CHAR(16) UNIQUE, 
  "Pendidikan" "Pendidikan", 
  "Motivasi" VARCHAR(255)
);

DROP TABLE IF EXISTS "Pasien" CASCADE;
CREATE TABLE "Pasien" (
  "NIK" CHAR(16) PRIMARY KEY, 
  "Nama" VARCHAR(64), 
  "Tempat_Lahir" VARCHAR(32), 
  "Tanggal_Lahir" timestamp, 
  "Nomor_BPJS" CHAR(13), 
  "Kelas_BJPS" "BPJS", 
  "Alamat_Provinsi" VARCHAR(32), 
  "Alamat_Kota" VARCHAR(32), 
  "Diagnosa" VARCHAR(64), 
  "Tindakan" VARCHAR(64), 
  "created_at" timestamp default current_timestamp, 
  "updated_at" timestamp
);

DROP TABLE IF EXISTS "Pendamping" CASCADE;
CREATE TABLE "Pendamping" (
  "NIK" CHAR(16) PRIMARY KEY, 
  "Pasien" CHAR(16), 
  "Nama" VARCHAR(64), 
  "Hubungan" "Hubungan", 
  "Surat_Rujukan" VARCHAR(32), 
  "created_at" timestamp default current_timestamp
);

DROP TABLE IF EXISTS "Kunjungan" CASCADE;
CREATE TABLE "Kunjungan" (
  "ID" uuid PRIMARY KEY, 
  "Kamar" INTEGER, 
  "Masuk" timestamp, 
  "Keluar" timestamp
);

DROP TABLE IF EXISTS "Kamar" CASCADE;
CREATE TABLE "Kamar" (
  "Nomor" INTEGER PRIMARY KEY, 
  "Pasien" CHAR(16) UNIQUE, 
  "Ditempati" boolean, 
  "Tipe" uuid, 
  "updated_at" timestamp, 
  "created_at" timestamp default current_timestamp
);

DROP TABLE IF EXISTS "Tipe_Kamar" CASCADE;
CREATE TABLE "Tipe_Kamar" (
  "ID" uuid PRIMARY KEY, 
  "Nama" VARCHAR(32), 
  "Harga" INTEGER
);

DROP TABLE IF EXISTS "Donatur" CASCADE;
CREATE TABLE "Donatur" (
  "NIK" CHAR(16) PRIMARY KEY, 
  "Nama" VARCHAR(64), 
  "Alamat" VARCHAR(64)
);

DROP TABLE IF EXISTS "Donasi_Tunai" CASCADE;
CREATE TABLE "Donasi_Tunai" (
  "ID" uuid UNIQUE PRIMARY KEY, 
  "Donatur" CHAR(16), 
  "Jumlah" INTEGER, 
  "created_at" timestamp default current_timestamp
);

DROP TABLE IF EXISTS "Donasi_Harta" CASCADE;
CREATE TABLE "Donasi_Harta" (
  "ID" uuid UNIQUE PRIMARY KEY, 
  "Donatur" CHAR(16), 
  "Nama_Barang" VARCHAR(64), 
  "Jumlah_Barang" INTEGER, 
  "created_at" timestamp default current_timestamp
);

ALTER TABLE 
  "Pengurus" 
ADD 
  FOREIGN KEY ("NIK") REFERENCES "Pekerja" ("NIK");

ALTER TABLE 
  "Volunteer" 
ADD 
  FOREIGN KEY ("NIK") REFERENCES "Pekerja" ("NIK");

ALTER TABLE 
  "Pendamping" 
ADD 
  FOREIGN KEY ("Pasien") REFERENCES "Pasien" ("NIK");

ALTER TABLE 
  "Kamar" 
ADD 
  FOREIGN KEY ("Pasien") REFERENCES "Pasien" ("NIK") ON UPDATE CASCADE;

ALTER TABLE 
  "Kunjungan" 
ADD 
  FOREIGN KEY ("Kamar") REFERENCES "Kamar" ("Nomor");

ALTER TABLE 
  "Kamar" 
ADD 
  FOREIGN KEY ("Tipe") REFERENCES "Tipe_Kamar" ("ID");

ALTER TABLE 
  "Donasi_Harta" 
ADD 
  FOREIGN KEY ("Donatur") REFERENCES "Donatur" ("NIK");

ALTER TABLE 
  "Donasi_Tunai" 
ADD 
  FOREIGN KEY ("Donatur") REFERENCES "Donatur" ("NIK");

CREATE OR REPLACE FUNCTION 
    update_updated_at() 
    RETURNS TRIGGER AS $$ 
BEGIN 
    NEW.updated_at = now();
    RETURN NEW;
END;
$$ language 'plpgsql';

CREATE TRIGGER TRG_update_updated_at BEFORE 
UPDATE 
  ON "Pekerja" FOR EACH ROW EXECUTE PROCEDURE update_updated_at();

CREATE TRIGGER TRG_update_updated_at BEFORE 
UPDATE 
  ON "Pengurus" FOR EACH ROW EXECUTE PROCEDURE update_updated_at();

CREATE TRIGGER TRG_update_updated_at BEFORE 
UPDATE 
  ON "Volunteer" FOR EACH ROW EXECUTE PROCEDURE update_updated_at();

CREATE TRIGGER TRG_update_updated_at BEFORE 
UPDATE 
  ON "Pasien" FOR EACH ROW EXECUTE PROCEDURE update_updated_at();

CREATE TRIGGER TRG_update_updated_at BEFORE 
UPDATE 
  ON "Kamar" FOR EACH ROW EXECUTE PROCEDURE update_updated_at();

CREATE TRIGGER TRG_update_updated_at BEFORE 
UPDATE 
  ON "Donasi_Tunai" FOR EACH ROW EXECUTE PROCEDURE update_updated_at();

CREATE TRIGGER TRG_update_updated_at BEFORE 
UPDATE 
  ON "Donasi_Harta" FOR EACH ROW EXECUTE PROCEDURE update_updated_at();

CREATE OR REPLACE FUNCTION 
    update_pasien_on_kamar_update() 
    RETURNS TRIGGER AS $$
BEGIN 
    IF NEW."Ditempati" = false THEN 
        UPDATE 
        "Kamar" 
        SET 
        "Pasien" = NULL 
        WHERE 
        "Nomor" = OLD."Nomor";
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER TRG_update_pasien_on_kamar_update 
AFTER 
UPDATE 
  OF "Ditempati" ON "Kamar" FOR EACH ROW EXECUTE FUNCTION update_pasien_on_kamar_update();

