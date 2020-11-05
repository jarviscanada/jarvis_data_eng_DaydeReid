package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class DuplicateNumsTest {

  @Test
  public void duplicateNum() {
    DuplicateNums dn = new DuplicateNums();
    assertEquals(4, dn.duplicateNum(new Integer[]{4,7,2,1,6,4,3,5}));
  }

  @Test
  public void fastDuplicateNum() {
    DuplicateNums dn = new DuplicateNums();
    assertEquals(4, dn.fastDuplicateNum(new Integer[]{4,7,2,1,6,4,3,5}));
  }
}