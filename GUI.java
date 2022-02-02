import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Dimension;

public class GUI extends JFrame {

  private JLabel progressLabel;
  private GibbetLabel gibbetLabel;

  GUI(String prog, JPanel alphabet) {
    JPanel container = new JPanel();
    container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
    add(container);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    gibbetLabel = new GibbetLabel();
    container.add(gibbetLabel);

    progressLabel = new ProgressLabel(prog);
    container.add(progressLabel);

    container.add(alphabet);
    setTitle("Hangman");
    setSize(new Dimension(350, 450));
    setLocationRelativeTo(null);
    setVisible(true);
  }

  void showStatus(int count, String prog){
    progressLabel.setText(prog);
    gibbetLabel.updateGibbetImage(count);
  }

}
