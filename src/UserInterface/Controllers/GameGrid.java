package UserInterface.Controllers;

import UserInterface.Insertion.InsertionFlag;
import static UserInterface.Insertion.InsertionFlag.*;
import UserInterface.Insertion.XorInsertion;
import java.util.Random;

import core.WireworldSimulation;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class GameGrid {
    private static int TILE_SIZE = 20;
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 600;
    private static int X_TILES = WIDTH / TILE_SIZE;
    private static int Y_TILES = HEIGHT / TILE_SIZE;;
    private Tile[][] grid;

    private InsertionFlag insertionFlag = NORMAL;
    
    public void setInsertionFlag(InsertionFlag flag){
        this.insertionFlag = flag;
    }
    
    public GameGrid(int size){
        setTileSize(size);
        calculateTilesNumber();
        grid = new Tile[X_TILES][Y_TILES];
    }

    public GameGrid(){
        grid = new Tile[X_TILES][Y_TILES];
    }
    
    public Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(WIDTH, HEIGHT);
        
        for(int x = 0; x < X_TILES; x++){
            for(int y = 0; y < Y_TILES; y++){
                Tile tile = new Tile(x, y, 0);
                grid[x][y] = tile;
                
                root.getChildren().add(tile);
            }
        }

        return root;
    }
    
    private void setTileSize(int size){
        this.TILE_SIZE = size;
    }
    
    private void calculateTilesNumber(){
        this.X_TILES = this.WIDTH / this.TILE_SIZE;
        this.Y_TILES = this.HEIGHT / this.TILE_SIZE;
    }
    
    public void clearGrid(){
        for(int x = 0; x < X_TILES; x++){
            for(int y = 0; y < Y_TILES; y++){
                changeState(x, y, 0);
                //grid[x][y].blackTile();
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
            
            setOnMousePressed(e ->changeState(e, this.state));
            setOnMouseEntered(en ->placeIsAllowed());
            setOnMouseExited(ex->placeExit());

            

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
            this.state = 0;
            this.color = Color.BLACK;
            border.setFill(color);
        }
        public void yellowTile(){
            this.state = 1;
            this.color = Color.YELLOW;
            border.setFill(color);
        }
        private void blueTile(){
            this.state = 3;
            this.color = Color.BLUE;
            border.setFill(color);
        }
        private void redTile(){
            this.state = 2;
            this.color = Color.RED;
            border.setFill(color);
        }
        
        private void placeIsAllowed(){
            if(insertionFlag == AND_TOP){
                if(this.x >= 3 && this.x <= X_TILES - 6 && this.y >= 17){
                    if(color == Color.BLACK){
                        border.setFill(this.color.brighter().brighter().brighter().brighter());
                    } else{
                        border.setFill(this.color.darker());
                    }
                }
            } else if(insertionFlag == AND_BOT){
                if(this.x >= 5 && this.x <= X_TILES - 4 && this.y <= Y_TILES - 18){
                    if(color == Color.BLACK){
                        border.setFill(this.color.brighter().brighter().brighter().brighter());
                    } else{
                        border.setFill(this.color.darker());
                    }
                }
            } else if(insertionFlag == AND_LEFT){
                if(this.x >= 17 && this.y >= 5 && this.y <= Y_TILES - 4){
                    if(color == Color.BLACK){
                        border.setFill(this.color.brighter().brighter().brighter().brighter());
                    } else{
                        border.setFill(this.color.darker());
                    }
                }
            } else if(insertionFlag == AND_RIGHT){
                if(this.x <= X_TILES - 18 && this.y >= 3 && this.y <= Y_TILES - 6){
                    if(color == Color.BLACK){
                        border.setFill(this.color.brighter().brighter().brighter().brighter());
                    } else{
                        border.setFill(this.color.darker());
                    }
                }
            } else if(insertionFlag == OR_TOP){
                if(this.x >= 1 && this.x <= X_TILES - 4 && this.y >= 8){
                    if(color == Color.BLACK){
                        border.setFill(this.color.brighter().brighter().brighter().brighter());
                    } else{
                        border.setFill(this.color.darker());
                    }
                }
            } else if(insertionFlag == OR_BOT){
                if(this.x >= 3 && this.x <= X_TILES - 2 && this.y <= Y_TILES - 9){
                    if(color == Color.BLACK){
                        border.setFill(this.color.brighter().brighter().brighter().brighter());
                    } else{
                        border.setFill(this.color.darker());
                    }
                }
            } else if(insertionFlag == OR_LEFT){
                if(this.x >= 8 && this.y >= 3 && this.y <= Y_TILES - 2){
                    if(color == Color.BLACK){
                        border.setFill(this.color.brighter().brighter().brighter().brighter());
                    } else{
                        border.setFill(this.color.darker());
                    }
                }
            } else if(insertionFlag == OR_RIGHT){
                if(this.x <= X_TILES - 9 && this.y >= 1 && this.y <= Y_TILES - 4){
                    if(color == Color.BLACK){
                        border.setFill(this.color.brighter().brighter().brighter().brighter());
                    } else{
                        border.setFill(this.color.darker());
                    }
                }
            } else if(insertionFlag == XOR_TOP){
                if(this.x >= 2 && this.x <= X_TILES - 4 && this.y >= 10){
                    if(color == Color.BLACK){
                        border.setFill(this.color.brighter().brighter().brighter().brighter());
                    } else{
                        border.setFill(this.color.darker());
                    }
                }
            } else if(insertionFlag == XOR_BOT){
                if(this.x >= 4 && this.x <= X_TILES - 3 && this.y <= Y_TILES - 11){
                    if(color == Color.BLACK){
                        border.setFill(this.color.brighter().brighter().brighter().brighter());
                    } else{
                        border.setFill(this.color.darker());
                    }
                }
            } else if(insertionFlag == XOR_LEFT){
                if(this.x >= 10 && this.y >= 4 && this.y <= Y_TILES - 3){
                    if(color == Color.BLACK){
                        border.setFill(this.color.brighter().brighter().brighter().brighter());
                    } else{
                        border.setFill(this.color.darker());
                    }
                }
            } else if(insertionFlag == XOR_RIGHT){
                if(this.x <= X_TILES - 11 && this.y >= 2 && this.y <= Y_TILES - 5){
                    if(color == Color.BLACK){
                        border.setFill(this.color.brighter().brighter().brighter().brighter());
                    } else{
                        border.setFill(this.color.darker());
                    }
                }
            } else if(insertionFlag == NAND_TOP){
                if(this.x >= 5 && this.x <= X_TILES - 8 && this.y >= 13){
                    if(color == Color.BLACK){
                        border.setFill(this.color.brighter().brighter().brighter().brighter());
                    } else{
                        border.setFill(this.color.darker());
                    }
                }
            } else if(insertionFlag == NAND_BOT){
                if(this.x >= 7 && this.x <= X_TILES - 6 && this.y <= Y_TILES - 14){
                    if(color == Color.BLACK){
                        border.setFill(this.color.brighter().brighter().brighter().brighter());
                    } else{
                        border.setFill(this.color.darker());
                    }
                }
            } else if(insertionFlag == NAND_LEFT){
                if(this.x >= 13 && this.y >= 7 && this.y <= Y_TILES - 6){
                    if(color == Color.BLACK){
                        border.setFill(this.color.brighter().brighter().brighter().brighter());
                    } else{
                        border.setFill(this.color.darker());
                    }
                }
            } else if(insertionFlag == NAND_RIGHT){
                if(this.x <= X_TILES - 14 && this.y >= 5 && this.y <= Y_TILES - 8){
                    if(color == Color.BLACK){
                        border.setFill(this.color.brighter().brighter().brighter().brighter());
                    } else{
                        border.setFill(this.color.darker());
                    }
                }
            } else{
                
            }
        }
        private void placeExit(){
            if(insertionFlag == NORMAL){
                
            } else{
                border.setFill(this.color);
            }
        }
                
                
        private void changeState(MouseEvent e, int currentState){
            if(insertionFlag == NORMAL || insertionFlag == AND_TOP){
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
            } 
            //else if(insertionFlag == AND_TOP){
                
            //} 
                else if(insertionFlag == AND_BOT){
                
            } else if(insertionFlag == AND_LEFT){
                
            } else if(insertionFlag == AND_RIGHT){
                
            } else if(insertionFlag == OR_TOP){
                
            } else if(insertionFlag == OR_BOT){
                
            } else if(insertionFlag == OR_LEFT){
                
            } else if(insertionFlag == OR_RIGHT){
                
            } else if(insertionFlag == XOR_TOP){
                if(this.x >= 2 && this.x <= X_TILES - 4 && this.y >= 10){
                    XorInsertion xorInsertion = new XorInsertion();
                    if(e.isPrimaryButtonDown()){
                        xorInsertion.insertTop(grid, x, y);
                        insertionFlag = NORMAL;
                    } else if(e.isSecondaryButtonDown()){
                        /* Cancel inserting */
                        border.setFill(this.color);
                        insertionFlag = NORMAL;
                    }
                }
            } else if(insertionFlag == XOR_BOT){
                
            } else if(insertionFlag == XOR_LEFT){
                
            } else if(insertionFlag == XOR_RIGHT){
                
            } else if(insertionFlag == NAND_TOP){
                
            } else if(insertionFlag == NAND_BOT){
                
            } else if(insertionFlag == NAND_LEFT){
                
            } else if(insertionFlag == NAND_RIGHT){
                
            }
        }  
    }
}
