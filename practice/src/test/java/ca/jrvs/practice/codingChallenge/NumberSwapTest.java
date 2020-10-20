package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class NumberSwapTest {

  @Test
  public void swapNumbersBitwise() {
    NumberSwap ns = new NumberSwap();

    try {
      ns.swapNumbersBitwise(new int[]{1, 2, 3});
      fail();
    } catch (IllegalArgumentException ex) {
      assertTrue(true);
    }

    int[] testSwap = ns.swapNumbersBitwise(new int[]{1, 2});
    assertEquals(2, testSwap[0]);
    assertEquals(1, testSwap[1]);

  }

  @Test
  public void swapNumbersArithmetic() {
    NumberSwap ns = new NumberSwap();

    try {
      ns.swapNumbersArithmetic(new int[]{1, 2, 3});
      fail();
    } catch (IllegalArgumentException ex) {
      assertTrue(true);
    }

    int[] testSwap = ns.swapNumbersArithmetic(new int[]{1, 2});
    assertEquals(2, testSwap[0]);
    assertEquals(1, testSwap[1]);
  }
}