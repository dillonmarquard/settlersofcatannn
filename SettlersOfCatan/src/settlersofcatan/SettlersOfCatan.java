/*
 * Settlers of Catan
 */
package settlersofcatan;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Dillon Marquard yes the cocaine helped
 */
public class SettlersOfCatan {

    public static void main(String[] args) {

        GUI gui = new GUI();
        gui.setVisible(true);

        gui.game = new Game();
        gui.game.loadImages(); // load images onto game for display
        gui.game.generateGameboard(); // debug
        gui.game.setHexLocations();
        Graphics g = gui.canvas.getGraphics();
        while (true) {
            if (gui.gamestate == 1) {
                // debug
                for(int i = 0; i < 6; i++){
                    System.out.println(gui.game.players[0].tradingports[i]);
                }
                System.out.println("");
                for(int x = 0; x < 5; x++){
                    gui.game.players[0].resources[x] = 10; // 0(3:1 any), 1(2:1 wood), 2(2:1 sheep), 3(2:1 wheat), 4(2:1 brick), 5(2:1 ore) 
                }
                //
                gui.game.render(g);
                // selected hex gui
                if (gui.game.selectedHexIndex != -1) {
                    g.setColor(Color.gray);
                    for (int i = 0; i < 12; i++) {
                        g.fillOval((int) gui.game.getSubLoc(i, true, gui.game.hexlocations[gui.game.selectedHexIndex][0] - 25 / 2), (int) gui.game.getSubLoc(i, false, gui.game.hexlocations[gui.game.selectedHexIndex][1] - 25 / 2), 25, 25);
                    }
                }
                // selected robber gui
                if(gui.game.robberSelected == true){
                    g.setColor(Color.red);
                    for (int i = 0; i < 19; i++) {
                        if(i != gui.game.robber.indexlocation){
                            g.fillOval((int) gui.game.hexlocations[i][0] - 25 / 2, (int) gui.game.hexlocations[i][1] - 25 / 2, 25, 25);
                        }
                    }
                }
                // update playerinfo administrative function
                try {
                    gui.labCurrentTurnCount.setText("Turn Count for Selected Player: " + Integer.toString(gui.game.players[gui.game.yourindex].yourturncount));
                    gui.labCurrentIndex.setText("Selected Players Index: " + Integer.toString(gui.game.yourindex));
                    gui.labCurrentPlayerTurnIndex.setText("Current Players Turn Index: " + Integer.toString(gui.game.playerturn));
                } catch (Exception e) {

                }
                // load each players resources
                try {
                    gui.p1wood.setText("wood: " + Integer.toString(gui.game.players[0].resources[0]));
                    gui.p1sheep.setText("wool: " + Integer.toString(gui.game.players[0].resources[1]));
                    gui.p1wheat.setText("wheat: " + Integer.toString(gui.game.players[0].resources[2]));
                    gui.p1brick.setText("brick: " + Integer.toString(gui.game.players[0].resources[3]));
                    gui.p1ore.setText("ore: " + Integer.toString(gui.game.players[0].resources[4]));
                } catch(Exception e){
                    
                }
                try {
                    gui.p2wood.setText("wood: " + Integer.toString(gui.game.players[1].resources[0]));
                    gui.p2sheep.setText("wool: " + Integer.toString(gui.game.players[1].resources[1]));
                    gui.p2wheat.setText("wheat: " + Integer.toString(gui.game.players[1].resources[2]));
                    gui.p2brick.setText("brick: " + Integer.toString(gui.game.players[1].resources[3]));
                    gui.p2ore.setText("ore: " + Integer.toString(gui.game.players[1].resources[4]));
                } catch(Exception e){
                    
                }
                try {
                    gui.p3wood.setText("wood: " + Integer.toString(gui.game.players[2].resources[0]));
                    gui.p3sheep.setText("wool: " + Integer.toString(gui.game.players[2].resources[1]));
                    gui.p3wheat.setText("wheat: " + Integer.toString(gui.game.players[2].resources[2]));
                    gui.p3brick.setText("brick: " + Integer.toString(gui.game.players[2].resources[3]));
                    gui.p3ore.setText("ore: " + Integer.toString(gui.game.players[2].resources[4]));
                } catch(Exception e){
                    
                }
                try {
                    gui.p4wood.setText("wood: " + Integer.toString(gui.game.players[3].resources[0]));
                    gui.p4sheep.setText("wool: " + Integer.toString(gui.game.players[3].resources[1]));
                    gui.p4wheat.setText("wheat: " + Integer.toString(gui.game.players[3].resources[2]));
                    gui.p4brick.setText("brick: " + Integer.toString(gui.game.players[3].resources[3]));
                    gui.p4ore.setText("ore: " + Integer.toString(gui.game.players[3].resources[4]));
                } catch(Exception e){
                    
                }
            }

            try {
                TimeUnit.MILLISECONDS.sleep((long) 1000.0 / (long) 3.0);
            } catch (InterruptedException ex) {
                Logger.getLogger(SettlersOfCatan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
