
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class GUI {
    JFrame fr;
    TextPanelInterface txt;
    BtnPanelInterface btn;
    
    public GUI()
    {
        initGUI();
    }
    
    public void initGUI()
    {
        fr = new JFrame("Calculator");
        txt = new TextPanelInterface(this);
        btn = new BtnPanelInterface(this);
        
        fr.setLayout(new BorderLayout());
        
        fr.add(txt.textPnl,BorderLayout.NORTH);
        fr.add(btn.btnPnl,BorderLayout.CENTER);
        
        fr.pack();
        fr.setMinimumSize(new Dimension(600, 700));
        fr.setLocationRelativeTo(null);
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
    }
}
