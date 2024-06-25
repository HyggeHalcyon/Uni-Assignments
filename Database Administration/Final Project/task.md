1. Buatlah sebuah prosedur untuk transaksi pembelian/sales pada Bisnis Adventureworks.
Detil -->
a. Customer Membeli barang secara online. --> membuat prosedur pembelian barang yang dilakukan secara online dengan "OnlineOrderFlag = 1". Ketika Prosedur ini dijalankan akan menginput satu baris dalam tabel "SalesOrderHeader" (dalam database saleco setara tabel "invoice") dan menginput tabel lain (mohon baca diagram ERD dari adventure works, bisa generate dari Management Studio atau dari file yang disediakan "8540.AdventureWorks2008.pdf") misalnya tabel "SalesOrderDetail" (dalam database SaleCo setara tabel "line").
b. Customer (toko retailer) Membeli barang secara offline. --> membuat prosedur pembelian barang yang dilakukan secara online dengan "OnlineOrderFlag = 0". Ketika Prosedur ini dijalankan akan menginput satu baris dalam tabel "SalesOrderHeader" (dalam database saleco setara tabel "invoice") dan menginput tabel lain (mohon baca diagram ERD dari adventure works, bisa generate dari Management Studio atau dari file yang disediakan "8540.AdventureWorks2008.pdf") misalnya tabel "SalesOrderDetail" (dalam database SaleCo setara tabel "line").

2. Buatlah sebuah prosedur untuk transaksi pemesanan/purchasing pada Bisnis Adventureworks.
Detil --> Order Barang (Purchase) --> membuat prosedur purchasing barang (Pabrik AdventureWorks membeli barang dari supplier). Ketika prosedur ini dijalankan, akan mengisi tabel "PurchaseOrderHeader" dan tabel lain yang berkaitan (termasuk "PurchaseOrderDetail"). Stocking barang, harus juga mengupdate stock dan kuantitas barang yang masuk dalam skema "Production". Perhatikan apakah barang yang di-purchase adalah barang jadi atau barang setengah jadi. Jalankan prosedurini ketika minimum point Product telah tercapai dalam "ReorderPoint".

3. Buatlah sebuah prosedur untuk transaksi bebas sesuai yang anda pilih pada Bisnis adventureworks.

Semua kode 1-3 disertakan dalam laporan. Beri penjelasan dan deskripsi tentang 3 Prosedur tersebut.
Syarat prosedur transaksi dikatakan benar
1. Mekanisme transaction dijalankan. Dibungkus dalam prosedur
2. Prinsip ACID diterapkan dalam prosedur

Nilai lebih.
1. Bangun konstruksi yang baik,
   a. Beberapa fungsi yang bisa dipakai ulang dapat diwujudkan dalam 'stored Function'
   b. Beberapa event/db access yang melibatkan
2. Sertai dengan pembangunan index yang tepat.
   a. pemilihan index yang tepat. single, multiple column
   b. melakukan analisis performa dengan membandingkan cost.

Presentasikan dalam Video,
Output
1. Submit link dan (durasi maksimum video 15 menit)
2. Dokumen deskripsi prosedur lengkap dengan penjelasannya.


Link Material SQL Server Hints
https://learn.microsoft.com/en-us/sql/t-sql/queries/hints-transact-sql?view=sql-server-ver16

Specific Lock 
https://www.sqlservercentral.com/forums/topic/tablockx-vs-tablock-xlock