import org.code.theater.*;
import org.code.media.*;

/* 
* Represents an image that contains multiple filters
*/
public class ImageFilter extends ImagePlus {
  
  /*
  * Calls the superclass constructor to initialize the 2D
  */
  public ImageFilter(String filename) {
    super(filename);
  }

  
  /** IMAGE FILTERS **/
  /*
   * Sets the red value to zero
   */
  public void zeroRed() {
    Pixel[][] temp = getPixelsFromImage();
    
    for (int row = 0; row < temp.length; row++) {
      for (int col = 0; col < temp[0].length; col++) {
        temp[row][col].setRed(0);
      }
    }
  }

  /*
   * Sets the green value to zero
   */
  public void zeroGreen() {
    Pixel[][] temp = getPixelsFromImage();
    
    for (int row = 0; row < temp.length; row++) {
      for (int col = 0; col < temp[0].length; col++) {
        temp[row][col].setGreen(0);
      }
    }
  }
  
  /*
   * Inverts the colors in the image by setting the red,
   * green, and blue color values of each Pixel object to
   * the result of 255 minus their current values
   */
  public void makeNegative() {
    Pixel[][] temp = getPixelsFromImage();

    for (int row = 0; row < temp.length; row++) {
      for (int col = 0; col < temp[0].length; col++) {
        temp[row][col].setRed(255 - temp[row][col].getRed());
        temp[row][col].setGreen(255 - temp[row][col].getGreen());
        temp[row][col].setBlue(255 - temp[row][col].getBlue());
      }
    }
  }

  /*
   * Shifts the color of each Pixel object by a fixed amount
   */
  public void colorShift(int value) {
    Pixel[][] temp = getPixelsFromImage();

    for (int row = 1; row < temp.length - 1; row++) {
      for (int col = 1; col < temp[0].length - 1; col++) {
        int newRed = temp[row][col].getRed() + value;
        int newGreen = temp[row][col].getGreen() + value;
        int newBlue = temp[row][col].getBlue() + value;

        if (newRed > 255) {
          newRed = 255;
        } else if (newGreen > 255) {
          newGreen = 255;
        } else if (newBlue > 255) {
          newBlue = 255;
        }
        
        temp[row][col].setRed(newRed);
        temp[row][col].setGreen(newGreen);
        temp[row][col].setBlue(newBlue);
      }
    }
  }

  /*
   * Applies a saturation filter to the image
   */
  public void saturate(int factor) {
    Pixel[][] temp = getPixelsFromImage();

    for (int row = 0; row < temp.length; row++) {
      for (int col = 0; col < temp[0].length; col++) {
        int average = temp[row][col].getRed() + temp[row][col].getGreen() + temp[row][col].getBlue();
        average = average / 3;

        int newGreyScale = average + (average - 255) * factor;

        temp[row][col].setRed(2 * newGreyScale - temp[row][col].getRed());
        temp[row][col].setGreen(2 * newGreyScale - temp[row][col].getGreen());
        temp[row][col].setBlue(2 * newGreyScale - temp[row][col].getBlue());
      }
    }
  }

  /*
   * Applies a Gaussian blur by finding the average of the red,
   * green, and blue color values of the current Pixel object and
   * its top-left neighboring Pixel object using a weighted average
   */
  public void applyBlur() {
    Pixel[][] temp = getPixelsFromImage();

    for (int row = 1; row < temp.length - 1; row++) {
      for (int col = 1; col < temp[0].length - 1; col++) {
        temp[row][col].setRed(calcWeightedRed(temp, row, col));
        temp[row][col].setGreen(calcWeightedGreen(temp, row, col));
        temp[row][col].setBlue(calcWeightedBlue(temp, row, col));
      }
    }
  }

  
  /** OTHER **/
  /*
   * Returns a weighted red average of the pixels around the specified row and col
   */
  public int calcWeightedRed(Pixel[][] pixels, int row, int col) {
    int avgRed = (pixels[row-1][col-1].getRed() + pixels[row-1][col].getRed() + pixels[row-1][col+1].getRed() +
                  pixels[row][col-1].getRed() + pixels[row][col].getRed() + pixels[row][col+1].getRed() +
                  pixels[row+1][col-1].getRed() + pixels[row+1][col].getRed() + pixels[row+1][col+1].getRed()) / 9;
    return avgRed;
  }

  /*
   * Returns a weighted green average of the pixels around the specified row and col 
   */
  public int calcWeightedGreen(Pixel[][] pixels, int row, int col) {
    int avgGreen = (pixels[row-1][col-1].getGreen() + pixels[row-1][col].getGreen() + pixels[row-1][col+1].getGreen() +
                    pixels[row][col-1].getGreen() + pixels[row][col].getGreen() + pixels[row][col+1].getGreen() +
                    pixels[row+1][col-1].getGreen() + pixels[row+1][col].getGreen() + pixels[row+1][col+1].getGreen()) / 9;
    return avgGreen;
  }

  /*
   * Returns a weighted blue average of the pixels around the specified row and col
   */
  public int calcWeightedBlue(Pixel[][] pixels, int row, int col) {
    int avgBlue = (pixels[row-1][col-1].getBlue() + pixels[row-1][col].getBlue() + pixels[row-1][col+1].getBlue() +
                   pixels[row][col-1].getBlue() + pixels[row][col].getBlue() + pixels[row][col+1].getBlue() +
                   pixels[row+1][col-1].getBlue() + pixels[row+1][col].getBlue() + pixels[row+1][col+1].getBlue()) / 9;
    return avgBlue;
  }
  
  
}