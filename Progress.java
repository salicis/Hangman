public class Progress {

  private static final String placeHolder = "*";
  private final char[] progress;
  private int wrongGuessCount =0;
  private final String targetWord;
  private final int MAX_BAD_GUESSES = 11;

  Progress(String targetWord){
    this.targetWord=targetWord;
    String progressString = targetWord.replaceAll("[A-Z]", placeHolder);
    progress = progressString.toCharArray();
  }

  String getProgress(){
        return new String(progress);
    }

  String getTargetWord(){
        return targetWord;
    }

  boolean playerWins(){
        return !new String(progress).contains(placeHolder);
    }

  boolean playerLooses(){
        return (wrongGuessCount > MAX_BAD_GUESSES);
    }

  int getNumberOfWrongGuesses(){
        return wrongGuessCount;
    }

  void updateProgress(char guess) {
    if (isGoodGuess(guess)) {
      for (int n = 0; n < targetWord.length(); n++) {
        if (targetWord.charAt(n) == guess) {
          progress[n] = guess;
        }
      }
    } else {
      wrongGuessCount++;
    }
}
  boolean isGoodGuess(char guess){
        return targetWord.contains(Character.toString(guess));
    }
}
