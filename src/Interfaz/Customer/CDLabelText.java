package Interfaz.Customer;

import javax.swing.*;

import Interfaz.CDIAStyle;

import java.awt.*;

public class CDLabelText extends JPanel{
    private CDLabel    lblEtiq = new CDLabel();
    private CDTextBox  txtCont= new CDTextBox();

    public CDLabelText(String etiqueta) {
        setLayout(new BorderLayout());
        lblEtiq.setCustomizeComponent(  etiqueta, 
                                            CDIAStyle.CDFONT_BOLD, 
                                            CDIAStyle.CDCOLOR_FONT_DARK,
                                            CDIAStyle.CDALIGNMENT_CENTER); 
        txtCont.setBorderLine();
        add(lblEtiq, BorderLayout.NORTH);
        add(txtCont, BorderLayout.CENTER);
    }
}
