
package gui;

import Business.PersonBusiness;
import Domain.Person;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdom.JDOMException;

/**
 *
 * @author Marco
 */
public class Show extends javax.swing.JFrame {

    private DefaultTableModel modeloDeMiJTable;
        private JTable jTable;

    public Show() {
        initComponents();
        setLocationRelativeTo(null);
        this.jTable = new JTable();
        this.modeloDeMiJTable = new DefaultTableModel();
        this.modeloDeMiJTable.addColumn("Cédula");
        this.modeloDeMiJTable.addColumn("Nomnbe");
        this.modeloDeMiJTable.addColumn("Primer Apellido");
        this.modeloDeMiJTable.addColumn("Segundo Apellido");
        this.modeloDeMiJTable.addColumn("Edad");
        this.modeloDeMiJTable.addColumn("Nacionalidad");
        this.modeloDeMiJTable.addColumn("Cédula del padre");

        this.jTable.setBounds(10, 20, 800, 300);

        Object[] line = new Object[7];
        line[0] = "Id";
        line[1] = "Name";
        line[2] = "First Surname";
        line[3] = "Second Surname";
        line[4] = "Age";
        line[5] = "Nationality";
        line[6] = "Father Id";
        this.modeloDeMiJTable.addRow(line);
        this.jTable.setModel(this.modeloDeMiJTable);
        this.add(this.jTable);

    }
       private void showAll() {

        try {
            PersonBusiness pBusiness = new PersonBusiness("Persona.xml");
            Person person[] = pBusiness.getPerson();
            for (int i = 0; i < person.length; i++) {
                Object[] linea = new Object[7];
                linea[0] = person[i].getId();
                linea[1] = person[i].getName();
                linea[2] = person[i].getFirstSurname();
                linea[3] = person[i].getSecondSurname();
                linea[4] = person[i].getBirthdate();
                linea[5] = person[i].getCountry();
                linea[6] = person[i].getFatherId();

                this.modeloDeMiJTable.addRow(linea);

            }//Fin del for i que recorre todos las personas insertadas.
        } catch (JDOMException ex) {
        } catch (IOException ex) {
        }//Fin del try-catch-catch.
    }//Si no se escribió nada dentro del campo de texto, no se hará nada.

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Show");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(843, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(309, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
showAll();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Show().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
