package ca.jrvs.apps.grep;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface JavaGrep {

  /**
   * Top level search workflow
   *
   * @throws IOException
   */
  void process() throws IOException;

  /**
   * Traverse a given directory and return all files
   *
   * @param rootDir - Input directory
   * @return files under rootdir
   */
  List<File> listFiles(String rootDir);

  /**
   * Read a file and return all the lines
   *
   * @param inputFile - File to be read
   * @return lines
   * @throws IllegalArgumentException if given an inputFile which is not a file
   */
  List<String> readLines(File inputFile);

  /**
   * Check if a line contains the regex pattern (Passed by the user)
   *
   * @param line - Input string
   */
  boolean containsPattern(String line);

  /**
   * Write lines to a file
   *
   * @param lines - Matched lines
   * @throws IOException if write failed
   */
  void writeToFile(List<String> lines) throws IOException;

  String getRootPath();

  void setRootPath(String rootPath);

  String getRegex();

  void setRegex(String regex);

  String getOutFile();

  void setOutFile(String outFile);
}
