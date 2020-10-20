package ca.jrvs.practice.codingChallenge;

import java.util.LinkedList;

/**
 * Class containing functions to reverse a linked list
 * Relevant Ticket: https://www.notion.so/Reverse-Linked-List-204f43a60ce64cd29a49c7feb93f6a03
 */
public class ReverseList {

  // Simple linked list implementation for use
  public static class LinkedNode {
    Integer value;
    LinkedNode next = null;
    public LinkedNode(Integer value) {
      this.value = value;
    }
  }

  /**
   * Reverse a linked list iteratively
   * Time Complexity: O(n)
   * Justification: Single loop through all the nodes in the list
   */
  public LinkedNode iterativeReverseList(LinkedNode head) {
    LinkedNode curr = head;
    LinkedNode prev = null;
    while (curr != null) {
      LinkedNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  /**
   * Reverse a linked list recursively
   * Time Complexity: O(n)
   * Justification: Recur through each node in the list once
   */
  public LinkedNode recursiveReverseList(LinkedNode head) {
    if(head == null || head.next == null) {
      return head;
    }
    LinkedNode ret = recursiveReverseList(head.next);
    head.next.next = head;
    head.next = null;
    return ret;
  }
}
