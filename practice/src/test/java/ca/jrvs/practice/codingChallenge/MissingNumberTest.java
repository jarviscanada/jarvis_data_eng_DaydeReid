package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class MissingNumberTest {

  @Test
  public void missingNumberSum() {
    MissingNumber mn = new MissingNumber();
    assertEquals(4, mn.missingNumberSum(new int[]{0,5,2,3,1}));
  }

  @Test
  public void missingNumberSet() {
    MissingNumber mn = new MissingNumber();
    assertEquals(4, mn.missingNumberSet(new int[]{0,5,2,3,1}));
  }

  @Test
  public void missingNumberGauss() {
    MissingNumber mn = new MissingNumber();
    assertEquals(4, mn.missingNumberGauss(new int[]{0,5,2,3,1}));
  }
}