package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import ca.jrvs.practice.codingChallenge.StackQueue.DoubleStackQueue;
import ca.jrvs.practice.codingChallenge.StackQueue.SimpleQueue;
import ca.jrvs.practice.codingChallenge.StackQueue.SingleStackQueue;
import org.junit.Test;

public class StackQueueTest {

  @Test
  public void doubleStackQueue() {
    SimpleQueue<Integer> testStack = new DoubleStackQueue<Integer>();

    testStack.enqueue(12);
    testStack.enqueue(21);
    assertEquals((Integer) 12, testStack.dequeue());
    testStack.enqueue(47);
    assertEquals((Integer) 21, testStack.dequeue());
    assertEquals((Integer) 47, testStack.dequeue());
  }

  @Test
  public void singleStackQueue() {
    SimpleQueue<Integer> testStack = new SingleStackQueue<Integer>();

    testStack.enqueue(12);
    testStack.enqueue(21);
    assertEquals((Integer) 12, testStack.dequeue());
    testStack.enqueue(47);
    assertEquals((Integer) 21, testStack.dequeue());
    assertEquals((Integer) 47, testStack.dequeue());
  }

}