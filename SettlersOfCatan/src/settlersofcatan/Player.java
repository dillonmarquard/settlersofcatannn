package settlersofcatan;

import java.util.ArrayList;

public class Player {
    int[] resources = new int[5]; //  0 wood, 1 sheep, 2 wheat, 3 brick, 4 ore
    int[] developmentcards = new int[3]; // 0 Knight, 1 Progress, 2 Victory Point
    int[] useddevelopmentcards = new int[3]; // 0 Knight, 1 Progress, 2 Victory Point
    int[] tradingports = new int[6]; // 0(3:1 any), 1(2:1 wood), 2(2:1 sheep), 3(2:1 wheat), 4(2:1 brick), 5(2:1 ore) 
    
    int victorypoints;
    int yourturncount = 1;
    boolean canusedevelopmentcard = true;
    boolean hasRobber = false;
    boolean hasRolled = false;
    
    boolean firstsettlement = false;
    int firstsettlementindex;
    int firstsettlementsubindex;
    boolean secondsettlement = false;
    int secondsettlementindex;
    int secondsettlementsubindex;
    
    public int numOfResources(String resource){
        switch(resource){
            case "wood":
                return this.resources[0];
            case "sheep":
                return this.resources[1];
            case "wheat":
                return this.resources[2];
            case "brick":
                return this.resources[3];
            case "ore":
                return this.resources[4];
        }
        return -1;
    }
    
    public void removeResource(String resource,int amount){
        switch(resource){
            case "wood":
                this.resources[0] -= amount;
                break;
            case "sheep":
                this.resources[1] -= amount;
                break;
            case "wheat":
                this.resources[2] -= amount;
                break;
            case "brick":
                this.resources[3] -= amount;
                break;
            case "ore":
                this.resources[4] -= amount;
                break;
        }
    }
    
    public void addResource(String resource,int amount){
        switch(resource){
            case "wood":
                this.resources[0] += amount;
                break;
            case "sheep":
                this.resources[1] += amount;
                break;
            case "wheat":
                this.resources[2] += amount;
                break;
            case "brick":
                this.resources[3] += amount;
                break;
            case "ore":
                this.resources[4] += amount;
                break;
        }
    }
}
