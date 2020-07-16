package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringDigitsTest {

  @Test
  public void isOnlyDigitsAscii() {
    StringDigits sd = new StringDigits();
    assertTrue(sd.isOnlyDigitsAscii("12345"));
    assertFalse(sd.isOnlyDigitsAscii("1 thousand"));
  }

  @Test
  public void isOnlyDigitsApi() {
    StringDigits sd = new StringDigits();
    assertTrue(sd.isOnlyDigitsApi("12345"));
    assertFalse(sd.isOnlyDigitsApi("1 thousand"));
  }

  @Test
  public void isOnlyDigitsRegex() {
    StringDigits sd = new StringDigits();
    assertTrue(sd.isOnlyDigitsRegex("12345"));
    assertFalse(sd.isOnlyDigitsRegex("1 thousand"));
  }
}