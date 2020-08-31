package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class DuplicateCharsTest {

  @Test
  public void duplicateChars() {
    DuplicateChars dc = new DuplicateChars();
    List<Character> testList = Arrays.asList(dc.duplicateChars("abra kadabra alakazam"));
    assertTrue(testList.contains('a'));
    assertTrue(testList.contains('b'));
    assertTrue(testList.contains('r'));
    assertTrue(testList.contains('k'));
    assertTrue(testList.contains(' '));
    assertFalse(testList.contains('d'));
    assertFalse(testList.contains('l'));
    assertFalse(testList.contains('z'));
    assertFalse(testList.contains('m'));
  }
}