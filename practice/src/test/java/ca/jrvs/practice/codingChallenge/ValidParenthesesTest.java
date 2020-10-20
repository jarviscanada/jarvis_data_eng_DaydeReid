package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidParenthesesTest {

  @Test
  public void hasValidParentheses() {
    ValidParentheses validator = new ValidParentheses();

    assertTrue(validator.hasValidParentheses("()()()()"));
    assertTrue(validator.hasValidParentheses("[[[[]]]]"));
    assertTrue(validator.hasValidParentheses("{{}{}{}}"));
    assertTrue(validator.hasValidParentheses("([{}])"));
    assertFalse(validator.hasValidParentheses("((()"));
    assertFalse(validator.hasValidParentheses("][][]["));
    assertFalse(validator.hasValidParentheses("{}{{}}{}{{}"));
    assertFalse(validator.hasValidParentheses("[}[){]"));
  }
}