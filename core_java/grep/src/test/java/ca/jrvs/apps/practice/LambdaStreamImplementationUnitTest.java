package ca.jrvs.apps.practice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LambdaStreamImplementationUnitTest {

  private LambdaStreamImplementation lambdaStream;
  private final ByteArrayOutputStream sout = new ByteArrayOutputStream();

  @Before
  public void setUp() throws Exception {
    lambdaStream = new LambdaStreamImplementation();
    System.setOut(new PrintStream(sout));
  }

  @After
  public void tearDown() throws Exception {
    System.setOut(System.out);
  }

  @Test
  public void createStrStream() {
    Stream<String> testStream = lambdaStream.createStrStream("a", "b", "c");
    assertEquals("a b c stream should collect to abc", "abc", testStream.collect(Collectors.joining("")));
  }

  @Test
  public void toUpperCase() {
    Stream<String> testStream = lambdaStream.toUpperCase("a", "b", "c");
    assertEquals("a b c stream should collect and uppercase to ABC", "ABC",
        testStream.collect(Collectors.joining("")));
  }

  @Test
  public void filter() {
    Stream<String> testStream2 = lambdaStream.createStrStream("cat", "dog", "albatross", "monkey");
    assertEquals("a b c stream filtered on .*a.* should collect to dogmonkey", "dogmonkey",
        lambdaStream.filter(testStream2, ".*a.*").collect(Collectors.joining("")));
  }

  @Test
  public void createIntStream() {
    IntStream testStream = lambdaStream.createIntStream(new int[]{1, 2, 3});
    assertEquals("1 2 3 stream should sum to 6", 6, testStream.sum());
  }

  @Test
  public void toList() {
    List<String> testList = Arrays.asList("a","b","c");
    Stream<String> testStream = lambdaStream.createStrStream("a", "b", "c");
    assertTrue(testList.equals(lambdaStream.toList(testStream)));
  }

  @Test
  public void toListInt() {
    List<Integer> testList = Arrays.asList(1,2,3);
    IntStream testStream = lambdaStream.createIntStream(new int[]{1, 2, 3});
    assertTrue(testList.equals(lambdaStream.toList(testStream)));
  }

  @Test
  public void createIntStreamRange() {
    IntStream testStream = lambdaStream.createIntStream(4, 6);
    assertEquals("4 5 6 stream should sum to 15", 15, testStream.sum());
  }

  @Test
  public void squareRootIntStream() {
    IntStream testStream = lambdaStream.createIntStream(new int[]{4, 9, 16});
    assertEquals("4 9 16 stream should sum to 9", 9.0, lambdaStream.squareRootIntStream(testStream).sum(), 0.0);
  }

  @Test
  public void getOdd() {
    IntStream testStream = lambdaStream.createIntStream(new int[]{1, 2, 3});
    assertEquals("1 2 3 stream should filter and sum to 4", 4, lambdaStream.getOdd(testStream).sum());
  }

  @Test
  public void getLambdaPrinter() {
    Consumer<String> testPrinter = lambdaStream.getLambdaPrinter("a", "c");
    testPrinter.accept("b");
    assertEquals("a c printer should output abc on b","abc", sout.toString());
  }

  @Test
  public void printMessages() {
    String[] testArray = new String[]{"1", "2", "3"};
    Consumer<String> testPrinter = lambdaStream.getLambdaPrinter("Printing ", " now\n");
    lambdaStream.printMessages(testArray, testPrinter);
    assertEquals("Printing now printer should output \"Printing i now\" on each i in testArray", "Printing 1 now\nPrinting 2 now\nPrinting 3 now\n", sout.toString());
  }

  @Test
  public void printOdd() {
    IntStream testStream = lambdaStream.createIntStream(new int[]{1, 2, 3});
    Consumer<String> testPrinter = lambdaStream.getLambdaPrinter("Odd number: ", "\n");
    lambdaStream.printOdd(testStream, testPrinter);
    assertEquals("Odd number printer should output \"Odd number: i\" on each odd i in the testStream", "Odd number: 1\nOdd number: 3\n", sout.toString());
  }

  @Test
  public void flatNestedInt() {
    List<Integer> listPart1 = Arrays.asList(1, 2, 3);
    List<Integer> listPart2 = Arrays.asList(4, 5, 6);
    Stream<List<Integer>> testStream = Arrays.asList(listPart1, listPart2).stream();
    assertEquals("[1 2 3], [4 5 6] stream squared should sum to 91", new Integer(91), (Integer) lambdaStream.flatNestedInt(testStream).reduce(0, (total, current) -> total + current));
  }
}