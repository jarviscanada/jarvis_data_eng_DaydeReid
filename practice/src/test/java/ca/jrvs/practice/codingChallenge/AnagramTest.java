package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnagramTest {

  @Test
  public void sortedIsAnagram() {
    Anagram anagram = new Anagram();
    assertTrue(anagram.sortedIsAnagram("Cedar", "Raced"));
    assertFalse(anagram.sortedIsAnagram("Racecar", "Radishes"));
  }

  @Test
  public void fastIsAnagram() {
    Anagram anagram = new Anagram();
    assertTrue(anagram.fastIsAnagram("Cedar", "Raced"));
    assertFalse(anagram.fastIsAnagram("Racecar", "Radishes"));
  }
}