package org.howard.edu.lsp.assignment7;
import java.util.*;
import java.lang.Math;
import java.util.ArrayList;


/**
 * 
 * @author sarim
 *
 */
public class Polynomial {
	private ArrayList<Term> polynomial = new ArrayList<Term>();
	
	public Polynomial(){
	}
	
	
/**
 * 	
 * @param c: User inputs an int coefficient value
 * @param e: User inputs an int exponent value
 * The method will use both values to construct a term object and store it in the polynomial arraylist
 */
	public void addTerm(int c, int e) {
		Term p = new Term(c,e);
		this.polynomial.add(p);
	}
	/**
	 * @param c: User inputs an int coefficient value
	 * @param e: User inputs an int exponent value
	 * 
	 * Method will traverse through the list and checks the term with both the given coefficient and exponent
	 * If so, it will be removed from list and stored in a variable, where it will eventually be deleted again
	 * If the variable is still null, it prints a message that there is no such term in polynomial
	 */
	public void delete(int c, int e) {
		int n = this.polynomial.size();
		Term a = null;
		for (int i = 0; i<n; i++) {
			if (this.polynomial.get(i).accessCoeff() == c & this.polynomial.get(i).accessExp() == e) {
				a = this.polynomial.remove(i);
				break;
			}
		}
		if (a==null) {
			System.out.println("No such term in polynomial");
		}
		else {
			a = null;
			System.out.println("Successfully deleted term");
		}
			}

	/**
	* This method will sort the array in a way that it displays the polynomial in decreasing degree
	* This code will use a bubble sort algorithm which will iterate through the array and compare two indices
	* if the higher index value has a larger exponent degree, then it swaps places
	*/	
	public void reversed() {
		int n = this.polynomial.size();
		for (int i=1; i<n; i++) {
			for (int j=0; j<n-1; j++) {
				if (this.polynomial.get(j).accessExp()<this.polynomial.get(j+1).accessExp()) {
					Collections.swap(this.polynomial, j, j+1);
					
				}
			}
		}
	}
	/**
	* It will first traverse through the array one index at a time
	* If the coefficient of a term is 0, it will be ommitted
	* Negative coefficients will retain their - sign, while positive coefficients will obtain a + sign to follow along
	* Positive terms that appear first will not have a sign preceding it
	* 
	* @return q: a polynomial expression in string format
	*/	
	public String equation(){
		String q = "";
		int n = this.polynomial.size();
		for (int i=0; i<n; i++) {
			if (this.polynomial.get(i).accessCoeff() == 0) {
				q = q;
			}
			else {
				if (this.polynomial.get(i).accessCoeff() < 0){
					q = q + this.polynomial.get(i).toString();
				}
				else {
					if (i==0) {
						q = this.polynomial.get(i).toString();
					}
					else {
						q = q + "+"+ this.polynomial.get(i).toString();
				}
				
			}
		}
	}
		return q;

	}
	/**
	 * 
	 * @param var: User provides an int value which will be calculated in the polynomial
	 * Following PEMDAS, first the method will multiply the variable by itself a number of _exp_ times as given from the term
	 * Next, it will multiply the new value by the coefficient
	 * It will be stored in a variable
	 * The method will traverse through the next index of the array, repeat the process of multiplying, and add to the value from the previous term
	 * Repeat until all terms are calculated
	 * @return b: the final calculation of the polynomial
	 */
	public int calculate(int var){
		int n = this.polynomial.size();
		int b = 0;
		for (int i = 0; i< n; i++) {
			int a = (int) Math.pow(var, this.polynomial.get(i).accessExp());
			a = a * this.polynomial.get(i).accessCoeff();
			b = b + a;
			
		}
		
		return b;
		
	}


}
