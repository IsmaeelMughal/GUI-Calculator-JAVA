
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class NumHandler implements ActionListener{
    GUI refg;
    String mainStr;
    String secStr;
    
    public NumHandler(GUI g)
    {
        refg = g;        
    }
    
    public void NumbtnAction(ActionEvent ae)
    {
        mainStr =refg.txt.maintxt.getText();
        
        if(mainStr.indexOf("0") == 0 && mainStr.length() == 1 && !ae.getActionCommand().equals("."))
        {
            refg.txt.maintxt.setText(ae.getActionCommand());
        }
        else if(refg.txt.maintxt.getText().length() <= 15)
        {
            mainStr =refg.txt.maintxt.getText();
            refg.txt.maintxt.setText(mainStr + ae.getActionCommand());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        mainStr =refg.txt.maintxt.getText();
        if(mainStr.contains("Invalid Input") || mainStr.contains("Cannot divide by zero"))
        {}
        else{
            if(ae.getActionCommand().equals("9") || ae.getActionCommand().equals("8") ||
               ae.getActionCommand().equals("7") || ae.getActionCommand().equals("6") ||
               ae.getActionCommand().equals("5") || ae.getActionCommand().equals("4") ||
               ae.getActionCommand().equals("3") || ae.getActionCommand().equals("2") || 
               ae.getActionCommand().equals("1") || ae.getActionCommand().equals("0") )
            {
                if(mainStr.equals("0") && ae.getActionCommand().equals("0"))
                {}
                else
                {
                    NumbtnAction(ae);
                }
            }
            else if(ae.getActionCommand().equals("."))
            {
                mainStr =refg.txt.maintxt.getText();
                if(mainStr.isEmpty())
                {
                    refg.txt.maintxt.setText("0"+ae.getActionCommand());
                }
                else if(mainStr.indexOf('.') == -1)
                {
                    NumbtnAction(ae);
                }
            }
            else if(ae.getActionCommand().equals("+/-"))
            {
                mainStr =refg.txt.maintxt.getText();
                if(mainStr.isEmpty())
                {}
                else
                {
                    if(Double.parseDouble(mainStr) == 0 || refg.txt.sectxt.getText().contains("="))
                    {}
                    else
                    {
                        refg.txt.maintxt.setText(String.valueOf(Double.parseDouble(mainStr)*-1));
                    }
                }
                
            }
        }
    }  
}
