package settlersofcatan;

import java.awt.Image;

public class Tile{
    public int[] tileData = new int[12]; // starting at the N position of the hex tile and circling clockwise from 0-11
    // - 0 Nothing
    // tileData Player 1 
    // - 1 Settlement
    // - 2 City
    // - 3 Road
    // tileData Player 2 
    // - 4 Settlement
    // - 5 City
    // - 6 Road
    // tileData Player 3 
    // - 7 Settlement
    // - 8 City
    // - 9 Road
    // tileData Player 4 
    // - 10 Settlement
    // - 11 City
    // - 12 Road
    public Tile[] neighborTiles = new Tile[6]; // starting NW and going clockwise from 0-5 
    
    public String tile;
    public int roll;
    public Image img;
    public void setTile(String tile){ 
        this.tile = tile; // port, wood, sheep, wheat, brick, ore, desert
    }
    public void setTile(int roll){
        this.roll = roll; // 2-12 no 7 roll
    }

}
