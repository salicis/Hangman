import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

class TopicProvider {

  String getTopic() throws NoWordsListsException, WordListDirectoryMissingException {
    List<String> categories = getTopics();
    return getPlayerChoice(categories);
  }

  private List<String> getTopics() throws NoWordsListsException, WordListDirectoryMissingException {
    Path path = Paths.get(Constants.WORD_LIST_DIRECTORY);
    List<String> topics;
    try {
      Stream<Path> stream = Files.list(path);
      topics = stream.filter(Files::isRegularFile)
                         .map(toTopic)
                         .collect(toList());
      if (topics.size() < 1) {
        throw new NoWordsListsException("Word lists missing");
      }
    } catch (IOException e) {
      throw new WordListDirectoryMissingException("Word lists directory missing");
    }
    return topics;
  }

  private final Function<Path, String> toTopic = path -> path.getFileName().toString();

  private String getPlayerChoice(List<String> Topics){
    return new TopicDialogue().ShowTopicDialogue(Topics);
  }
}
