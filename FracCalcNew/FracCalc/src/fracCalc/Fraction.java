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

	public Fraction handleOperation(String oper, Fraction f) {
		int whole = 0;
		int denom = 1;
		int num = 0;

		// rewrite - as + of negatives and / as * of reciprocal
		if (oper.equals("-")) {
			oper = "+";
			if (f.whole == 0) {
				f.num *= -1;
			} else {
				f.whole *= -1;
			}
		} else if (oper.equals("/")) {
			if (f.whole < 0) {
				f.num *= -1;
			}
			oper = "*";
			f.num = toImproperFracNumerator(f.whole, f.num, f.denom);
			f.whole = 0;
			int temp = f.denom;
			f.denom = f.num;
			f.num = temp;
			if (f.denom < 0) {
				f.num *= -1;
				f.denom *= -1;
			}
		}

		// when a whole number is negative transfer the sign to the numerator
		if (this.whole < 0) {
			this.num *= -1;
		}
		if (f.whole < 0) {
			f.num *= -1;
		}

		// add the whole part to the numerator so we only need to add the two fractions
		this.num += this.whole * this.denom;
		this.whole = 0;
		f.num += f.whole * f.denom;
		f.whole = 0;

		// we only implement two operations + and *
		if (oper.equals("+")) {
			whole = this.whole + f.whole;
			denom = this.denom * f.denom;
			num = 0;
			if (this.denom != denom) {
				num += this.num * (denom / this.denom);
			} else {
				num += this.num;
			}
			if (f.denom != denom) {
				num += f.num * (denom / f.denom);
			} else {
				num += f.num;
			}
		} else if (oper.equals("*")) {
			denom = this.denom * f.denom;
			num = toImproperFracNumerator(this.whole, this.num, this.denom) * toImproperFracNumerator(f.whole, f.num, f.denom);
			whole = num / denom;
			num = num % denom;
		}

		Fraction result = new Fraction(whole, num, denom);
		return result;
	}

	public static int toImproperFracNumerator(int number, int numerator, int denominator) {
		int mixedNumerator = (number * denominator + numerator);
		return mixedNumerator;
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

	public static int lcd(int x, int y) {
		int result = x * y;
		for (int i = 2; i <= min(x, y); i++) {
			if (isDivisibleBy(x, i) && isDivisibleBy(y, i)) {
				result = i;
			}
		}
		return result;
	}

	public static double absValue(double operand1) {
		if (operand1 > 0) {
			return operand1;
		} else {
			return operand1 * -1;
		}
	}

	public static int gcf(int x, int y) {
		int result = 1;
		for (int i = 1; i <= absValue(min(x, y)); i++) {
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
		// when both the whole part and numerator part are negative we only need to
		// return the whole as negative
		if (this.whole < 0 && this.num < 0) {
			this.num *= -1;
		}

		// if there is no fractional part just return the whole part
		if (this.num == 0) {
			return "" + this.whole;
		}
		if (this.whole == 0) {
			return this.num + "/" + this.denom;
		}
		return this.whole + "_" + this.num + "/" + this.denom;
		
	}
}
