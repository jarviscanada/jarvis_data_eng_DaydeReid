package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest {

  @Test
  public void recursiveFibonacci() {
    Fibonacci fibonacci = new Fibonacci();
    assertEquals("0th Fibonacci number should be 0", 0, fibonacci.recursiveFibonacci(0));
    assertEquals("1st Fibonacci number should be 1", 1, fibonacci.recursiveFibonacci(1));
    assertEquals("2nd Fibonacci number should be 1", 1, fibonacci.recursiveFibonacci(2));
    assertEquals("5th Fibonacci number should be 5", 5, fibonacci.recursiveFibonacci(5));
  }

  @Test
  public void dynamicFibonacci() {
    Fibonacci fibonacci = new Fibonacci();
    assertEquals("0th Fibonacci number should be 0", 0, fibonacci.dynamicFibonacci(0));
    assertEquals("1st Fibonacci number should be 1", 1, fibonacci.dynamicFibonacci(1));
    assertEquals("2nd Fibonacci number should be 1", 1, fibonacci.dynamicFibonacci(2));
    assertEquals("5th Fibonacci number should be 5", 5, fibonacci.dynamicFibonacci(5));
  }
}