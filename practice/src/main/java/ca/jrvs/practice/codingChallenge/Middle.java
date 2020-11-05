package ca.jrvs.practice.codingChallenge;

/**
 * Class containing functions to find the middle node in a linked list
 * Relevant Ticket: https://www.notion.so/Middle-of-the-Linked-List-dd808f9b37c4402280a5474e61fc3b19
 */
public class Middle {

  /**
   * Find the middle node in the linked list using two pointers
   * Time Complexity: O(n)
   * Justification: The second pointer visits each node once, plus the first pointer which visits less nodes, makes O(n)
   */
  public BasicLinkedListNode getMiddleNode(BasicLinkedListNode root) {

    BasicLinkedListNode first = root;
    BasicLinkedListNode second = root;
    while (second != null && second.next !=null) {
      first = first.next;
      second = second.next;
      if(second == null)
        break;
      second = second.next;
    }
    return first;
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
  }
}
