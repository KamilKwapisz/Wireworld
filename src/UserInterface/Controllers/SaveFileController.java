package UserInterface.Controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javax.imageio.ImageIO;


public class SaveFileController {
    private WritableImage image;
    private FileChooser fileChooser;
    private final PixelWriter writer;
    public SaveFileController(GameGrid grid){
        image = new WritableImage(grid.getXTiles(), grid.getYTiles());
        writer = image.getPixelWriter();
        
        for(int x = 0; x < grid.getXTiles(); x++){
            for(int y = 0; y < grid.getYTiles(); y++){
                if(grid.getGridState(x, y) == 0){
                    writer.setColor(x, y, Color.BLACK);
                } else if(grid.getGridState(x, y) == 1){
                    writer.setColor(x, y, Color.YELLOW);
                } else if(grid.getGridState(x, y) == 2){
                    writer.setColor(x, y, Color.BLUE);
                } else if(grid.getGridState(x, y) == 3){
                    writer.setColor(x, y, Color.RED);
                }
            }
        }
        createFileChooser();
    }
    
    private void createFileChooser(){
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("PNG files", "*.png"),
                new ExtensionFilter("JPG files", "*.jpg"),
                new ExtensionFilter("BMP files", "*.bmp"));
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.setTitle("Save generation");
        fileChooser.setInitialFileName("generacja");
        File savedFile = fileChooser.showSaveDialog(null);
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        String fileName = savedFile.getName();          
        String extension = fileName.substring(fileName.indexOf(".") + 1, savedFile.getName().length());
        try{
            ImageIO.write(bImage, extension, savedFile);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        
        /* Test print */
        if(savedFile != null){
            System.out.println("File path:" +  savedFile);
        }
        
    }
}
