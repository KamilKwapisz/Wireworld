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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.imageio.ImageIO;


public class SaveFileController implements FileController {
    private WritableImage image;
    private FileChooser fileChooser;
    private final PixelWriter writer;
    
    public SaveFileController(GameGrid grid, Stage stage){
        image = new WritableImage(grid.getXTiles(), grid.getYTiles());
        writer = image.getPixelWriter();
        
        for(int x = 0; x < grid.getXTiles(); x++){
            for(int y = 0; y < grid.getYTiles(); y++){
                switch (grid.getGridState(x, y)) {
                    case 0:
                        writer.setColor(x, y, Color.BLACK);
                        break;
                    case 1:
                        writer.setColor(x, y, Color.YELLOW);
                        break;
                    case 2:
                        writer.setColor(x, y, Color.RED);
                        break;
                    case 3:
                        writer.setColor(x, y, Color.BLUE);
                        break;
                    default:
                        break;
                }
            }
        }
        createFileChooser(stage);
    }
    
    @Override
    public void createFileChooser(Stage stage){
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("PNG files", "*.png"),
                new ExtensionFilter("BMP files", "*.bmp"));
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        fileChooser.setTitle("Save generation");
        fileChooser.setInitialFileName("generation");
        File savedFile = fileChooser.showSaveDialog(stage);
        
        if(savedFile != null){
            BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
            BufferedImage bImage2 = new BufferedImage(bImage.getWidth(), bImage.getHeight(), BufferedImage.TYPE_INT_RGB);
            bImage2.getGraphics().drawImage(bImage, 0, 0, null);
            String fileName = savedFile.getName();          
            String extension = fileName.substring(fileName.indexOf(".") + 1, savedFile.getName().length());
             try{
                ImageIO.write(bImage2, extension, savedFile);
            }catch(IOException e){
                throw new RuntimeException(e);
            }
        }
        /* Test print */
        System.out.println("File path:" +  savedFile);

        if (!checkIsAvaliableDiskSpace(savedFile+"")){
            System.out.println("not enough space");
            // error
        } else {
            // everything cool
        }
        
        
    }

    private boolean checkIsAvaliableDiskSpace(String filePath) {
        File file = new File(filePath);
        if (file.getUsableSpace() < 5000 )
            return false;
        else
            return true;
    }

}
