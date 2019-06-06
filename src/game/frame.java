
package game;
public class frame extends javax.swing.JFrame {

   
    public frame() {
        initComponents();
        
      
    }

    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        towersOfHanoi1 = new game.TowersOfHanoi();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Towers Of Hanoi");
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(towersOfHanoi1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(towersOfHanoi1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              new frame().setVisible(true);
                
            }
        });
    }
 
      
      
   
      
    

    
    public static game.TowersOfHanoi GO;
    public static game.TowersOfHanoi PAUSE;
    public static game.TowersOfHanoi STEP;
    public static game.TowersOfHanoi RESTART;         

    /**
     *
     */
    public static game.TowersOfHanoi status;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private game.TowersOfHanoi towersOfHanoi1;
    // End of variables declaration//GEN-END:variables

}
