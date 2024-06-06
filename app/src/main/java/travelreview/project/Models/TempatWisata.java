package travelreview.project.Models;

public class TempatWisata extends Model{
    private String nama, imagePath, lokasi, kota, kategori, deskripsi;
    private int jumlah_review;
    private double total_rating;

    // Constructors
    public TempatWisata(int id, String nama, String imagePath, String lokasi, String kota, String kategori,
            String deskripsi, int jumlah_review, double total_rating) {
        super(id);
        this.nama = nama;
        this.imagePath = imagePath;
        this.lokasi = lokasi;
        this.kota = kota;
        this.kategori = kategori;
        this.deskripsi = deskripsi;
        this.jumlah_review = jumlah_review;
        this.total_rating = total_rating;
    }

    // Getter & Settter
    public String getNama() {return nama;}
    public void setNama(String nama) {this.nama = nama;}

    public String getImagePath() {return imagePath;}
    public void setImagePath(String imagePath) {this.imagePath = imagePath;}

    public String getLokasi() {return lokasi;}
    public void setLokasi(String lokasi) {this.lokasi = lokasi;}

    public String getKota() {return kota;}
    public void setKota(String kota) {this.kota = kota;}

    public String getKategori() {return kategori;}
    public void setKategori(String kategori) {this.kategori = kategori;}

    public String getDeskripsi() {return deskripsi;}
    public void setDeskripsi(String deskripsi) {this.deskripsi = deskripsi;}

    public int getJumlah_review() {return jumlah_review;}
    public void setJumlah_review(int jumlah_review) {this.jumlah_review = jumlah_review;}

    public double getTotal_rating() {return total_rating;}
    public void setTotal_rating(double total_rating) {this.total_rating = total_rating;}
}
