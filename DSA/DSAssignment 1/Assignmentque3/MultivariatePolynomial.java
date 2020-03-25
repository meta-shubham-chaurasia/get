package que3;

import java.util.*;

/**
 * This class represents a multivariable polynomial using nested lists of its terms and powers of variable
 */
public class MultivariatePolynomial {

	public List<Term> polynomialTerms = new ArrayList<>();

	/**
	 * Constructor for multivariable polynomial
	 */
	public MultivariatePolynomial(List<Term> terms) {
		this.polynomialTerms = terms;
	}

	/**
	 * Method to calculate the degree of the multivariable polynomial
	 * 
	 * @return int degree of the multivariable polynomial
	 */
	public int calculatePolynomialDegree() {
		int variablePowerSum;
		int degreeOfPolynomial = 0;
		for (Term term : polynomialTerms) {
			variablePowerSum = 0;
			for (Variable variable : term.variableList) {
				variablePowerSum += variable.getPower();
			}
			if (degreeOfPolynomial < variablePowerSum)
				degreeOfPolynomial = variablePowerSum;
		}
		return degreeOfPolynomial;
	}

	/**
	 * The method represents the Multivariable polynomial into string format for better readability
	 * 
	 * @return {String} Multivariable Polynomial
	 */
	public String toString() {

		String polynomial = new String("");
		for (Term term : polynomialTerms) {
			polynomial += term.coefficient;
			for (Variable variable : term.variableList) {
				polynomial = polynomial + "*" + variable.getVariable() + "^" + variable.getPower();
			}
			if (term != polynomialTerms.get(polynomialTerms.size() - 1))
				polynomial = polynomial + " + ";
		}

		return polynomial;
	}

}