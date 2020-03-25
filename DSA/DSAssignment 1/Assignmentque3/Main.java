package que3;
import java.util.*;

/**
 * This class contains the main method for generating polynomial
 */
public class Main {
	public static void  main(String[] args){
		
		List<Term> termList= new ArrayList<>();
		
		List<Variable> var1= new ArrayList<>();
		var1.add(new Variable('x',2));
		var1.add(new Variable('y', 1));
		var1.add(new Variable('z', 1));
		
		List<Variable> var2= new ArrayList<>();
		var2.add(new Variable('x',3));
		var2.add(new Variable('y', 1));
		var2.add(new Variable('z', 0));
		
		Term term1= new Term(2, var1);
		Term term2= new Term(3, var2);
		
		termList.add(term1);
		termList.add(term2);
		
		MultivariatePolynomial polynomialObject= new MultivariatePolynomial(termList);
		String polynomialString= polynomialObject.toString();
		
		System.out.println("Multivariable Polynomial = " + polynomialString);
		System.out.println("Degree = " + polynomialObject.calculatePolynomialDegree());
	
	}
}