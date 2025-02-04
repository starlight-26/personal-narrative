import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    String[][] favs = {
      {"sylveon-fairy.png", "altaria-mega-fairy.png"},
      {"absol-mega-dark.png", "nickit-dark.png"},
      {"mimikyu-ghost.png", "zorua-hisuian-ghost.png"},
    };

    String[][] favNames = {
      {"Sylveon", "Altaria"},
      {"Absol", "Nickit"},
      {"Mimikyu", "Zorua"},
    };

    String[][] leastFavs = {
      {"dracovish-water.png", "bruzish-water.png"},
      {"diggersby-normal.png", "exploud-normal.png"},
      {"arctozolt-electric.png", "raging-bolt-electric.png"},
    };

    String[][] leastFavNames = {
      {"Dracovish", "Bruzish"},
      {"Diggersby", "Exploud"},
      {"Arctozolt", "Raging Bolt"},
    };

    // Creates a MyStory object
    MyStory scene = new MyStory(favs, favNames, leastFavs, leastFavNames);

    // Main DrawScene call
    scene.drawScene();

    // Play the scene in the Theater
    Theater.playScenes(scene);

    
  }
}