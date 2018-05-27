package UserInterface.Controllers;

import UserInterface.Insertion.HighlightLogicGate;
import UserInterface.Insertion.InsertionFlag;
import static UserInterface.Insertion.InsertionFlag.*;
import core.Cell;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class GameGrid {

    private static int TILE_SIZE = 20;
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 600;
    private static int X_TILES = WIDTH / TILE_SIZE;
    private static int Y_TILES = HEIGHT / TILE_SIZE;
    private Tile[][] grid;
    private InsertionFlag insertionFlag = NORMAL;
    private HighlightLogicGate highlightLogicGate;

    public void setInsertionFlag(InsertionFlag flag) {
        this.insertionFlag = flag;
    }

    public GameGrid(int size) {
        setTileSize(size);
        calculateTilesNumber();
        grid = new Tile[X_TILES][Y_TILES];
        // logicGate = new InsertLogicGate(grid);
        highlightLogicGate = new HighlightLogicGate(grid);
        for (int x = 0; x < X_TILES; x++) {
            for (int y = 0; y < Y_TILES; y++) {
                Tile tile = new Tile(x, y, 0);
                grid[x][y] = tile;
            }
        }
    }

    public GameGrid() {
        grid = new Tile[X_TILES][Y_TILES];
        // logicGate = new InsertLogicGate(grid);
        highlightLogicGate = new HighlightLogicGate(grid);
        for (int x = 0; x < X_TILES; x++) {
            for (int y = 0; y < Y_TILES; y++) {
                Tile tile = new Tile(x, y, 0);
                grid[x][y] = tile;
            }
        }
    }

    public Parent fillGrid() {
        Pane root = new Pane();
        root.setPrefSize(WIDTH, HEIGHT);

        for (int x = 0; x < X_TILES; x++) {
            for (int y = 0; y < Y_TILES; y++) {
                //Tile tile = new Tile(x, y, 0);
                //grid[x][y] = tile;
                root.getChildren().add(grid[x][y]);
            }
        }
        return root;
    }

    private void setTileSize(int size) {
        this.TILE_SIZE = size;
    }

    public int getTileSize() {
        return this.TILE_SIZE;
    }

    public int getWidth() {
        return this.WIDTH;
    }

    public int getHeight() {
        return this.HEIGHT;
    }

    private void calculateTilesNumber() {
        this.X_TILES = this.WIDTH / this.TILE_SIZE;
        this.Y_TILES = this.HEIGHT / this.TILE_SIZE;
    }

    public void clearGrid() {
        for (int x = 0; x < X_TILES; x++) {
            for (int y = 0; y < Y_TILES; y++) {
                changeState(x, y, 0);;
            }
        }
    }

    public Tile[][] getGrid() {
        return grid;
    }

    public int getXTiles() {
        return X_TILES;
    }

    public int getYTiles() {
        return Y_TILES;
    }

    public int getGridState(int x, int y) {
        return grid[x][y].getState();
    }

    public void changeState(int x, int y, int newState) {
        switch (newState) {
            case 0:
                grid[x][y].blackTile();
                break;
            case 1:
                grid[x][y].yellowTile();
                break;
            case 2:
                grid[x][y].redTile();
                break;
            case 3:
                grid[x][y].blueTile();
                break;
            default:
                break;
        }
    }

    public Rectangle getRectangle(int x, int y) {
        return grid[x][y].border;
    }

    public Color getColor(int x, int y) {
        return grid[x][y].color;
    }

    public void updateGeneration(ArrayList<Cell> cells) {
        for (Cell cell : cells) {
            changeState(cell.getX(), cell.getY(), cell.getType());
        }
    }

    public class Tile extends StackPane {

        private int x, y;
        private int state;
        private Rectangle border = new Rectangle(TILE_SIZE, TILE_SIZE);
        private Color color = Color.BLACK;

        public Tile(int x, int y, int state) {
            this.x = x;
            this.y = y;
            this.state = state;

            //border.setStroke(Color.web("262626"));
            border.setStroke(Color.web("353333"));
            border.setFill(color);

            getChildren().addAll(border);
            setTranslateX(x * TILE_SIZE);
            setTranslateY(y * TILE_SIZE);

            AllowInsertionController allowInsert = new AllowInsertionController(X_TILES, Y_TILES);


            //  setOnMousePressed(e ->changeState(e, this.state));
            setOnMouseEntered(en -> allowInsert.placeIsAllowed(x, y, highlightLogicGate, insertionFlag));
            setOnMouseExited(ex -> allowInsert.leaveTile(grid, insertionFlag));
        }

        public int getX() {
            return this.x;
        }

        public Color getColor() {
            return color;
        }

        public Rectangle getTileBorder() {
            return border;
        }

        public int getY() {
            return this.y;
        }

        public int getState() {
            return this.state;
        }

        private void blackTile() {

            this.state = 0;
            this.color = Color.BLACK;
            border.setFill(color);

        }

        public void yellowTile() {

            this.state = 1;
            this.color = Color.YELLOW;
            border.setFill(color);

        }

        public void blueTile() {

            this.state = 3;
            this.color = Color.BLUE;
            border.setFill(color);

        }

        public void redTile() {

            this.state = 2;
            this.color = Color.RED;
            border.setFill(color);

        }

        public void highlightTile() {
            if (color == Color.BLACK) {
                border.setFill(this.color.brighter().brighter().brighter().brighter());
            } else {
                border.setFill(this.color.darker());
            }
        }

    }
}
