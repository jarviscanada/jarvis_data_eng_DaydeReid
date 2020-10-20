package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

public class LetterWithNumberTest {

  private final ByteArrayOutputStream printOutput = new ByteArrayOutputStream();

  @Test
  public void printWithNumbers() {
    LetterWithNumber lwn = new LetterWithNumber();

    System.setOut(new PrintStream(printOutput));

    try {
      lwn.printWithNumbers("1234567");
      fail();
    } catch (IllegalArgumentException ex) {
      assertTrue(true);
    }

    lwn.printWithNumbers("abcdeqABCDEQ");
    assertEquals("a1b2c3d4e5q17A27B28C29D30E31Q43", printOutput.toString());

    System.setOut(System.out);
  }
}