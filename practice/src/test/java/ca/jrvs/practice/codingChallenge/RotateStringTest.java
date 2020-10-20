package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotateStringTest {

  @Test
  public void isRotatable() {
    RotateString rs = new RotateString();
    assertFalse(rs.isRotatable("Dog", "Monkey"));
    assertTrue(rs.isRotatable("Dog", "Dog"));
    assertTrue(rs.isRotatable("Monkey", "keyMon"));
    assertFalse(rs.isRotatable("Monkey", "nkoMny"));
  }
}