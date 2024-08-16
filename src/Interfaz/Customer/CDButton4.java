package Interfaz.Customer;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import Interfaz.CDIAStyle;

import java.awt.event.MouseListener;

public class CDButton4 extends JButton implements MouseListener {
    public CDButton4(String text){
        customizeComponent(text);
    }
    public CDButton4(String text, String iconnew){
        customizeComponent(text, iconnew);
    }

    public void customizeComponent(String text, String iconnew){ 
        
        setSize(20, 70);
        addMouseListener(this);
        customizeComponent(text);
        setBounds(50, 30, 100, 20); 
        
        setIcon(new ImageIcon(iconnew));
        setFont(CDIAStyle.CDFONT);
    }
    public void customizeComponent(String text) {
        setText(text);
        setOpaque(true);
        setFocusPainted(false);
        setBorderPainted(true);
        setContentAreaFilled(true);
        setForeground(CDIAStyle.CDCOLOR_FONT);
        setHorizontalAlignment(CDIAStyle.CDALIGNMENT_CENTER);
        setFont(CDIAStyle.CDFONT);
        setBackground(CDIAStyle.CDCOLOR_FONDO);
        
        setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        setForeground(Color.BLACK);
        setCursor(CDIAStyle.CDCURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setForeground(Color.GRAY);
        setCursor(CDIAStyle.CDCURSOR_DEFAULT);
    }
    
}
