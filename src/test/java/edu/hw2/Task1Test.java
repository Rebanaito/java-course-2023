package edu.hw2;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task1Test {
	@Test
	@DisplayName("Normal tests")
	void normalTests() {
		var seven = new Expr.Constant(7);
		assertThat(seven.evaluate()).isEqualTo(7);

		var neg = new Expr.Negate(seven);
		assertThat(neg.evaluate()).isEqualTo(-7);

		var add = new Expr.Addition(seven, neg);
		assertThat(add.evaluate()).isEqualTo(0);

		var mul = new Expr.Multiplication(seven, neg);
		assertThat(mul.evaluate()).isEqualTo(-49);

		var exp = new Expr.Exponent(new Expr.Constant(2), 10);
		assertThat(exp.evaluate()).isEqualTo(1024);
	}

	@Test
	@DisplayName("Edge cases")
	void edgeCases() {
		var negativeExp = new Expr.Exponent(new Expr.Constant(2), -5);
		assertThat(negativeExp.evaluate()).isEqualTo(1.0 / 32.0);

		var zeroExp = new Expr.Exponent(new Expr.Constant(-17), 0);
		assertThat(zeroExp.evaluate()).isEqualTo(1);

		var negMul = new Expr.Multiplication(new Expr.Constant(-4), new Expr.Constant(-5));
		assertThat(negMul.evaluate()).isEqualTo(20);
	}
}