package Interfaz.Form;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Interfaz.CDIAStyle;
import Interfaz.Customer.CDLabel;
import Interfaz.Customer.CDLabelText;

public class CDCedNomPanel extends JPanel{

    public CDCedNomPanel(){
        customizeComponent();
        setBorder(BorderFactory.createEmptyBorder(7, 150, 7, 60));
        setLayout(new GridLayout(2, 2, 0, 10));

        CDLabelText CDCedula = new CDLabelText("172740951-6");
        CDLabelText CDNombre = new CDLabelText("Cuasquer David");

        add(new CDLabel("Cédula:"));
        add(CDCedula);
        add(new CDLabel("Nombres:"));
        add(CDNombre);

    }
    private void customizeComponent() {
        setBackground(CDIAStyle.CDCOLOR_FONDO);
        setPreferredSize(new Dimension(40, 60));
        setAlignmentX(BOTTOM_ALIGNMENT);
    }

}