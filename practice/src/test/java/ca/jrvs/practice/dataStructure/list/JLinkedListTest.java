package ca.jrvs.practice.dataStructure.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class JLinkedListTest {

  JLinkedList<String> list;

  @Before
  public void setup() {
    list = new JLinkedList<>();
    list.add("Dog");
  }

  @Test
  public void add() {
    list.add("Cat");
    assertTrue(list.contains("Cat"));
  }

  @Test
  public void toArray() {
    Object[] testArray = list.toArray();
    assertEquals("Dog", testArray[0]);
  }

  @Test
  public void size() {
    assertEquals(1, list.size());
  }

  @Test
  public void isEmpty() {
    assertFalse(list.isEmpty());
    list.remove(0);
    assertTrue(list.isEmpty());
  }

  @Test
  public void indexOf() {
    assertEquals(0, list.indexOf("Dog"));
  }

  @Test
  public void contains() {
    assertTrue(list.contains("Dog"));
    assertFalse(list.contains("Monkey"));
  }

  @Test
  public void get() {
    assertEquals("Dog", list.get(0));
    try {
      list.get(47);
      fail();
    } catch (IndexOutOfBoundsException ex) {
      assertTrue(true);
    }
  }

  @Test
  public void remove() {
    list.remove(0);
    assertEquals(0, list.size());
    assertFalse(list.contains("Dog"));
  }

  @Test
  public void clear() {
    list.clear();
    assertEquals(0, list.size());
    assertFalse(list.contains("Dog"));
  }

  @Test
  public void removeDuplicates() {
    list.add("Cat");
    list.add("Dog");
    list.add("Monkey");
    list.add("Monkey");
    list.removeDuplicates();
    Arrays.stream(list.toArray()).forEach(s -> System.out.println(s));
    assertTrue(Arrays.equals(new String[]{"Dog", "Cat", "Monkey"}, list.toArray()));
  }
}