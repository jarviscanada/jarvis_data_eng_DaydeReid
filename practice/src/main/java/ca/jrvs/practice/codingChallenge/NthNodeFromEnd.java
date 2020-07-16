package ca.jrvs.practice.codingChallenge;

/**
 * Class containing functions to find the nth node from the end of a linked list Relevant Ticket:
 * https://www.notion.so/Nth-Node-From-End-of-LinkedList-be0c04c239c742789865a03e6e97898d
 */
public class NthNodeFromEnd {

  /**
   * Find the nth node from the end of the linked list using two pointers
   * Time Complexity: O(n)
   * Justification: The first pointer visits each node once, plus the second pointer which visits less nodes, makes O(n)
   */
  public BasicLinkedListNode nthNodeFromEnd(BasicLinkedListNode root, int n) {

    BasicLinkedListNode tempNode = new BasicLinkedListNode(999);
    tempNode.next = root;
    BasicLinkedListNode first = tempNode;
    for(int i = 0; i < n + 1; i++) {
      first = first.next;
      if (first == null)
        return null;
    }
    BasicLinkedListNode second = tempNode;
    while (first != null) {
      first = first.next;
      second = second.next;
    }
    return second;
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


