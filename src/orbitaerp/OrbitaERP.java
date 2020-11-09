/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package orbitaerp;


import com.sun.awt.AWTUtilities;
import java.awt.Image;
import java.awt.Window;
import java.io.File;
import java.lang.reflect.Method;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import GUI.Login;

/**
 *
 * @author halda
 */
public class OrbitaERP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String dir = System.getProperty("user.dir");
        JFrame welcome = new JFrame ();
        JLabel label = new JLabel();
        Image image;
        Icon icon = new ImageIcon();
        System.out.println(dir);
        
        //Creando imagen de presentacion
        try{
            image = ImageIO.read(new File(dir+"\\src\\Images\\Orbita_Logo.jpg"));
            Image image2 = image.getScaledInstance(1000, 785,  java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(image2);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se encontro imagen de inicio\n","ERROR", JOptionPane.ERROR_MESSAGE);
        }
       
        //Seteando imagen de presentacion y mostrando el Frame
        label.setIcon(icon);
        welcome.setUndecorated(true);
        welcome.add (label);
        welcome.setSize (1000,785);
        welcome.setLocationRelativeTo ( null );
        welcome.setVisible ( true );
        
        //Ejecutando efecto de opacidad
        for(int i =100; i>0; i--){
            setOpaque(welcome, i/100f);
            try{
                Thread.sleep(20);
            }catch(Exception e){

            }
        }
        welcome.setVisible(false);
        
        //Mostrando el login
        Login login = new Login();
        login.setLocationRelativeTo(null);
        login.setTitle("Orbita - Login");
        login.setVisible(true);
        

        
    }
    
    public static void setOpaque(Window window, float opaque) {
        try {
            Class<?> awtUtilsClass = Class.forName("com.sun.awt.AWTUtilities");
            if (awtUtilsClass != null) {
                Method method = awtUtilsClass.getMethod("setWindowOpacity", Window.class, float.class);
                method.invoke(null, window, opaque);
            }
        } catch (Exception exp) {
        }
    }
    
}
