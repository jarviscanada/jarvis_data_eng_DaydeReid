package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringToIntegerTest {

  @Test
  public void stringToIntegerParse() {
    StringToInteger stringToInt = new StringToInteger();

    assertEquals((Integer) 28, stringToInt.stringToIntegerParse("28"));
    assertEquals((Integer) 15, stringToInt.stringToIntegerParse("+15"));
    assertEquals((Integer) (-84), stringToInt.stringToIntegerParse("-84"));
    assertEquals(null, stringToInt.stringToIntegerParse("abrakadabra"));
    assertEquals(null, stringToInt.stringToIntegerParse("123 testing"));
  }

  @Test
  public void stringToIntegerAscii() {
    StringToInteger stringToInt = new StringToInteger();

    assertEquals((Integer) 28, stringToInt.stringToIntegerAscii("28"));
    assertEquals((Integer) 15, stringToInt.stringToIntegerAscii("+15"));
    assertEquals((Integer) (-84), stringToInt.stringToIntegerAscii("-84"));
    assertEquals((Integer) null, stringToInt.stringToIntegerAscii("abrakadabra"));
    assertEquals(null, stringToInt.stringToIntegerAscii("123 testing"));
  }
}