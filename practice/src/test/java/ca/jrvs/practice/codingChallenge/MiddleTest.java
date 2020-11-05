package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import ca.jrvs.practice.codingChallenge.Middle.BasicLinkedListNode;
import org.junit.Test;

public class MiddleTest {

  @Test
  public void getMiddleNode() {
    Middle middle = new Middle();

    BasicLinkedListNode root = new BasicLinkedListNode(5);
    assertEquals(5, middle.getMiddleNode(root).value);

    root.next = new BasicLinkedListNode(2);
    root.next.next = new BasicLinkedListNode(8);
    root.next.next.next = new BasicLinkedListNode(0);
    assertEquals(8, middle.getMiddleNode(root).value);

    root.next.next.next.next = new BasicLinkedListNode(3);
    assertEquals(8, middle.getMiddleNode(root).value);
  }

}