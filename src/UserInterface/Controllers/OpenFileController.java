package UserInterface.Controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;


public class OpenFileController implements FileController{
    private Image image;
    private FileChooser fileChooser;
    private PixelReader reader;

    public OpenFileController(GameGrid grid, Stage stage){
        createFileChooser(stage);
        try{
            reader = image.getPixelReader();
            System.out.println(grid.getXTiles() + "\n" + grid.getYTiles());
            loadToGrid(grid);
        } catch(NullPointerException e){
            System.out.println("Working bugfix (may be changed)");
            reader = null;
        }
    }

    @Override
    public void createFileChooser(Stage stage){
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PNG files", "*.png"),
                new FileChooser.ExtensionFilter("BMP files", "*.bmp"));
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        fileChooser.setTitle("Load generation");
        fileChooser.setInitialFileName("generation");
        File openedFile = fileChooser.showOpenDialog(stage);
        if(openedFile != null){
            try{
                BufferedImage bImage = ImageIO.read(openedFile);
                image = SwingFXUtils.toFXImage(bImage, null);
            }catch(IOException e){
                throw new RuntimeException(e);
            }
        }
    }

    private void loadToGrid(GameGrid grid){
        for(int x = 0; x < grid.getXTiles() && x < image.getWidth(); x++){
            for(int y = 0; y < image.getHeight() && y < grid.getYTiles(); y++){
                Color color = reader.getColor(x, y);
                if(color.equals(Color.BLACK)){
                    grid.changeState(x, y, 0);
                } else if(color.equals(Color.YELLOW)){
                    grid.changeState(x, y, 1);
                } else if(color.equals(Color.BLUE)){
                    grid.changeState(x, y, 3);
                } else if(color.equals(Color.RED)){
                    grid.changeState(x, y, 2);
                } else{
                    grid.changeState(x, y, 0);
                }
            }
        }
    }
}