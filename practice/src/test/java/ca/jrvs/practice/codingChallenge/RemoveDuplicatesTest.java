package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class RemoveDuplicatesTest {

  @Test
  public void removeDuplicates() {
    RemoveDuplicates rd = new RemoveDuplicates();

    List<Integer> testList = new ArrayList<>();
    testList.add(1);
    testList.add(1);
    testList.add(2);
    testList.add(3);
    testList.add(3);
    testList.add(5);
    testList.add(7);
    testList.add(7);
    testList = rd.removeDuplicates(testList);
    assertEquals((Integer) 1, testList.get(0));
    assertEquals((Integer) 2, testList.get(1));
    assertEquals((Integer) 3, testList.get(2));
    assertEquals((Integer) 5, testList.get(3));
    assertEquals((Integer) 7, testList.get(4));
    try {
      testList.get(5);
      fail();
    } catch (IndexOutOfBoundsException ex) {
      assertTrue(true);
    }
  }
}