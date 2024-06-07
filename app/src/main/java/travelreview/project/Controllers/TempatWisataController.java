package travelreview.project.Controllers;

import java.util.ArrayList;
import java.util.List;

import travelreview.project.Config.DbConfig;
import travelreview.project.Models.TempatWisata;

public class TempatWisataController extends DbConfig {
    // CREATE
    public static boolean addTempatWisata(String name, String imagePath, String lokasi, String kota, String kategori, String deskripsi) {
        query = "INSERT INTO tempat_wisata (name, image_path, lokasi, kota, kategori, deskripsi) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, imagePath);
            preparedStatement.setString(3, lokasi);
            preparedStatement.setString(4, kota);
            preparedStatement.setString(5, kategori);
            preparedStatement.setString(6, deskripsi);
            preparedStatement.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // READ
    public static List<TempatWisata> getAllTempatWisata() {
        List<TempatWisata> tempatWisatas = new ArrayList<>();
        query = "SELECT * FROM tempat_wisata";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nama = resultSet.getString("nama");
                String imagePath = resultSet.getString("image_path");
                String lokasi = resultSet.getString("lokasi");
                String kota = resultSet.getString("kota");
                String kategori = resultSet.getString("kategori");
                String deskripsi = resultSet.getString("deskripsi");
                int jumlahReview = resultSet.getInt("jumlah_review");
                double totalRating = resultSet.getDouble("total_rating");

                TempatWisata tempatWisata = new TempatWisata(id, nama, imagePath, lokasi, kota, kategori, deskripsi, jumlahReview, totalRating);

                tempatWisatas.add(tempatWisata);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempatWisatas;
    }

    //READ
    public static TempatWisata getTempatWisataById(int id) {
        TempatWisata tempatWisata = null;
        query = "SELECT * FROM tempat_wisata WHERE id=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nama = resultSet.getString("nama");
                String imagePath = resultSet.getString("image_path");
                String lokasi = resultSet.getString("lokasi");
                String kota = resultSet.getString("kota");
                String kategori = resultSet.getString("kategori");
                String deskripsi = resultSet.getString("deskripsi");
                int jumlahReview = resultSet.getInt("jumlah_review");
                double totalRating = resultSet.getDouble("total_rating");

                tempatWisata = new TempatWisata(id, nama, imagePath, lokasi, kota, kategori, deskripsi, jumlahReview, totalRating);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempatWisata;
    }

    // UPDATE
    public static boolean updateTempatWisata(int id, String nama, String lokasi, String kota, String kategori, String deskripsi, int jumlahReview) {
        query = "UPDATE tempat_wisata SET nama=?, lokasi=?, kota=?, kategori=?, deskripsi=?, jumlah_review=? WHERE id=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, lokasi);
            preparedStatement.setString(3, kota);
            preparedStatement.setString(4, kategori);
            preparedStatement.setString(5, deskripsi);
            preparedStatement.setInt(6, jumlahReview);
            preparedStatement.setInt(7, id);

            int rowsUpdate = preparedStatement.executeUpdate();

            return rowsUpdate > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // DELETE
    public static boolean deleteTempatWisata(int id) {
        query = "DELETE FROM tempat_wisata WHERE id=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int getJumlahReview(int id) {
        int jumlahReview = 0;
        query = "SELECT jumlah_review FROM tempat_wisata WHERE id=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                jumlahReview = resultSet.getInt("jumlah_review");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jumlahReview;
    }

    public static boolean updateJumlahReview(int id, int jumlahReview) {
        query = "UPDATE tempat_wisata SET jumlah_review=? WHERE id=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, jumlahReview);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateTotalRating(int id, double totalRating) {
        query = "UPDATE tempat_wisata SET total_rating=? WHERE id=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, totalRating);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
