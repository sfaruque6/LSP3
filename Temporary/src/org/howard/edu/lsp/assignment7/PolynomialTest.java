package org.howard.edu.lsp.assignment7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PolynomialTest {
	private Polynomial equation1 = new Polynomial();
	private Polynomial equation2 = new Polynomial();
	private Polynomial equation3 = new Polynomial();

	@BeforeEach
	void setUp() throws Exception {
		Polynomial equation1 = new Polynomial();
		Polynomial equation2 = new Polynomial();
		Polynomial equation3 = new Polynomial();

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Test case for adding terms to the polynomial")
	void testAdd() {
		System.out.println("Testing add cases");
		
		System.out.println("");
		equation1.addTerm(3,2);
		equation1.addTerm(4,4);
		equation1.addTerm(1,6);
		
		equation2.addTerm(2,0);
		equation2.addTerm(5,2);
		equation2.addTerm(6,3);
		equation2.addTerm(2,7);
		
		equation3.addTerm(4,10);
		
		System.out.println("Results");
		
		System.out.println(equation1.equation());
		System.out.println(equation2.equation());
		System.out.println(equation3.equation());

		
		
		
		Assertions.assertEquals("3x^2+4x^4+x^6", equation1.equation(), "Actual polynomials should be equal to expected");
		Assertions.assertEquals("2+5x^2+6x^3+2x^7", equation2.equation());
		Assertions.assertEquals("4x^10", equation3.equation());	
	}
	
	@Test
	@DisplayName("Test case for sorting polynomials in standard form")
	void testReverse() {
		System.out.println("");

		
		System.out.println("Testing reverse cases:");

		
		equation1.addTerm(3,2);
		equation1.addTerm(4,4);
		equation1.addTerm(1,6);
		
		equation2.addTerm(2,0);
		equation2.addTerm(5,2);
		equation2.addTerm(6,3);
		equation2.addTerm(2,7);
		
		equation3.addTerm(4,10);
		
		System.out.println("Original:");

		System.out.println(equation1.equation());
		System.out.println(equation2.equation());
		System.out.println(equation3.equation());
		
		System.out.println("");
		
		equation1.reversed();
		equation2.reversed();
		equation3.reversed();
		
		System.out.println("Reversed:");

		
		System.out.println(equation1.equation());
		System.out.println(equation2.equation());
		System.out.println(equation3.equation());

		
		
		Assertions.assertEquals("x^6+4x^4+3x^2", equation1.equation());
		Assertions.assertEquals("2x^7+6x^3+5x^2+2", equation2.equation());
		Assertions.assertEquals("4x^10", equation3.equation());	
	}
	
	@Test
	@DisplayName("Test case for calculating polynomials")
	void testProduct() {
		
		System.out.println("");
		
		
		equation1.addTerm(3,2);
		equation1.addTerm(4,4);
		equation1.addTerm(1,6);
		
		equation2.addTerm(2,0);
		equation2.addTerm(5,2);
		equation2.addTerm(6,3);
		equation2.addTerm(2,7);
		
		equation3.addTerm(4,10);
		
		int a = equation1.calculate(3);
		int b = equation2.calculate(3);
		int c = equation3.calculate(3);
		
		System.out.println("for equation 1: " +a);
		System.out.println("for equation 2: " +b);
		System.out.println("for equation 3: " +c);

		
		Assertions.assertEquals(1080, a);
		Assertions.assertEquals(4583, b);
		Assertions.assertEquals(236196, c);	
	
	}
	
	@Test
	@DisplayName("Test case for deleting a term from a polynomial")
	void testDeletion() {
		System.out.println("");

		
		System.out.println("Testing delete cases:");

		System.out.println("Original:");

		
		equation1.addTerm(3,2);
		equation1.addTerm(4,4);
		equation1.addTerm(1,6);
		
		equation2.addTerm(2,0);
		equation2.addTerm(5,2);
		equation2.addTerm(6,3);
		equation2.addTerm(2,7);
		
		equation3.addTerm(4,10);
		
		System.out.println(equation1.equation());
		System.out.println(equation2.equation());
		System.out.println(equation3.equation());
		
		System.out.println("");
		
		equation1.delete(4,4);
		equation2.delete(5,3);
		equation3.delete(4,10);
		
		System.out.println("");
		System.out.println("Results:");

		
		System.out.println(equation1.equation());
		System.out.println(equation2.equation());
		System.out.println(equation3.equation());
		
		
		Assertions.assertEquals("3x^2+x^6", equation1.equation());
		Assertions.assertEquals("2+5x^2+6x^3+2x^7", equation2.equation());
		Assertions.assertEquals("", equation3.equation());	
	
	}

}
