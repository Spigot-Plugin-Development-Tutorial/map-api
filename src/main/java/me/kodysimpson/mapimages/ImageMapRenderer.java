package me.kodysimpson.mapimages;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.map.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

//My custom MapRenderer class because MapRenderer itself is abstract
public class ImageMapRenderer extends MapRenderer {

    private final String url;

    public ImageMapRenderer(String url) {
        this.url = url;
    }

    @Override
    public void render(MapView map, MapCanvas canvas, Player player) {

        //MapView = the map itself
        //MapCanvas = the visual canvas of the map/responsible for doing the drawing
        //MapRenderer = the class that dictates how the map is drawn/what will be drawn
        //MapPallete = a sort of utility class that contains the colors of the map and resizing capability

        // The coordinate of the top left corner of the map is (0, 0)
        // The coordinate of the bottom right corner of the map is (127, 127)

        try {
            //get an image of a Dog from the internet
            URL url = new URL(this.url);
            BufferedImage image = ImageIO.read(url);
            canvas.drawImage(0, 0, MapPalette.resizeImage(image));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //try drawing Subscribe on the map
//        canvas.drawText(5, 0, MinecraftFont.Font, "Subscribe or i will");
//        canvas.drawText(5, 10, MinecraftFont.Font, "chop you in the ");
//        canvas.drawText(5, 20, MinecraftFont.Font, "eyebrows!");
//
//        canvas.drawText(5, 30, MinecraftFont.Font, "Multiple \nlines");
//
//        drawHeart(canvas);
    }

    //Draw a red smiley face on the canvas that is 0-127 in the x and y axis
    private void drawHeart(MapCanvas canvas){
        for (int x = 0; x < 128; x++) {
            for (int y = 0; y < 128; y++) {
                if(x % 2 == 0 && y % 2 == 0){
                    canvas.setPixel(x, y, MapPalette.RED);
                }else{
                    canvas.setPixel(x, y, MapPalette.BLUE);
                }
            }
        }
    }
}
