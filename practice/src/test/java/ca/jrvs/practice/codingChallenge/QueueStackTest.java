package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.assertEquals;

import ca.jrvs.practice.codingChallenge.QueueStack.DoubleQueueStack;
import ca.jrvs.practice.codingChallenge.QueueStack.SimpleStack;
import ca.jrvs.practice.codingChallenge.QueueStack.SingleQueueStack;
import org.junit.Test;

public class QueueStackTest {

  @Test
  public void doubleQueueStack() {
    SimpleStack<Integer> testStack = new DoubleQueueStack<Integer>();

    testStack.push(12);
    testStack.push(21);
    assertEquals((Integer) 21, testStack.pop());
    testStack.push(47);
    assertEquals((Integer) 47, testStack.pop());
    assertEquals((Integer) 12, testStack.pop());
  }

  @Test
  public void singleQueueStack() {
    SimpleStack<Integer> testStack = new SingleQueueStack<Integer>();

    testStack.push(12);
    testStack.push(21);
    assertEquals((Integer) 21, testStack.pop());
    testStack.push(47);
    assertEquals((Integer) 47, testStack.pop());
    assertEquals((Integer) 12, testStack.pop());
  }

}