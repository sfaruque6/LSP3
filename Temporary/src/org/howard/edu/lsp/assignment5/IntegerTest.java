package org.howard.edu.lsp.assignment5;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntegerTest extends junit.framework.TestCase  {
	private IntegerSet test1 = new IntegerSet();
	private IntegerSet test2 = new IntegerSet();

@BeforeEach
protected void init() {
	test1 = new IntegerSet();
	test2 = new IntegerSet();
}


@Test
@DisplayName("Test case for adding values to sets")
public void testAdd() throws IntegerSetException {
	test1.add(1);
	test2.add(2);
	test2.add(4);
	Assertions.assertFalse(test1.isEmpty());
	Assertions.assertFalse(test2.isEmpty());
	Assertions.assertEquals(1,test1.peek());
	Assertions.assertEquals(4,test2.peek());		
}
/**
 * This test will check if the clear() method works properly
 * First we add a value, then we use the clear() method
 * We will assert if true that the set is empty to prove it works
 */
@Test
@DisplayName("Test case for clearing sets")
public void testClear() {
	test1.add(1);
	test1.clear();
	Assertions.assertTrue(test1.isEmpty());
}

/**
 * This test will check if the length() method works properly
 * First, we will add three values to a set
 * After that, we will check if length() returns a 3; if so, then the method works
 */
@Test
@DisplayName("Test case for checking length of set")
public void testLength() {
	test1.add(1);
	test1.add(2);
	test1.add(3);
	Assertions.assertEquals(3,test1.length());
}
/**
 * This test will check if the contain() method works
 * First, we will add values from 0 to 30 in multiples of 3
 * We will verify that 12 is in the set, but not 5
 */
@Test
@DisplayName("Test case for checking if a given value is contained in a set")
public void testContains() {
	
	for (int i = 0; i < 31; i+= 3) {
		test1.add(i);
	}
	Assertions.assertTrue(test1.contains(12));
	Assertions.assertFalse(test1.contains(5));
}

/**
 * 
 * @throws IntegerSetException
 */

@Test
@DisplayName("Test case for removing a specified item in a set")
public void testRemove() throws IntegerSetException{
	
	test1.add(4);
	test1.add(5);
	test1.remove(4);
	Assertions.assertFalse(test1.contains(4));
}

@Test
@DisplayName("Test case for checking intersections")
public void testIntersect() {
	ArrayList<Integer> intersect = new ArrayList<Integer>();
	for (int i = 0; i<41; i+= 12) {
		intersect.add(i);
	}
	intersect.sort(null);
	for (int i = 0; i<41; i+= 4) {
		test1.add(i);
	}
	for (int j = 0; j<41; j+=3) {
		test2.add(j);
	}
	Assertions.assertEquals(intersect,test1.intersect(test2));
}

@Test
@DisplayName("Test case for checking unions")
public void testUnion() {
	ArrayList<Integer> union = new ArrayList<Integer>();
	for (int i = 0; i<41; i+= 4) {
		union.add(i);
	}
	for (int j = 0; j<31; j+=3) {
		if(!union.contains(j)) {
			union.add(j);
		}
	}
	union.sort(null);
	for (int i = 0; i<31; i+= 3) {
		test1.add(i);
	}
	for (int j = 0; j<41; j+=4) {
		test2.add(j);
	}
	Assertions.assertEquals(union,test1.union(test2));
}

@Test
@DisplayName("Test case for checking differences")
public void testDifference() {
	ArrayList<Integer> difference = new ArrayList<Integer>();
	for (int i = 0; i<41; i+= 3) {
		if (i%4!=0) {
			difference.add(i);
		}
		}
	difference.sort(null);
	for (int i = 0; i<41; i+= 3) {
		test1.add(i);
	}
	for (int j = 0; j<41; j+=4) {
		test2.add(j);
	}
	Assertions.assertEquals(difference,test1.diff(test2));
}

@Test
@DisplayName("Test case for checking the largest value in a set")
public void testLargest() throws IntegerSetException  {
	for  (int i = 0; i<10; i++) {
		test1.add(i);
	}
	Assertions.assertEquals(9, test1.largest());
}

@Test
@DisplayName("Test case for checking the smallest value in a set")
public void testSmallest() throws IntegerSetException  {
	for  (int i = 0; i<10; i++) {
		test1.add(i);
	}
	Assertions.assertEquals(0, test1.smallest());
}
@Test
@DisplayName("Test case for checking if set is empty")
public void testEmpty() {
	Assertions.assertTrue(test1.isEmpty());
}


@Test
@DisplayName("Test case for checking if arraylist can be successfully converted to string")
public void testToString() {
	test1.add(1);
	test1.add(2);
	test1.add(3);
	String e = "1 2 3 ";
	Assertions.assertEquals(e,test1.toString());
}

@Test
@DisplayName("Test case for checking if two sets are equal")
public void testEqual() {
	for(int i = 0; i < 3; i++) {
		test1.add(i);
		test2.add(i);
	}
	Assertions.assertTrue(test1.equals(test2));
	test2.add(4);
	Assertions.assertFalse(test1.equals(test2));
}
@Test
@DisplayName("Checks if IntegerSetException works")
public void testException() {
	Throwable exception1 = assertThrows(IntegerSetException.class, () -> 
test1.remove(5));
	assertEquals("There are no elements in the arraylist",exception1.getMessage());
	Throwable exception2 = assertThrows(IntegerSetException.class, () -> 
test1.largest());
	assertEquals("There are no elements in the arraylist",exception2.getMessage());
	Throwable exception3 = assertThrows(IntegerSetException.class, () -> 
test1.smallest());
	assertEquals("There are no elements in the arraylist",exception3.getMessage());
		

}

@AfterEach
public void TearDown() {
	test1.clear();
	test2.clear();
}
	

}
