package ca.jrvs.practice.codingChallenge;

import ca.jrvs.practice.dataStructure.map.JMap;
import java.util.Map;

/**
 * Class containing functions to determine if two maps are equal
 * Relevant Ticket: https://www.notion.so/How-to-compare-two-maps-fb829761ea1e4d85b65e3ed901a3b0c3
 */
public class MapComparison {

  /**
   * Determine if two maps are equal using Collection.equals()
   * Time Complexity: O(n)
   * Justification: Collection.equals() compares keys and values for every pair in the map
   */
  public <K, V> boolean compareMaps(Map<K, V> m1, Map<K, V> m2) {
    return m1.equals(m2);
  }

  /**
   * Determine if two JMaps are equal using JMAap.equals()
   * Time Complexity: O(n)
   * Justification: JMap.equals() compares keys and values for every pair in the JMap
   */
  public <K, V> boolean compareJMaps(JMap<K, V> m1, JMap<K, V> m2) {
    return m1.equals(m2);
  }
}
