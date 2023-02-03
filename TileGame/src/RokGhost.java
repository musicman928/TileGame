import java.io.File;
import java.util.ArrayList;

public class RokGhost extends TileObject{
    private boolean winning;

    RokGhost(File sprite, int posx, int posy, ArrayList<TileObject> parent) {
        super(sprite, posx, posy, parent);
    }

    public boolean checkIfWinning() {
        for (int i = 0; i < getActors().length; i++) {
            if (getActors()[i].getClass().toString().equals("class Rok") && getActors()[i].getPosx() == getPosx() && getActors()[i].getPosy() == getPosy()) {
                return true;
            }
        }
        return false;
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
        return true;
    }

    @Override
    public boolean checkLeft() {
        return true;
    }

    @Override
    public boolean checkDown() {
        return true;
    }

    @Override
    public boolean checkUp() {
        return true;
    }
}
