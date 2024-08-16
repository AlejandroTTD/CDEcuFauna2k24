package Interfaz.Form;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import Interfaz.CDIAStyle;

public class CDMainForm extends JFrame{
    CDCedNomPanel CDCedNom = new CDCedNomPanel();
    CDPanelCentral CDCentral = new CDPanelCentral();

    public CDMainForm(String tilteApp){
        customizeComponent(tilteApp);
    }

    private void customizeComponent(String tilteApp) {

        setTitle(tilteApp);
        setSize(610, 570);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(CDIAStyle.CDCOLOR_FONDO);

        Container CDcontainer = getContentPane();
        CDcontainer.setLayout(new BorderLayout());

        // Agregar los paneles al contenedor
        CDcontainer.add(CDCedNom, BorderLayout.NORTH);
        CDcontainer.add(CDCentral, BorderLayout.CENTER);
        setVisible(true);
    }

}
