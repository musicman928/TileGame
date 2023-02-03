import java.io.File;
import java.util.ArrayList;

public class Wall extends TileObject{

    Wall(File sprite, int posx, int posy, ArrayList<TileObject> parent) {
        super(sprite, posx, posy, parent);
    }

    @Override
    public void moveRight() {}

    @Override
    public void moveLeft() {}

    @Override
    public void moveDown() {}

    @Override
    public void moveUp() {}

    @Override
    public boolean checkRight() {
        return false;
    }

    @Override
    public boolean checkLeft() {
        return false;
    }

    @Override
    public boolean checkDown() {
        return false;
    }

    @Override
    public boolean checkUp() {
        return false;
    }
}
