package ca.jrvs.practice.dataStructure.list;

import java.util.HashSet;
import java.util.Set;

public class JLinkedList<E> implements JList<E> {

  private class Node<E> {

    E element;
    Node next;

    Node(E element) {
      this.element = element;
      this.next = null;
    }
  }

  private Node root = null;
  private int size = 0;

  /**
   * Appends the specified element to the end of this list (optional operation).
   *
   * @param e element to be appended to this list
   * @return true
   * @throws NullPointerException if the specified element is null and this list does not permit
   *                              null elements
   */
  @Override
  public boolean add(E e) {
    if (root == null) {
      root = new Node(e);
    } else {
      Node current = root;
      while (current.next != null) {
        current = current.next;
      }
      current.next = new Node(e);
    }
    size++;
    return true;
  }

  /**
   * Returns an array containing all of the elements in this list in proper sequence (from first to
   * last element).
   *
   * <p>This method acts as bridge between array-based and collection-based
   * APIs.
   *
   * @return an array containing all of the elements in this list in proper sequence
   */
  @Override
  public Object[] toArray() {
    Object[] array = new Object[size];
    Node current = root;
    for (int i = 0; i < size; i++) {
      array[i] = current.element;
      current = current.next;
    }
    return array;
  }

  /**
   * The size of the ArrayList (the number of elements it contains).
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Returns <tt>true</tt> if this list contains no elements.
   *
   * @return <tt>true</tt> if this list contains no elements
   */
  @Override
  public boolean isEmpty() {
    return (size == 0);
  }

  /**
   * Returns the index of the first occurrence of the specified element in this list, or -1 if this
   * list does not contain the element. More formally, returns the lowest index <tt>i</tt> such
   * that
   * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
   * or -1 if there is no such index.
   *
   * @param o
   */
  @Override
  public int indexOf(Object o) {
    int i = 0;
    Node current = root;
    while (current != null) {
      if (current.element == o) {
        return i;
      } else {
        current = current.next;
        i++;
      }
    }
    return -1;
  }

  /**
   * Returns <tt>true</tt> if this list contains the specified element. More formally, returns
   * <tt>true</tt> if and only if this list contains at least one element <tt>e</tt> such that
   * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
   *
   * @param o element whose presence in this list is to be tested
   * @return <tt>true</tt> if this list contains the specified element
   * @throws NullPointerException if the specified element is null and this list does not permit
   *                              null elements
   */
  @Override
  public boolean contains(Object o) {
    return indexOf(o) >= 0;
  }

  /**
   * Returns the element at the specified position in this list.
   *
   * @param index index of the element to return
   * @return the element at the specified position in this list
   * @throws IndexOutOfBoundsException if the index is out of range (<tt>index &lt; 0 || index &gt;=
   *                                   size()</tt>)
   */
  @Override
  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("ERROR: Index " + index + " is out of bounds");
    }
    Node current = root;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    return (E) current.element;
  }

  /**
   * Removes the element at the specified position in this list. Shifts any subsequent elements to
   * the left (subtracts one from their indices).
   *
   * @param index the index of the element to be removed
   * @return the element that was removed from the list
   * @throws IndexOutOfBoundsException {@inheritDoc}
   */
  @Override
  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("ERROR: Index " + index + " is out of bounds");
    }
    Node current = root;
    Node prev = null;
    for (int i = 0; i < index; i++) {
      prev = current;
      current = current.next;
    }
    E ret = (E) current.element;
    if (prev == null)
      root = current.next;
    else
      prev.next = current.next;
    size --;
    return ret;
  }

  /**
   * Removes all of the elements from this list (optional operation). The list will be empty after
   * this call returns.
   */
  @Override
  public void clear() {
    root = null;
    size = 0;
  }

  /**
   * Function to remove all duplicate nodes in the list
   * Relevant Ticket: https://www.notion.so/Duplicate-LinkedList-Node-1a2e355132494383aa10c4e55d5e09ed
   * Time Complexity: O(n)
   * Justification: Loops through each element in the list, HashSet operations are constant time
   */
  public void removeDuplicates () {
    Set<E> set = new HashSet<>();
    Node current = root;
    Node prev = null;
    for (int i = 0; i <= size(); i++) {
      if(set.contains(current.element)) {
        prev.next = current.next;
        size --;
      } else {
        set.add((E) current.element);
      }
      prev = current;
      current = current.next;
    }
  }
}
