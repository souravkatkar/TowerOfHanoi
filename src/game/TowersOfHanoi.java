package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;


public class TowersOfHanoi extends javax.swing.JPanel implements ActionListener, Runnable  {

  
    public TowersOfHanoi() {
      n=First.getVariable();
      initComponents();
      OSC = new BufferedImage(430,143,BufferedImage.TYPE_INT_RGB);
      display = new Display();
      display.setPreferredSize(new Dimension(430,143));
      display.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 2));
      display.setBackground(BACKGROUND_COLOR);
      setLayout(new BorderLayout());
      add(display, BorderLayout.CENTER);
       JPanel buttonBar = new JPanel();
      add(buttonBar, BorderLayout.SOUTH);
      buttonBar.setLayout(new GridLayout(1,0));
      runPauseButton = new JButton("Run");
      runPauseButton.addActionListener(this);
      buttonBar.add(runPauseButton);
      nextStepButton = new JButton("Next Step");
      nextStepButton.addActionListener(this);
      buttonBar.add(nextStepButton);
      startOverButton = new JButton("Start Over");
      startOverButton.addActionListener(this);
      startOverButton.setEnabled(false);
      buttonBar.add(startOverButton);
      restartButton = new JButton("Restart");
      restartButton.addActionListener(this);
      buttonBar.add(restartButton);
      new Thread(this).start();
    }

   
    synchronized public void actionPerformed(ActionEvent evt) {
      Object source = evt.getSource();
      if (source == runPauseButton) {  // Toggle between running and paused.
         if (status == GO) {  // Animation is running.  Pause it.
            status = PAUSE;
            nextStepButton.setEnabled(true);
            runPauseButton.setText("Run");
         }
         else {  // Animation is paused.  Start it running.
            status = GO;
            nextStepButton.setEnabled(false);  // Disabled when animation is running
            runPauseButton.setText("Pause");
         }
      }
      else if (source == nextStepButton) {  // Set status to make animation run one step.
         status = STEP;
      }
      else if (source == startOverButton) { // Set status to make animation restart.
         status = RESTART;
      }
      else if(source == restartButton)
      {
         
          First.main(new String[0]);
          
      }
      notify();  // Wake up the thread so it can see the new status value!
   }
   
   
    private class Display extends JPanel {
      protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         int x = (getWidth() - OSC.getWidth())/2;
         int y = (getHeight() - OSC.getHeight())/2;
         g.drawImage(OSC, x, y, null);
      }
   }
     public void run() {
      while (true) {
         
         runPauseButton.setText("Run");
         nextStepButton.setEnabled(true);
         startOverButton.setEnabled(false);
       
         setUpProblem();  // Sets up the initial state of the puzzle
         status = PAUSE;
         checkStatus(); // Returns only when user has clicked "Run" or "Next"
         startOverButton.setEnabled(true);
         try {
            solve(n,0,1,2);  // Move n disks from pile 0 to pile 1.
         }
         catch (IllegalStateException e) {
               // Exception was thrown because user clicked "Start Over".
         }         
      }
   }
     
     
     synchronized private void setUpProblem() {
      moveDisk= 0;
      tower = new int[3][n];
      for (int i = 0; i < n; i++)
         tower[0][i] = n - i;
      towerHeight = new int[3];
      towerHeight[0] = n;
      if (OSC != null) {
         Graphics g = OSC.getGraphics();
         drawCurrentFrame(g);
         g.dispose();
      }
      display.repaint();
   }
     private void solve(int disks, int from, int to, int spare) {
      if (disks == 1)
         moveOne(from,to);
      else {
         solve(disks-1, from, spare, to);
         moveOne(from,to);
         solve(disks-1, spare, to, from);
      }
   }
     synchronized private void moveOne(int fromStack, int toStack) {
      moveDisk = tower[fromStack][towerHeight[fromStack]-1];
      moveTower = fromStack;
      delay(120);
      towerHeight[fromStack]--;
      putDisk(MOVE_DISK_COLOR,moveDisk,moveTower);
      delay(80);
      putDisk(BACKGROUND_COLOR,moveDisk,moveTower);
      delay(80);
      moveTower = toStack;
      putDisk(MOVE_DISK_COLOR,moveDisk,moveTower);
      delay(80);
      putDisk(DISK_COLOR,moveDisk,moveTower);
      tower[toStack][towerHeight[toStack]] = moveDisk;
      towerHeight[toStack]++;
      moveDisk = 0;
      if (status == STEP)
         status = PAUSE;
      checkStatus();
   }
      synchronized private void delay(int milliseconds) {
      try {
         wait(milliseconds);
      }
      catch (InterruptedException e) {
      }
   }
      
      private void putDisk(Color color, int disk, int t) {
      Graphics g = OSC.getGraphics();
      g.setColor(color);
      g.fillRoundRect(75+140*t - 5*disk - 5, 116-12*towerHeight[t], 10*disk+10, 10, 10, 10);
      g.dispose();
      display.repaint();
   }
      synchronized private void drawCurrentFrame(Graphics g) {
      // Called to draw the current frame.  But it is not drawn during
      // the animation of the solution.  During the animation, the
      // moveDisk() method just modifies the existing picture.
      g.setColor(BACKGROUND_COLOR);
      g.fillRect(0,0,430,143);
      g.setColor(BORDER_COLOR);
      if (tower == null)
         return;
      g.fillRect(10,128,130,5);
      g.fillRect(150,128,130,5);
      g.fillRect(290,128,130,5);
      g.setColor(DISK_COLOR);
      for (int t = 0; t < 3; t++) {
         for (int i = 0; i < towerHeight[t]; i++) {
            int disk = tower[t][i];
            g.fillRoundRect(75+140*t - 5*disk - 5, 116-12*i, 10*disk+10, 10, 10, 10);
         }
      }
      if (moveDisk > 0) {
         g.setColor(MOVE_DISK_COLOR);
         g.fillRoundRect(75+140*moveTower - 5*moveDisk - 5, 116-12*towerHeight[moveTower], 
               10*moveDisk+10, 10, 10, 10);
      }
      }
      
 synchronized public  void checkStatus() {
      while (status == PAUSE) {
        
          try {
             wait();
        }
         catch (InterruptedException e) {
         }
      if (status == RESTART)
         throw new IllegalStateException("Restart");
      // At this point, status is RUN or STEP.
   }
 }


    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

   private int[][] tower;
   private int[] towerHeight;
   private int moveDisk;
   private int moveTower;
   private static int n;
   private BufferedImage OSC;   // The off-screen canvas.  Frames are drawn here, then copied to the screen.

   public static int status;   // Controls the execution of the thread; value is one of the following constants.
   
   public static final int GO = 0;       // a value for status, meaning thread is to run continuously   
   public static final int PAUSE = 1;    // a value for status, meaning thread should not run
   public static final int STEP = 2;     // a value for status, meaning thread should run one step then pause
   public static final int RESTART = 3;  // a value for status, meaning thread should start again from the beginning

   private Display display; 
   private static Color BACKGROUND_COLOR = new Color(255,255,180); // 4 colors used in drawing.
   private static Color BORDER_COLOR = new Color(100,0,0);
   private static Color DISK_COLOR = new Color(0,0,180);
   private static Color MOVE_DISK_COLOR = new Color(180,180,255);
   
   private JButton runPauseButton;
   private JButton nextStepButton;
   private JButton startOverButton;
   private JButton restartButton;
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
