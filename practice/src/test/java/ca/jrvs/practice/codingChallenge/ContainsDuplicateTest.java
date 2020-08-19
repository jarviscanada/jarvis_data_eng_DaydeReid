package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContainsDuplicateTest {

  @Test
  public void containsDuplicate() {
    ContainsDuplicate cd = new ContainsDuplicate();

    assertTrue(cd.containsDuplicate(new int[]{1, 1, 2, 5}));
    assertFalse(cd.containsDuplicate(new int[]{1, 2, 3, 4}));
    assertFalse(cd.containsDuplicate(new int[]{1}));
    assertFalse(cd.containsDuplicate(new int[]{}));
  }

  @Test
  public void containsDuplicateSet() {
    ContainsDuplicate cd = new ContainsDuplicate();

    assertTrue(cd.containsDuplicateSet(new int[]{1, 1, 2, 5}));
    assertFalse(cd.containsDuplicateSet(new int[]{1, 2, 3, 4}));
    assertFalse(cd.containsDuplicateSet(new int[]{1}));
    assertFalse(cd.containsDuplicateSet(new int[]{}));
  }
}