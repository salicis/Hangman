import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.util.List;

class TopicDialogue {

  private String topic;

  String ShowTopicDialogue(List<String> categoryNames){
    String[] categories = categoryNames.toArray(new String[0]);
    topic = categories[0];
    JComboBox<String> jComboBox = new JComboBox<>(categories);
    jComboBox.addActionListener(e -> topic = (String) jComboBox.getSelectedItem());
    JOptionPane.showMessageDialog(null, jComboBox, "Choose a topic", JOptionPane.PLAIN_MESSAGE);
    return topic;
  }

}
