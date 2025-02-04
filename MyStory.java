import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene {

  // Instance Variables
  private String[][] favImages;
  private String[][] favNames;
  private String[][] leastFavImages;
  private String[][] leastFavNames;

  // Constructor
  public MyStory(String[][] favImages, String[][] favNames, String[][] leastFavImages, String[][] leastFavNames) {
    this.favImages = favImages;
    this.favNames = favNames;
    this.leastFavImages = leastFavImages;
    this.leastFavNames = leastFavNames;
  }

  // Main drawScene method
  public void drawScene() {
    // Plays music
    playSound("Geosenge-Town.wav");

    // Calls the drawFavScene() method
    drawFavScene();

    pause(1.0);

    // Calls the drawNotFavScene() method
    drawNotFavScene();

    pause(1.0);

    // Clears screen
    clear("white");

    // Sets text color, height, and style
    setTextHeight(60);
    setTextColor("black");
    setTextStyle(Font.MONO, FontStyle.BOLD);

    // Draws ending text
    drawText("The End", 90, 200);
  }

  // Other Methods

  /*
   * Draws the Favorite Pokemon Scene
   */
  public void drawFavScene() {

    // Creates an ImageFilter object
    ImageFilter pokeball = new ImageFilter("pokeball.jpg");

    // Draws the ImageFilter object
    drawImage(pokeball, 0, 0, pokeball.getWidth());

    // Sets the text height and style
    setTextHeight(40);
    setTextStyle(Font.MONO, FontStyle.BOLD);

    // Draws text
    drawText("My Fave", 110, 100);
    drawText("Pokemon", 115, 320);
    
    pause(1.5);
    clear("white");

    // Traverses the 2D array favImages
    for (int row = 0; row < favImages.length; row++) {
      for (int col = 0; col < favImages[0].length; col++) {

        // Calls the chooseBGColor() method
        chooseBGColor(favImages, row, col);

        // Sets the text height and color
        setTextHeight(60);
        setTextColor("white");

        // Draws the Pokemon name
        drawText(favNames[row][col], 80, 200);
        pause(1.0);
        clear("white");

        // Creates and draws an ImageFilter object
        ImageFilter image = new ImageFilter(favImages[row][col]);
        drawImage(image, 0, 0, 400);
        pause(1.0);

        // Creates and draws an ImageFilter object
        ImageFilter imageFilter = new ImageFilter(favImages[row][col]);
        // Applies an image filter
        imageFilter.zeroGreen();
        drawImage(imageFilter, 0, 0, 400);
        pause(1.0);
      }
    }
  }

  /*
   * Draws the Least Favorite Pokemon Scene
   */
  public void drawNotFavScene() {

    // Creates and draws an ImageFilter object
    ImageFilter pokeball = new ImageFilter("pokeball.jpg");
    drawImage(pokeball, 0, 0, pokeball.getWidth());
    
    pause(1.0);

    // Applies an image filter
    pokeball.makeNegative();

    // Draws another ImageFilter object
    drawImage(pokeball, 0, 0, pokeball.getWidth());

    // Sets the text height, color, and style
    setTextHeight(40);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD);

    // Draws text
    drawText("Least Fave", 86, 100);
    drawText("Pokemon", 115, 320);

    pause(1.5);
    clear("white");

    // Traverses the leastFavImages 2D array
    for (int row = 0; row < leastFavImages.length; row++) {
      for (int col = 0; col < leastFavImages[0].length; col++) {

        // Calls the chooseBGColor() method
        chooseBGColor(leastFavImages, row, col);

        // Sets the text height and color
        setTextHeight(50);
        setTextColor("white");

        // Draws the Pokemon's name
        drawText(leastFavNames[row][col], 70, 200);
        
        pause(1.0);
        clear("white");

        // Creates and draws an ImageFilter object
        ImageFilter image = new ImageFilter(leastFavImages[row][col]);
        drawImage(image, 0, 0, 400);
        pause(1.0);

        // Creates and draws an ImageFilter object
        ImageFilter imageFilter = new ImageFilter(leastFavImages[row][col]);
        // Applies an image filter
        imageFilter.saturate(10);
        drawImage(imageFilter, 0, 0, 400);
        pause(1.0);
      }
    }
  }

  /*
   * Clears the screen with different 
   * colors depending on the Pokemon type
   */
  public void chooseBGColor(String[][] text, int row, int col) {
    if (text[row][col].indexOf("fairy") != -1) {
      clear("pink");
    } else if (text[row][col].indexOf("dark") != -1) {
      clear("black");
    } else if (text[row][col].indexOf("ghost") != -1) {
      clear("purple");
    } else if (text[row][col].indexOf("water") != -1) {
      clear("blue");
    } else if (text[row][col].indexOf("normal") != -1) {
      clear("silver");
    } else if (text[row][col].indexOf("electric") != -1) {
      clear("gold");
    } else {
      clear("white");
    }
  } 
  
  
}