package settlersofcatan;

public class GUI extends javax.swing.JFrame {

    Game game;
    int gamestate = 0;
    
    public GUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        canvas = new java.awt.Canvas();
        jPanel2 = new javax.swing.JPanel();
        butExit = new javax.swing.JButton();
        butCreateSession = new javax.swing.JButton();
        butPlayOffline = new javax.swing.JButton();
        butJoinSession = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtConsole = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        butNextTurn = new javax.swing.JButton();
        player1Menu = new javax.swing.JPanel();
        p1wood = new javax.swing.JLabel();
        p1sheep = new javax.swing.JLabel();
        p1wheat = new javax.swing.JLabel();
        p1brick = new javax.swing.JLabel();
        p1ore = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        player2Menu = new javax.swing.JPanel();
        p2sheep = new javax.swing.JLabel();
        p2ore = new javax.swing.JLabel();
        p2wheat = new javax.swing.JLabel();
        p2brick = new javax.swing.JLabel();
        p2wood = new javax.swing.JLabel();
        player3Menu = new javax.swing.JPanel();
        p3ore = new javax.swing.JLabel();
        p3sheep = new javax.swing.JLabel();
        p3wheat = new javax.swing.JLabel();
        p3brick = new javax.swing.JLabel();
        p3wood = new javax.swing.JLabel();
        player4Menu = new javax.swing.JPanel();
        p4wood = new javax.swing.JLabel();
        p4wheat = new javax.swing.JLabel();
        p4brick = new javax.swing.JLabel();
        p4ore = new javax.swing.JLabel();
        p4sheep = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        labCurrentIndex = new javax.swing.JLabel();
        labCurrentPlayerTurnIndex = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        labCurrentTurnCount = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Settlers of Catan"));
        jPanel1.setMinimumSize(new java.awt.Dimension(659, 569));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 600));

        canvas.setMaximumSize(new java.awt.Dimension(659, 569));
        canvas.setMinimumSize(new java.awt.Dimension(659, 569));
        canvas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                canvasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(canvas, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(canvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu"));

        butExit.setText("Exit");
        butExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butExitActionPerformed(evt);
            }
        });

        butCreateSession.setText("Create Session");

        butPlayOffline.setText("Play Offline");

        butJoinSession.setText("Join Session");
        butJoinSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butJoinSessionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(butCreateSession)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(butJoinSession)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(butPlayOffline)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(butExit)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butJoinSession)
                    .addComponent(butCreateSession, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butPlayOffline)
                    .addComponent(butExit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));

        txtConsole.setEditable(false);

        jLabel1.setText("Console");

        butNextTurn.setText("Next Turn");
        butNextTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butNextTurnActionPerformed(evt);
            }
        });

        player1Menu.setBorder(javax.swing.BorderFactory.createTitledBorder("Player 1"));

        p1wood.setText("wood:");

        p1sheep.setText("wool:");

        p1wheat.setText("wheat:");

        p1brick.setText("brick:");

        p1ore.setText("ore:");

        javax.swing.GroupLayout player1MenuLayout = new javax.swing.GroupLayout(player1Menu);
        player1Menu.setLayout(player1MenuLayout);
        player1MenuLayout.setHorizontalGroup(
            player1MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player1MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(player1MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p1wheat)
                    .addGroup(player1MenuLayout.createSequentialGroup()
                        .addGroup(player1MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p1wood)
                            .addComponent(p1sheep))
                        .addGap(26, 26, 26)
                        .addGroup(player1MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p1ore)
                            .addComponent(p1brick))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        player1MenuLayout.setVerticalGroup(
            player1MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player1MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(player1MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p1wood)
                    .addComponent(p1brick))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(player1MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p1sheep)
                    .addComponent(p1ore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p1wheat)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jButton7.setText("Roll");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        player2Menu.setBorder(javax.swing.BorderFactory.createTitledBorder("Player 2"));

        p2sheep.setText("wool:");

        p2ore.setText("ore:");

        p2wheat.setText("wheat:");

        p2brick.setText("brick:");

        p2wood.setText("wood:");

        javax.swing.GroupLayout player2MenuLayout = new javax.swing.GroupLayout(player2Menu);
        player2Menu.setLayout(player2MenuLayout);
        player2MenuLayout.setHorizontalGroup(
            player2MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player2MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(player2MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p2wheat)
                    .addGroup(player2MenuLayout.createSequentialGroup()
                        .addGroup(player2MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p2wood)
                            .addComponent(p2sheep))
                        .addGap(26, 26, 26)
                        .addGroup(player2MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p2ore)
                            .addComponent(p2brick))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        player2MenuLayout.setVerticalGroup(
            player2MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player2MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(player2MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p2wood)
                    .addComponent(p2brick))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(player2MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p2sheep)
                    .addComponent(p2ore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p2wheat)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        player3Menu.setBorder(javax.swing.BorderFactory.createTitledBorder("Player 3"));

        p3ore.setText("ore:");

        p3sheep.setText("wool:");

        p3wheat.setText("wheat:");

        p3brick.setText("brick:");

        p3wood.setText("wood:");

        javax.swing.GroupLayout player3MenuLayout = new javax.swing.GroupLayout(player3Menu);
        player3Menu.setLayout(player3MenuLayout);
        player3MenuLayout.setHorizontalGroup(
            player3MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player3MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(player3MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p3wheat)
                    .addGroup(player3MenuLayout.createSequentialGroup()
                        .addGroup(player3MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p3wood)
                            .addComponent(p3sheep))
                        .addGap(26, 26, 26)
                        .addGroup(player3MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p3ore)
                            .addComponent(p3brick))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        player3MenuLayout.setVerticalGroup(
            player3MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player3MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(player3MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p3wood)
                    .addComponent(p3brick))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(player3MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p3sheep)
                    .addComponent(p3ore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p3wheat)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        player4Menu.setBorder(javax.swing.BorderFactory.createTitledBorder("Player 4"));

        p4wood.setText("wood:");

        p4wheat.setText("wheat:");

        p4brick.setText("brick:");

        p4ore.setText("ore:");

        p4sheep.setText("wool:");

        javax.swing.GroupLayout player4MenuLayout = new javax.swing.GroupLayout(player4Menu);
        player4Menu.setLayout(player4MenuLayout);
        player4MenuLayout.setHorizontalGroup(
            player4MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player4MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(player4MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p4wheat)
                    .addGroup(player4MenuLayout.createSequentialGroup()
                        .addGroup(player4MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p4wood)
                            .addComponent(p4sheep))
                        .addGap(26, 26, 26)
                        .addGroup(player4MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p4ore)
                            .addComponent(p4brick))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        player4MenuLayout.setVerticalGroup(
            player4MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player4MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(player4MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p4wood)
                    .addComponent(p4brick))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(player4MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p4sheep)
                    .addComponent(p4ore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p4wheat)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jButton9.setText("Trade");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(player4Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(player3Menu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(player1Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(100, 100, 100)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7))
                    .addComponent(player2Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtConsole, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butNextTurn)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(player1Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(player2Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(player3Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(player4Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7)
                        .addComponent(jButton9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConsole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butNextTurn))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Administrative Functions"));

        jButton1.setText("player0");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("player1");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("player2");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("player3");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        labCurrentIndex.setText("Selected Players Index: ");

        labCurrentPlayerTurnIndex.setText("Current Players Turn Index:");

        jButton5.setText("Current Player Turn ++");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Current Player Turn --");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        labCurrentTurnCount.setText("Turn Count for Selected Player: ");

        jButton8.setText("Give Player Robber");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labCurrentTurnCount)
                            .addComponent(jButton4)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8))
                            .addComponent(labCurrentIndex)
                            .addComponent(labCurrentPlayerTurnIndex))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labCurrentIndex)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labCurrentPlayerTurnIndex)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labCurrentTurnCount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_butExitActionPerformed

    private void canvasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseClicked
        this.game.interpretAction(evt.getX(), evt.getY());
    }//GEN-LAST:event_canvasMouseClicked

    private void butJoinSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butJoinSessionActionPerformed
        // server magic assigns each player an index from 0-3 in the players array
        this.game = new Game();
        this.game.gui = this;
        this.game.yourindex = 0; 
        this.game.generateGameboard(); // debug
        this.game.numOfPlayers = 2; // get number from session queue or something(TBD)
        for(int i = 0; i < 4; i++){
            if(i < this.game.numOfPlayers){
                this.game.players[i] = new Player();
            }else{
                this.game.players[i] = null;
            }
        }
        this.gamestate = 1;
        switch(this.game.numOfPlayers){
            case 1:
                this.player1Menu.setVisible(true);
                this.player2Menu.setVisible(false);
                this.player3Menu.setVisible(false);
                this.player4Menu.setVisible(false);
            case 2:
                this.player1Menu.setVisible(true);
                this.player2Menu.setVisible(true);
                this.player3Menu.setVisible(false);
                this.player4Menu.setVisible(false);
            case 3:
                this.player1Menu.setVisible(true);
                this.player2Menu.setVisible(true);
                this.player3Menu.setVisible(true);
                this.player4Menu.setVisible(false);
            case 4:
                this.player1Menu.setVisible(true);
                this.player2Menu.setVisible(true);
                this.player3Menu.setVisible(true);
                this.player4Menu.setVisible(true);
        }
    }//GEN-LAST:event_butJoinSessionActionPerformed

    private void butNextTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butNextTurnActionPerformed
        if(!this.game.players[this.game.yourindex].hasRolled){
            this.txtConsole.setText("must roll before ending turn");
            return;
        }
        if(this.game.players[this.game.yourindex].yourturncount > 2){
            this.game.nextTurn();
        }else{
            this.txtConsole.setText("must place starting settlements and roads.");
        }
    }//GEN-LAST:event_butNextTurnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.game.yourindex = 0;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.game.yourindex = 1;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.game.yourindex = 2;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.game.yourindex = 3;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.game.players[this.game.yourindex].yourturncount++;
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.game.players[this.game.yourindex].yourturncount--;
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(this.game.playerturn == this.game.yourindex && this.game.players[this.game.yourindex].hasRolled == false && this.game.players[this.game.yourindex].yourturncount > 2){
            this.game.roll();
            
        }else{
            this.txtConsole.setText("you may not roll");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.game.players[this.game.yourindex].hasRobber = true;
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(!this.game.players[this.game.yourindex].hasRolled){
            this.txtConsole.setText("must roll before trading");
            return;
        }
        this.game.checkPortTrade();
    }//GEN-LAST:event_jButton9ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);

            }
        }); 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butCreateSession;
    private javax.swing.JButton butExit;
    private javax.swing.JButton butJoinSession;
    private javax.swing.JButton butNextTurn;
    private javax.swing.JButton butPlayOffline;
    public java.awt.Canvas canvas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    public javax.swing.JLabel labCurrentIndex;
    public javax.swing.JLabel labCurrentPlayerTurnIndex;
    public javax.swing.JLabel labCurrentTurnCount;
    public javax.swing.JLabel p1brick;
    public javax.swing.JLabel p1ore;
    public javax.swing.JLabel p1sheep;
    public javax.swing.JLabel p1wheat;
    public javax.swing.JLabel p1wood;
    public javax.swing.JLabel p2brick;
    public javax.swing.JLabel p2ore;
    public javax.swing.JLabel p2sheep;
    public javax.swing.JLabel p2wheat;
    public javax.swing.JLabel p2wood;
    public javax.swing.JLabel p3brick;
    public javax.swing.JLabel p3ore;
    public javax.swing.JLabel p3sheep;
    public javax.swing.JLabel p3wheat;
    public javax.swing.JLabel p3wood;
    public javax.swing.JLabel p4brick;
    public javax.swing.JLabel p4ore;
    protected javax.swing.JLabel p4sheep;
    public javax.swing.JLabel p4wheat;
    public javax.swing.JLabel p4wood;
    public javax.swing.JPanel player1Menu;
    public javax.swing.JPanel player2Menu;
    public javax.swing.JPanel player3Menu;
    public javax.swing.JPanel player4Menu;
    public javax.swing.JTextField txtConsole;
    // End of variables declaration//GEN-END:variables
}
