package travelreview.project.Controllers;

import travelreview.project.Config.DbConfig;

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
}
