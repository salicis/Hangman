import javax.swing.JPanel;
import javax.swing.JButton;

class Alphabet extends JPanel{

  Alphabet(Game game){

    for(char c = 'A'; c <= 'Z'; ++c){
      JButton button = new JButton(Character.toString(c));
      button.addActionListener(e -> {
        game.recordGuess(e.getActionCommand().charAt(0));
        button.setEnabled(false);
      });
      add(button);
    }
  }
}
