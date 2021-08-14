import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author lance
 *
 */
public class BuiltinLogIntoXML {

	/**
	 * Method main
	 * Abstract TODO
	 * @param args
	 */
	protected static final Logger logger=Logger.getLogger("myLog");
	
	public static void log(Exception ex, String level, String msg){

        FileHandler fh = null;
        try {
            fh = new FileHandler("mylog.xml",true);
            logger.addHandler(fh);
            switch (level) {
                case "severe":
                    logger.log(Level.SEVERE, msg, ex);
                    if(!msg.equals(""))
                        JOptionPane.showMessageDialog(null,msg,
                            "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                case "warning":

                default:
                    logger.log(Level.CONFIG, msg, ex);
                    break;
            }
        } catch (IOException | SecurityException ex1) {
            logger.log(Level.SEVERE, null, ex1);
        } finally{
            if(fh!=null)fh.close();
        }
    }

    public static void main(String[] args) {

        /*
            Create simple frame for the example
        */
        JFrame myFrame = new JFrame();
        myFrame.setTitle("Logging by TG");
        myFrame.setSize(600, 200);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);
        JPanel pnlMsg = new JPanel();
        JButton severe = new JButton("------severe------");
        pnlMsg.add(severe);


        /*
            Create an exception on click to use the BuiltInLoggingToFile class
        */

        });
        severe.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                int intHrs = 80;
                int intWeeks = 0;
                try {
                    System.out.println(intHrs/intWeeks);
                } catch (ArithmeticException ex) {
                    log(ex,"severe","Divide by zero error. Cannot have " + intWeeks + " weeks.");
                }

            }

        });

        warning.addActionListener(new ActionListener(){

            @Override


        });

        info.addActionListener(new ActionListener(){

            @Override


        });

        /*
            Add the JPanel to the JFrame and set the JFrame visible
        */
        myFrame.setContentPane(pnlMsg);
        myFrame.setVisible(true);
    }
}



}
