package Utilities;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ReadTextFromImage {

  static String WorkingDirectory = System.getProperty("user.dir");

  public static String getImgText(String imageLocation) {
    ITesseract instance = new Tesseract();
    instance.setLanguage("eng");
    try {
      String imgText = instance.doOCR(new File(imageLocation));
      return imgText;
    } catch (TesseractException e) {
      e.getMessage();
      return "Error while reading image";
    }
  }

  public static void main(String[] args) {

    String path = WorkingDirectory + "/Data/Images/english.png";
    System.out.println(path);
    System.out.println(getImgText(path));
  }

}
