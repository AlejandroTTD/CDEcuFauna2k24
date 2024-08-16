package Interfaz.Customer;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import Interfaz.CDIAStyle;

public class CDLabel2 extends JLabel {
    public CDLabel2(){
        customizeComponent();
    }
    public CDLabel2(String text){
        setText(text);
        customizeComponent();
    }
    private void customizeComponent(){
        setCustomizeComponent(getText(), CDIAStyle.CDFONT_SMALL, CDIAStyle.CDCOLOR_FONT, CDIAStyle.CDALIGNMENT_RIGHT);
    }
    public void setCustomizeComponent(String text, Font  font, Color color, int alignment) {
        setText(text);
        setFont(font);
        setOpaque(false);
        setBackground(null);
        setForeground(color);
        setHorizontalAlignment(alignment);
    }
}
