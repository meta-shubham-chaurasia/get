package que3;

/**
 * This class represents a single variable along with its power in a multivariable polynomial
 */
public class Variable {
	int power;
	char variable;

	public Variable(char var, int pow) {
		this.variable = var;
		this.power = pow;
	}

	/**
	 * This method returns the power of the variable
	 * 
	 * @return {int} power of the variable
	 */
	public int getPower() {
		return power;
	}

	/**
	 * This method returns the char value of the variable
	 * 
	 * @return {char} name of the variable
	 */
	public char getVariable() {
		return variable;
	}

}
