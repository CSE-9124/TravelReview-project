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

                TempatWisata tempatWisata = new TempatWisata(id, nama, imagePath, lokasi, kota, kategori, deskripsi);

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

                tempatWisata = new TempatWisata(id, nama, imagePath, lokasi, kota, kategori, deskripsi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempatWisata;
    }

    // UPDATE
    public static boolean updateTempatWisata(int id, String nama, String lokasi, String kota, String kategori, String deskripsi) {
        query = "UPDATE tempat_wisata SET nama=?, lokasi=?, kota=?, kategori=?, deskripsi=? WHERE id=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, lokasi);
            preparedStatement.setString(3, kota);
            preparedStatement.setString(4, kategori);
            preparedStatement.setString(5, deskripsi);
            preparedStatement.setInt(6, id);

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
}
