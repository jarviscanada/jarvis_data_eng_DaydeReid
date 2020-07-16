package ca.jrvs.practice.codingChallenge;

import ca.jrvs.practice.codingChallenge.Middle.BasicLinkedListNode;
import java.util.Objects;

/**
 * Class containing functions to determine if a linked list contains a cycle
 * Relevant Ticket: https://www.notion.so/LinkedList-Cycle-2cf1a4eb10a34ba09a9f4c9c202f4d82
 */
public class Cycle {

  /**
   * Find the middle node in the linked list using two pointers
   * Time Complexity: O(n)
   * Justification: The second pointer visits each node once, plus the first pointer which visits less nodes, makes O(n)
   */
  public boolean hasCycle(BasicLinkedListNode root) {

    BasicLinkedListNode first = root;
    BasicLinkedListNode second = root;
    while (second != null && second.next != null) {
      first = first.next;
      second = second.next;
      if(second == null)
        break;
      second = second.next;
      if(first.equals(second))
        return true;
    }
    return false;
  }

  /**
   * Simple linked list implementation without size
   */
  public static class BasicLinkedListNode {

    public int value;
    public BasicLinkedListNode next = null;

    BasicLinkedListNode(int value) {
      this.value = value;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      BasicLinkedListNode that = (BasicLinkedListNode) o;
      return value == that.value &&
          Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
      return Objects.hash(value, next);
    }
  }
}
