package game;

import javax.swing.JFrame;
import game.frame;

import javax.swing.JOptionPane;

public class First extends javax.swing.JFrame {

   
    public First() {
        initComponents();
    }
    public static void main(String args[])
    {
        First f=new First();
        f.setVisible(true);
    }

   
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        userinput = new javax.swing.JTextField();
        exitbutton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Towers Of Hanoi");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Enter number of disks");

        userinput.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        userinput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userinputActionPerformed(evt);
            }
        });

        exitbutton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        exitbutton.setText("Exit");
        exitbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbuttonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel2.setText("Tower Of Hanoi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(userinput, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(exitbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userinput, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(exitbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static int getVariable()
    {
       return input;
    }
    private void userinputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userinputActionPerformed
        String inputdata=userinput.getText();
        try
        {
            input=Integer.parseInt(inputdata);
            if(input>10)
            {
                JOptionPane.showMessageDialog(userinput,"Large Number Enter a number less than or equal to 10","Error",JOptionPane.ERROR_MESSAGE); 
                
            }
            else{
               
       frame.main(new String[0]);
      
       
        }
        }
        catch(NumberFormatException e)
                {
                   JOptionPane.showMessageDialog(userinput,"Invalid Number","Error",JOptionPane.ERROR_MESSAGE); 
                   
                }
    }//GEN-LAST:event_userinputActionPerformed

    private void exitbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbuttonActionPerformed
       System.exit(0);
    }//GEN-LAST:event_exitbuttonActionPerformed

    
  
    private static int input;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField userinput;
    // End of variables declaration//GEN-END:variables
}
