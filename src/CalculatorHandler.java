
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
public class CalculatorHandler implements ActionListener{
    GUI refg;
    NumHandler nmHnd;
    OperationHandler opHnd;
    String[] nums = {"1","2","3","4","5","6","7","8","9","0",".","+/-"};

    public CalculatorHandler(GUI g) {
        refg = g;
        nmHnd = new NumHandler(g);
        opHnd = new OperationHandler(g);
    }
    
    public boolean isNum(ActionEvent ae)
    {
        for(int i = 0; i <nums.length;i++)
        {
            if(ae.getActionCommand().equals(nums[i]))
            {
                return true;
            }
        }
        return false;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(isNum(ae))
        {
            nmHnd.actionPerformed(ae);
        }
        else
        {
            opHnd.actionPerformed(ae);
        }
    }
}
