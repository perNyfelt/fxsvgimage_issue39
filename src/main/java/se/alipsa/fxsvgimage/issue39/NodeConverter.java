package se.alipsa.fxsvgimage.issue39;

import javafx.scene.Node;
import org.girod.javafx.svgimage.tosvg.ConverterParameters;
import org.girod.javafx.svgimage.tosvg.SVGConverter;

import java.io.File;
import java.io.IOException;

public class NodeConverter {

  static final double ADDITIONAL_WIDTH = 0;
  static final double ADDITIONAL_HEIGHT = 0;

  public static void convert(Node node, String fileName) {
    double contentWidth = node.getBoundsInParent().getWidth() + ADDITIONAL_WIDTH;
    double contentHeight = node.getBoundsInParent().getHeight() + ADDITIONAL_HEIGHT;

    System.out.println("Converting to " + fileName + " from node with dimensions " + contentWidth + " x " + contentHeight);
    // taken from example usage of the converter from https://github.com/hervegirod/fxsvgimage
    ConverterParameters params = new ConverterParameters();
    params.width = contentWidth;
    params.height = contentHeight;
    SVGConverter converter = new SVGConverter();

    // Perform the conversion
    File svgFile = new File(fileName);

    try {
      converter.convert(node, svgFile, params);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    System.out.println("SVG file created: " + svgFile.getAbsolutePath());

  }
}
