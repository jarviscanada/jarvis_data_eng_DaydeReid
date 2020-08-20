package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import ca.jrvs.practice.codingChallenge.ReverseList.LinkedNode;
import org.junit.Test;

public class ReverseListTest {

  @Test
  public void iterativeReverseList() {
    ReverseList rl = new ReverseList();
    LinkedNode testHead = new LinkedNode(6);
    testHead.next = new LinkedNode(3);
    testHead.next.next = new LinkedNode(8);
    testHead.next.next.next = new LinkedNode(2);
    testHead.next.next.next.next = new LinkedNode(5);

    LinkedNode reverseHead = rl.iterativeReverseList(testHead);
    assertEquals((Integer) 5, reverseHead.value);
    assertEquals((Integer) 2, reverseHead.next.value);
    assertEquals((Integer) 8, reverseHead.next.next.value);
    assertEquals((Integer) 3, reverseHead.next.next.next.value);
    assertEquals((Integer) 6, reverseHead.next.next.next.next.value);
  }

  @Test
  public void recursiveReverseList() {
    ReverseList rl = new ReverseList();
    LinkedNode testHead = new LinkedNode(6);
    testHead.next = new LinkedNode(3);
    testHead.next.next = new LinkedNode(8);
    testHead.next.next.next = new LinkedNode(2);
    testHead.next.next.next.next = new LinkedNode(5);

    LinkedNode reverseHead = rl.recursiveReverseList(testHead);
    assertEquals((Integer) 5, reverseHead.value);
    assertEquals((Integer) 2, reverseHead.next.value);
    assertEquals((Integer) 8, reverseHead.next.next.value);
    assertEquals((Integer) 3, reverseHead.next.next.next.value);
    assertEquals((Integer) 6, reverseHead.next.next.next.next.value);
  }
}