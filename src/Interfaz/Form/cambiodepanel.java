package Interfaz.Form;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import Interfaz.CDIAStyle;

public abstract class cambiodepanel {
    private static JFrame       CDfrmSplash;
    private static JProgressBar CDprbLoaging;
    private static ImageIcon    CDicoImagen ;
    private static JLabel       CDlblSplash ;

    public static void show() {
        CDicoImagen  = new ImageIcon(CDIAStyle.CDURL_MAIN);
        CDlblSplash  = new JLabel(CDicoImagen);
        CDprbLoaging = new JProgressBar(0, 99);

        CDprbLoaging.setStringPainted(true);
        
        CDfrmSplash = new JFrame();
        CDfrmSplash.setUndecorated(true);
        CDfrmSplash.getContentPane().add(CDlblSplash, BorderLayout.CENTER);
        CDfrmSplash.add(CDprbLoaging, BorderLayout.SOUTH);
        CDfrmSplash.setSize(CDicoImagen.getIconWidth(), CDicoImagen.getIconHeight());
        CDfrmSplash.setLocationRelativeTo(null);

        CDfrmSplash.setVisible(true);
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(10); // Espera por 10 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CDprbLoaging.setValue(i);
        }
        CDfrmSplash.setVisible(false);
    }
}
