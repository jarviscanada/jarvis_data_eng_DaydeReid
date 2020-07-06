package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeTest {

  @Test
  public void isPalindromePointers() {
    Palindrome palindrome = new Palindrome();
    assertTrue(palindrome.isPalindromePointers("I"));
    assertFalse(palindrome.isPalindromePointers("To"));
    assertTrue(palindrome.isPalindromePointers("AA"));
    assertTrue(palindrome.isPalindromePointers("Racecar"));
    assertFalse(palindrome.isPalindromePointers("Tiger Lily"));
  }

  @Test
  public void isPalindromeRecursive() {
    Palindrome palindrome = new Palindrome();
    assertTrue(palindrome.isPalindromeRecursive("I"));
    assertFalse(palindrome.isPalindromeRecursive("To"));
    assertTrue(palindrome.isPalindromeRecursive("AA"));
    assertTrue(palindrome.isPalindromeRecursive("Racecar"));
    assertFalse(palindrome.isPalindromeRecursive("Tiger Lily"));
  }
}