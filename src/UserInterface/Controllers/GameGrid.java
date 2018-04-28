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
            border.setStroke(Color.web("181818"));
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
        
        public void setState(int state){
            this.state = state;
        }
        
        public void changeState(MouseEvent e, int currentState){
            if(e.isPrimaryButtonDown()){
                if(currentState == 1){
                    setState(0);
                    border.setFill(Color.BLACK);
                } else{
                    setState(1);
                    border.setFill(Color.YELLOW);
                }
            } else if(e.isSecondaryButtonDown()){
                if(currentState == 4){
                    setState(0);
                    border.setFill(Color.BLACK);
                } else if(currentState == 3){
                    setState(4);
                    border.setFill(Color.RED);
                } else{
                    setState(3);
                    border.setFill(Color.BLUE);
                }
            }
        } 
        
    }
}
