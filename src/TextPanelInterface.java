
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class TextPanelInterface {
    GUI refg;
    JPanel textPnl;
    JTextField maintxt,sectxt;
    
    public TextPanelInterface(GUI g) {
        refg = g;
        initPnl();
    }
    
    public void initPnl()
    {
        textPnl = new JPanel();
        maintxt = new JTextField(20);
        sectxt = new JTextField(30);
        
        textPnl.setLayout(new GridLayout(2,1));      
        
        textPnl.add(sectxt);
        textPnl.add(maintxt);
        
        textPnl.setPreferredSize(new Dimension(600,200));
        
        maintxt.setFont(new Font("SansSerif", Font.BOLD, 35));      // increasing font size
        maintxt.setHorizontalAlignment(SwingConstants.RIGHT);       // right align
        maintxt.setBorder(null);
        maintxt.setEditable(false);                                 // bcz we cannot type
        
       // maintxt.setText("0");           //default text
        
        sectxt.setFont(new Font("SansSerif", Font.PLAIN, 25));
        sectxt.setHorizontalAlignment(SwingConstants.RIGHT);
        sectxt.setBorder(null);
        sectxt.setEditable(false);
    }
    
}
