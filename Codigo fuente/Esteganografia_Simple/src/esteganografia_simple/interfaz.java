package esteganografia_simple;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
/**
 * @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
public class interfaz extends javax.swing.JFrame {
    BufferedImage foto;
    paint mipaint = new paint();
    Esteganos esteganos = new Esteganos();

    /** Creates new form interfaz */
    public interfaz() {
       initComponents();
       this.setTitle("Esteganografia Básica - by Mouse");
       //se añade el componente mipaint
       this.setLocationRelativeTo(null);
       jPanel1.add(mipaint);
       mipaint.updateUI();
       this.cmdGuardarImagen.setEnabled(false);
       this.cmdOcultarMensaje.setEnabled(false);
       this.cmdVerMensaje.setEnabled(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cmdAbrirImagen = new javax.swing.JButton();
        cmdOcultarMensaje = new javax.swing.JButton();
        cmdGuardarImagen = new javax.swing.JButton();
        cmdVerMensaje = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtMensaje = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.setLayout(new java.awt.GridLayout(4, 1, 10, 10));

        cmdAbrirImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/folder_picture.png"))); // NOI18N
        cmdAbrirImagen.setText("Abrir Imagen");
        cmdAbrirImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAbrirImagenActionPerformed(evt);
            }
        });
        jPanel2.add(cmdAbrirImagen);

        cmdOcultarMensaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/key1.png"))); // NOI18N
        cmdOcultarMensaje.setText("Ocultar Mensaje");
        cmdOcultarMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdOcultarMensajeActionPerformed(evt);
            }
        });
        jPanel2.add(cmdOcultarMensaje);

        cmdGuardarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/picture_save.png"))); // NOI18N
        cmdGuardarImagen.setText("Guardar Imagen");
        cmdGuardarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGuardarImagenActionPerformed(evt);
            }
        });
        jPanel2.add(cmdGuardarImagen);

        cmdVerMensaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/lock_open.png"))); // NOI18N
        cmdVerMensaje.setText("Ver Mensaje");
        cmdVerMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdVerMensajeActionPerformed(evt);
            }
        });
        jPanel2.add(cmdVerMensaje);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("   Mensaje Oculto   "));

        jtMensaje.setColumns(20);
        jtMensaje.setRows(5);
        jScrollPane2.setViewportView(jtMensaje);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdAbrirImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAbrirImagenActionPerformed
      if( mipaint.Abrir_Imagen() ){        
        this.cmdOcultarMensaje.setEnabled(true);
        this.cmdVerMensaje.setEnabled(true);
        this.jtMensaje.setText("");
        jPanel1.setPreferredSize(mipaint.getTamanio());
        mipaint.updateUI();
       }
    }//GEN-LAST:event_cmdAbrirImagenActionPerformed

    private void cmdOcultarMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOcultarMensajeActionPerformed
        //oculta el mensaje en la imagen
        esteganos.OcultarMensaje( mipaint.getFoto(),jtMensaje.getText() );        
        //vuelve a pintar la imagen en pantalla
        mipaint.setFoto( esteganos.getFoto()  );
        //deshabilita el boton
        cmdOcultarMensaje.setEnabled(false);
        cmdGuardarImagen.setEnabled(true);
        JOptionPane.showMessageDialog(null, "El mensaje se oculto en la imagen");
    }//GEN-LAST:event_cmdOcultarMensajeActionPerformed

    private void cmdGuardarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGuardarImagenActionPerformed
        mipaint.guardar_imagen( esteganos.getFoto() );
        cmdGuardarImagen.setEnabled(false);
    }//GEN-LAST:event_cmdGuardarImagenActionPerformed

    private void cmdVerMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdVerMensajeActionPerformed
        this.jtMensaje.setText("");
        this.jtMensaje.setText( esteganos.getMensajeToImage( mipaint.getFoto() ) );
    }//GEN-LAST:event_cmdVerMensajeActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAbrirImagen;
    private javax.swing.JButton cmdGuardarImagen;
    private javax.swing.JButton cmdOcultarMensaje;
    private javax.swing.JButton cmdVerMensaje;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jtMensaje;
    // End of variables declaration//GEN-END:variables

}
