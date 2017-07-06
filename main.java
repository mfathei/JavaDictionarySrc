
import java.util.Locale;
import org.sqlite.data.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class main {
    
    public static void main(String[] args) {
       
       Locale.setDefault(new Locale("ar","EG"));
       System.setProperty("file.encoding","windows-1256");

        Dict mas=new Dict();
        mas.setLocationRelativeTo(null);
        mas.setVisible(true);
    }
}
