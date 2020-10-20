package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class MergeSortedListsTest {

  @Test
  public void mergeLists() {
    MergeSortedLists msl = new MergeSortedLists();
    List<Integer> testListA = new ArrayList<>();
    testListA.add(1);
    testListA.add(5);
    testListA.add(9);
    List<Integer> testListB = new ArrayList<>();
    testListB.add(2);
    testListB.add(4);
    testListB.add(7);

    List<Integer> mergeList = msl.mergeLists(testListA, testListB);
    assertEquals((Integer) 1, mergeList.get(0));
    assertEquals((Integer) 2, mergeList.get(1));
    assertEquals((Integer) 4, mergeList.get(2));
    assertEquals((Integer) 5, mergeList.get(3));
    assertEquals((Integer) 7, mergeList.get(4));
    assertEquals((Integer) 9, mergeList.get(5));
  }
}