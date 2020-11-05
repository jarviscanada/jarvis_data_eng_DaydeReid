package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import ca.jrvs.practice.codingChallenge.NthNodeFromEnd.BasicLinkedListNode;
import org.junit.Test;

public class NthNodeFromEndTest {

  @Test
  public void nthNodeFromEnd() {
    NthNodeFromEnd nth = new NthNodeFromEnd();

    BasicLinkedListNode root = new BasicLinkedListNode(5);
    root.next = new BasicLinkedListNode(2);
    root.next.next = new BasicLinkedListNode(8);
    root.next.next.next = new BasicLinkedListNode(0);

    assertEquals(null, nth.nthNodeFromEnd(root, 8));
    assertEquals(8, nth.nthNodeFromEnd(root, 1).value);
    assertEquals(5, nth.nthNodeFromEnd(root, 3).value);
  }
}