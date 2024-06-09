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
  2. Memiliki halaman utama yang akan disambut dengan sapaan nama dan rekomendai tempat wisata yang diurut berdasarkan nilai Ratenya.
  3. Menampilkan deskripsi tempat wisata yang berisi tentang daya tarik dan apa yang ditawarkan di tempat wisata tersebut.
  4. Memiliki fitur untuk menambahkan dan melihat rating juga ulasan tempat wisata yang diberikan oleh user.
  5. Memiliki fitur untuk mengubah isi profile dan mengupload foto profil.

C. Admin
  1. Memiliki daftar tempat wisata dalam bentuk Tabel.
  2. Memiliki halaman utama yang akan dengan sapaan nama.
  3. Memiliki fitur untuk menambahkan, mengedit dan menghapus tempat wisata

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
![Login Scene](https://github.com/CSE-9124/TravelReview-project/blob/main/readme/LoginScene.jpg)

### *Register Scene*
![Register Scene](https://github.com/CSE-9124/TravelReview-project/blob/main/readme/RegisterScene.jpg)

### *Home Scene*
![Home Scene](https://github.com/CSE-9124/TravelReview-project/blob/main/readme/HomeScene.jpg)

### *List Tempat Wisata Scene*
![Daftar Tempat](https://github.com/CSE-9124/TravelReview-project/blob/main/readme/DaftarTempatWisata.jpg)

### *Deskripsi Tempat Wisata Scene*
![Detail Tempat](https://github.com/CSE-9124/TravelReview-project/blob/main/readme/DetailTempatWisata.jpg)

### *Komentar dan Rating Scene*
![Kommentar Rating](https://github.com/CSE-9124/TravelReview-project/blob/main/readme/RatingUlasan.jpg)

### *Profile User Scene*
![Profile Scene](https://github.com/CSE-9124/TravelReview-project/blob/main/readme/ProfileScene.jpg)

### *Admin Home Scene*
![Profile Scene](https://github.com/CSE-9124/TravelReview-project/blob/main/readme/AdminHomeScene.jpg)

### *Tabel List Tempat Wisata*
![Profile Scene](https://github.com/CSE-9124/TravelReview-project/blob/main/readme/TableTempatWisataScene.jpg)

### *Add Tempat Wisata Scene*
![Profile Scene](https://github.com/CSE-9124/TravelReview-project/blob/main/readme/AddTempatWisata.jpg)

### *Edit Tempat Wisata Scene*
![Profile Scene](https://github.com/CSE-9124/TravelReview-project/blob/main/readme/EditTempatWisata.jpg)

## Pengujian Pada Aplikasi
| No | Deskripsi pengujian | Hasil yang diharapkan | Hasil |
|----|-----------------------|------------------------|-------|
| 1  | Percobaan login dengan email atau password yang salah | Sistem dapat menampilkan pesan kesalahan yang sesuai jika email atau password yang dimasukkan salah | Berhasil |
| 2  | Percobaan login tanpa mengisi email atau password | Aplikasi dapat menampilkan pesan kesalahan yang sesuai jika email atau password tidak diisi | Berhasil |
| 3  | Percobaan register jika tidak di isi username, nama, email, password | Aplikasi dapat menampilkan pesan kesalahan jika username, nama, email, password tidak diisi | Berhasil |
| 4  | Percobaan menambahkan komentar dan akan menampilkan semua komentar dari para user | Aplikasi dapat menerima komentar dari user dan menampilkan komentar tersebut | Berhasil |
| 5  | Percobaan menambahkan rating tempat wisata | Aplikasi dapat menghitung rata rata dari rating yang diberikan tiap user dan menampilkannya | Berhasil |
| 6  | Percobaan jika komentar dan rating dari tempat wisata masih kosong | Aplikasi dapat menampilkan pesan “Belum ada komentar” dan rating “0.0“ | Berhasil
| 7  | Percobaan logout user | Aplikasi akan kembali ke menu login saat user memilih menu logout | Berhasil |
| 8  | Percobaan user menambahkan foto profil | Aplikasi akan menampilkan foto profil user di halaman profil | Berhasil |
| 9  | Percobaan user tidak menambahkan foto profil | Aplikasi akan menampilkan foto profil default jika pengguna belum menambahkan foto profil | Berhasil |
| 10 | Percobaan update profil user | Aplikasi akan menampilkan data profil user yang sudah diperbaharui | Berhasil |
| 11 | Percobaan register dengan memasukkan email yang tidak sesuai syarat (regex) | Aplikasi akan menampilkan pesan kesalahan | Berhasil |
| 12 | Percobaan login dengan email atau password Admin | Aplikasi akan membawa user ke scene-scene Admin | Berhasil |
| 13 | Percobaan menambahkan Tempat Wisata | Aplikasi dapat menerima Tempat Wisata dari admin dan ditampilkan ke user scene | Berhasil |
| 14 | Percobaan mengedit Tempat Wisata | Aplikasi dapat menerima Tempat Wisata yang diedit dan ditampilkan ke user scene | Berhasil |
| 15 | Percobaan menghapus Tempat Wisata | Aplikasi dapat menghapus Tempat Wisata yang ada didatabase | Berhasil |