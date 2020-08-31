package ca.jrvs.practice.codingChallenge;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import ca.jrvs.practice.codingChallenge.Cycle.BasicLinkedListNode;
import org.junit.Test;

public class CycleTest {

  @Test
  public void hasCycle() {
    Cycle cycle = new Cycle();

    BasicLinkedListNode root = new BasicLinkedListNode(5);

    root.next = new BasicLinkedListNode(2);
    root.next.next = new BasicLinkedListNode(8);
    root.next.next.next = new BasicLinkedListNode(0);
    assertFalse(cycle.hasCycle(root));

    root.next.next.next.next = root;
    assertTrue(cycle.hasCycle(root));

  }
}