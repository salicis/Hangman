import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;

public class ProgressLabel extends JLabel {

    ProgressLabel(String prog){
        setText(prog);
        setFont(new Font("Monospaced", Font.PLAIN, 20));
        setAlignmentX(Component.CENTER_ALIGNMENT);
    }
}
