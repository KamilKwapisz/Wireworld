package UserInterface.Controllers;

import java.util.Random;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class GameGrid {
    private static final int TILE_SIZE = 20;
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 595;
    private static final int X_TILES = WIDTH / TILE_SIZE;
    private static final int Y_TILES = HEIGHT / TILE_SIZE;

    private Tile[][] grid = new Tile[X_TILES][Y_TILES];
    
    public Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(WIDTH, HEIGHT);
        
        for(int x = 0; x < X_TILES; x++){
            for(int y = 0; y < Y_TILES; y++){
                Random generator = new Random();
                
                int i = generator.nextInt(4);
               /* Change 0 to i for random state to generate colorfull grid. */
                Tile tile = new Tile(x, y, 0);
                
                grid[x][y] = tile;
                root.getChildren().add(tile);
            }
        }
        
        return root;
    }
    
    public void clearGrid(){
        for(int x = 0; x < X_TILES; x++){
            for(int y = 0; y < Y_TILES; y++){
                grid[x][y].blackTile();
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
    
    public void setBlack(int x, int y){
        grid[x][y].blackTile();
    }
    public void setYellow(int x, int y){
        grid[x][y].yellowTile();
    }
    public void setBlue(int x, int y){
        grid[x][y].blueTile();
    }
    public void setRed(int x, int y){
        grid[x][y].redTile();
    }
    
    private class Tile extends StackPane{
        private int x, y;
        private int state;
        private Rectangle border = new Rectangle(TILE_SIZE, TILE_SIZE);
        
        public Tile(int x, int y, int state){
            this.x = x;
            this.y = y;
            this.state = state;
            
            
            /* We can remove this switch as soon as it works.
            ** We just need state = 0 on app load.
            */
            border.setStroke(Color.web("202020"));
            switch (this.state) {
                case 0:
                    border.setFill(Color.BLACK);
                    break;
                case 1:
                    border.setFill(Color.YELLOW);
                    break;
                case 2:
                    border.setFill(Color.RED);
                    break;
                case 3:
                    border.setFill(Color.BLUE);
                    break;
                default:
                    break;
            }
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
            this.state = 2;
            border.setFill(Color.BLUE);
        }
        public void redTile(){
            this.state = 3;
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
                if(currentState == 3){
                    blackTile();
                } else if(currentState == 2){
                    redTile();
                } else{
                    blueTile();
                }
            }
        } 
        
    }
}
