package org.howard.edu.lsp.assignment7;


public class Term {
	private int c;
	private int exp;
	
	/**
	*@param c: User inputs an int coefficient value
	*@param exp: User inputs an int exponent value
	*
	*if the exponent value is less than 0; the exponent will automatically change to 0 
	*/
	public Term(int c, int exp) {
		this.c = c;
		if (exp < 0) {
			this.exp = 0;
		}
		else {
			this.exp = exp;
		}
	}
	
	/**
	 *
	 * @return c: Returns the coefficient value of the term
	 */
	public int accessCoeff() {
		return c;
	}

	/**
	 *
	 * @return exp: Returns the exponent value of the term
	 */
	public int accessExp() {
		return exp;
	}
	
	/**
	 * @return t: Returns the term in a string format
	 * 
	 * If the coefficient is zero, the entire term will not appear
	 * If the exponent is zero, the variable will not appear
	 * If the exponent is one, the variable will not display the exponent
	 * If the coefficient is one, the term will not display the variable
	 * 
	 * Otherwise, the format will be in ax^b
	 */
	public String toString() {
		String a = String.valueOf(this.c);
		String b = String.valueOf(this.exp);
		String t = null;
		if (this.exp < 2 || this.c < 2) {
			if (this.c == 0) {
				t = "";
			}
			else {
				if (this.c == 1 & this.exp == 1) {
					t = "x";
				}
				else {
					if (this.exp ==0) {
						t = a;
					}
					else {
						if (this.c == 1) {
							t = "x^" + b;
						}
						else {
							t = a + "x";
						}
					}
				}
				
			}
			
		}
		else {
			t = a + "x^" + b;
			}
		
		return t;
	
	}
	
}
		
		
		
		
		