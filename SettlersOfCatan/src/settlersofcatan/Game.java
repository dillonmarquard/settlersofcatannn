package settlersofcatan;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Game {

    GUI gui;
    public Tile[] gameboard = new Tile[19]; // 0-18 land tiles
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
    public Tile[] portarray = new Tile[9];
    public ArrayList developmentcards = new ArrayList(25);
    public Player[] players = new Player[4];
    public Robber robber = new Robber();
    public float[][] hexlocations = new float[19][2];

    int playerturn = 0;
    int yourindex; // assigned after joining a game by webserver
    int longestroad = 4;
    int largestarmy = 2;
    int numOfPlayers = 1;
    boolean hexSelected = false;
    int selectedHexIndex = -1;

    boolean robberSelected = false;

    Image port0;
    Image port1;
    Image port2;
    Image port3;
    Image port4;
    Image port5;
    Image wood;
    Image sheep;
    Image wheat;
    Image brick;
    Image ore;
    Image desert;

    Image settlement1;
    Image settlement2;
    Image settlement3;
    Image settlement4;
    Image city1;
    Image city2;
    Image city3;
    Image city4;

    Image backgroundimage;
    Image robberimage;

    Color backgroundcolor = new Color(0, 200, 243);

    Color player1 = new Color(0, 168, 243);
    Color player2 = new Color(236, 28, 36);
    Color player3 = new Color(255, 127, 39);
    Color player4 = new Color(255, 255, 255);

    public float getSubLoc(int subindex, boolean x, float value) {
        switch (subindex) {
            case 0:
                if (x) {
                    return value;
                } else {
                    return value - 50 - (5 / 2);
                }
            case 1:
                if (x) {
                    return value + 30;
                } else {
                    return value - 40;
                }
            case 2:
                if (x) {
                    return value + 50 + (5 / 2);
                } else {
                    return value - 25 - (5 / 2);
                }
            case 3:
                if (x) {
                    return value + 50;
                } else {
                    return value;
                }
            case 4:
                if (x) {
                    return value + 50 + (5 / 2);
                } else {
                    return value + 25 + (5 / 2);
                }
            case 5:
                if (x) {
                    return value + 30;
                } else {
                    return value + 40;
                }
            case 6:
                if (x) {
                    return value;
                } else {
                    return value + 50 + (5 / 2);
                }
            case 7:
                if (x) {
                    return value - 30;
                } else {
                    return value + 40;
                }
            case 8:
                if (x) {
                    return value - 50 - (5 / 2);
                } else {
                    return value + 25 + (5 / 2);
                }
            case 9:
                if (x) {
                    return value - 50;
                } else {
                    return value;
                }
            case 10:
                if (x) {
                    return value - 50 - (5 / 2);
                } else {
                    return value - 25 - (5 / 2);
                }
            case 11:
                if (x) {
                    return value - 30;
                } else {
                    return value - 40;
                }

        }
        return -1;
    }

    public void interpretAction(double x, double y) {
        // add robber check before other tiles
        if (!this.players[this.yourindex].hasRolled && this.players[this.yourindex].yourturncount > 2) {
            gui.txtConsole.setText("must roll before building");
            return;
        }
        if (this.yourindex == this.playerturn) {
            if (this.hexSelected == true) {
                float dist = 100;
                for (int i = 0; i < 12; i++) {
                    dist = (float) Math.sqrt((x - getSubLoc(i, true, this.hexlocations[this.selectedHexIndex][0])) * (x - getSubLoc(i, true, this.hexlocations[this.selectedHexIndex][0])) + (y - getSubLoc(i, false, this.hexlocations[this.selectedHexIndex][1])) * (y - getSubLoc(i, false, this.hexlocations[this.selectedHexIndex][1])));
                    if (dist < 15) {
                        switch (i) {
                            case 0:
                                if (this.gameboard[this.selectedHexIndex].tileData[i] > 0) {
                                    upgradeSettlement(this.yourindex, this.selectedHexIndex, i);
                                } else {
                                    placeSettlement(this.yourindex, this.selectedHexIndex, i);
                                }
                                break;
                            case 1:
                                placeRoad(this.yourindex, this.selectedHexIndex, i);
                                break;
                            case 2:
                                if (this.gameboard[this.selectedHexIndex].tileData[i] > 0) {
                                    upgradeSettlement(this.yourindex, this.selectedHexIndex, i);
                                } else {
                                    placeSettlement(this.yourindex, this.selectedHexIndex, i);
                                }
                                break;
                            case 3:
                                placeRoad(this.yourindex, this.selectedHexIndex, i);
                                break;
                            case 4:
                                if (this.gameboard[this.selectedHexIndex].tileData[i] > 0) {
                                    upgradeSettlement(this.yourindex, this.selectedHexIndex, i);
                                } else {
                                    placeSettlement(this.yourindex, this.selectedHexIndex, i);
                                }
                                break;
                            case 5:
                                placeRoad(this.yourindex, this.selectedHexIndex, i);
                                break;
                            case 6:
                                if (this.gameboard[this.selectedHexIndex].tileData[i] > 0) {
                                    upgradeSettlement(this.yourindex, this.selectedHexIndex, i);
                                } else {
                                    placeSettlement(this.yourindex, this.selectedHexIndex, i);
                                }
                                break;
                            case 7:
                                placeRoad(this.yourindex, this.selectedHexIndex, i);
                                break;
                            case 8:
                                if (this.gameboard[this.selectedHexIndex].tileData[i] > 0) {
                                    upgradeSettlement(this.yourindex, this.selectedHexIndex, i);
                                } else {
                                    placeSettlement(this.yourindex, this.selectedHexIndex, i);
                                }
                                break;
                            case 9:
                                placeRoad(this.yourindex, this.selectedHexIndex, i);
                                break;
                            case 10:
                                if (this.gameboard[this.selectedHexIndex].tileData[i] > 0) {
                                    upgradeSettlement(this.yourindex, this.selectedHexIndex, i);
                                } else {
                                    placeSettlement(this.yourindex, this.selectedHexIndex, i);
                                }
                                break;
                            case 11:
                                placeRoad(this.yourindex, this.selectedHexIndex, i);
                                break;
                        }

                    }
                }
                this.hexSelected = false;
                this.selectedHexIndex = -1;
                return;
            }
            if (this.hexSelected == false) {
                float dist = 100;
                for (int i = 0; i < 19; i++) {
                    dist = (float) Math.sqrt((x - this.hexlocations[i][0]) * (x - this.hexlocations[i][0]) + (y - this.hexlocations[i][1]) * (y - this.hexlocations[i][1]));
                    if (dist < 50) {
                        if (this.robberSelected == true) {
                            placeRobber(i);
                            this.players[this.yourindex].hasRobber = false;
                            this.robberSelected = false;
                            return;
                        }
                        if (this.players[this.yourindex].hasRobber && !this.robberSelected) {
                            this.robberSelected = true;
                            return;
                        }
                        this.hexSelected = true;
                        this.selectedHexIndex = i;

                    }
                }
            }

        } else {
            gui.txtConsole.setText("it's not your turn.");
        }
    }

    public void placeRobber(int index) {
        int settlementnum = ((this.yourindex + 1) * 3) - 2;
        int citynum = ((this.yourindex + 1) * 3) - 1;

        robber.indexlocation = index;
        for (int i = 0; i < 12; i++) {
            if (this.gameboard[robber.indexlocation].tileData[i] != citynum && this.gameboard[robber.indexlocation].tileData[i] != settlementnum) {

            }
        }
    }

    public void nextTurn() {
        if (this.players[this.yourindex].hasRobber) {
            gui.txtConsole.setText("must place robber before end of turn.");
            return;
        }
        if (this.yourindex == this.playerturn) {
            if (this.playerturn == this.numOfPlayers - 1) {
                this.playerturn = 0;

            } else {
                this.playerturn++;
            }
            this.players[this.yourindex].hasRolled = false;
            this.players[this.yourindex].yourturncount++;
            //sendServer(this.playerturn); sends server to update the current playerturn for each player
        }

    }

    public void lastTurn() {
        if (this.yourindex == this.playerturn) {
            this.playerturn--;
            this.players[this.yourindex].yourturncount++;
            //sendServer(this.playerturn); sends server to update the current playerturn for each player
        }
    }

    public void roll() {
        this.players[this.yourindex].hasRolled = true;
        int roll = (int) ((Math.floor(Math.random() * 6) + 1) + (Math.floor(Math.random() * 6) + 1));
        gui.txtConsole.setText(Integer.toString(roll));
        this.dealResources(roll); // 2 - 12
    }

    public void placeSettlement(int yourindex, int index, int tileDataIndex) {
        // rule check
        if (this.gameboard[index].tileData[tileDataIndex] != 0) {
            gui.txtConsole.setText("cannot place settlement here.");
            return;
        }
        if (this.players[this.yourindex].yourturncount <= 2) {
            if (this.players[this.yourindex].yourturncount == 1) {
                if (this.players[this.yourindex].firstsettlement == true) {
                    gui.txtConsole.setText("you may only place one settlement this turn.");
                    return;
                }
            }
            if (this.players[this.yourindex].yourturncount == 2) {
                if (this.players[this.yourindex].secondsettlement == true) {
                    gui.txtConsole.setText("you may only place one settlement this turn.");
                    return;
                }
            }
        }
        // must have no other settlements or cities within one road(distance rule)
        switch (tileDataIndex) {
            case 0:
                if (this.gameboard[index].tileData[10] != 0 || this.gameboard[index].tileData[2] != 0) {
                    gui.txtConsole.setText("cannot place settlement here, must have no adjacent buildings.");
                    return;
                }
                if (this.gameboard[index].neighborTiles[0] != null) {
                    if (this.gameboard[index].neighborTiles[0].tileData[2] != 0) {
                        gui.txtConsole.setText("cannot place settlement here, must have no adjacent buildings.");
                        return;
                    }
                }
                if (this.gameboard[index].neighborTiles[1] != null) {
                    if (this.gameboard[index].neighborTiles[1].tileData[10] != 0) {
                        gui.txtConsole.setText("cannot place settlement here, must have no adjacent buildings.");
                        return;
                    }
                }
                break;
            case 2:
                if (this.gameboard[index].tileData[0] != 0 || this.gameboard[index].tileData[4] != 0) {
                    gui.txtConsole.setText("cannot place settlement here, must have no adjacent buildings.");
                    return;
                }
                if (this.gameboard[index].neighborTiles[1] != null) {
                    if (this.gameboard[index].neighborTiles[1].tileData[4] != 0) {
                        gui.txtConsole.setText("cannot place settlement here, must have no adjacent buildings.");
                        return;
                    }
                }
                if (this.gameboard[index].neighborTiles[2] != null) {
                    if (this.gameboard[index].neighborTiles[2].tileData[0] != 0) {
                        gui.txtConsole.setText("cannot place settlement here, must have no adjacent buildings.");
                        return;
                    }
                }
                break;
            case 4:
                if (this.gameboard[index].tileData[2] != 0 || this.gameboard[index].tileData[6] != 0) {
                    gui.txtConsole.setText("cannot place settlement here, must have no adjacent buildings.");
                    return;
                }
                if (this.gameboard[index].neighborTiles[2] != null) {
                    if (this.gameboard[index].neighborTiles[2].tileData[6] != 0) {
                        gui.txtConsole.setText("cannot place settlement here, must have no adjacent buildings.");
                        return;
                    }
                }
                if (this.gameboard[index].neighborTiles[3] != null) {
                    if (this.gameboard[index].neighborTiles[3].tileData[2] != 0) {
                        gui.txtConsole.setText("cannot place settlement here, must have no adjacent buildings.");
                        return;
                    }
                }
                break;
            case 6:
                if (this.gameboard[index].tileData[4] != 0 || this.gameboard[index].tileData[8] != 0) {
                    gui.txtConsole.setText("cannot place settlement here, must have no adjacent buildings.");
                    return;
                }
                if (this.gameboard[index].neighborTiles[3] != null) {
                    if (this.gameboard[index].neighborTiles[3].tileData[8] != 0) {
                        gui.txtConsole.setText("cannot place settlement here, must have no adjacent buildings.");
                        return;
                    }
                }
                if (this.gameboard[index].neighborTiles[4] != null) {
                    if (this.gameboard[index].neighborTiles[4].tileData[4] != 0) {
                        gui.txtConsole.setText("cannot place settlement here, must have no adjacent buildings.");
                        return;
                    }
                }
                break;
            case 8:
                if (this.gameboard[index].tileData[6] != 0 || this.gameboard[index].tileData[10] != 0) {
                    gui.txtConsole.setText("cannot place settlement here, must have no adjacent buildings.");
                    return;
                }
                if (this.gameboard[index].neighborTiles[4] != null) {
                    if (this.gameboard[index].neighborTiles[4].tileData[10] != 0) {
                        gui.txtConsole.setText("cannot place settlement here, must have no adjacent buildings.");
                        return;
                    }
                }
                if (this.gameboard[index].neighborTiles[5] != null) {
                    if (this.gameboard[index].neighborTiles[5].tileData[6] != 0) {
                        gui.txtConsole.setText("cannot place settlement here, must have no adjacent buildings.");
                        return;
                    }
                }
                break;
            case 10:
                if (this.gameboard[index].tileData[8] != 0 || this.gameboard[index].tileData[0] != 0) {
                    gui.txtConsole.setText("cannot place settlement here, must have no adjacent buildings.");
                    return;
                }
                if (this.gameboard[index].neighborTiles[5] != null) {
                    if (this.gameboard[index].neighborTiles[5].tileData[0] != 0) {
                        gui.txtConsole.setText("cannot place settlement here, must have no adjacent buildings.");
                        return;
                    }
                }
                if (this.gameboard[index].neighborTiles[0] != null) {
                    if (this.gameboard[index].neighborTiles[0].tileData[8] != 0) {
                        gui.txtConsole.setText("cannot place settlement here, must have no adjacent buildings.");
                        return;
                    }
                }
                break;
        }
        // on turn three and beyond cities must have an owned road next to it
        if (this.players[this.yourindex].yourturncount > 2) {
            int roadnum = ((this.yourindex + 1) * 3);
            int count = 0;
            switch (tileDataIndex) {
                case 0:
                    count = 0;
                    if (this.gameboard[index].tileData[1] == roadnum || this.gameboard[index].tileData[11] == roadnum) {
                        count++;
                    }
                    if (this.gameboard[index].neighborTiles[0] != null) {
                        if (this.gameboard[index].neighborTiles[0].tileData[3] == roadnum) {
                            count++;
                        }
                    }
                    if (this.gameboard[index].neighborTiles[1] != null) {
                        if (this.gameboard[index].neighborTiles[1].tileData[9] == roadnum) {
                            count++;
                        }
                    }
                    if (count == 0) {
                        gui.txtConsole.setText("cannot place settlement here, must have an adjacent road.");
                        return;
                    }
                    break;
                case 2:
                    count = 0;
                    if (this.gameboard[index].tileData[1] == roadnum || this.gameboard[index].tileData[3] == roadnum) {
                        count++;
                    }
                    if (this.gameboard[index].neighborTiles[1] != null) {
                        if (this.gameboard[index].neighborTiles[1].tileData[5] == roadnum) {
                            count++;
                        }
                    }
                    if (this.gameboard[index].neighborTiles[2] != null) {
                        if (this.gameboard[index].neighborTiles[2].tileData[11] == roadnum) {
                            count++;
                        }
                    }
                    if (count == 0) {
                        gui.txtConsole.setText("cannot place settlement here, must have an adjacent road.");
                        return;
                    }
                    break;
                case 4:
                    count = 0;
                    if (this.gameboard[index].tileData[3] == roadnum || this.gameboard[index].tileData[5] == roadnum) {
                        count++;
                    }

                    if (this.gameboard[index].neighborTiles[2] != null) {
                        if (this.gameboard[index].neighborTiles[2].tileData[7] == roadnum) {
                            count++;
                        }
                    }
                    if (this.gameboard[index].neighborTiles[3] != null) {
                        if (this.gameboard[index].neighborTiles[3].tileData[1] == roadnum) {
                            count++;
                        }
                    }
                    if (count == 0) {
                        gui.txtConsole.setText("cannot place settlement here, must have an adjacent road.");
                        return;
                    }
                    break;
                case 6:
                    count = 0;
                    if (this.gameboard[index].tileData[5] == roadnum || this.gameboard[index].tileData[7] == roadnum) {
                        count++;
                    }

                    if (this.gameboard[index].neighborTiles[3] != null) {
                        if (this.gameboard[index].neighborTiles[3].tileData[9] == roadnum) {
                            count++;
                        }
                    }
                    if (this.gameboard[index].neighborTiles[4] != null) {
                        if (this.gameboard[index].neighborTiles[4].tileData[3] == roadnum) {
                            count++;
                        }
                    }
                    if (count == 0) {
                        gui.txtConsole.setText("cannot place settlement here, must have an adjacent road.");
                        return;
                    }
                    break;
                case 8:
                    count = 0;
                    if (this.gameboard[index].tileData[7] == roadnum || this.gameboard[index].tileData[9] == roadnum) {
                        count++;
                    }

                    if (this.gameboard[index].neighborTiles[4] != null) {
                        if (this.gameboard[index].neighborTiles[4].tileData[11] == roadnum) {
                            count++;
                        }
                    }
                    if (this.gameboard[index].neighborTiles[5] != null) {
                        if (this.gameboard[index].neighborTiles[5].tileData[5] == roadnum) {
                            count++;
                        }
                    }
                    if (count == 0) {
                        gui.txtConsole.setText("cannot place settlement here, must have an adjacent road.");
                        return;
                    }
                    break;
                case 10:
                    count = 0;
                    if (this.gameboard[index].tileData[9] == roadnum || this.gameboard[index].tileData[11] == roadnum) {
                        count++;
                    }

                    if (this.gameboard[index].neighborTiles[5] != null) {
                        if (this.gameboard[index].neighborTiles[5].tileData[1] == roadnum) {
                            count++;
                        }
                    }
                    if (this.gameboard[index].neighborTiles[0] != null) {
                        if (this.gameboard[index].neighborTiles[0].tileData[7] == roadnum) {
                            count++;
                        }
                    }
                    if (count == 0) {
                        gui.txtConsole.setText("cannot place settlement here, must have an adjacent road.");
                        return;
                    }
                    break;
            }

            //resource check
            if (this.players[this.yourindex].numOfResources("brick") < 1 || this.players[this.yourindex].numOfResources("wood") < 1 || this.players[this.yourindex].numOfResources("sheep") < 1 || this.players[this.yourindex].numOfResources("wheat") < 1) {
                gui.txtConsole.setText("not enough resources");
                return;
            }
            //then take cost of settlement
            this.players[yourindex].removeResource("brick", 1);
            this.players[yourindex].removeResource("wood", 1);
            this.players[yourindex].removeResource("sheep", 1);
            this.players[yourindex].removeResource("wheat", 1);
        }
        if (this.players[this.yourindex].yourturncount == 1) {
            this.players[this.yourindex].firstsettlement = true;
            this.players[this.yourindex].firstsettlementindex = index;
            this.players[this.yourindex].firstsettlementsubindex = tileDataIndex;
        }
        if (this.players[this.yourindex].yourturncount == 2) {
            this.players[this.yourindex].secondsettlement = true;
            this.players[this.yourindex].secondsettlementindex = index;
            this.players[this.yourindex].secondsettlementsubindex = tileDataIndex;
        }
        gui.txtConsole.setText("placing settlement");
        switch (yourindex) {
            case 0:
                this.gameboard[index].tileData[tileDataIndex] = 1;
                break;
            case 1:
                this.gameboard[index].tileData[tileDataIndex] = 4;
                break;
            case 2:
                this.gameboard[index].tileData[tileDataIndex] = 7;
                break;
            case 3:
                this.gameboard[index].tileData[tileDataIndex] = 10;
                break;
        }
        switch (tileDataIndex) {
            case 0:
                if (this.gameboard[index].neighborTiles[0] != null) {
                    switch (yourindex) {
                        case 0:
                            this.gameboard[index].neighborTiles[0].tileData[4] = 1;
                            break;
                        case 1:
                            this.gameboard[index].neighborTiles[0].tileData[4] = 4;
                            break;
                        case 2:
                            this.gameboard[index].neighborTiles[0].tileData[4] = 7;
                            break;
                        case 3:
                            this.gameboard[index].neighborTiles[0].tileData[4] = 10;
                            break;
                    }
                }
                if (this.gameboard[index].neighborTiles[1] != null) {
                    switch (yourindex) {
                        case 0:
                            this.gameboard[index].neighborTiles[1].tileData[8] = 1;
                            break;
                        case 1:
                            this.gameboard[index].neighborTiles[1].tileData[8] = 4;
                            break;
                        case 2:
                            this.gameboard[index].neighborTiles[1].tileData[8] = 7;
                            break;
                        case 3:
                            this.gameboard[index].neighborTiles[1].tileData[8] = 10;
                            break;
                    }
                }
                break;
            case 2:
                if (this.gameboard[index].neighborTiles[1] != null) {
                    switch (yourindex) {
                        case 0:
                            this.gameboard[index].neighborTiles[1].tileData[6] = 1;
                            break;
                        case 1:
                            this.gameboard[index].neighborTiles[1].tileData[6] = 4;
                            break;
                        case 2:
                            this.gameboard[index].neighborTiles[1].tileData[6] = 7;
                            break;
                        case 3:
                            this.gameboard[index].neighborTiles[1].tileData[6] = 10;
                            break;
                    }
                }
                if (this.gameboard[index].neighborTiles[2] != null) {
                    switch (yourindex) {
                        case 0:
                            this.gameboard[index].neighborTiles[2].tileData[10] = 1;
                            break;
                        case 1:
                            this.gameboard[index].neighborTiles[2].tileData[10] = 4;
                            break;
                        case 2:
                            this.gameboard[index].neighborTiles[2].tileData[10] = 7;
                            break;
                        case 3:
                            this.gameboard[index].neighborTiles[2].tileData[10] = 10;
                            break;
                    }
                }
                break;
            case 4:
                if (this.gameboard[index].neighborTiles[2] != null) {
                    switch (yourindex) {
                        case 0:
                            this.gameboard[index].neighborTiles[2].tileData[8] = 1;
                            break;
                        case 1:
                            this.gameboard[index].neighborTiles[2].tileData[8] = 4;
                            break;
                        case 2:
                            this.gameboard[index].neighborTiles[2].tileData[8] = 7;
                            break;
                        case 3:
                            this.gameboard[index].neighborTiles[2].tileData[8] = 10;
                            break;
                    }
                }
                if (this.gameboard[index].neighborTiles[3] != null) {
                    switch (yourindex) {
                        case 0:
                            this.gameboard[index].neighborTiles[3].tileData[0] = 1;
                            break;
                        case 1:
                            this.gameboard[index].neighborTiles[3].tileData[0] = 4;
                            break;
                        case 2:
                            this.gameboard[index].neighborTiles[3].tileData[0] = 7;
                            break;
                        case 3:
                            this.gameboard[index].neighborTiles[3].tileData[0] = 10;
                            break;
                    }
                }
                break;
            case 6:
                if (this.gameboard[index].neighborTiles[3] != null) {
                    switch (yourindex) {
                        case 0:
                            this.gameboard[index].neighborTiles[3].tileData[10] = 1;
                            break;
                        case 1:
                            this.gameboard[index].neighborTiles[3].tileData[10] = 4;
                            break;
                        case 2:
                            this.gameboard[index].neighborTiles[3].tileData[10] = 7;
                            break;
                        case 3:
                            this.gameboard[index].neighborTiles[3].tileData[10] = 10;
                            break;
                    }
                }
                if (this.gameboard[index].neighborTiles[4] != null) {
                    switch (yourindex) {
                        case 0:
                            this.gameboard[index].neighborTiles[4].tileData[2] = 1;
                            break;
                        case 1:
                            this.gameboard[index].neighborTiles[4].tileData[2] = 4;
                            break;
                        case 2:
                            this.gameboard[index].neighborTiles[4].tileData[2] = 7;
                            break;
                        case 3:
                            this.gameboard[index].neighborTiles[4].tileData[2] = 10;
                            break;
                    }
                }
                break;
            case 8:
                if (this.gameboard[index].neighborTiles[4] != null) {
                    switch (yourindex) {
                        case 0:
                            this.gameboard[index].neighborTiles[4].tileData[0] = 1;
                            break;
                        case 1:
                            this.gameboard[index].neighborTiles[4].tileData[0] = 4;
                            break;
                        case 2:
                            this.gameboard[index].neighborTiles[4].tileData[0] = 7;
                            break;
                        case 3:
                            this.gameboard[index].neighborTiles[4].tileData[0] = 10;
                            break;
                    }
                }
                if (this.gameboard[index].neighborTiles[5] != null) {
                    switch (yourindex) {
                        case 0:
                            this.gameboard[index].neighborTiles[5].tileData[4] = 1;
                            break;
                        case 1:
                            this.gameboard[index].neighborTiles[5].tileData[4] = 4;
                            break;
                        case 2:
                            this.gameboard[index].neighborTiles[5].tileData[4] = 7;
                            break;
                        case 3:
                            this.gameboard[index].neighborTiles[5].tileData[4] = 10;
                            break;
                    }
                }
                break;
            case 10:
                if (this.gameboard[index].neighborTiles[5] != null) {
                    switch (yourindex) {
                        case 0:
                            this.gameboard[index].neighborTiles[5].tileData[2] = 1;
                            break;
                        case 1:
                            this.gameboard[index].neighborTiles[5].tileData[2] = 4;
                            break;
                        case 2:
                            this.gameboard[index].neighborTiles[5].tileData[2] = 7;
                            break;
                        case 3:
                            this.gameboard[index].neighborTiles[5].tileData[2] = 10;
                            break;
                    }
                }
                if (this.gameboard[index].neighborTiles[0] != null) {
                    switch (yourindex) {
                        case 0:
                            this.gameboard[index].neighborTiles[0].tileData[6] = 1;
                            break;
                        case 1:
                            this.gameboard[index].neighborTiles[0].tileData[6] = 4;
                            break;
                        case 2:
                            this.gameboard[index].neighborTiles[0].tileData[6] = 7;
                            break;
                        case 3:
                            this.gameboard[index].neighborTiles[0].tileData[6] = 10;
                            break;
                    }
                }
                break;
        }
    }

    public void upgradeSettlement(int yourindex, int index, int tileDataIndex) {
        gui.txtConsole.setText("upgrading settlement to city");
        return;
    }

    public void placeRoad(int yourindex, int index, int tileDataIndex) {
        // rule check
        if (this.gameboard[index].tileData[tileDataIndex] != 0) {
            gui.txtConsole.setText("cannot place road here.");
            return;
        }
        //roads must be placed next to cities or other roads
        int settlementnum = ((this.yourindex + 1) * 3) - 2;
        int citynum = ((this.yourindex + 1) * 3) - 1;
        int roadnum = ((this.yourindex + 1) * 3);

        int count = 0;
        switch (tileDataIndex) {
            case 1:
                count = 0;
                if (this.gameboard[index].tileData[0] == settlementnum || this.gameboard[index].tileData[2] == settlementnum || this.gameboard[index].tileData[0] == citynum || this.gameboard[index].tileData[2] == citynum) {
                    count++;
                }
                if (this.gameboard[index].tileData[(tileDataIndex + 10) % 12] == roadnum || this.gameboard[index].tileData[(tileDataIndex + 2) % 12] == roadnum) {
                    count++;
                }
                if (this.gameboard[index].neighborTiles[0] != null) {
                    if (this.gameboard[index].neighborTiles[0].tileData[3] == roadnum) {
                        count++;
                    }
                }
                if (this.gameboard[index].neighborTiles[1] != null) {
                    if (this.gameboard[index].neighborTiles[1].tileData[9] == roadnum || this.gameboard[index].neighborTiles[1].tileData[5] == roadnum) {
                        count++;
                    }
                }
                if (this.gameboard[index].neighborTiles[2] != null) {
                    if (this.gameboard[index].neighborTiles[2].tileData[11] == roadnum) {
                        count++;
                    }
                }
                if (count == 0) {
                    gui.txtConsole.setText("cannot place road here, must have an adjacent road or settlement.");
                    return;
                }
                break;
            case 3:
                count = 0;
                if (this.gameboard[index].tileData[2] == settlementnum || this.gameboard[index].tileData[4] == settlementnum || this.gameboard[index].tileData[2] == citynum || this.gameboard[index].tileData[4] == citynum) {
                    count++;
                }
                if (this.gameboard[index].tileData[(tileDataIndex + 10) % 12] == roadnum || this.gameboard[index].tileData[(tileDataIndex + 2) % 12] == roadnum) {
                    count++;
                }
                if (this.gameboard[index].neighborTiles[1] != null) {
                    if (this.gameboard[index].neighborTiles[1].tileData[5] == roadnum) {
                        count++;
                    }
                }
                if (this.gameboard[index].neighborTiles[2] != null) {
                    if (this.gameboard[index].neighborTiles[2].tileData[11] == roadnum || this.gameboard[index].neighborTiles[2].tileData[7] == roadnum) {
                        count++;
                    }
                }
                if (this.gameboard[index].neighborTiles[3] != null) {
                    if (this.gameboard[index].neighborTiles[3].tileData[1] == roadnum) {
                        count++;
                    }
                }
                if (count == 0) {
                    gui.txtConsole.setText("cannot place road here, must have an adjacent road or settlement.");
                    return;
                }
                break;
            case 5:
                count = 0;
                if (this.gameboard[index].tileData[4] == settlementnum || this.gameboard[index].tileData[6] == settlementnum || this.gameboard[index].tileData[4] == citynum || this.gameboard[index].tileData[6] == citynum) {
                    count++;
                }
                if (this.gameboard[index].tileData[(tileDataIndex + 10) % 12] == roadnum || this.gameboard[index].tileData[(tileDataIndex + 2) % 12] == roadnum) {
                    count++;
                }
                if (this.gameboard[index].neighborTiles[2] != null) {
                    if (this.gameboard[index].neighborTiles[2].tileData[7] == roadnum) {
                        count++;
                    }
                }
                if (this.gameboard[index].neighborTiles[3] != null) {
                    if (this.gameboard[index].neighborTiles[3].tileData[1] == roadnum || this.gameboard[index].neighborTiles[3].tileData[9] == roadnum) {
                        count++;
                    }
                }
                if (this.gameboard[index].neighborTiles[4] != null) {
                    if (this.gameboard[index].neighborTiles[4].tileData[3] == roadnum) {
                        count++;
                    }
                }
                if (count == 0) {
                    gui.txtConsole.setText("cannot place road here, must have an adjacent road or settlement.");
                    return;
                }
                break;
            case 7:
                count = 0;
                if (this.gameboard[index].tileData[6] == settlementnum || this.gameboard[index].tileData[8] == settlementnum || this.gameboard[index].tileData[6] == citynum || this.gameboard[index].tileData[8] == citynum) {
                    count++;
                }
                if (this.gameboard[index].tileData[(tileDataIndex + 10) % 12] == roadnum || this.gameboard[index].tileData[(tileDataIndex + 2) % 12] == roadnum) {
                    count++;
                }
                if (this.gameboard[index].neighborTiles[3] != null) {
                    if (this.gameboard[index].neighborTiles[3].tileData[9] == roadnum) {
                        count++;
                    }
                }
                if (this.gameboard[index].neighborTiles[4] != null) {
                    if (this.gameboard[index].neighborTiles[4].tileData[3] == roadnum || this.gameboard[index].neighborTiles[4].tileData[11] == roadnum) {
                        count++;
                    }
                }
                if (this.gameboard[index].neighborTiles[5] != null) {
                    if (this.gameboard[index].neighborTiles[5].tileData[5] == roadnum) {
                        count++;
                    }
                }
                if (count == 0) {
                    gui.txtConsole.setText("cannot place road here, must have an adjacent road or settlement.");
                    return;
                }
                break;
            case 9:
                count = 0;
                if (this.gameboard[index].tileData[10] == settlementnum || this.gameboard[index].tileData[8] == settlementnum || this.gameboard[index].tileData[10] == citynum || this.gameboard[index].tileData[8] == citynum) {
                    count++;
                }
                if (this.gameboard[index].tileData[(tileDataIndex + 10) % 12] == roadnum || this.gameboard[index].tileData[(tileDataIndex + 2) % 12] == roadnum) {
                    count++;
                }
                if (this.gameboard[index].neighborTiles[4] != null) {
                    if (this.gameboard[index].neighborTiles[4].tileData[11] == roadnum) {
                        count++;
                    }
                }
                if (this.gameboard[index].neighborTiles[5] != null) {
                    if (this.gameboard[index].neighborTiles[5].tileData[5] == roadnum || this.gameboard[index].neighborTiles[5].tileData[1] == roadnum) {
                        count++;
                    }
                }
                if (this.gameboard[index].neighborTiles[0] != null) {
                    if (this.gameboard[index].neighborTiles[0].tileData[7] == roadnum) {
                        count++;
                    }
                }
                if (count == 0) {
                    gui.txtConsole.setText("cannot place road here, must have an adjacent road or settlement.");
                    return;
                }
                break;
            case 11:
                count = 0;
                if (this.gameboard[index].tileData[10] == settlementnum || this.gameboard[index].tileData[0] == settlementnum || this.gameboard[index].tileData[10] == citynum || this.gameboard[index].tileData[0] == citynum) {
                    count++;
                }
                if (this.gameboard[index].tileData[(tileDataIndex + 10) % 12] == roadnum || this.gameboard[index].tileData[(tileDataIndex + 2) % 12] == roadnum) {
                    count++;
                }
                if (this.gameboard[index].neighborTiles[5] != null) {
                    if (this.gameboard[index].neighborTiles[5].tileData[1] == roadnum) {
                        count++;
                    }
                }
                if (this.gameboard[index].neighborTiles[0] != null) {
                    if (this.gameboard[index].neighborTiles[0].tileData[7] == roadnum || this.gameboard[index].neighborTiles[0].tileData[3] == roadnum) {
                        count++;
                    }
                }
                if (this.gameboard[index].neighborTiles[1] != null) {
                    if (this.gameboard[index].neighborTiles[1].tileData[9] == roadnum) {
                        count++;
                    }
                }
                if (count == 0) {
                    gui.txtConsole.setText("cannot place road here, must have an adjacent road or settlement.");
                    return;
                }
                break;
        }
        if (this.players[this.yourindex].yourturncount > 2) { // only take resources if they are past the first two turns
            //resource check
            if (this.players[this.yourindex].numOfResources("brick") < 1 || this.players[this.yourindex].numOfResources("wood") < 1) {
                gui.txtConsole.setText("not enough resources");
                return;
            }
            //then take cost of settlement
            this.players[yourindex].removeResource("brick", 1);
            this.players[yourindex].removeResource("wood", 1);
        }
        if (this.players[this.yourindex].yourturncount == 2) {
            switch (this.players[this.yourindex].secondsettlementsubindex) {
                case 0:
                    count = 0;
                    if (index == this.players[this.yourindex].secondsettlementindex) {
                        if (tileDataIndex == 11 || tileDataIndex == 1) {
                            count++;
                        }
                    }
                    if (this.gameboard[this.players[this.yourindex].secondsettlementindex].neighborTiles[0] != null) {
                        if (this.gameboard[index] == this.gameboard[this.players[this.yourindex].secondsettlementindex].neighborTiles[0]) {
                            if (tileDataIndex == 3 || tileDataIndex == 5) {
                                count++;
                            }
                        }
                    }
                    if (this.gameboard[this.players[this.yourindex].secondsettlementindex].neighborTiles[1] != null) {
                        if (this.gameboard[index] == this.gameboard[this.players[this.yourindex].secondsettlementindex].neighborTiles[1]) {
                            if (tileDataIndex == 7 || tileDataIndex == 9) {
                                count++;
                            }
                        }
                    }
                    if (count == 0) {
                        gui.txtConsole.setText("must place road adjacent to settlement placed");
                        return;
                    }
                    break;
                case 2:
                    count = 0;
                    if (index == this.players[this.yourindex].secondsettlementindex) {
                        if (tileDataIndex == 1 || tileDataIndex == 3) {
                            count++;
                        }
                    }
                    if (this.gameboard[this.players[this.yourindex].secondsettlementindex].neighborTiles[1] != null) {
                        if (this.gameboard[index] == this.gameboard[this.players[this.yourindex].secondsettlementindex].neighborTiles[1]) {
                            if (tileDataIndex == 7 || tileDataIndex == 5) {
                                count++;
                            }
                        }
                    }
                    if (this.gameboard[this.players[this.yourindex].secondsettlementindex].neighborTiles[2] != null) {
                        if (this.gameboard[index] == this.gameboard[this.players[this.yourindex].secondsettlementindex].neighborTiles[2]) {
                            if (tileDataIndex == 11 || tileDataIndex == 9) {
                                count++;
                            }
                        }
                    }
                    if (count == 0) {
                        gui.txtConsole.setText("must place road adjacent to settlement placed");
                        return;
                    }
                    break;
                case 4:
                    count = 0;
                    if (index == this.players[this.yourindex].secondsettlementindex) {
                        if (tileDataIndex == 5 || tileDataIndex == 3) {
                            count++;
                        }
                    }
                    if (this.gameboard[this.players[this.yourindex].secondsettlementindex].neighborTiles[2] != null) {
                        if (this.gameboard[index] == this.gameboard[this.players[this.yourindex].secondsettlementindex].neighborTiles[2]) {
                            if (tileDataIndex == 9 || tileDataIndex == 7) {
                                count++;
                            }
                        }
                    }
                    if (this.gameboard[this.players[this.yourindex].secondsettlementindex].neighborTiles[3] != null) {
                        if (this.gameboard[index] == this.gameboard[this.players[this.yourindex].secondsettlementindex].neighborTiles[3]) {
                            if (tileDataIndex == 11 || tileDataIndex == 1) {
                                count++;
                            }
                        }
                    }
                    if (count == 0) {
                        gui.txtConsole.setText("must place road adjacent to settlement placed");
                        return;
                    }
                    break;
                case 6:
                    count = 0;
                    if (index == this.players[this.yourindex].secondsettlementindex) {
                        if (tileDataIndex == 5 || tileDataIndex == 7) {
                            count++;
                        }
                    }
                    if (this.gameboard[this.players[this.yourindex].secondsettlementindex].neighborTiles[3] != null) {
                        if (this.gameboard[index] == this.gameboard[this.players[this.yourindex].secondsettlementindex].neighborTiles[3]) {
                            if (tileDataIndex == 11 || tileDataIndex == 9) {
                                count++;
                            }
                        }
                    }
                    if (this.gameboard[this.players[this.yourindex].secondsettlementindex].neighborTiles[4] != null) {
                        if (this.gameboard[index] == this.gameboard[this.players[this.yourindex].secondsettlementindex].neighborTiles[4]) {
                            if (tileDataIndex == 1 || tileDataIndex == 3) {
                                count++;
                            }
                        }
                    }
                    if (count == 0) {
                        gui.txtConsole.setText("must place road adjacent to settlement placed");
                        return;
                    }
                    break;
                case 8:
                    count = 0;
                    if (index == this.players[this.yourindex].secondsettlementindex) {
                        if (tileDataIndex == 7 || tileDataIndex == 9) {
                            count++;
                        }
                    }
                    if (this.gameboard[this.players[this.yourindex].secondsettlementindex].neighborTiles[4] != null) {
                        if (this.gameboard[index] == this.gameboard[this.players[this.yourindex].secondsettlementindex].neighborTiles[4]) {
                            if (tileDataIndex == 1 || tileDataIndex == 11) {
                                count++;
                            }
                        }
                    }
                    if (this.gameboard[this.players[this.yourindex].secondsettlementindex].neighborTiles[5] != null) {
                        if (this.gameboard[index] == this.gameboard[this.players[this.yourindex].secondsettlementindex].neighborTiles[5]) {
                            if (tileDataIndex == 3 || tileDataIndex == 5) {
                                count++;
                            }
                        }
                    }
                    if (count == 0) {
                        gui.txtConsole.setText("must place road adjacent to settlement placed");
                        return;
                    }
                    break;
                case 10:
                    count = 0;
                    if (index == this.players[this.yourindex].secondsettlementindex) {
                        if (tileDataIndex == 11 || tileDataIndex == 9) {
                            count++;
                        }
                    }
                    if (this.gameboard[this.players[this.yourindex].secondsettlementindex].neighborTiles[5] != null) {
                        if (this.gameboard[index] == this.gameboard[this.players[this.yourindex].secondsettlementindex].neighborTiles[5]) {
                            if (tileDataIndex == 3 || tileDataIndex == 1) {
                                count++;
                            }
                        }
                    }
                    if (this.gameboard[this.players[this.yourindex].secondsettlementindex].neighborTiles[0] != null) {
                        if (this.gameboard[index] == this.gameboard[this.players[this.yourindex].secondsettlementindex].neighborTiles[0]) {
                            if (tileDataIndex == 5 || tileDataIndex == 7) {
                                count++;
                            }
                        }
                    }
                    if (count == 0) {
                        gui.txtConsole.setText("must place road adjacent to settlement placed");
                        return;
                    }
                    break;

            }
        }
        gui.txtConsole.setText("placing road");
        // placing road
        this.gameboard[index].tileData[tileDataIndex] = roadnum;
        if (this.gameboard[index].neighborTiles[(((tileDataIndex + 1) / 2) % 6)] != null) {
            this.gameboard[index].neighborTiles[(((tileDataIndex + 1) / 2) % 6)].tileData[(tileDataIndex + 6) % 12] = roadnum;
        }
        if (this.players[this.yourindex].yourturncount == 2) {
            if (this.yourindex != 0) {
                lastTurn();
            }
            if (this.yourindex == 0) {
                this.players[this.yourindex].yourturncount++;
                // deal all initial resources
                dealInitialResources();
            }

        }
        if (this.players[this.yourindex].yourturncount == 1) {
            if (this.yourindex != this.numOfPlayers - 1) {
                nextTurn();
            } else {
                this.players[this.yourindex].yourturncount++;
            }
        }

    }

    public void dealResources(int roll) {
        if (roll == 7) {
            this.players[this.yourindex].hasRobber = true;
            return;
        }
        for (int i = 0; i < 19; i++) {
            if (i == robber.indexlocation) {
                continue;
            }
            if (this.gameboard[i].roll != roll) {
                continue;
            }
            for (int j = 0; j < 12; j++) {
                if (this.gameboard[i].tileData[j] > 0) {

                    switch (this.gameboard[i].tileData[j]) {
                        //player 1
                        case 1:
                            this.players[0].addResource(this.gameboard[i].tile, 1);
                            break;
                        case 2:
                            this.players[0].addResource(this.gameboard[i].tile, 2);
                            break;
                        //player 2
                        case 4:
                            this.players[1].addResource(this.gameboard[i].tile, 1);
                            break;
                        case 5:
                            this.players[1].addResource(this.gameboard[i].tile, 2);
                            break;
                        //player 3
                        case 7:
                            this.players[2].addResource(this.gameboard[i].tile, 1);
                            break;
                        case 8:
                            this.players[2].addResource(this.gameboard[i].tile, 2);
                            break;
                        //player 4
                        case 10:
                            this.players[3].addResource(this.gameboard[i].tile, 1);
                            break;
                        case 11:
                            this.players[3].addResource(this.gameboard[i].tile, 2);
                            break;

                    }
                }
            }
        }
    }

    public void dealInitialResources() {
        gui.txtConsole.setText("dealing initial resources");
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 12; j++) {
                if (this.gameboard[i].tileData[j] > 0) {
                    switch (this.gameboard[i].tileData[j]) {
                        //player 1
                        case 1:
                            this.players[0].addResource(this.gameboard[i].tile, 1);
                            break;
                        case 2:
                            this.players[0].addResource(this.gameboard[i].tile, 2);
                            break;
                        //player 2
                        case 4:
                            this.players[1].addResource(this.gameboard[i].tile, 1);
                            break;
                        case 5:
                            this.players[1].addResource(this.gameboard[i].tile, 2);
                            break;
                        //player 3
                        case 7:
                            this.players[2].addResource(this.gameboard[i].tile, 1);
                            break;
                        case 8:
                            this.players[2].addResource(this.gameboard[i].tile, 2);
                            break;
                        //player 4
                        case 10:
                            this.players[3].addResource(this.gameboard[i].tile, 1);
                            break;
                        case 11:
                            this.players[3].addResource(this.gameboard[i].tile, 2);
                            break;

                    }
                }
            }
        }
    }

    public void render(Graphics g) {
        //background
        g.setColor(backgroundcolor);
        g.fillRect(0, 0, 700, 569);
        // gameboard
        if (this.gameboard == null || this.gameboard[0] == null || this.gameboard[0].tile == null) {
            return;
        }
        g.drawImage(getImage("background"), 0, 0, 667, 571, null);

        g.drawImage(getImage(this.gameboard[0].tile), (659 / 2) - 50 + 100 + 5 - 200 - 10, (569 / 2) - 50 - 160, 100, 100, null);
        g.drawImage(getImage(this.gameboard[1].tile), (659 / 2) - 50 + 100 + 5 - 100 - 5, (569 / 2) - 50 - 160, 100, 100, null);
        g.drawImage(getImage(this.gameboard[2].tile), (659 / 2) - 50 + 100 + 5, (569 / 2) - 50 - 160, 100, 100, null);
        g.drawImage(getImage(this.gameboard[3].tile), (659 / 2) + 3 - 200 - 10, (569 / 2) - 50 - 75 - 5, 100, 100, null);
        g.drawImage(getImage(this.gameboard[4].tile), (659 / 2) + 3 - 100 - 5, (569 / 2) - 50 - 75 - 5, 100, 100, null);
        g.drawImage(getImage(this.gameboard[5].tile), (659 / 2) + 3, (569 / 2) - 50 - 75 - 5, 100, 100, null);
        g.drawImage(getImage(this.gameboard[6].tile), (659 / 2) + 3 + 100 + 5, (569 / 2) - 50 - 75 - 5, 100, 100, null);
        g.drawImage(getImage(this.gameboard[7].tile), (659 / 2) - 50 - 200 - 10, (569 / 2) - 50, 100, 100, null);
        g.drawImage(getImage(this.gameboard[8].tile), (659 / 2) - 50 - 100 - 5, (569 / 2) - 50, 100, 100, null);
        g.drawImage(getImage(this.gameboard[9].tile), (659 / 2) - 50, (569 / 2) - 50, 100, 100, null);
        g.drawImage(getImage(this.gameboard[10].tile), (659 / 2) - 50 + 100 + 5, (569 / 2) - 50, 100, 100, null);
        g.drawImage(getImage(this.gameboard[11].tile), (659 / 2) - 50 + 200 + 5 + 5, (569 / 2) - 50, 100, 100, null);
        g.drawImage(getImage(this.gameboard[12].tile), (659 / 2) + 3 - 200 - 10, (569 / 2) - 50 + 75 + 5, 100, 100, null);
        g.drawImage(getImage(this.gameboard[13].tile), (659 / 2) + 3 - 100 - 5, (569 / 2) - 50 + 75 + 5, 100, 100, null);
        g.drawImage(getImage(this.gameboard[14].tile), (659 / 2) + 3, (569 / 2) - 50 + 75 + 5, 100, 100, null);
        g.drawImage(getImage(this.gameboard[15].tile), (659 / 2) + 3 + 100 + 5, (569 / 2) - 50 + 75 + 5, 100, 100, null);
        g.drawImage(getImage(this.gameboard[16].tile), (659 / 2) - 50 + 100 + 5 - 200 - 10, (569 / 2) - 50 + 160, 100, 100, null);
        g.drawImage(getImage(this.gameboard[17].tile), (659 / 2) - 50 + 100 + 5 - 100 - 5, (569 / 2) - 50 + 160, 100, 100, null);
        g.drawImage(getImage(this.gameboard[18].tile), (659 / 2) - 50 + 100 + 5, (569 / 2) - 50 + 160, 100, 100, null);
        // ports (need to add text for type for each)
        g.drawImage(getImage(this.portarray[0].tile), (659 / 2) - 50 + 100 + 5 - 200 - 10 - 50 - 5 + 2, (569 / 2) - 50 - 160 - 75 - 5, 100, 100, null);
        g.drawImage(getImage(this.portarray[1].tile), (659 / 2) - 50 + 100 + 5 - 200 - 10 - 50 - 5 + 2 + 200 + 10, (569 / 2) - 50 - 160 - 75 - 5, 100, 100, null);
        g.drawImage(getImage(this.portarray[2].tile), (659 / 2) - 50 + 100 + 5 + 100 + 5, (569 / 2) - 50 - 160, 100, 100, null);
        g.drawImage(getImage(this.portarray[3].tile), (659 / 2) + 3 - 200 - 10 - 100 - 5, (569 / 2) - 50 - 75 - 5, 100, 100, null);
        g.drawImage(getImage(this.portarray[4].tile), (659 / 2) - 50 + 200 + 5 + 5 + 100 + 5, (569 / 2) - 50, 100, 100, null);
        g.drawImage(getImage(this.portarray[5].tile), (659 / 2) + 3 - 200 - 10 - 100 - 5, (569 / 2) - 50 + 75 + 5, 100, 100, null);
        g.drawImage(getImage(this.portarray[6].tile), (659 / 2) - 50 + 100 + 5 + 100 + 5, (569 / 2) - 50 + 160, 100, 100, null);
        g.drawImage(getImage(this.portarray[7].tile), (659 / 2) - 50 + 100 + 5 - 200 - 10 - 50 - 5 + 2, (569 / 2) + 50 + 140, 100, 100, null);
        g.drawImage(getImage(this.portarray[8].tile), (659 / 2) + 3, (569 / 2) - 50 + 75 + 5 + 160, 100, 100, null);

        // tile roll
        g.setFont(new Font("TimesRoman", Font.PLAIN, 18));
        for (int i = 0; i < 19; i++) {
            if (this.gameboard[i].tile != "desert") {
                g.setColor(Color.white);
                g.fillOval((int) this.hexlocations[i][0] - 25 - (25 / 2), (int) this.hexlocations[i][1] + 25 - (25 / 2), 25, 25);
                g.setColor(Color.black);
                g.drawString(Integer.toString(this.gameboard[i].roll), (int) this.hexlocations[i][0] - 25 - (14 / 2), (int) this.hexlocations[i][1] + 25 + (14 / 2));
            }
        }
        // robber
        g.drawImage(getImage("robber"), getX(this.robber.indexlocation) + (100 - 35) / 2, getY(this.robber.indexlocation) + (100 - 35) / 2, 35, 35, null);
        // roads
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5.0f));
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 12; j++) {
                if (this.gameboard[i].tileData[j] > 0) {
                    switch (this.gameboard[i].tileData[j]) {
                        case 3:
                            g2.setColor(this.player1);
                            g2.drawLine((int) getSubLoc(((j + 11) % 12), true, this.hexlocations[i][0]), (int) getSubLoc(((j + 11) % 12), false, this.hexlocations[i][1]), (int) getSubLoc(((j + 1) % 12), true, this.hexlocations[i][0]), (int) getSubLoc(((j + 1) % 12), false, this.hexlocations[i][1]));
                            break;
                        case 6:
                            g2.setColor(this.player2);
                            g2.drawLine((int) getSubLoc(((j + 11) % 12), true, this.hexlocations[i][0]), (int) getSubLoc(((j + 11) % 12), false, this.hexlocations[i][1]), (int) getSubLoc(((j + 1) % 12), true, this.hexlocations[i][0]), (int) getSubLoc(((j + 1) % 12), false, this.hexlocations[i][1]));
                            break;
                        case 9:
                            g2.setColor(this.player3);
                            g2.drawLine((int) getSubLoc(((j + 11) % 12), true, this.hexlocations[i][0]), (int) getSubLoc(((j + 11) % 12), false, this.hexlocations[i][1]), (int) getSubLoc(((j + 1) % 12), true, this.hexlocations[i][0]), (int) getSubLoc(((j + 1) % 12), false, this.hexlocations[i][1]));
                            break;
                        case 12:
                            g2.setColor(this.player4);
                            g2.drawLine((int) getSubLoc(((j + 11) % 12), true, this.hexlocations[i][0]), (int) getSubLoc(((j + 11) % 12), false, this.hexlocations[i][1]), (int) getSubLoc(((j + 1) % 12), true, this.hexlocations[i][0]), (int) getSubLoc(((j + 1) % 12), false, this.hexlocations[i][1]));
                            break;
                    }

                }
            }
        }
        // settlements & cities
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 12; j++) {
                if (this.gameboard[i].tileData[j] > 0) {
                    switch (this.gameboard[i].tileData[j]) {
                        // settlements
                        case 1:
                            g.drawImage(getImage("settlement1"), (int) getSubLoc(j, true, this.hexlocations[i][0]) - (25 / 2), (int) getSubLoc(j, false, this.hexlocations[i][1]) - (25 / 2), 25, 25, null);
                            break;
                        case 4:
                            g.drawImage(getImage("settlement2"), (int) getSubLoc(j, true, this.hexlocations[i][0]) - (25 / 2), (int) getSubLoc(j, false, this.hexlocations[i][1]) - (25 / 2), 25, 25, null);
                            break;
                        case 7:
                            g.drawImage(getImage("settlement3"), (int) getSubLoc(j, true, this.hexlocations[i][0]) - (25 / 2), (int) getSubLoc(j, false, this.hexlocations[i][1]) - (25 / 2), 25, 25, null);
                            break;
                        case 10:
                            g.drawImage(getImage("settlement4"), (int) getSubLoc(j, true, this.hexlocations[i][0]) - (25 / 2), (int) getSubLoc(j, false, this.hexlocations[i][1]) - (25 / 2), 25, 25, null);
                            break;
                        // cities
                        case 2:
                            g.drawImage(getImage("city1"), (int) getSubLoc(j, true, this.hexlocations[i][0]) - (25 / 2), (int) getSubLoc(j, false, this.hexlocations[i][1]) - (25 / 2), 25, 25, null);
                            break;
                        case 5:
                            g.drawImage(getImage("city2"), (int) getSubLoc(j, true, this.hexlocations[i][0]) - (25 / 2), (int) getSubLoc(j, false, this.hexlocations[i][1]) - (25 / 2), 25, 25, null);
                            break;
                        case 8:
                            g.drawImage(getImage("city3"), (int) getSubLoc(j, true, this.hexlocations[i][0]) - (25 / 2), (int) getSubLoc(j, false, this.hexlocations[i][1]) - (25 / 2), 25, 25, null);
                            break;
                        case 11:
                            g.drawImage(getImage("city4"), (int) getSubLoc(j, true, this.hexlocations[i][0]) - (25 / 2), (int) getSubLoc(j, false, this.hexlocations[i][1]) - (25 / 2), 25, 25, null);
                            break;
                    }
                }
            }
        }
    }

    public int getX(int index) {
        switch (index) {
            case 0:
                return (659 / 2) - 50 + 100 + 5 - 200 - 10;
            case 1:
                return (659 / 2) - 50 + 100 + 5 - 100 - 5;
            case 2:
                return (659 / 2) - 50 + 100 + 5;
            case 3:
                return (659 / 2) + 3 - 200 - 10;
            case 4:
                return (659 / 2) + 3 - 100 - 5;
            case 5:
                return (659 / 2) + 3;
            case 6:
                return (659 / 2) + 3 + 100 + 5;
            case 7:
                return (659 / 2) - 50 - 200 - 10;
            case 8:
                return (659 / 2) - 50 - 100 - 5;
            case 9:
                return (659 / 2) - 50;
            case 10:
                return (659 / 2) - 50 + 100 + 5;
            case 11:
                return (659 / 2) - 50 + 200 + 5 + 5;
            case 12:
                return (659 / 2) + 3 - 200 - 10;
            case 13:
                return (659 / 2) + 3 - 100 - 5;
            case 14:
                return (659 / 2) + 3;
            case 15:
                return (659 / 2) + 3 + 100 + 5;
            case 16:
                return (659 / 2) - 50 + 100 + 5 - 200 - 10;
            case 17:
                return (659 / 2) - 50 + 100 + 5 - 100 - 5;
            case 18:
                return (659 / 2) - 50 + 100 + 5;
        }

        return -1;
    }

    public int getY(int index) {
        switch (index) {
            case 0:
                return (569 / 2) - 50 - 160;
            case 1:
                return (569 / 2) - 50 - 160;
            case 2:
                return (569 / 2) - 50 - 160;
            case 3:
                return (569 / 2) - 50 - 75 - 5;
            case 4:
                return (569 / 2) - 50 - 75 - 5;
            case 5:
                return (569 / 2) - 50 - 75 - 5;
            case 6:
                return (569 / 2) - 50 - 75 - 5;
            case 7:
                return (569 / 2) - 50;
            case 8:
                return (569 / 2) - 50;
            case 9:
                return (569 / 2) - 50;
            case 10:
                return (569 / 2) - 50;
            case 11:
                return (569 / 2) - 50;
            case 12:
                return (569 / 2) - 50 + 75 + 5;
            case 13:
                return (569 / 2) - 50 + 75 + 5;
            case 14:
                return (569 / 2) - 50 + 75 + 5;
            case 15:
                return (569 / 2) - 50 + 75 + 5;
            case 16:
                return (569 / 2) - 50 + 160;
            case 17:
                return (569 / 2) - 50 + 160;
            case 18:
                return (569 / 2) - 50 + 160;
        }
        return -1;
    }

    public Image getImage(String tile) {
        // tiles
        if (tile == "wood") {
            return this.wood;
        }
        if (tile == "sheep") {
            return this.sheep;
        }
        if (tile == "wheat") {
            return this.wheat;
        }
        if (tile == "brick") {
            return this.brick;
        }
        if (tile == "ore") {
            return this.ore;
        }
        if (tile == "desert") {
            return this.desert;
        }
        if (tile == "port0") {
            return this.port0;
        }
        if (tile == "port1") {
            return this.port1;
        }
        if (tile == "port2") {
            return this.port2;
        }
        if (tile == "port3") {
            return this.port3;
        }
        if (tile == "port4") {
            return this.port4;
        }
        if (tile == "port5") {
            return this.port5;
        }
        // buildings
        if (tile == "settlement1") {
            return this.settlement1;
        }
        if (tile == "settlement2") {
            return this.settlement2;
        }
        if (tile == "settlement3") {
            return this.settlement3;
        }
        if (tile == "settlement4") {
            return this.settlement4;
        }
        if (tile == "city1") {
            return this.city1;
        }
        if (tile == "city2") {
            return this.city2;
        }
        if (tile == "city3") {
            return this.city3;
        }
        if (tile == "city4") {
            return this.city4;
        }
        if (tile == "background") {
            return this.backgroundimage;
        }
        if (tile == "robber") {
            return this.robberimage;
        }
        return null;
    }

    public void loadImages() {
        this.setHexLocations();
        try {
            this.brick = ImageIO.read(getClass().getClassLoader().getResource("images/brick.png"));
            this.wood = ImageIO.read(getClass().getClassLoader().getResource("images/wood.png"));
            this.sheep = ImageIO.read(getClass().getClassLoader().getResource("images/sheep.png"));
            this.wheat = ImageIO.read(getClass().getClassLoader().getResource("images/wheat.png"));
            this.ore = ImageIO.read(getClass().getClassLoader().getResource("images/stone.png"));
            this.desert = ImageIO.read(getClass().getClassLoader().getResource("images/desert.png"));
            this.port0 = ImageIO.read(getClass().getClassLoader().getResource("images/port0.png"));
            this.port1 = ImageIO.read(getClass().getClassLoader().getResource("images/port1.png"));
            this.port2 = ImageIO.read(getClass().getClassLoader().getResource("images/port2.png"));
            this.port3 = ImageIO.read(getClass().getClassLoader().getResource("images/port3.png"));
            this.port4 = ImageIO.read(getClass().getClassLoader().getResource("images/port4.png"));
            this.port5 = ImageIO.read(getClass().getClassLoader().getResource("images/port5.png"));
            this.settlement1 = ImageIO.read(getClass().getClassLoader().getResource("images/settlement1.png"));
            this.settlement2 = ImageIO.read(getClass().getClassLoader().getResource("images/settlement2.png"));
            this.settlement3 = ImageIO.read(getClass().getClassLoader().getResource("images/settlement3.png"));
            this.settlement4 = ImageIO.read(getClass().getClassLoader().getResource("images/settlement4.png"));
            this.city1 = ImageIO.read(getClass().getClassLoader().getResource("images/city1.png"));
            this.city2 = ImageIO.read(getClass().getClassLoader().getResource("images/city2.png"));
            this.city3 = ImageIO.read(getClass().getClassLoader().getResource("images/city3.png"));
            this.city4 = ImageIO.read(getClass().getClassLoader().getResource("images/city4.png"));

            this.backgroundimage = ImageIO.read(getClass().getClassLoader().getResource("images/background.png"));
            this.robberimage = ImageIO.read(getClass().getClassLoader().getResource("images/robber.png"));
//            this.brick = ImageIO.read(new File(Game.class.getResource("/brick.png").getPath()));
//            this.wood = ImageIO.read(new File(Game.class.getResource("/wood.png").getPath()));
//            this.sheep = ImageIO.read(new File(Game.class.getResource("/sheep.png").getPath()));
//            this.wheat = ImageIO.read(new File(Game.class.getResource("/wheat.png").getPath()));
//            this.ore = ImageIO.read(new File(Game.class.getResource("/stone.png").getPath()));
//            this.desert = ImageIO.read(new File(Game.class.getResource("/desert.png").getPath()));
//            this.port = ImageIO.read(new File(Game.class.getResource("/port.png").getPath()));
        } catch (IOException e) {
            e.printStackTrace();
            gui.txtConsole.setText("Image could not be read");
        }
    }

    public void generateGameboard() {
        // 9 ports, 4 wood, 4 sheep, 4 wheat, 3 brick, 3 ore, 1 desert
        loadImages();
        setHexLocations();
        setTiles();
        setTilesRoll();
        setNeighbors();
        setPorts();
    }

    public void setHexLocations() {
        for (int i = 0; i < 19; i++) {
            this.hexlocations[i][0] = getX(i) + 50;
            this.hexlocations[i][1] = getY(i) + 50;
        }
    }

    public void setTiles() {
        for (int i = 0; i < 19; i++) {
            this.gameboard[i] = new Tile();
        }
        String[] tileTypes = new String[]{"wood", "wood", "wood", "wood", "sheep", "sheep", "sheep", "sheep", "wheat", "wheat", "wheat", "wheat", "brick", "brick", "brick", "ore", "ore", "ore", "desert"};
        int index;
        for (int i = 0; i < 19; i++) {
            while (true) {
                index = (int) (Math.random() * 19);
                if (tileTypes[index] != "") {
                    this.gameboard[i].setTile(tileTypes[index]);
                    tileTypes[index] = "";
                    if (this.gameboard[i].tile == "desert") {
                        this.robber.indexlocation = i;
                    }
                    break;
                }
            }
        }
    }

    void setTilesRoll() {
        int[] rollNums = new int[]{2, 3, 3, 4, 4, 5, 5, 6, 6, 8, 8, 9, 9, 10, 10, 11, 11, 12};
        int index;
        for (int i = 0; i < 19; i++) {
            if (this.gameboard[i].tile != "desert") {
                while (true) {
                    index = (int) Math.floor(Math.random() * 18);
                    if (rollNums[index] != 0) {
                        this.gameboard[i].setTile(rollNums[index]);
                        rollNums[index] = 0;
                        break;
                    }
                }
            }
        }
    }

    void setPorts() {
        String[] portType = new String[]{"port0", "port0", "port0", "port0", "port1", "port2", "port3", "port4", "port5"}; // 0(3:1 any), 1(2:1 wood), 2(2:1 sheep), 3(2:1 wheat), 4(2:1 brick), 5(2:1 ore)
        for (int i = 0; i < 9; i++) {
            this.portarray[i] = new Tile();
        }
        int index;

        while (true) {
            index = (int) Math.floor(Math.random() * 9);
            if (portType[index] != "") {
                this.portarray[0].setTile(portType[index]);
                this.gameboard[0].neighborTiles[0] = this.portarray[0];
                portType[index] = "";
                break;
            }
        }
        while (true) {
            index = (int) Math.floor(Math.random() * 9);
            if (portType[index] != "") {
                this.portarray[1].setTile(portType[index]);
                //this.gameboard[1].neighborTiles[1] = this.portarray[1];
                //this.gameboard[2].neighborTiles[0] = this.portarray[1];
                portType[index] = "";
                break;
            }
        }
        while (true) {
            index = (int) Math.floor(Math.random() * 9);
            if (portType[index] != "") {
                this.portarray[2].setTile(portType[index]);
                //this.gameboard[2].neighborTiles[2] = this.portarray[2];
                //this.gameboard[6].neighborTiles[1] = this.portarray[2];
                portType[index] = "";
                break;
            }
        }
        while (true) {
            index = (int) Math.floor(Math.random() * 9);
            if (portType[index] != "") {
                this.portarray[3].setTile(portType[index]);
                //this.gameboard[3].neighborTiles[5] = this.portarray[3];
                //this.gameboard[7].neighborTiles[0] = this.portarray[3];
                portType[index] = "";
                break;
            }
        }
        while (true) {
            index = (int) Math.floor(Math.random() * 9);
            if (portType[index] != "") {
                this.portarray[4].setTile(portType[index]);
                //this.gameboard[11].neighborTiles[2] = this.portarray[4];
                portType[index] = "";
                break;
            }
        }
        while (true) {
            index = (int) Math.floor(Math.random() * 9);
            if (portType[index] != "") {
                this.portarray[5].setTile(portType[index]);
                //this.gameboard[7].neighborTiles[4] = this.portarray[5];
                //this.gameboard[12].neighborTiles[5] = this.portarray[5];
                portType[index] = "";
                break;
            }
        }
        while (true) {
            index = (int) Math.floor(Math.random() * 9);
            if (portType[index] != "") {
                this.portarray[6].setTile(portType[index]);
                //this.gameboard[15].neighborTiles[3] = this.portarray[6];
                //this.gameboard[18].neighborTiles[2] = this.portarray[6];
                portType[index] = "";
                break;
            }
        }
        while (true) {
            index = (int) Math.floor(Math.random() * 9);
            if (portType[index] != "") {
                this.portarray[7].setTile(portType[index]);
                //this.gameboard[16].neighborTiles[4] = this.portarray[7];
                portType[index] = "";
                break;
            }
        }
        while (true) {
            index = (int) Math.floor(Math.random() * 9);
            if (portType[index] != "") {
                this.portarray[8].setTile(portType[index]);
                //this.gameboard[17].neighborTiles[3] = this.portarray[8];
                //this.gameboard[18].neighborTiles[4] = this.portarray[8];
                portType[index] = "";
                break;
            }
        }
    }

    public void checkPortTrade() {
        int index = 0;
        //
        if(this.gameboard[0].tileData[0] > 0){
            switch(this.portarray[0].tile){
                case "port0":
                    index = 0;
                    break;
                case "port1":
                    index = 1;
                    break;
                case "port2":
                    index = 2;
                    break;
                case "port3":
                    index = 3;
                    break;
                case "port4":
                    index = 4;
                    break;
                case "port5":
                    index = 5;
                    break;
            }
            switch(this.gameboard[0].tileData[0]){
                case 1:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 2:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 4:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 5:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 7:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 8:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 10:
                    this.players[3].tradingports[index] = 1;
                    break;
                case 11:
                    this.players[3].tradingports[index] = 1;
                    break;
            }
        }
        //
        if(this.gameboard[0].tileData[10] > 0){
            switch(this.portarray[0].tile){
                case "port0":
                    index = 0;
                    break;
                case "port1":
                    index = 1;
                    break;
                case "port2":
                    index = 2;
                    break;
                case "port3":
                    index = 3;
                    break;
                case "port4":
                    index = 4;
                    break;
                case "port5":
                    index = 5;
                    break;
            }
            switch(this.gameboard[0].tileData[10]){
                case 1:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 2:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 4:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 5:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 7:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 8:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 10:
                    this.players[3].tradingports[index] = 1;
                    break;
                case 11:
                    this.players[3].tradingports[index] = 1;
                    break;
            }
        }
        //
        if(this.gameboard[1].tileData[0] > 0){
            switch(this.portarray[1].tile){
                case "port0":
                    index = 0;
                    break;
                case "port1":
                    index = 1;
                    break;
                case "port2":
                    index = 2;
                    break;
                case "port3":
                    index = 3;
                    break;
                case "port4":
                    index = 4;
                    break;
                case "port5":
                    index = 5;
                    break;
            }
            switch(this.gameboard[1].tileData[0]){
                case 1:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 2:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 4:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 5:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 7:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 8:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 10:
                    this.players[3].tradingports[index] = 1;
                    break;
                case 11:
                    this.players[3].tradingports[index] = 1;
                    break;
            }
        }
        //
        if(this.gameboard[1].tileData[2] > 0){
            switch(this.portarray[1].tile){
                case "port0":
                    index = 0;
                    break;
                case "port1":
                    index = 1;
                    break;
                case "port2":
                    index = 2;
                    break;
                case "port3":
                    index = 3;
                    break;
                case "port4":
                    index = 4;
                    break;
                case "port5":
                    index = 5;
                    break;
            }
            switch(this.gameboard[1].tileData[2]){
                case 1:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 2:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 4:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 5:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 7:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 8:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 10:
                    this.players[3].tradingports[index] = 1;
                    break;
                case 11:
                    this.players[3].tradingports[index] = 1;
                    break;
            }
        }
        //
        if(this.gameboard[6].tileData[0] > 0){
            switch(this.portarray[2].tile){
                case "port0":
                    index = 0;
                    break;
                case "port1":
                    index = 1;
                    break;
                case "port2":
                    index = 2;
                    break;
                case "port3":
                    index = 3;
                    break;
                case "port4":
                    index = 4;
                    break;
                case "port5":
                    index = 5;
                    break;
            }
            switch(this.gameboard[6].tileData[0]){
                case 1:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 2:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 4:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 5:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 7:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 8:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 10:
                    this.players[3].tradingports[index] = 1;
                    break;
                case 11:
                    this.players[3].tradingports[index] = 1;
                    break;
            }
        }
        //
        if(this.gameboard[6].tileData[2] > 0){
            switch(this.portarray[2].tile){
                case "port0":
                    index = 0;
                    break;
                case "port1":
                    index = 1;
                    break;
                case "port2":
                    index = 2;
                    break;
                case "port3":
                    index = 3;
                    break;
                case "port4":
                    index = 4;
                    break;
                case "port5":
                    index = 5;
                    break;
            }
            switch(this.gameboard[6].tileData[2]){
                case 1:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 2:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 4:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 5:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 7:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 8:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 10:
                    this.players[3].tradingports[index] = 1;
                    break;
                case 11:
                    this.players[3].tradingports[index] = 1;
                    break;
            }
        }
        //
        if(this.gameboard[3].tileData[10] > 0){
            switch(this.portarray[3].tile){
                case "port0":
                    index = 0;
                    break;
                case "port1":
                    index = 1;
                    break;
                case "port2":
                    index = 2;
                    break;
                case "port3":
                    index = 3;
                    break;
                case "port4":
                    index = 4;
                    break;
                case "port5":
                    index = 5;
                    break;
            }
            switch(this.gameboard[3].tileData[10]){
                case 1:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 2:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 4:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 5:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 7:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 8:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 10:
                    this.players[3].tradingports[index] = 1;
                    break;
                case 11:
                    this.players[3].tradingports[index] = 1;
                    break;
            }
        }
        //
        if(this.gameboard[3].tileData[10] > 0){
            switch(this.portarray[3].tile){
                case "port0":
                    index = 0;
                    break;
                case "port1":
                    index = 1;
                    break;
                case "port2":
                    index = 2;
                    break;
                case "port3":
                    index = 3;
                    break;
                case "port4":
                    index = 4;
                    break;
                case "port5":
                    index = 5;
                    break;
            }
            switch(this.gameboard[3].tileData[10]){
                case 1:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 2:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 4:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 5:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 7:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 8:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 10:
                    this.players[3].tradingports[index] = 1;
                    break;
                case 11:
                    this.players[3].tradingports[index] = 1;
                    break;
            }
        }
        //
        if(this.gameboard[3].tileData[8] > 0){
            switch(this.portarray[3].tile){
                case "port0":
                    index = 0;
                    break;
                case "port1":
                    index = 1;
                    break;
                case "port2":
                    index = 2;
                    break;
                case "port3":
                    index = 3;
                    break;
                case "port4":
                    index = 4;
                    break;
                case "port5":
                    index = 5;
                    break;
            }
            switch(this.gameboard[3].tileData[8]){
                case 1:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 2:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 4:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 5:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 7:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 8:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 10:
                    this.players[3].tradingports[index] = 1;
                    break;
                case 11:
                    this.players[3].tradingports[index] = 1;
                    break;
            }
        }
        //
        if(this.gameboard[11].tileData[4] > 0){
            switch(this.portarray[4].tile){
                case "port0":
                    index = 0;
                    break;
                case "port1":
                    index = 1;
                    break;
                case "port2":
                    index = 2;
                    break;
                case "port3":
                    index = 3;
                    break;
                case "port4":
                    index = 4;
                    break;
                case "port5":
                    index = 5;
                    break;
            }
            switch(this.gameboard[11].tileData[4]){
                case 1:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 2:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 4:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 5:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 7:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 8:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 10:
                    this.players[3].tradingports[index] = 1;
                    break;
                case 11:
                    this.players[3].tradingports[index] = 1;
                    break;
            }
        }
        //
        if(this.gameboard[11].tileData[2] > 0){
            switch(this.portarray[4].tile){
                case "port0":
                    index = 0;
                    break;
                case "port1":
                    index = 1;
                    break;
                case "port2":
                    index = 2;
                    break;
                case "port3":
                    index = 3;
                    break;
                case "port4":
                    index = 4;
                    break;
                case "port5":
                    index = 5;
                    break;
            }
            switch(this.gameboard[11].tileData[2]){
                case 1:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 2:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 4:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 5:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 7:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 8:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 10:
                    this.players[3].tradingports[index] = 1;
                    break;
                case 11:
                    this.players[3].tradingports[index] = 1;
                    break;
            }
        }
        //
        if(this.gameboard[12].tileData[10] > 0){
            switch(this.portarray[5].tile){
                case "port0":
                    index = 0;
                    break;
                case "port1":
                    index = 1;
                    break;
                case "port2":
                    index = 2;
                    break;
                case "port3":
                    index = 3;
                    break;
                case "port4":
                    index = 4;
                    break;
                case "port5":
                    index = 5;
                    break;
            }
            switch(this.gameboard[12].tileData[10]){
                case 1:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 2:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 4:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 5:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 7:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 8:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 10:
                    this.players[3].tradingports[index] = 1;
                    break;
                case 11:
                    this.players[3].tradingports[index] = 1;
                    break;
            }
        }
        //
        if(this.gameboard[12].tileData[8] > 0){
            switch(this.portarray[5].tile){
                case "port0":
                    index = 0;
                    break;
                case "port1":
                    index = 1;
                    break;
                case "port2":
                    index = 2;
                    break;
                case "port3":
                    index = 3;
                    break;
                case "port4":
                    index = 4;
                    break;
                case "port5":
                    index = 5;
                    break;
            }
            switch(this.gameboard[12].tileData[8]){
                case 1:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 2:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 4:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 5:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 7:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 8:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 10:
                    this.players[3].tradingports[index] = 1;
                    break;
                case 11:
                    this.players[3].tradingports[index] = 1;
                    break;
            }
        }
        //
        if(this.gameboard[15].tileData[4] > 0){
            switch(this.portarray[6].tile){
                case "port0":
                    index = 0;
                    break;
                case "port1":
                    index = 1;
                    break;
                case "port2":
                    index = 2;
                    break;
                case "port3":
                    index = 3;
                    break;
                case "port4":
                    index = 4;
                    break;
                case "port5":
                    index = 5;
                    break;
            }
            switch(this.gameboard[15].tileData[4]){
                case 1:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 2:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 4:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 5:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 7:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 8:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 10:
                    this.players[3].tradingports[index] = 1;
                    break;
                case 11:
                    this.players[3].tradingports[index] = 1;
                    break;
            }
        }
        //
        if(this.gameboard[15].tileData[6] > 0){
            switch(this.portarray[6].tile){
                case "port0":
                    index = 0;
                    break;
                case "port1":
                    index = 1;
                    break;
                case "port2":
                    index = 2;
                    break;
                case "port3":
                    index = 3;
                    break;
                case "port4":
                    index = 4;
                    break;
                case "port5":
                    index = 5;
                    break;
            }
            switch(this.gameboard[15].tileData[6]){
                case 1:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 2:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 4:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 5:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 7:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 8:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 10:
                    this.players[3].tradingports[index] = 1;
                    break;
                case 11:
                    this.players[3].tradingports[index] = 1;
                    break;
            }
        }
        //
        if(this.gameboard[16].tileData[8] > 0){
            switch(this.portarray[7].tile){
                case "port0":
                    index = 0;
                    break;
                case "port1":
                    index = 1;
                    break;
                case "port2":
                    index = 2;
                    break;
                case "port3":
                    index = 3;
                    break;
                case "port4":
                    index = 4;
                    break;
                case "port5":
                    index = 5;
                    break;
            }
            switch(this.gameboard[16].tileData[8]){
                case 1:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 2:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 4:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 5:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 7:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 8:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 10:
                    this.players[3].tradingports[index] = 1;
                    break;
                case 11:
                    this.players[3].tradingports[index] = 1;
                    break;
            }
        }
        //
        if(this.gameboard[16].tileData[6] > 0){
            switch(this.portarray[7].tile){
                case "port0":
                    index = 0;
                    break;
                case "port1":
                    index = 1;
                    break;
                case "port2":
                    index = 2;
                    break;
                case "port3":
                    index = 3;
                    break;
                case "port4":
                    index = 4;
                    break;
                case "port5":
                    index = 5;
                    break;
            }
            switch(this.gameboard[16].tileData[6]){
                case 1:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 2:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 4:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 5:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 7:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 8:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 10:
                    this.players[3].tradingports[index] = 1;
                    break;
                case 11:
                    this.players[3].tradingports[index] = 1;
                    break;
            }
        }
        //
        if(this.gameboard[17].tileData[4] > 0){
            switch(this.portarray[8].tile){
                case "port0":
                    index = 0;
                    break;
                case "port1":
                    index = 1;
                    break;
                case "port2":
                    index = 2;
                    break;
                case "port3":
                    index = 3;
                    break;
                case "port4":
                    index = 4;
                    break;
                case "port5":
                    index = 5;
                    break;
            }
            switch(this.gameboard[17].tileData[4]){
                case 1:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 2:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 4:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 5:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 7:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 8:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 10:
                    this.players[3].tradingports[index] = 1;
                    break;
                case 11:
                    this.players[3].tradingports[index] = 1;
                    break;
            }
        }
        //
        if(this.gameboard[17].tileData[6] > 0){
            switch(this.portarray[8].tile){
                case "port0":
                    index = 0;
                    break;
                case "port1":
                    index = 1;
                    break;
                case "port2":
                    index = 2;
                    break;
                case "port3":
                    index = 3;
                    break;
                case "port4":
                    index = 4;
                    break;
                case "port5":
                    index = 5;
                    break;
            }
            switch(this.gameboard[17].tileData[6]){
                case 1:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 2:
                    this.players[0].tradingports[index] = 1;
                    break;
                case 4:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 5:
                    this.players[1].tradingports[index] = 1;
                    break;
                case 7:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 8:
                    this.players[2].tradingports[index] = 1;
                    break;
                case 10:
                    this.players[3].tradingports[index] = 1;
                    break;
                case 11:
                    this.players[3].tradingports[index] = 1;
                    break;
            }
        }
    }

    void setNeighbors() {
        // index based 
        // 0 neighbors are port,null,1,4,3,null
        this.gameboard[0].neighborTiles[2] = this.gameboard[1];
        this.gameboard[0].neighborTiles[3] = this.gameboard[4];
        this.gameboard[0].neighborTiles[4] = this.gameboard[3];
        // 1 neighbors are null,port,2,5,4,0
        this.gameboard[1].neighborTiles[2] = this.gameboard[2];
        this.gameboard[1].neighborTiles[3] = this.gameboard[5];
        this.gameboard[1].neighborTiles[4] = this.gameboard[4];
        this.gameboard[1].neighborTiles[5] = this.gameboard[0];
        // 2 neighbors are null,null,null,6,5,1
        this.gameboard[2].neighborTiles[3] = this.gameboard[6];
        this.gameboard[2].neighborTiles[4] = this.gameboard[5];
        this.gameboard[2].neighborTiles[5] = this.gameboard[1];
        // 3 neighbors are null,0,4,8,7,null
        this.gameboard[3].neighborTiles[1] = this.gameboard[0];
        this.gameboard[3].neighborTiles[2] = this.gameboard[4];
        this.gameboard[3].neighborTiles[3] = this.gameboard[8];
        this.gameboard[3].neighborTiles[4] = this.gameboard[7];
        // 4 neighbors are 0,1,5,9,8,3
        this.gameboard[4].neighborTiles[0] = this.gameboard[0];
        this.gameboard[4].neighborTiles[1] = this.gameboard[1];
        this.gameboard[4].neighborTiles[2] = this.gameboard[5];
        this.gameboard[4].neighborTiles[3] = this.gameboard[9];
        this.gameboard[4].neighborTiles[4] = this.gameboard[8];
        this.gameboard[4].neighborTiles[5] = this.gameboard[3];
        // 5 neighbors are 1,2,6,10,9,4
        this.gameboard[5].neighborTiles[0] = this.gameboard[1];
        this.gameboard[5].neighborTiles[1] = this.gameboard[2];
        this.gameboard[5].neighborTiles[2] = this.gameboard[6];
        this.gameboard[5].neighborTiles[3] = this.gameboard[10];
        this.gameboard[5].neighborTiles[4] = this.gameboard[9];
        this.gameboard[5].neighborTiles[5] = this.gameboard[4];
        // 6 neighbors are 2,null,null,11,10,5
        this.gameboard[6].neighborTiles[1] = this.portarray[2];
        this.gameboard[6].neighborTiles[0] = this.gameboard[2];
        this.gameboard[6].neighborTiles[3] = this.gameboard[11];
        this.gameboard[6].neighborTiles[4] = this.gameboard[10];
        this.gameboard[6].neighborTiles[5] = this.gameboard[5];
        // 7 neighbors are null,3,8,12,null,null
        this.gameboard[7].neighborTiles[1] = this.gameboard[3];
        this.gameboard[7].neighborTiles[2] = this.gameboard[8];
        this.gameboard[7].neighborTiles[3] = this.gameboard[12];
        // 8 neighbors are 3,4,9,13,12,7
        this.gameboard[8].neighborTiles[0] = this.gameboard[3];
        this.gameboard[8].neighborTiles[1] = this.gameboard[4];
        this.gameboard[8].neighborTiles[2] = this.gameboard[9];
        this.gameboard[8].neighborTiles[3] = this.gameboard[13];
        this.gameboard[8].neighborTiles[4] = this.gameboard[12];
        this.gameboard[8].neighborTiles[5] = this.gameboard[7];
        // 9 neighbors are 4,5,10,14,13,8
        this.gameboard[9].neighborTiles[0] = this.gameboard[4];
        this.gameboard[9].neighborTiles[1] = this.gameboard[5];
        this.gameboard[9].neighborTiles[2] = this.gameboard[10];
        this.gameboard[9].neighborTiles[3] = this.gameboard[14];
        this.gameboard[9].neighborTiles[4] = this.gameboard[13];
        this.gameboard[9].neighborTiles[5] = this.gameboard[8];
        // 10 neighbors are 5,6,11,15,14,9
        this.gameboard[10].neighborTiles[0] = this.gameboard[5];
        this.gameboard[10].neighborTiles[1] = this.gameboard[6];
        this.gameboard[10].neighborTiles[2] = this.gameboard[11];
        this.gameboard[10].neighborTiles[3] = this.gameboard[15];
        this.gameboard[10].neighborTiles[4] = this.gameboard[14];
        this.gameboard[10].neighborTiles[5] = this.gameboard[9];
        // 11 neighbors are 6,null,port,null,15,10
        this.gameboard[11].neighborTiles[0] = this.gameboard[6];
        this.gameboard[11].neighborTiles[4] = this.gameboard[15];
        this.gameboard[11].neighborTiles[5] = this.gameboard[10];
        // 12 neighbors are 7,8,13,16,null,null
        this.gameboard[12].neighborTiles[0] = this.gameboard[7];
        this.gameboard[12].neighborTiles[1] = this.gameboard[8];
        this.gameboard[12].neighborTiles[2] = this.gameboard[13];
        this.gameboard[12].neighborTiles[3] = this.gameboard[16];
        // 13 neighbors are 8,9,14,17,16,12
        this.gameboard[13].neighborTiles[0] = this.gameboard[8];
        this.gameboard[13].neighborTiles[1] = this.gameboard[9];
        this.gameboard[13].neighborTiles[2] = this.gameboard[14];
        this.gameboard[13].neighborTiles[3] = this.gameboard[17];
        this.gameboard[13].neighborTiles[4] = this.gameboard[16];
        this.gameboard[13].neighborTiles[5] = this.gameboard[12];
        // 14 neighbors are 9,10,15,18,17,13
        this.gameboard[14].neighborTiles[0] = this.gameboard[9];
        this.gameboard[14].neighborTiles[1] = this.gameboard[10];
        this.gameboard[14].neighborTiles[2] = this.gameboard[15];
        this.gameboard[14].neighborTiles[3] = this.gameboard[18];
        this.gameboard[14].neighborTiles[4] = this.gameboard[17];
        this.gameboard[14].neighborTiles[5] = this.gameboard[13];
        // 15 neighbors are 10,11,null,null,18,14
        this.gameboard[15].neighborTiles[0] = this.gameboard[10];
        this.gameboard[15].neighborTiles[1] = this.gameboard[11];
        this.gameboard[15].neighborTiles[4] = this.gameboard[18];
        this.gameboard[15].neighborTiles[5] = this.gameboard[14];
        // 16 neighbors are 12,13,17,null,null,null
        this.gameboard[16].neighborTiles[0] = this.gameboard[12];
        this.gameboard[16].neighborTiles[1] = this.gameboard[13];
        this.gameboard[16].neighborTiles[2] = this.gameboard[17];
        // 17 neighbors are 13,14,18,null,null,16
        this.gameboard[17].neighborTiles[0] = this.gameboard[13];
        this.gameboard[17].neighborTiles[1] = this.gameboard[14];
        this.gameboard[17].neighborTiles[2] = this.gameboard[18];
        this.gameboard[17].neighborTiles[5] = this.gameboard[16];
        // 18 neighbors are 14,15,null,null,null,17
        this.gameboard[18].neighborTiles[0] = this.gameboard[14];
        this.gameboard[18].neighborTiles[1] = this.gameboard[15];
        this.gameboard[18].neighborTiles[5] = this.gameboard[17];
    }
}
