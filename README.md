# TravelReview

TravelReview adalah aplikasi yang dirancang untuk membantu wisatawan menemukan tempat wisata terbaik, memberikan rating, serta menulis ulasan tentang pengalaman mereka.

## Group Name : RoamRangers
Nama Anggota :

  1. Cholyn Sharon Enos - H071231040
  2. Muhammad Dirga Dian Nugraha - H071231039
  3. Amalia Diah Ramadani - H071231063

## Tema yang dipilih : Travel and Culture
## Nama Pendamping : Muh. Adnan Putra Amiruddin
## Tim Juri :

  1. Awang Mulya Nugrawan
  2. Rahmaliyah Kadir

## Executive Summary
TravelReview adalah aplikasi yang dirancang untuk membantu wisatawan menemukan tempat wisata terbaik, memberikan rating, serta menulis ulasan tentang pengalaman mereka.

### 1. Latar Belakang
Indonesia memiliki banyak destinasi wisata yang beragam, namun informasi tentang tempat-tempat tersebut seringkali tersebar dan tidak terstruktur. Wisatawan sering menghadapi kesulitan dalam menemukan ulasan yang dapat dipercaya dan penilaian obyektif mengenai tempat wisata yang ingin mereka kunjungi.

### 2. Masalah yang diatasi
Banyak ulasan tersebar di berbagai platform yang berbeda, membuat proses pengambilan keputusan menjadi lebih sulit. Maka dari itu, kami menghadirkan solusi untuk wisatawan dalam mengatasi masalah seperti:

- Kurangnya Informasi Terpusat : Wisatawan seringkali kesulitan menemukan ulasan dan penilaian yang terpusat tentang tempat wisata tertentu.
- Keterpercayaan Ulasan: Beberapa ulasan di internet yang masih kurang jelas sumbernya, sehingga sulit dipercaya.
- Pengalaman Pengguna: Tidak adanya sistem yang memungkinkan pengguna untuk berbagi pengalaman dan memberikan penilaian yang dapat membantu wisatawan lain.

### 3. Alasan Pemilihan Projek ini
Kami memilih projek ini karena projek ini dapat memberikan manfaat bagi pengguna, TravelReview memberikan platform terpusat dimana pengguna dapat dengan mudah menemukan informasi terpercaya tentang tempat wisata, membantu mereka membuat keputusan yang lebih baik, dan projek ini juga dapat berguna untuk peningkatan pariwisata, dengan memberikan umpan balik yang berharga, aplikasi ini dapat membantu meningkatkan kualitas layanan dan fasilitas di tempat wisata.

## Fitur Aplikasi
A. General
  1. *Login User*
  2. *Register User*
  3. *Navbar*
  4. *Logout User*

B. User
  1. Memiliki daftar tempat wisata yang menampilkan foto, nama, dan lokasi tempat wisata dalam bentuk card.
  2. Memiliki halaman utama yang akan disambut dengan sapaan nama.
  3. Menampilkan deskripsi tempat wisata yang berisi tentang daya tarik dan apa yang ditawarkan di tempat wisata tersebut.
  4. Memiliki fitur untuk menambahkan dan melihat rating juga ulasan tempat wisata yang diberikan oleh user.
  5. Memiliki fitur untuk mengubah isi profile dan mengupload foto profil.

## Penjelasan Penerapan Prinsip OOP
1. Pada class *Ascene* menunjukkan prinsip OOP dengan adanya kelas abstrak `AScene`, yang memberikan kerangka dasar dan metode yang harus diimplementasikan oleh kelas turunannya. Ini adalah salah satu bagian dari OOP yaitu **abstarction** karena kelas ini tidak bisa digunakan langsung, hanya sebagai dasar. **Inheritance** terjadi karena kelas turunan akan mewarisi atribut `stage` dan metode `show()` dari `AScene`. **Encapsulation** terlihat dengan melindungi metode `show()` sehingga hanya bisa diakses oleh kelas turunan. **Polymorphism** ditunjukkan dengan metode `show()`
2. Kelas *DbConfig* menggunakan **Encapsulation** dengan membuat atribut `connection`, `preparedStatement`, `resultSet`, dan `query` bersifat `protected`, sehingga hanya bisa diakses oleh kelas dalam paket yang sama atau oleh kelas turunan. **Abstraction** diterapkan dengan menyembunyikan detail koneksi database di dalam metode `getConnection()`, sehingga user tidak perlu tahu bagaimana cara menghubungkan ke database.
3. Kelas-kelas seperti *CommentsController*, *TempatWisataController*, dan *UsersController* menggunakan **inheritance** dengan mewarisi kelas *DbConfig*, yang menyediakan metode untuk mengelola koneksi database. **Abstraksi** diterapkan dengan menyembunyikan detail implementasi koneksi database dan operasi *CRUD* (*Create*, *Read*, *Update*, *Delete*) dalam metode-metode yang spesifik untuk setiap kelas, seperti `addComment()` dan `getAllCommentsByTempatWisataId()` pada CommentsController. **Enkapsulasi** digunakan untuk melindungi atribut dan metode dengan kata kunci protected dan private.
4. Kelas *Comment*, *TempatWisata*, dan *User* menerapkan **encapsulation** dengan mendefinisikan atribut-atributnya sebagai private dan menggunakan metode-metode getter dan setter untuk mengakses dan memodifikasi nilai atribut tersebut. Fungsi dari getter setter adalah menjaga data dan mencegah akses langsung dari luar kelas. Selain itu, kelas TempatWisata dan User mewarisi atribut id dari kelas Model, menunjukkan **inheritance** yang memungkinkan penggunaan kembali kode.
5. Kelas *App* pada projek ini mewarisi kelas `Application` ini menggunakan prinsip **Inheritance**. Fungsi utama dari kelas *App* adalah sebagai kelas utama (main class) yang menjalankan aplikasi. Metode `start(Stage stage)` di dalam kelas *App* mengatur tampilan utama aplikasi, termasuk judul, ukuran, ikon, dan tema. Kelas ini juga memuat dan menampilkan `LoginScene` ketika aplikasi dimulai. Metode `main(String[] args)` memanggil `launch()`, yang memulai aplikasi **JavaFX**.

## Mentoring
- Kak Adnan - Senin, 13 Mei 2024
- Kak Adnan – Rabu, 22 Mei 2024
- Kak Adnan – Kamis, 23 Mei 2024
- Kak Adnan – Senin, 27 Mei 2024
- Kak Adnan – Rabu, 29 Mei 2024

## Link Repository GitHub
[https://github.com/CSE-9124/TravelReview-project](https://github.com/CSE-9124/TravelReview-project)

## Screenshots
### *Login Scene*
![Login Scene](readme\LoginScene.jpg)

### *Register Scene*
![Register Scene](readme\RegisterScene.jpg)

### *Home Scene*
![Home Scene](readme\HomeScene.jpg)

### *List Tempat Wisata Scene*
![Daftar Tempat](readme\DaftarTempatWisata.jpg)

### *Deskripsi Tempat Wisata Scene*
![Detail Tempat](readme\DetailTempatWisata.jpg)

### *Komentar dan Rating Scene*
![Kommentar Rating](readme\RatingUlasan.jpg)

### *Profile User Scene*
![Profile Scene](readme\ProfileScene.jpg)

## Pengujian Pada Aplikasi
![Table1](readme\Table1.png)
![Table2](readme\Table2.png)
