
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
public class OperationHandler implements ActionListener{
    GUI refg;
    double num1 = 0;
    double num2 = 0;
    char op;
    String mainStr;
    String secStr;
    String opStr;
    
    public OperationHandler(GUI g) {
        refg = g;
    }
 
    public double performOperation(double num1, double num2, char op)
    {
        switch(op)
        {
            case '+':
                return num1+num2;
            case '-':
                return num1-num2;
            case '*':
                return num1*num2;
            case '/':
            {
                if (num2 == 0)
                {
                    return 0;
                }
                else
                {
                    return num1/num2;
                }
            }
        }
        return 0;
    }
    
    public void opHandel(ActionEvent ae)
    {
        mainStr = refg.txt.maintxt.getText();
        secStr = refg.txt.sectxt.getText();
        if (mainStr.length() == 0 && secStr.length() == 0)
        {}
        else if (secStr.indexOf('=') != -1)
        {
            num1 = Double.parseDouble(mainStr);
            refg.txt.sectxt.setText(mainStr + " " + ae.getActionCommand());
            refg.txt.maintxt.setText("");
        }
        else if(secStr.indexOf('+') == -1 && secStr.indexOf('-') == -1 && 
                secStr.indexOf('*') == -1 && secStr.indexOf('/') == -1)
        {
            mainStr = refg.txt.maintxt.getText();
            refg.txt.sectxt.setText(mainStr + " " + ae.getActionCommand());
            refg.txt.maintxt.setText("");
        }
        else
        {
            if(mainStr.length() == 0)
            {
                refg.txt.sectxt.setText(secStr.substring(0, secStr.length()-1) + " " + ae.getActionCommand());
            }
            else
            {
                num2 = Double.parseDouble(mainStr);
                op = secStr.charAt(secStr.length() - 1);
                num1 = Double.parseDouble(secStr.substring(0, secStr.length()-2));
                num1 = performOperation(num1,num2,op);
                refg.txt.sectxt.setText(String.valueOf(num1) + " " + ae.getActionCommand());
                refg.txt.maintxt.setText("");
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        mainStr =refg.txt.maintxt.getText();
        if (ae.getActionCommand().equals("BACK"))
        {
            
            if(mainStr.contains("Invalid Input") || mainStr.contains("Cannot divide by zero") || mainStr.contains("Infinity"))
            {
                refg.txt.maintxt.setText("");
                refg.txt.sectxt.setText("");
            }
            else if(mainStr.contains("-") && mainStr.length() == 2)
            {
                refg.txt.maintxt.setText("");
            }
            else
            {
                if(mainStr.length() > 0)
                {
                    refg.txt.maintxt.setText(mainStr.substring(0,mainStr.length() - 1));
                }
            }
        }
        else if (ae.getActionCommand().equals("CE"))
        {
            refg.txt.maintxt.setText("");
        }
        else if (ae.getActionCommand().equals("C"))
        {
            refg.txt.maintxt.setText("");
            refg.txt.sectxt.setText("");
            num1 = 0;
            num2 = 0;
        }
        mainStr =refg.txt.maintxt.getText();
        if(mainStr.contains("Invalid Input") || mainStr.contains("Cannot divide by zero"))
        {}
        else{
            if (ae.getActionCommand().equals("1/x"))
            {
                
                if(mainStr.isEmpty())
                {}
                else
                {
                    num1 = Double.parseDouble(mainStr);
                    if(num1 == 0)
                    {
                        refg.txt.maintxt.setText("Cannot divide by zero");
                        refg.txt.sectxt.setText("1/" + mainStr);
                    }
                    else
                    {
                        num1 = 1 / num1;
                        refg.txt.maintxt.setText(String.valueOf(num1));
                    }
                }
            }
            else if (ae.getActionCommand().equals("SQR"))
            {
                
                if(mainStr.isEmpty())
                {}
                else
                {
                    num1 = Double.parseDouble(mainStr);
                    num1 = num1 * num1;
                    refg.txt.maintxt.setText(String.valueOf(num1));
                    refg.txt.sectxt.setText("SQR("+ mainStr + ")");
                }
            }
            else if (ae.getActionCommand().equals("SQRT"))
            {
                
                if(!mainStr.isEmpty())
                {
                    num1 = Double.parseDouble(mainStr);
                    if(num1<0)
                    {
                        refg.txt.maintxt.setText("Invalid Input");
                    }
                    else
                    {
                        num1 = Math.sqrt(num1);
                        refg.txt.maintxt.setText(String.valueOf(num1));
                        refg.txt.sectxt.setText("SQRT("+ mainStr + ")");
                    }
                }
            }
            else if(ae.getActionCommand().equals("/") || 
                    ae.getActionCommand().equals("*") || 
                    ae.getActionCommand().equals("-") || 
                    ae.getActionCommand().equals("+"))
            {
                
                secStr = refg.txt.sectxt.getText();
                if(mainStr.isEmpty() && (secStr.indexOf("/")!=-1 || secStr.indexOf("*")!=-1 ||
                        secStr.indexOf("-")!=-1 || secStr.indexOf("+")!=-1))
                {
                    refg.txt.sectxt.setText(secStr.substring(0, secStr.length()-1) + ae.getActionCommand());
                }
                else
                {
                    opHandel(ae);
                }

            }
            else if (ae.getActionCommand().equals("="))
            {
                
                secStr = refg.txt.sectxt.getText();
                if ((mainStr.length() == 0 && secStr.length() == 0) || mainStr.length() == 0 || secStr.isEmpty())
                {}
                else if(secStr.indexOf('+') == -1 && secStr.indexOf('-') == -1 && 
                        secStr.indexOf('*') == -1 && secStr.indexOf('/') == -1)
                {
                    refg.txt.sectxt.setText(mainStr + " " + ae.getActionCommand());
                    refg.txt.maintxt.setText("");
                }
                else
                {
                    if(secStr.indexOf('/') != -1)
                    {
                        num2 = Double.parseDouble(mainStr);
                        if(num2 == 0)
                        {
                            refg.txt.maintxt.setText("Cannot divide by zero"); 
                        }
                        else
                        {
                            op = secStr.charAt(secStr.length() - 1);
                            num1 = Double.parseDouble(secStr.substring(0, secStr.length()-2));
                            refg.txt.sectxt.setText(String.valueOf(num1) + " " + op + String.valueOf(num2) + " =");
                            num1 = performOperation(num1,num2,op);
                            refg.txt.maintxt.setText(String.valueOf(num1)); 
                        }
                    }
                    else
                    {
                        num2 = Double.parseDouble(mainStr);
                        op = secStr.charAt(secStr.length() - 1);
                        num1 = Double.parseDouble(secStr.substring(0, secStr.length()-2));
                        refg.txt.sectxt.setText(String.valueOf(num1) + " " + op + String.valueOf(num2) + " =");
                        num1 = performOperation(num1,num2,op);
                        refg.txt.maintxt.setText(String.valueOf(num1)); 
                    } 
                }
            }
            else if(ae.getActionCommand().equals("%"))
            {
                
                secStr = refg.txt.sectxt.getText();
                if (!secStr.isEmpty())
                {
                    num2 = Double.parseDouble(mainStr);
                    num1 = Double.parseDouble(secStr.substring(0, secStr.length() - 1));
                    num1 = num1 * (num2/100);
                    refg.txt.maintxt.setText(String.valueOf(num1));
                }
            }   
        }
        
    }
}
