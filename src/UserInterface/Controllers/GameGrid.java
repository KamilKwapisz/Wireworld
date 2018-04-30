package UserInterface.Controllers;

import java.util.Random;
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

    public GameGrid(int size){
        setTileSize(size);
        calculateTilesNumber();
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

    private class Tile extends StackPane{
        private int x, y;
        private int state;
        private Rectangle border = new Rectangle(TILE_SIZE, TILE_SIZE);
        
        public Tile(int x, int y, int state){
            this.x = x;
            this.y = y;
            this.state = state;
            
            border.setStroke(Color.web("202020"));
            border.setFill(Color.BLACK);
            
            getChildren().addAll(border);
            setTranslateX(x * TILE_SIZE);
            setTranslateY(y * TILE_SIZE);
            
            setOnMousePressed(e ->changeState(e, this.state));

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
        

        public void blackTile(){
            this.state = 0;
            border.setFill(Color.BLACK);
        }
        public void yellowTile(){
            this.state = 1;
            border.setFill(Color.YELLOW);
        }
        public void blueTile(){
            this.state = 3;
            border.setFill(Color.BLUE);
        }
        public void redTile(){
            this.state = 2;
            border.setFill(Color.RED);
        }
        
        
        private void changeState(MouseEvent e, int currentState){
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
        
    }
}
