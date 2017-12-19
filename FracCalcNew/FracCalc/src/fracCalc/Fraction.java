package fracCalc;

public class Fraction {
	private int whole;
	private int num;
	private int denom;

	public Fraction(int whole, int num, int denom) {
		this.whole = whole;
		this.num = num;
		this.denom = denom;
	}

	public static int min(int operand1, int operand2) {
		if (operand1 > operand2) {
			return operand2;
		} else {
			return operand1;
		}
	}

	public static boolean isDivisibleBy(int operand1, int operand2) {
		if (operand2 == 0) {
			throw new IllegalArgumentException();
		}
		return operand1 % operand2 == 0;
	}

	public static int gcf(int x, int y) {
		int result = 1;
		for (int i = 1; i <= min(x, y); i++) {
			if (isDivisibleBy(x, i) && isDivisibleBy(y, i)) {
				result = i;
			}
		}
		return result;
	}

	public void toMixedNumber() {
		this.whole += this.num / this.denom;
		this.num = this.num % this.denom;
		int factor = gcf(this.num, this.denom);
		this.num /= factor;
		this.denom /= factor;
	}

	public String toString() {
		return "whole:" + this.whole + " numerator:" + this.num + " denominator:" + this.denom;
	}
}
