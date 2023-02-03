import com.sun.istack.internal.Nullable;

import java.io.File;
import java.util.ArrayList;

public class TileObject {
    private File sprite;
    private int posx;
    private int posy;

    private ArrayList<TileObject> parent;

    TileObject(File sprite, int posx, int posy, ArrayList<TileObject> parent) {
        this.sprite = sprite;
        this.posx = posx;
        this.posy = posy;
        this.parent = parent;

    }

    public File getSprite() {
        return sprite;
    }

    public int getPosx() {
        return posx;
    }

    public int getPosy() {
        return posy;
    }

    public ArrayList<TileObject> getParent() {
        return parent;
    }

    public void moveRight() {
        if (checkRight()) {
            try {
                getActorAtCoords(posx + 1, posy).moveRight();
            } catch (Exception ignored) {}
            posx += 1;
        }
    }

    public void moveLeft() {
        if (checkLeft()) {
            try {
                getActorAtCoords(posx - 1, posy).moveLeft();
            } catch (Exception ignored) {}
            posx -= 1;
        }
    }

    public void moveUp() {
        if (checkUp()) {
            try {
                getActorAtCoords(posx, posy - 1).moveUp();
            } catch (Exception ignored) {}
            posy -= 1;
        }
    }

    public void moveDown() {
        if (checkDown()) {
            try {
                getActorAtCoords(posx, posy + 1).moveDown();
            } catch (Exception ignored) {}
            posy += 1;
        }
    }

    public boolean checkInBounds(int x, int y) {
        return ((x >= 0 && x < 12) && (y >= 0 && y < 12));
    }

    public TileObject[] getActors() {
        TileObject[] out = parent.toArray(new TileObject[0]);
        return out;
    }

    public TileObject getActorAtCoords(int x, int y) {
        TileObject[] actors = getActors();

        for (int i = 0; i < actors.length; i++) {
            if (actors[i].posx == x && actors[i].posy == y && (actors[i].getClass().toString().equals("class Rok") || actors[i].getClass().toString().equals("class Wall"))) {
                return actors[i];
            }
        }

        return actors[-1];
    }

    public boolean checkRight() {

        int tempx = posx + 1;
        int tempy = posy;

        try {
            return getActorAtCoords(tempx, tempy).checkRight() && checkInBounds(tempx, tempy);
        } catch (ArrayIndexOutOfBoundsException e) {
            return checkInBounds(tempx, tempy);
        }

    }

    public boolean checkLeft() {

        int tempx = posx - 1;
        int tempy = posy;

        try {
            return getActorAtCoords(tempx, tempy).checkLeft() && checkInBounds(tempx, tempy);
        } catch (ArrayIndexOutOfBoundsException e) {
            return checkInBounds(tempx, tempy);
        }

    }

    public boolean checkDown() {

        int tempx = posx;
        int tempy = posy + 1;

        try {
            return getActorAtCoords(tempx, tempy).checkDown() && checkInBounds(tempx, tempy);
        } catch (ArrayIndexOutOfBoundsException e) {
            return checkInBounds(tempx, tempy);
        }

    }

    public boolean checkUp() {

        int tempx = posx;
        int tempy = posy - 1;

        try {
            return getActorAtCoords(tempx, tempy).checkUp() && checkInBounds(tempx, tempy);
        } catch (ArrayIndexOutOfBoundsException e) {
            return checkInBounds(tempx, tempy);
        }

    }

}
