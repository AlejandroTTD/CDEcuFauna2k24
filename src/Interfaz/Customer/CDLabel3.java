package Interfaz.Customer;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import Interfaz.CDIAStyle;

public class CDLabel3 extends JLabel {
    public CDLabel3(){
        customizeComponent();
    }
    public CDLabel3(String text){
        setText(text);
        customizeComponent();
    }
    private void customizeComponent(){
        setCustomizeComponent(getText(), CDIAStyle.CDFONT_BOLD2, CDIAStyle.CDCOLOR_FONT_DARK, CDIAStyle.CDALIGNMENT_LEFT);
    }
    public void setCustomizeComponent(String text, Font  font, Color color, int alignment) {
        setText(text);
        setFont(font);
        setOpaque(false);
        setBackground(null);
        setForeground(color);
        setHorizontalAlignment(alignment);
    }
    public void setCustomizeComponent(String etiqueta, Font cdfontBold, Color cdcolorFontLight, Color cdcolorFondo2,
            int cdalignmentCenter) {
        throw new UnsupportedOperationException("Unimplemented method 'setCustomizeComponent'");
    }
}