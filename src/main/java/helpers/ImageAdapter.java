package helpers;

import javafx.scene.image.Image;

import java.io.File;

public class ImageAdapter {
    private Image image;
    private File file;

    public Image getImage() {
        return image;
    }

    public File getFile() {
        return file;
    }

    public ImageAdapter(Image image) {
        this.image = image;
    }

    public ImageAdapter(File file) {
        this.file = file;
    }
}
