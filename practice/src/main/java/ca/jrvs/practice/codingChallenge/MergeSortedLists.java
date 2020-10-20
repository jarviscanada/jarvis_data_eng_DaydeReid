package ca.jrvs.practice.codingChallenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Class containing functions to merge two sorted lists into a single sorted list
 * Relevant Ticket: https://www.notion.so/Merge-Sorted-Array-2a55a19dfeda4ef48f3032c7cdbe46e0
 */
public class MergeSortedLists {
  /**
   * Merge two sorted lists into one
   * Time Complexity: O(n)
   * Justification: Single loop through all the elements between both lists
   */
  public List<Integer> mergeLists(List<Integer> a, List<Integer> b) {
    List<Integer> mergeList = new ArrayList<>();
    while (a.size() > 0 && b.size() > 0) {
      if(a.get(0) < b.get(0)) {
        mergeList.add(a.get(0));
        a.remove(0);
      } else {
        mergeList.add(b.get(0));
        b.remove(0);
      }
    }
    if(a.size() == 0) {
      for (Integer i : b) {
        mergeList.add(i);
      }
    } else {
      for (Integer i : a) {
        mergeList.add(i);
      }
    }
    return mergeList;
  }
}
