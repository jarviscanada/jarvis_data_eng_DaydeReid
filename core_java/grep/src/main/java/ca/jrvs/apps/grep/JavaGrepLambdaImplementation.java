package ca.jrvs.apps.grep;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JavaGrepLambdaImplementation extends JavaGrepImplementation {

  public static void main(String[] args) {
    if (args.length != 3) {
      throw new IllegalArgumentException("Usage: JavaGrep regex rootPath outFile");
    }
    JavaGrepImplementation javaGrep = new JavaGrepLambdaImplementation();
    javaGrep.setRegex(args[0]);
    javaGrep.setRootPath(args[1]);
    javaGrep.setOutFile(args[2]);

    try {
      javaGrep.process();
    } catch (Exception ex) {
      javaGrep.logger.error("Failed to start grep process", ex);
    }
  }

  @Override
  public List<File> listFiles(String rootDir) {
    List<File> fileList = new ArrayList<File>();
    try {
      Files.walk(Paths.get(rootDir)).filter(Files::isRegularFile)
          .forEach(f -> fileList.add(f.toFile()));
    } catch (IOException ex) {
      logger.error("Failed to open file", ex);
    }
    return fileList;
  }

  @Override
  public List<String> readLines(File inputFile) {
    if (!inputFile.isFile()) {
      throw new IllegalArgumentException("Error: inputFile was not a file");
    }
    List<String> lineList = new ArrayList<String>();
    try {
      Files.lines(inputFile.toPath()).forEach(l -> lineList.add(l));
    } catch (IOException ex) {
      logger.error("Failed to open file", ex);
    }
    return lineList;
  }
}
