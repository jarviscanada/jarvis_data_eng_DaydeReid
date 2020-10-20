package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveElementTest {

  @Test
  public void removeElement() {
    RemoveElement re = new RemoveElement();

    assertEquals(3, re.removeElement(new int[]{1,7,6,3,6}, 6));
  }
}