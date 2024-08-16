package Interfaz.Customer;

import javax.swing.*;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import Interfaz.CDIAStyle;

public class CDTextBox extends JTextField{

    public CDTextBox() {
        customizeComponent();
    }

    private void customizeComponent() {
        setBorderRect();
        setBackground(CDIAStyle.CDCOLOR_FONDO2);
        setFont(CDIAStyle.CDFONT_SMALL);  
        setForeground(CDIAStyle.CDCOLOR_FONT_LIGHT);  
        setCaretColor(CDIAStyle.CDCOLOR_CURSOR); 
        setMargin(new Insets(10, 10, 10, 10));    
        setOpaque(true);                     
    }

    public void setBorderRect() {
        Border lineBorder = BorderFactory.createLineBorder(CDIAStyle.CDCOLOR_BORDER);
        Border emptyBorder = new EmptyBorder(5, 10, 5, 10);  // Márgenes internos
        setBorder( new CompoundBorder(lineBorder, emptyBorder));
    }

    public void setBorderLine(){
        int thickness = 1;
        setBorder(  BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(0, 0, thickness, 0),
                    BorderFactory.createMatteBorder(0, 0, thickness, 0, CDIAStyle.CDCOLOR_BORDER) 
        ));
    }
}
