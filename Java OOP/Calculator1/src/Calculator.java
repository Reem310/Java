import java.util.Scanner;

public class Calculator implements java.io.Serializable{
	private double operand1;
	private double operand2;
	private char operator;
	private double result;
	
	public Calculator() {
	}
	
	public void calculator() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the first number");
		operand1 = input.nextDouble();
        System.out.println("Enter the second number");
        operand2 = input.nextDouble();
        System.out.println("Enter operator(+ or -)");
        operator = input.next().charAt(0);
        performOperation();
        input.close();
	}
	public void setOperandOne(double operand1) {
		this.operand1 = operand1;
	}
	public void setOperation(char operator) {
		this.operator = operator;
	}
	public void setOperandTwo(double operand2) {
        this.operand2 = operand2;
	}
	public void performOperation() {
		switch (operator) {
		case '+':
			result = operand1 + operand2;
			break;
		case '-':
			result = operand1 - operand2;
			break;
		default:
	        System.out.println("*Invalid operator!");
	        calculator();
	        break;
		}
	}
	public double getResults() {
		return result;
	}
}
