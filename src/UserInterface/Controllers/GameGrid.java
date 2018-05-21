package UserInterface.Controllers;

import UserInterface.Insertion.InsertionFlag;
import static UserInterface.Insertion.InsertionFlag.*;
import UserInterface.Insertion.LogicGate;
import core.Cell;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
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
    private static int Y_TILES = HEIGHT / TILE_SIZE;;
    private Tile[][] grid;
    private InsertionFlag insertionFlag = NORMAL;
    private LogicGate logicGate;
    
    public void setInsertionFlag(InsertionFlag flag){
        this.insertionFlag = flag;
    }
    
    public GameGrid(int size){
        setTileSize(size);
        calculateTilesNumber();
        grid = new Tile[X_TILES][Y_TILES];
        logicGate = new LogicGate(grid);
        //fillGrid();
        for(int x = 0; x < X_TILES; x++){
            for(int y = 0; y < Y_TILES; y++){
                Tile tile = new Tile(x, y, 0);
                grid[x][y] = tile;
            }
        }
    }

    public GameGrid(){
        grid = new Tile[X_TILES][Y_TILES];
        logicGate = new LogicGate(grid);
        //fillGrid();
        for(int x = 0; x < X_TILES; x++){
            for(int y = 0; y < Y_TILES; y++){
                Tile tile = new Tile(x, y, 0);
                grid[x][y] = tile;
            }
        }
    }
    
    public Parent fillGrid() {
        Pane root = new Pane();
        root.setPrefSize(WIDTH, HEIGHT);
        
        for(int x = 0; x < X_TILES; x++){
            for(int y = 0; y < Y_TILES; y++){
                //Tile tile = new Tile(x, y, 0);
                //grid[x][y] = tile;
                root.getChildren().add(grid[x][y]);
            }
        }
        return root;
    }
    
    private void setTileSize(int size){
        this.TILE_SIZE = size;
    }
    
    public int getTileSize(){
        return this.TILE_SIZE;
    }
    
    public int getWidth(){
        return this.WIDTH;
    }
    
    public int getHeight(){
        return this.HEIGHT;
    }
    
    private void calculateTilesNumber(){
        this.X_TILES = this.WIDTH / this.TILE_SIZE;
        this.Y_TILES = this.HEIGHT / this.TILE_SIZE;
    }
    
    public void clearGrid(){
        for(int x = 0; x < X_TILES; x++){
            for(int y = 0; y < Y_TILES; y++){
                changeState(x, y, 0);;
            }
        }
    }
    
    public Tile[][] getGrid(){
        return grid;
    }
    
    public int getXTiles(){
        return X_TILES;
    }
    
    public int getYTiles(){
        return Y_TILES;
    }
    
    public int getGridState(int x, int y){
        return grid[x][y].getState();
    }
    
    
    public void changeState(int x, int y, int newState){
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

    public void updateGeneration(ArrayList<Cell> cells){
        for( Cell cell : cells)
            changeState(cell.getX(), cell.getY(), cell.getType());
    }

    public class Tile extends StackPane{
        private int x, y;
        private int state;
        private Rectangle border = new Rectangle(TILE_SIZE, TILE_SIZE);
        private Color color = Color.BLACK;
        
        public Tile(int x, int y, int state){
            this.x = x;
            this.y = y;
            this.state = state;
            
            border.setStroke(Color.web("262626"));
            border.setFill(color);
            
            getChildren().addAll(border);
            setTranslateX(x * TILE_SIZE);
            setTranslateY(y * TILE_SIZE);
            
          //  setOnMousePressed(e ->changeState(e, this.state));
            setOnMouseEntered(en ->placeIsAllowed());
            setOnMouseExited(ex->leaveTile());
        }
        
        public int getX(){
            return this.x;
        }
        
        public int getY(){
            return this.y;
        }
        
        public int getState(){
            return this.state;
        }
        

        private void blackTile(){
            if(this.state != 0){
                this.state = 0;
                this.color = Color.BLACK;
                border.setFill(color);
            }
        }
        public void yellowTile(){
            if(this.state != 1){
                this.state = 1;
                this.color = Color.YELLOW;
                border.setFill(color);
            }
        }
        public void blueTile(){
            if(this.state != 3){
                this.state = 3;
                this.color = Color.BLUE;
                border.setFill(color);
            }
        }
        public void redTile(){
            if(this.state != 2){
                this.state = 2;
                this.color = Color.RED;
                border.setFill(color);
            }
        }
        
        private void highlightTile(){
            if(color == Color.BLACK){
                border.setFill(this.color.brighter().brighter().brighter().brighter());
            } else{
                border.setFill(this.color.darker());
            }
        }
        
        /* Highloghts tiles when user can insert logicGate. Used in onEntered event */
        private void placeIsAllowed(){
            if(insertionFlag == AND_TOP){
                if(this.x >= 3 && this.x <= X_TILES - 6 && this.y >= 17){
                    highlightTile();
                }
            } else if(insertionFlag == AND_BOT){
                if(this.x >= 5 && this.x <= X_TILES - 4 && this.y <= Y_TILES - 18){
                    highlightTile();
                }
            } else if(insertionFlag == AND_LEFT){
                if(this.x >= 17 && this.y >= 5 && this.y <= Y_TILES - 4){
                    highlightTile();
                }
            } else if(insertionFlag == AND_RIGHT){
                if(this.x <= X_TILES - 18 && this.y >= 3 && this.y <= Y_TILES - 6){
                    highlightTile();
                }
            } else if(insertionFlag == OR_TOP){
                if(this.x >= 1 && this.x <= X_TILES - 4 && this.y >= 8){
                    highlightTile();
                }
            } else if(insertionFlag == OR_BOT){
                if(this.x >= 3 && this.x <= X_TILES - 2 && this.y <= Y_TILES - 9){
                    highlightTile();
                }
            } else if(insertionFlag == OR_LEFT){
                if(this.x >= 8 && this.y >= 3 && this.y <= Y_TILES - 2){
                    highlightTile();
                }
            } else if(insertionFlag == OR_RIGHT){
                if(this.x <= X_TILES - 9 && this.y >= 1 && this.y <= Y_TILES - 4){
                    highlightTile();
                }
            } else if(insertionFlag == XOR_TOP){
                if(this.x >= 2 && this.x <= X_TILES - 4 && this.y >= 10){
                    highlightTile();
                }
            } else if(insertionFlag == XOR_BOT){
                if(this.x >= 4 && this.x <= X_TILES - 3 && this.y <= Y_TILES - 11){
                    highlightTile();
                }
            } else if(insertionFlag == XOR_LEFT){
                if(this.x >= 10 && this.y >= 4 && this.y <= Y_TILES - 3){
                    highlightTile();
                }
            } else if(insertionFlag == XOR_RIGHT){
                if(this.x <= X_TILES - 11 && this.y >= 2 && this.y <= Y_TILES - 5){
                    highlightTile();
                }
            } else if(insertionFlag == NAND_TOP){
                if(this.x >= 5 && this.x <= X_TILES - 8 && this.y >= 13){
                    highlightTile();
                }
            } else if(insertionFlag == NAND_BOT){
                if(this.x >= 7 && this.x <= X_TILES - 6 && this.y <= Y_TILES - 14){
                    highlightTile();
                }
            } else if(insertionFlag == NAND_LEFT){
                if(this.x >= 13 && this.y >= 7 && this.y <= Y_TILES - 6){
                    highlightTile();
                }
            } else if(insertionFlag == NAND_RIGHT){
                if(this.x <= X_TILES - 14 && this.y >= 5 && this.y <= Y_TILES - 8){
                    highlightTile();
                }
            } else if(insertionFlag == NOT_TOP){
                if(this.x >= 2 && this.x <= X_TILES - 4 && this.y >= 11){
                    highlightTile();
                }
            } else if(insertionFlag == NOT_BOT){
                if(this.x >= 2 && this.x <= X_TILES - 3 && this.y <= Y_TILES - 12){
                    highlightTile();
                }
            } else if(insertionFlag == NOT_LEFT){
                if(this.x >= 11 && this.y >= 2 && this.y <= Y_TILES - 3){
                    highlightTile();
                }
            } else if(insertionFlag == NOT_RIGHT){
                if(this.x <= X_TILES - 12 && this.y >= 2 && this.y <= Y_TILES - 4){
                    highlightTile();
                }
            }
        }
        /* recover color when mouse leaves the tile. Works when inserting logicGate in onExit event */
        private void leaveTile(){
            if(insertionFlag != NORMAL){
                border.setFill(this.color);
            }
        }
                
        private void cancelInserting(){
            border.setFill(this.color);
            insertionFlag = NORMAL;
        }
        
        private void insertAnd(){
            logicGate.setProperties(this.x, this.y, insertionFlag);
            logicGate.insertAnd();
            insertionFlag = NORMAL;
        }
        private void insertOr(){
            logicGate.setProperties(this.x, this.y, insertionFlag);
            logicGate.insertOr();
            insertionFlag = NORMAL;
        }
        private void insertXor(){
            logicGate.setProperties(this.x, this.y, insertionFlag);
            logicGate.insertXor();
            insertionFlag = NORMAL;
        }
        private void insertNand(){
            logicGate.setProperties(this.x, this.y, insertionFlag);
            logicGate.insertNand();
            insertionFlag = NORMAL;
        }
        private void insertNot(){
            logicGate.setProperties(this.x, this.y, insertionFlag);
            logicGate.insertNot();
            insertionFlag = NORMAL;
        }
        
        /* Change tile state or insert logicGate. Used in onPressed event */
        
        /* Method not used - moving mouse events from each Tile to one global mouse event. Temporary version for reminding */
        private void changeState(MouseEvent e, int currentState){
            if(insertionFlag == NORMAL){
                if(e.isPrimaryButtonDown()){
                    if(currentState == 1){
                        blackTile();
                    } else{
                      yellowTile();
                    }
                } else if(e.isSecondaryButtonDown()){
                    if(currentState == 2){
                        blackTile();
                     } else if(currentState == 3){
                        redTile();
                    } else{
                        blueTile();
                    }
                }
            } else if(insertionFlag == AND_TOP){
                if(e.isPrimaryButtonDown()){
                    if(this.x >= 3 && this.x <= X_TILES - 6 && this.y >= 17){
                        insertAnd();
                    }
                } else if(e.isSecondaryButtonDown()){
                    cancelInserting();
                }
            } else if(insertionFlag == AND_BOT){
                if(e.isPrimaryButtonDown()){
                    if(this.x >= 5 && this.x <= X_TILES - 4 && this.y <= Y_TILES - 18){
                        insertAnd();
                    }
                } else if(e.isSecondaryButtonDown()){
                    cancelInserting();
                }
            } else if(insertionFlag == AND_LEFT){
                if(e.isPrimaryButtonDown()){
                    if(this.x >= 17 && this.y >= 5 && this.y <= Y_TILES - 4){
                        insertAnd();
                    }
                } else if(e.isSecondaryButtonDown()){
                    cancelInserting();
                }
            } else if(insertionFlag == AND_RIGHT){
                if(e.isPrimaryButtonDown()){
                    if(this.x <= X_TILES - 18 && this.y >= 3 && this.y <= Y_TILES - 6){
                        insertAnd();
                    }
                } else if(e.isSecondaryButtonDown()){
                    cancelInserting();
                }
            } else if(insertionFlag == OR_TOP){
                if(e.isPrimaryButtonDown()){
                    if(this.x >= 1 && this.x <= X_TILES - 4 && this.y >= 8){
                        insertOr();
                    }
                } else if(e.isSecondaryButtonDown()){
                    cancelInserting();
                }
            } else if(insertionFlag == OR_BOT){
                if(e.isPrimaryButtonDown()){
                    if(this.x >= 3 && this.x <= X_TILES - 2 && this.y <= Y_TILES - 9){
                        insertOr();
                    }
                } else if(e.isSecondaryButtonDown()){
                    cancelInserting();
                }
            } else if(insertionFlag == OR_LEFT){
                if(e.isPrimaryButtonDown()){
                    if(this.x >= 8 && this.y >= 3 && this.y <= Y_TILES - 2){
                        insertOr();
                    }
                } else if(e.isSecondaryButtonDown()){
                    cancelInserting();
                }
            } else if(insertionFlag == OR_RIGHT){
                if(e.isPrimaryButtonDown()){
                    if(this.x <= X_TILES - 9 && this.y >= 1 && this.y <= Y_TILES - 4){
                        insertOr();
                    }
                } else if(e.isSecondaryButtonDown()){
                    cancelInserting();
                }
            } else if(insertionFlag == XOR_TOP){
                if(e.isPrimaryButtonDown()){
                    if(this.x >= 2 && this.x <= X_TILES - 4 && this.y >= 10){
                        insertXor();
                    }
                } else if(e.isSecondaryButtonDown()){
                    cancelInserting();
                }
            } else if(insertionFlag == XOR_BOT){
                if(e.isPrimaryButtonDown()){
                    if(this.x >= 4 && this.x <= X_TILES - 3 && this.y <= Y_TILES - 11){
                        insertXor();
                    }
                } else if(e.isSecondaryButtonDown()){
                    cancelInserting();
                }
            } else if(insertionFlag == XOR_LEFT){
                if(e.isPrimaryButtonDown()){
                    if(this.x >= 10 && this.y >= 4 && this.y <= Y_TILES - 3){
                        insertXor();
                    }
                } else if(e.isSecondaryButtonDown()){
                    cancelInserting();
                }
            } else if(insertionFlag == XOR_RIGHT){
                if(e.isPrimaryButtonDown()){
                    if(this.x <= X_TILES - 11 && this.y >= 2 && this.y <= Y_TILES - 5){
                        insertXor();
                    }
                } else if(e.isSecondaryButtonDown()){
                    cancelInserting();
                }
            } else if(insertionFlag == NAND_TOP){
                if(e.isPrimaryButtonDown()){
                    if(this.x >= 5 && this.x <= X_TILES - 8 && this.y >= 13){
                        insertNand();
                    }
                } else if(e.isSecondaryButtonDown()){
                    cancelInserting();
                }
            } else if(insertionFlag == NAND_BOT){
                if(e.isPrimaryButtonDown()){
                    if(this.x >= 7 && this.x <= X_TILES - 6 && this.y <= Y_TILES - 14){
                        insertNand();
                    }
                } else if(e.isSecondaryButtonDown()){
                    cancelInserting();
                }
            } else if(insertionFlag == NAND_LEFT){
                if(e.isPrimaryButtonDown()){
                    if(this.x >= 13 && this.y >= 7 && this.y <= Y_TILES - 6){
                        insertNand();
                    }
                } else if(e.isSecondaryButtonDown()){
                    cancelInserting();
                }
            } else if(insertionFlag == NAND_RIGHT){
                if(e.isPrimaryButtonDown()){
                    if(this.x <= X_TILES - 14 && this.y >= 5 && this.y <= Y_TILES - 8){
                        insertNand();
                    }
                } else if(e.isSecondaryButtonDown()){
                    cancelInserting();
                }
            } else if(insertionFlag == NOT_TOP){
                if(e.isPrimaryButtonDown()){
                    if(this.x >= 2 && this.x <= X_TILES - 4 && this.y >= 11){
                        insertNot();
                    }
                } else if(e.isSecondaryButtonDown()){
                    cancelInserting();
                }
            } else if(insertionFlag == NOT_BOT){
                if(e.isPrimaryButtonDown()){
                    if(this.x >= 2 && this.x <= X_TILES - 3 && this.y <= Y_TILES - 12){
                        insertNot();
                    }
                } else if(e.isSecondaryButtonDown()){
                    cancelInserting();
                }
            } else if(insertionFlag == NOT_LEFT){
                if(e.isPrimaryButtonDown()){
                    if(this.x >= 11 && this.y >= 2 && this.y <= Y_TILES - 3){
                        insertNot();
                    }
                } else if(e.isSecondaryButtonDown()){
                    cancelInserting();
                }
            } else if(insertionFlag == NOT_RIGHT){
                if(e.isPrimaryButtonDown()){
                    if(this.x <= X_TILES - 12 && this.y >= 2 && this.y <= Y_TILES - 4){
                        insertNot();
                    }
                } else if(e.isSecondaryButtonDown()){
                    cancelInserting();
                }
            }
        }  
    }
}
