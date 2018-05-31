package gui;

import Business.PersonBusiness;
import Domain.Person;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jdom.JDOMException;

/**
 *
 * @author Marco
 */
public class Insert extends javax.swing.JFrame {

    int e;
    String wa;

    public Insert() {
        super("Insert");
        initComponents();
        this.setLocationRelativeTo(null);

        jtxtFecha.setText("00.00.0000");

        this.jtxtFecha.addFocusListener(new FocusListener() {
            String textoCampo = "";

            @Override
            public void focusGained(FocusEvent e) {
                textoCampo = jtxtFecha.getText();
                jtxtFecha.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jtxtFecha.getText().isEmpty()) {
                    jtxtFecha.setText(textoCampo);
                }
            }
        });

    }

    private void insertPerson() {
        if (!this.jtxtCedula.getText().equals("")
                && !this.jtxtNombre.getText().equals("")
                && !this.jtxtPrimerApellido.getText().equals("")
                && !this.jtxtSegundoApellido.getText().equals("")
                && !this.jtxtFecha.getText().equals("")
                && !this.jtxtPais.getText().equals("")
                && !this.jtxtCedulaPadre.getText().equals("")) {
            String num = jtxtFecha.getText();

            String substring = num.substring(6, 10);
            int anno = 2018;
            e = anno - Integer.parseInt(substring);
            wa = Integer.toString(e);

            try {
                PersonBusiness vBusiness = new PersonBusiness("Persona.xml");
                Person personaAInsertar = new Person(
                        this.jtxtCedula.getText(),
                        this.jtxtNombre.getText(),
                        this.jtxtPrimerApellido.getText(),
                        this.jtxtSegundoApellido.getText(),
                        this.wa,
                        this.jtxtPais.getText(),
                        this.jtxtCedulaPadre.getText()
                );
                Person persona[] = vBusiness.getPerson();

                boolean existe = false;
                for (int i = 0; i < persona.length; i++) {
                    if (persona[i].getName().equalsIgnoreCase(personaAInsertar.getName())) {
                        existe = true;
                    }
                }
                if (existe) {
                    JOptionPane.showMessageDialog(null, "Esta persona ya existe dentro del archivo",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    vBusiness.insertPerson(personaAInsertar);
                    this.jtxtCedula.setText("");
                    this.jtxtNombre.setText("");
                    this.jtxtPrimerApellido.setText("");
                    this.jtxtSegundoApellido.setText("");
                    this.jtxtFecha.setText("");
                    this.jtxtPais.setText("");
                    this.jtxtCedulaPadre.setText("");
                }

                boolean exist = false;
                for (int i = 0; i < persona.length; i++) {
                    if (persona[i].getFatherId().equalsIgnoreCase(personaAInsertar.getFatherId())) {
                        exist = true;
                    }
                    if (exist) {
                    //    JOptionPane.showMessageDialog(null, "Usted es hermano de " + persona[i].getNombre());
                    }
                }
//Si existe, dará un mensaje de error, sino, lo inserta en el XML.
            } catch (JDOMException ex) {
            } catch (IOException ex) {
            }//Fin del try-catch-catch.
        }//Si no se escribió nada dentro del campo de texto, no se hará nada.
    }//Fin del método insertPerson.

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtxtCedula = new javax.swing.JTextField();
        jtxtNombre = new javax.swing.JTextField();
        jtxtPrimerApellido = new javax.swing.JTextField();
        jtxtSegundoApellido = new javax.swing.JTextField();
        jtxtFecha = new javax.swing.JTextField();
        jtxtPais = new javax.swing.JTextField();
        jtxtCedulaPadre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Insert Person");

        jLabel2.setText("Id");

        jLabel3.setText("Name");

        jLabel4.setText("First Surname");

        jLabel5.setText("Second Surname");

        jLabel6.setText("Birthday");

        jLabel7.setText("Country");

        jLabel8.setText("Id Father");

        jButton1.setText("Insert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtxtCedula)
                                .addComponent(jtxtNombre)
                                .addComponent(jtxtPrimerApellido)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(jtxtSegundoApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtxtPais)
                                .addComponent(jtxtCedulaPadre)
                                .addComponent(jtxtFecha, javax.swing.GroupLayout.Alignment.TRAILING))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(213, 213, 213)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtPrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtSegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtCedulaPadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        insertPerson();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Insert().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jtxtCedula;
    private javax.swing.JTextField jtxtCedulaPadre;
    private javax.swing.JTextField jtxtFecha;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtPais;
    private javax.swing.JTextField jtxtPrimerApellido;
    private javax.swing.JTextField jtxtSegundoApellido;
    // End of variables declaration//GEN-END:variables

}
