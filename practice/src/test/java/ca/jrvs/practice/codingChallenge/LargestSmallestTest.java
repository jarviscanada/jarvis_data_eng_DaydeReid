package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class LargestSmallestTest {

  List<Integer> testList;
  LargestSmallest ls;

  @Before
  public void setUp() {
    testList = new ArrayList<>();
    testList.add(6);
    testList.add(3);
    testList.add(8);
    testList.add(4);

    ls = new LargestSmallest();
  }

  @Test
  public void getLargestLoop() {
    assertEquals((Integer) 8, ls.getLargestLoop(testList));
  }

  @Test
  public void getSmallestLoop() {
    assertEquals((Integer) 3, ls.getSmallestLoop(testList));
  }

  @Test
  public void getLargestStream() {
    assertEquals((Integer) 8, ls.getLargestStream(testList));
  }

  @Test
  public void getSmallestStream() {
    assertEquals((Integer) 3, ls.getSmallestStream(testList));
  }

  @Test
  public void getLargestApi() {
    assertEquals((Integer) 8, ls.getLargestApi(testList));
  }

  @Test
  public void getSmallestApi() {
    assertEquals((Integer) 3, ls.getSmallestApi(testList));
  }
}