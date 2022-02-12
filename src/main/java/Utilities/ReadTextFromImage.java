package Utilities;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

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

  public static String take(String path) {
    // JNA Interface Mapping
    ITesseract instance = new Tesseract();
    // JNA Direct Mapping
    // ITesseract instance = new Tesseract1();
    File imageFile = new File(path);
    // In case you don't have your own tessdata, let it also be extracted for you
    // 这样就能使用classpath目录下的训练库了
    File tessDataFolder = LoadLibs.extractTessResources("tessdata");
    // Set the tessdata path
    instance.setDatapath(tessDataFolder.getAbsolutePath());
    // 英文库识别数字比较准确
    instance.setLanguage("eng");
    return getOCRText(instance, imageFile);
  }

  private static String getOCRText(ITesseract instance, File imageFile) {
    String result = null;
    try {
      result = instance.doOCR(imageFile);
    } catch (TesseractException e) {
      e.printStackTrace();
    }
    return result;
  }

  public static void main(String[] args) {

    String path = WorkingDirectory + "/Data/Images/english.png";
    System.out.println(path);
    System.out.println(take(path));
  }

}
