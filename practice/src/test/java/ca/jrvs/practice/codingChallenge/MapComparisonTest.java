package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import ca.jrvs.practice.dataStructure.map.HashJMap;
import ca.jrvs.practice.dataStructure.map.JMap;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class MapComparisonTest {

  @Test
  public void compareMaps() {
    MapComparison mapComparison = new MapComparison();
    Map<Integer, String> map1 = new HashMap<>();
    map1.put(12, "hello");
    Map<Integer, String> map2 = new HashMap<>();
    map2.put(12, "hello");
    assertTrue(mapComparison.compareMaps(map1, map2));

    map1.put(7, "world");
    assertFalse(mapComparison.compareMaps(map1, map2));
  }

  @Test
  public void CompareJMaps() {
    MapComparison mapComparison = new MapComparison();
    JMap<Integer, String> map1 = new HashJMap<>();
    map1.put(12, "hello");
    JMap<Integer, String> map2 = new HashJMap<>();
    map2.put(12, "hello");
    assertTrue(mapComparison.compareJMaps(map1, map2));

    map1.put(7, "world");
    assertFalse(mapComparison.compareJMaps(map1, map2));
  }
}