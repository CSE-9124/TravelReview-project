package travelreview.project.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageUtils {
    public static String saveImage(File imageFile) throws IOException {
        String targetDirPath = "src/main/resources/images/profile-photo/";
        File targetDir = new File(targetDirPath);

        File targetFile = new File(targetDir + "/" + imageFile.getName());
        try (FileInputStream in = new FileInputStream(imageFile);
            FileOutputStream out = new FileOutputStream(targetFile)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
        return targetFile.getPath();
    }

    public static String saveImageTempat(File imageFile) throws IOException {
        String targetDirPath = "src/main/resources/images/tempat-images/";
        File targetDir = new File(targetDirPath);

        File targetFile = new File(targetDir + "/" + imageFile.getName());
        try (FileInputStream in = new FileInputStream(imageFile);
            FileOutputStream out = new FileOutputStream(targetFile)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
        return targetFile.getPath();
    }
}
