import java.io.File;
import java.util.ArrayList;

public class SpritePanel {
    private int width;
    private int height;

    private File defaultImageFile;
    private File[][] data;

    SpritePanel(int width, int height, File defaultImageFile){
        this.width = width;
        this.height = height;
        this.defaultImageFile = defaultImageFile;
        data = new File[width][height];

        fillAll(defaultImageFile);
    }

    public void fillAll(File image) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = image;
            }
        }
    }

    public void fillAll() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = defaultImageFile;
            }
        }
    }

    public File[][] getData() {
        return data;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public File getDefaultImageFile() {
        return defaultImageFile;
    }

    public void draw(TileObject tileObject) {
        data[tileObject.getPosy()][tileObject.getPosx()] = tileObject.getSprite();
    }
}
