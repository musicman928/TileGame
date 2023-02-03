import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class TileGame extends Application {
    public static void Main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        TilePane pane = new TilePane(Orientation.HORIZONTAL);
        pane.setTileAlignment(Pos.TOP_LEFT);
        pane.setPrefTileHeight(48);
        pane.setPrefTileWidth(48);
        pane.setMaxWidth(512);
        pane.setMaxHeight(480);
        pane.setHgap(0);
        pane.setVgap(0);

        File playerSprite = new File("Assets/Textures/Player.png");

        File emptySprite = new File("Assets/Textures/Empty.png");

        File blackSprite = new File("Assets/Textures/Black.png");

        File rokSprite = new File("Assets/Textures/Rok.png");

        File wallSprite = new File("Assets/Textures/Wall.png");

        File rokGhostSprite = new File("Assets/Textures/RokGhost.png");

        pane.setAlignment(Pos.TOP_LEFT);

        ArrayList<TileObject> actors = new ArrayList<>();
        SpritePanel spritePanel = new SpritePanel(12, 12, blackSprite);

        Scene scene = new Scene(pane, 576,576);

        RokGhost rokGhost0 = new RokGhost(rokGhostSprite, 4, 6, actors);
        RokGhost rokGhost1 = new RokGhost(rokGhostSprite, 1, 4, actors);
        RokGhost rokGhost2 = new RokGhost(rokGhostSprite, 3, 1, actors);
        RokGhost rokGhost3 = new RokGhost(rokGhostSprite, 6, 3, actors);

        actors.add(rokGhost0);
        actors.add(rokGhost1);
        actors.add(rokGhost2);
        actors.add(rokGhost3);

        ArrayList<RokGhost> rokGhosts = new ArrayList<>();

        rokGhosts.add(rokGhost0);
        rokGhosts.add(rokGhost1);
        rokGhosts.add(rokGhost2);
        rokGhosts.add(rokGhost3);

        TileObject toby = new TileObject(playerSprite,4,4, actors);

        actors.add(toby);

        Rok rok = new Rok(rokSprite, 3, 3, actors);
        Rok rok0 = new Rok(rokSprite, 3, 4, actors);
        Rok rok1 = new Rok(rokSprite,5,3, actors);
        Rok rok2 = new Rok(rokSprite,4,5,actors);


        actors.add(rok);
        actors.add(rok0);
        actors.add(rok1);
        actors.add(rok2);

        Wall wall = new Wall(wallSprite,0,3,actors);
        Wall wall0 = new Wall(wallSprite,0,4,actors);
        Wall wall1 = new Wall(wallSprite,0,5,actors);
        Wall wall2 = new Wall(wallSprite,1,3,actors);
        Wall wall3 = new Wall(wallSprite,1,5,actors);
        Wall wall4 = new Wall(wallSprite,2,0,actors);
        Wall wall5 = new Wall(wallSprite,2,1,actors);
        Wall wall6 = new Wall(wallSprite,2,2,actors);
        Wall wall7 = new Wall(wallSprite,2,3,actors);
        Wall wall8 = new Wall(wallSprite,2,5,actors);
        Wall wall9 = new Wall(wallSprite,3,0,actors);
        Wall wall10 = new Wall(wallSprite,3,5,actors);

        actors.add(wall);
        actors.add(wall0);
        actors.add(wall1);
        actors.add(wall2);
        actors.add(wall3);
        actors.add(wall4);
        actors.add(wall5);
        actors.add(wall6);
        actors.add(wall7);
        actors.add(wall8);
        actors.add(wall9);
        actors.add(wall10);


        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(String.valueOf(new File("Assets/Textures/icon.png").toURI())));
        primaryStage.setTitle("Tile Game");
        primaryStage.setResizable(false);
        primaryStage.show();

        draw(spritePanel, pane, actors);

        scene.setOnKeyPressed(e -> {
            if (e.getCode().getName() == "Left") {
                toby.moveLeft(); draw(spritePanel, pane, actors); checkIfWinning(rokGhosts, 4);
            }
            else if (e.getCode().getName() == "Right") {
                toby.moveRight(); draw(spritePanel, pane, actors); checkIfWinning(rokGhosts, 4);
            }
            /*

                California girls
                We're undeniable
                Fine, fresh, fierce
                We got it on lock
                West coast represent
                Now put your hands up
                Ooh oh ooh
                Ooh oh ooh

                    -Katheryn Perry

             */
            else if (e.getCode().getName() == "Down") {
                toby.moveDown(); draw(spritePanel, pane, actors); checkIfWinning(rokGhosts, 4);
            }
            else if (e.getCode().getName() == "Up") {
                toby.moveUp(); draw(spritePanel, pane, actors); checkIfWinning(rokGhosts, 4);
            }
        });

    }

    public static void checkIfWinning(ArrayList<RokGhost> rokGhosts, int rokGhostAmount) {
        int amount = 0;
        for (int i = 0; i < rokGhosts.size(); i++) {
            if (rokGhosts.get(i).checkIfWinning()) {
                amount++;
            }
            if (amount == rokGhosts.size()) {
                System.exit(0);
            }
        }
    }

    public static void draw(SpritePanel spritePanel, TilePane pane, ArrayList<TileObject> actors) {
        pane.getChildren().clear();
        spritePanel.fillAll();
        drawActors(spritePanel, actors);
        drawSpritePanel(spritePanel, pane);
    }

    public static void drawActors(SpritePanel spritePanel, ArrayList<TileObject> actors) {
        for (int i = 0; i < actors.size(); i++) {
            spritePanel.draw(actors.get(i));
        }
    }

    public static void drawSpritePanel(SpritePanel spritePanel, TilePane pane) {
        for (int i = 0; i < spritePanel.getWidth(); i++) {
            for (int j = 0; j < spritePanel.getHeight(); j++) {
                pane.getChildren().add(new ImageView(new Image(String.valueOf(spritePanel.getData()[i][j].toURI()))));
            }
        }
    }
}
