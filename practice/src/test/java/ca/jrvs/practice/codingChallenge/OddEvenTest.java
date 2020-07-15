package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OddEvenTest {

  @Test
  public void oddEvenModulo() {
    OddEven oddEven = new OddEven();
    assertEquals("Odd", oddEven.oddEvenModulo(3));
    assertEquals("Even", oddEven.oddEvenModulo(8));
  }

  @Test
  public void oddEvenXOR() {
    OddEven oddEven = new OddEven();
    assertEquals("Odd", oddEven.oddEvenXOR(17));
    assertEquals("Even", oddEven.oddEvenXOR(6));
  }
}