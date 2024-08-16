package Interfaz.Customer;

import javax.swing.ImageIcon;

import Interfaz.CDIAStyle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CDLabelLink extends CDLabel implements MouseListener{
    CDLabelLink(String text){
        super(text);
        setPersonalizacion();
    }

    CDLabelLink(String text, String iconCD){
        super(text);
        setPersonalizacion();
        setIcon(new ImageIcon(iconCD));
    }
    
    void setPersonalizacion(){
        addMouseListener(this);
        setOpaque(true);
        setForeground(CDIAStyle.CDCOLOR_FONT);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setCursor(CDIAStyle.CDCURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setCursor(CDIAStyle.CDCURSOR_DEFAULT);
    }
}
