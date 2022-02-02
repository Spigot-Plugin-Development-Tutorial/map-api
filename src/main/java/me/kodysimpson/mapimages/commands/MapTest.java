package me.kodysimpson.mapimages.commands;

import me.kodysimpson.mapimages.ImageMapRenderer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapView;

public class MapTest implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //make sure they are a player
        if(sender instanceof Player player){

            //see if there was an argument provided, and if so, grab it
            String imageURL;
            if(args.length > 0){
                imageURL = args[0];
            }else{
                player.sendMessage("An image URL was not provided, using the default Mr. Dewey image.");
                //if not, use the default image
               imageURL = "https://media.discordapp.net/attachments/562679683364159488/929026632092647434/20220107_085603.jpg";
            }

            //Create a new map ITEM, which we will set the MapMeta of to be the map
            ItemStack itemStack = new ItemStack(Material.FILLED_MAP);
            MapMeta mapMeta = (MapMeta) itemStack.getItemMeta();

            //create a new map
            MapView mapView = Bukkit.createMap(player.getWorld());

            //remove any current renderers from the map(the default renderer)
            mapView.getRenderers().clear();

            //create an instance of our custom renderer and pass in the url of an image to render
            ImageMapRenderer renderer = new ImageMapRenderer(imageURL);

            //add the renderer to the map so that it will be rendered
            mapView.addRenderer(renderer);

            //set the map meta to the map we just created
            mapMeta.setMapView(mapView);
            //set the item meta to the map meta
            itemStack.setItemMeta(mapMeta);

            //give the player the map
            player.getInventory().addItem(itemStack);

            player.sendMessage("Map created and given!");
        }

        return true;
    }
}
