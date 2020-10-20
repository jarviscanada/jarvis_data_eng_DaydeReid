package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountPrimesTest {

  @Test
  public void countPrimes() {
    CountPrimes countPrimes = new CountPrimes();

    try {
      countPrimes.countPrimes(-12);
      fail();
    } catch (IllegalArgumentException ex) {
      assertTrue(true);
    }

    assertEquals(0, countPrimes.countPrimes(1));
    assertEquals(0, countPrimes.countPrimes(2));
    assertEquals(1, countPrimes.countPrimes(3));
    assertEquals(4, countPrimes.countPrimes(10));
  }
}