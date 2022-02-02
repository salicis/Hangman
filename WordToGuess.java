import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class WordToGuess {

  private static final int MAX_WORD_LENGTH = 20;
  private static final int MIN_WORD_LENGTH = 3;

  private final String word;

  private final Predicate<String> wordLengthPredicate =
      s -> s.length() <= MAX_WORD_LENGTH && s.length() >= MIN_WORD_LENGTH;

  WordToGuess() {
    List<String> candidateWords = getCandidateWords();
    int randomIndex = new Random().nextInt(candidateWords.size());
    word = candidateWords.get(randomIndex);
  }

  String getWordToGuess() {
    return word;
  }

  private List<String> getCandidateWords() {
    List<String> candidateWords = defaultWords();
    try {
      String topic = new TopicProvider().getTopic();
      candidateWords = getWordsInTopic(topic);
    }catch(NoWordsListsException e){
      ErrorReporter.missingFiles();
    }catch (TopicWordsMissingException e){
      ErrorReporter.missingWords();
    } catch (WordListDirectoryMissingException e) {
      ErrorReporter.missingDirectory();
    }
    return candidateWords;
  }

  private List<String> getWordsInTopic(String topic) throws TopicWordsMissingException {
    List<String> candidateWords;
    try {
      Path path = Paths.get(Constants.WORD_LIST_DIRECTORY +topic);
      Stream<String> stream = Files.lines(path);
      candidateWords = stream.map(String::toUpperCase)
                    .filter(wordLengthPredicate)
                    .collect(toList());
      if (candidateWords.size() < 1) {
        throw new TopicWordsMissingException("The file for that topic contained no words");
      }
    } catch (IOException e) {
      throw new TopicWordsMissingException("The file for that topic was missing");
    }
    return candidateWords;
  }

  private static List<String> defaultWords(){
    return List.of("FOXGLOVE", "MICROWAVE","ZOMBIE","PUPPY","RHUBARB","DWARF","BICYCLE",
                   "BUZZARD","OWL","CHAFFINCH","KIRIBATI","LIECHTENSTEIN","MOZAMBIQUE");
  }
}
