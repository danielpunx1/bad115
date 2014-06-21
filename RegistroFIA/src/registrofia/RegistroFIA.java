/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package registrofia;

import Views.InicioSesion;
import com.alee.laf.WebLookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author anderson
 */
public class RegistroFIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            WebLookAndFeel.setDecorateAllWindows(true);
            UIManager.setLookAndFeel(new WebLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        }
        
        InicioSesion ini = new InicioSesion();
        ini.setLocationRelativeTo(null);
        ini.setVisible(true);
    }
}
