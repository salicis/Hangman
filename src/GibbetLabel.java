import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class GibbetLabel extends JLabel {
    private static final int IMAGE_COUNT = 13;
    private ArrayList<File> gibbetImages = new ArrayList<>();

    GibbetLabel() {
        for (int i = 0; i < IMAGE_COUNT; i++) {
            try {
                gibbetImages.add(new File("images/" + i + ".png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        setIcon(new ImageIcon(String.valueOf(gibbetImages.get(0))));
        setAlignmentX(Component.CENTER_ALIGNMENT);
    }
    void updateGibbetImage(int count){
        setIcon(new ImageIcon(String.valueOf(gibbetImages.get(count))));
    }
}
