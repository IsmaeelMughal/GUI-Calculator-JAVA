
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class BtnPanelInterface {
    GUI refg;
    JPanel btnPnl;
    String[] btnNames = {   "%", "CE", "C", "BACK",
                            "1/x", "SQR", "SQRT", "/",
                            "7", "8", "9", "*",
                            "4", "5", "6", "-",
                            "1", "2", "3", "+",
                            "+/-", "0", ".", "=" };
    JButton[][] btns; 
    CalculatorHandler calHnd;
    
    public BtnPanelInterface(GUI g) {
        refg = g;
        initPanel();
    }
    
    public void initPanel()
    {
        calHnd = new CalculatorHandler(refg);
        btnPnl = new JPanel();
        btns = new JButton[6][4];
        
        btnPnl.setLayout(new GridLayout(6, 4));
        
        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 4;j++)
            {
                btns[i][j] = new JButton(btnNames[(i*4)+j]);
                btnPnl.add(btns[i][j]);
                btns[i][j].setFont(new Font("SansSarif", Font.BOLD, 20));
                btns[i][j].setFocusable(false);
                
                if(i==0 || i == 1 || j == 3)
                {
                    btns[i][j].setBackground(java.awt.Color.LIGHT_GRAY);
                }
                else
                {
                    btns[i][j].setBackground(java.awt.Color.white);
                }
                if(i == 5 && j == 3)
                {
                    btns[i][j].setBackground(java.awt.Color.PINK);
                }
                btns[i][j].addActionListener(calHnd);
            }
        }
        btnPnl.setPreferredSize(new Dimension(600, 500));
    }
}
