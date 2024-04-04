---
title   : "Tugas Prkatikum 1"
author  : "Name - Student ID"
date    : "2023-03-06"
output  : html_document
---

##Data untuk menjawab soal 

```{r load-abrbuthnot-data, eval=TRUE}
source("http://www.openintro.org/stat/data/arbuthnot.R")
```

```{r load-present-data}
borncity
arbuthnot
```
## Nomor 1
Tahun berapa saja yang termasuk dalam kumpulan data kelahiran di kota Surabaya? 
Apa dimensi dari dataframe dan apa saja nama variabel atau kolom pada data?
```{r No.1 }
  borncity$year
  dim(borncity)
  names(borncity)
```
*Jawab*:
- Tahun yang termasuk dalam data kelahiran kota Surabaya dimulai dari tahun 1960 hingga tahun 2022.
- Dimensi dari dataframe adalah 63 Object(Baris) dan 3 Variable(Kolom).
- Terdapat 3 nama Variable(Kolom) antara lain "year", "boys" dan "girls".

## Nomor 2
Bagaimana jumlah data kelahiran di kota Surabaya dibandingkan dengan data Arbuthnot? Apakah mereka berada pada skala yang sama?
```{r No.2}
  varsurabaya <- sum(borncity$boys + borncity$girls)
  vararbuthnot <- sum(arbuthnot$boys + arbuthnot$girls)
  varsurabaya
  vararbuthnot
  varsurabaya > vararbuthnot
  range(borncity$year)
  range(arbuthnot$year)

  dim(arbuthnot)
  names(arbuthnot)
  dim(borncity)
  names(borncity)
```
*Jawab*:
- Jumlah kelahiran di kota Surabaya sebanyak 231910139
- Jumlah kelahiran di Arbuthnot sebanyak 938223
- Jumlah kelahiran di Kota Surabaya pada tahun 1960-2022 lebih banyak dibandingkan jumlah kelahiran di Arbuthnot pada tahun 1629-1710
- mengenai Skala Data, meskipun secara variable kedua dataframe sama (year, boys, girls), Namun terdapat perbedaan dalam hal dimensi banyaknya object dan juga range dimana data tersebut dikumpulkan. Arbuthnot mengambil data pada tahun 1629-1710 sedangkan borncity mengambil data pada tahun 1960-2022 

## Nomor 3
Buatlah plot yang menampilkan rasio laki-laki dan perempuan untuk setiap tahun dalam kumpulan data kelahiran di Surabaya!
```{r No.3}
  plot(
    borncity$year, 
    borncity$boys / borncity$girls, 
    xlab = "Tahun kelahiran di Surabaya", 
    ylab = "Rasio kelahiran Laki-Laki dan Perempuan", 
    type = 'o'
    )
```
*Jawab*: Jalankan kode untuk menampilkan plot.

## Nomor 4
Hitung jumlah seluruh anak laki-laki pada masing-masing data (arbuthnot dan data kelahiran kota Surabaya)!
Apakah pengamatan pada data Arbuthnot mengenai anak laki-laki yang dilahirkan memiliki proporsi yang lebih besar dibandingkan anak laki-laki di SUrabaya? Sertakan gambaran plot dalam tanggapan Anda.
```{r No.4}
  sumboysArb <- sum(arbuthnot$boys)
  sumboysSur <-sum(borncity$boys)
  totalboys <- c(sumboysArb, sumboysSur)
  sumboysArb > sumboysSur
  
  barplot(
    totalboys, 
    xlab = "Total birth",
    ylab = "region",
    names.arg = c("Arbuthnot", "Surabaya"),
    main = "Total males born Comparison"
    )
```
*Jawab*:
- Jumlah seluruh kelahiran anak laki-laki kota Surabaya tahun 1960 - 2022 sebanyak 118697433.
- Jumlah seluruh kelahiran anak laki-laki data arbuthnot sebanyak 484382.
- pengamatan menunjukkan bahwa argumen tersebut (jumlah kelahiran anak laki-laki pada Arbuthnot lebih besar dari Surabaya) adalah salah. Faktanya, pengamatan menunjukkan bahwa kelahiran anak laki-laki di Surabaya jauh melebihi yang terdapat pada data Arbuthnot

## Nomor 5
Pada tahun berapa kita melihat jumlah kelahiran terbanyak di Surabaya? 
```{r No.5}
  borncity$year[which(max(borncity$boys + borncity$girls) == borncity$girls + borncity$boys)] #cara1
  borncity$year[match(max(borncity$boys + borncity$girls), borncity$girls + borncity$boys)] #cara2
  max(borncity$boys + borncity$girls)
```
*Jawab*: Jumlah kelahiran terbanyak di Surabaya terjadi pada tahun 1981 dengan total kelahiran sebanyak 4268274.
