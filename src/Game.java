import javax.swing.JPanel;
import javax.swing.JOptionPane;

class Game {

  private Progress progress;
  private GUI gui;

  Game() {
    String targetWord = new WordToGuess().getWordToGuess();
    progress = new Progress(targetWord);
    JPanel alphabet = new Alphabet(this);
    gui = new GUI(progress.getProgress(),alphabet);
    gui.setVisible(true);
  }

  void recordGuess(char letter) {
    progress.updateProgress(letter);
    gui.showStatus(progress.getNumberOfWrongGuesses(), progress.getProgress());
    if (progress.playerWins()) {
      displayEndGameMessage("Well done, it was "+progress.getTargetWord()+", another game?");
    }
    if (progress.playerLooses()) {
      displayEndGameMessage("Bad luck, it was "+progress.getTargetWord()+", another game?");
    }
  }

 void displayEndGameMessage(String message){
   int reply = JOptionPane.showConfirmDialog(gui, message, "end", JOptionPane.YES_NO_OPTION);
   if (reply == JOptionPane.YES_OPTION) {
     GUI oldGUI = gui;
     new Game();
     oldGUI.dispose();
   } else {
     System.exit(0);
   }

 }

}


