package UserInterface.Controllers;

import LogicGate.Insertion.AllowInsertionController;
import LogicGate.Highlights.HighlightLogicGate;
import LogicGate.Insertion.InsertionFlag;
import static LogicGate.Insertion.InsertionFlag.*;
import core.Cell;
import core.CellType;
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
        highlightLogicGate = new HighlightLogicGate(grid);
        for (int x = 0; x < X_TILES; x++) {
            for (int y = 0; y < Y_TILES; y++) {
                Tile tile = new Tile(x, y, CellType.EMPTY);
                grid[x][y] = tile;
            }
        }
    }

    public GameGrid() {
        grid = new Tile[X_TILES][Y_TILES];
        highlightLogicGate = new HighlightLogicGate(grid);
        for (int x = 0; x < X_TILES; x++) {
            for (int y = 0; y < Y_TILES; y++) {
                Tile tile = new Tile(x, y, CellType.EMPTY);
                grid[x][y] = tile;
            }
        }
    }

    public Parent fillGrid() {
        // filling grid with tiles
        Pane root = new Pane();
        root.setPrefSize(WIDTH, HEIGHT);

        for (int x = 0; x < X_TILES; x++) {
            for (int y = 0; y < Y_TILES; y++) {
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
                changeState(x, y, CellType.EMPTY);;
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

    public CellType getGridState(int x, int y) {
        return grid[x][y].getState();
    }

    public void changeState(int x, int y, CellType newState) {
        switch (newState) {
            case EMPTY:
                grid[x][y].blackTile();
                break;
            case CONDUCTOR:
                grid[x][y].yellowTile();
                break;
            case TAIL:
                grid[x][y].redTile();
                break;
            case HEAD:
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

        private final int x;
        private final int y;
        private CellType state;
        private Rectangle border = new Rectangle(TILE_SIZE, TILE_SIZE);
        private Color color = Color.BLACK;

        public Tile(int x, int y, CellType state) {
            this.x = x;
            this.y = y;
            this.state = state;

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

        public CellType getState() {
            return this.state;
        }

        private void blackTile() {

            this.state = CellType.EMPTY;
            this.color = Color.BLACK;
            border.setFill(color);

        }

        public void yellowTile() {

            this.state = CellType.CONDUCTOR;
            this.color = Color.YELLOW;
            border.setFill(color);

        }

        public void blueTile() {

            this.state = CellType.HEAD;
            this.color = Color.BLUE;
            border.setFill(color);

        }

        public void redTile() {

            this.state = CellType.TAIL;
            this.color = Color.RED;
            border.setFill(color);

        }

        public void highlightTile() {
            // method highlights tile in logic gate insertion mode
            if (color == Color.BLACK) {
                border.setFill(this.color.brighter().brighter().brighter().brighter());
            } else {
                border.setFill(this.color.darker());
            }
        }
    }
}
