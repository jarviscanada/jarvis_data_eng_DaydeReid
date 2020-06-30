package ca.jrvs.practice.codingChallenge;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Class containing implementations of a queue using only stacks
 * Relevant Ticket: https://www.notion.so/String-to-Integer-atoi-82ec747728674a5d8651dfe1addadd99
 */
public class StackQueue {

  /**
   * A simple queue interface for the queues to implement
   *
   * @param <E> - Type of object the simple queue should hold
   */
  public interface SimpleQueue<E> {

    void enqueue(E element);

    E dequeue();
  }

  public static class DoubleStackQueue<E> implements SimpleQueue<E> {

    private Stack<E> stack = new Stack<E>();
    private Stack<E> tempStack = new Stack<E>();

    /**
     * Enqueue an element into the queue
     * Time Complexity: O(n)
     * Justification: Must loop through all existing elements in the queue twice for each enqueue
     */
    @Override
    public void enqueue(E element) {
      while(!stack.empty()) {
        tempStack.push(stack.pop());
      }
      stack.push(element);
      while(!tempStack.empty()) {
        stack.push(tempStack.pop());
      }
    }

    /**
     * Dequeue the first element in the queue
     * Time Complexity: O(1)
     * Justification: Stack's pop method has O(1) complexity
     */
    @Override
    public E dequeue() {
      return stack.pop();
    }
  }

  public static class SingleStackQueue<E> implements SimpleQueue<E> {

    private Stack<E> pushStack = new Stack<E>();
    private Stack<E> popStack = new Stack<E>();

    /**
     * Enqueue an element into the queue
     * Time Complexity: O(1)
     * Justification: Stack's push method has O(1) complexity
     */
    @Override
    public void enqueue(E element) {
      pushStack.push(element);
    }

    /**
     * Dequeue the first element in the queue
     * Time Complexity: O(1) (Amortized)
     * Justification: For the usual case of pop stack already having values in it, complexity is O(1) to pop one from the stack. If pop stack is empty, need to push into it all the values from the push stack for complexity O(n) as the worst case.
     */
    @Override
    public E dequeue() {
      if (popStack.empty()) {
        while (!pushStack.empty()) {
          popStack.push(pushStack.pop());
        }
      }
      return popStack.pop();
    }
  }
}
