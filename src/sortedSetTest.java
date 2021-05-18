
/**
 * Author: Clem Francis
 * Software Testing Assignment: Part One
 */

import static org.junit.Assert.*;

import org.junit.*;

import java.util.*;


/**
 * This class contains xx JUnit tests for the Iterator interface. The tests are derived from an
 * IDM (input domain modeling) based on the JavaDoc API for SortedSet<>.
 * The three methods tested are: first() last(), headSet()
 * The following characteristics have been identified and are used to generate tests for the methods:
 * C1: Set contains more than one element
 * C2: Element correctly implements comparable interface type
 * C3: Element is not null
 * C4: Element is not null
 * Each characteristic has a boolean partition
 */

public class sortedSetTest {

    private TreeSet<Object> sortedSet;


    @Before
    public void setUp() {
        sortedSet = new TreeSet<Object>();

        sortedSet.add("Jiangsu");
        sortedSet.add("Guangdong");
        sortedSet.add("Guangxi");
        sortedSet.add("Yunnan");
        sortedSet.add("Sichuan");

    }

    // Test 1 of first(): testFirst_BaseCase(): C1-T
    @Test
    public void testFirst_BaseCase() {
        assertEquals("Guangdong", sortedSet.first());

    }
    // Test 2 of first(): test_FirstC1(): C1-F
    @Test(expected=NoSuchElementException.class)
    public void testFirst_C1() {
        // Remove all elements from list
        sortedSet.clear();
        // Test fails as list is empty
        sortedSet.first();
    }

    // Test from Base-Pair Coverage

    // Test 1 of last(): testLast_BaseCase(): C1-T
    @Test
    public void testLast_BaseCase() {
        assertEquals("Yunnan", sortedSet.last());
    }

    //Test 2 of last(): testLast_C1(): C1 - F
    @Test(expected=NoSuchElementException.class)
    public void testLast_C1() {
        // Remove all elements from list
        sortedSet.clear();
        // Test fails as list is empty
        sortedSet.last();
    }

    // Test 1 of headSet(): testHeadSet_BaseCase(): C1-T,C2-T,C3-T, C4-T
    @Test()
    public void testHeadSet_BaseCase() {
        assertEquals("[Guangdong, Guangxi, Jiangsu]", sortedSet.headSet("Sichuan").toString());
    }

    // Test 2 of headSet(): testHeadSet_C1(): C1-F,C2-T,C3-T,C4-T
    @Test
    public void testHeadSet_C1() {
        sortedSet.clear();
        // Empty Set returns an empty set
        assertEquals("[]", sortedSet.headSet("Sichuan").toString());
    }

    // Test 3 of headSet(): testHeadSet_C2(): C1-T,C2-F,C3-T,C4-T
    @Test(expected = ClassCastException.class)
    public void testHeadSet_C2() {
        // Add a data type that cannot be compared to existing elements in the list, such as Boolean in Set<String>;
        sortedSet.headSet("").add(true);
    }

    // Test 4 of headSet(): testHeadSet_C3(): C1-T,C2-T,C3-F,C4-T
    @Test(expected = NullPointerException.class)
    public void testHeadSet_C3() {
        // Exception if looking for a null in a set
        sortedSet.headSet(null);
    }

    // Test 5 of headSet(): testHeadSet_C4():  C1-T,C2-T,C3-T,C4-F
    @Test(expected = IllegalArgumentException.class)
    public void testHeadSet_C4() {
        // Exception if trying to add an element out of bounds
        // Eg: ["Guangdong", "Guangxi", "Jiangsu" | "Sichuan"] means that "Zhejiang" cannot be added to the left side
        sortedSet.headSet(sortedSet.last()).add("Zhejiang");
    }

    // Tests from Pair-Wise Coverage

    // Test 6 of headSet(): testHeadSet_C2_C4(): C1-T,C2-F,C3-T,C4-F
    @Test(expected = ClassCastException.class)
    public void testHeadSet_C2_C4() {
        // ClassCastException is thrown as SortedSet cannot implement a sorted set of different data types
        sortedSet.headSet(sortedSet.last()).add(1);
    }

    // Test 7 of headSet(): testHeadSet_C3_C4(): C1-T,C2-T,C3-F,C4-F
    @Test(expected = NullPointerException.class)
    public void testHeadSet_C3_C4() {
        // NullPointerException is thrown as a null object cannot be inserted at all
        sortedSet.headSet("Guangdong").add(null);
    }

    // Test 8 of headSet(): testHeadSet_C1_C3: C1-F,C2-T,C3-F,C4-T
    @Test(expected = NullPointerException.class)
    public void testHeadSet_C1_C3() {
        sortedSet.clear();
        // NullPointerException is thrown because null cannot be sorted
        sortedSet.add(null);
    }

    // Test 9 of headSet(): testHeadSet_C1_C2_C3: C1-F,C2-F,C3-F,C4-T
    @Test(expected = NullPointerException.class)
    public void testHeadSet_C1_C2_C3() {
        // NullPointerException is thrown as null cannot be a headset
        sortedSet.headSet(null).add(true);
    }

    // Test 10 of headSet(): testHeadSet_C2_C3_C4: C1-F,C2-F,C3-F,C4-T
    @Test(expected = NullPointerException.class)
    public void testHeadSetC2_C3_C4(){
        sortedSet.clear();
        // NullPointerException is thrown as you cannot add null to a set
        sortedSet.headSet(true).add(null);
    }

}