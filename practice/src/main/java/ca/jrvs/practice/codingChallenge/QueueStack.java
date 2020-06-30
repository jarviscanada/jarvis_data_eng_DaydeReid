package ca.jrvs.practice.codingChallenge;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class containing implementations of a stack using only queues
 * Relevant Ticket: https://www.notion.so/String-to-Integer-atoi-82ec747728674a5d8651dfe1addadd99
 */
public class QueueStack {

  /**
   * A simple stack interface for the stacks to implement
   *
   * @param <E> - Type of object the simple stack should hold
   */
  public interface SimpleStack<E> {

    void push(E element);

    E pop();
  }

  public static class DoubleQueueStack<E> implements SimpleStack<E> {

    private Queue<E> pushQueue = new LinkedList<E>();
    private Queue<E> popQueue = new LinkedList<E>();

    /**
     * Push an element to the top of the stack
     * Time Complexity: O(1)
     * Justification: Queue's add method has O(1) complexity
     */
    @Override
    public void push(E element) {
      pushQueue.add(element);
    }

    /**
     * Pop the top item off of the stack
     * Time Complexity: O(n)
     * Justification: If the pop queue is empty, need to add all the elements in the push queue into it
     */
    @Override
    public E pop() {
      while (pushQueue.size() > 1) {
        popQueue.add(pushQueue.remove());
      }
      E ret = pushQueue.remove();
      pushQueue = popQueue;
      popQueue = new LinkedList<E>();
      return ret;
    }
  }

  public static class SingleQueueStack<E> implements SimpleStack<E> {

    private Queue<E> queue = new LinkedList<E>();

    /**
     * Push an element to the top of the stack
     * Time Complexity: O(n)
     * Justification: Need to cycle through all elements in the queue to reverse them into a stack
     */
    @Override
    public void push(E element) {
      int size = queue.size();
      queue.add(element);
      for (int i = 0; i < size; i ++) {
        queue.add(queue.remove());
      }
    }

    /**
     * Pop the top item off of the stack
     * Time Complexity: O(1)
     * Justification: Queue's remove method has O(1) complexity
     */
    @Override
    public E pop() {
      return queue.remove();
    }
  }
}
