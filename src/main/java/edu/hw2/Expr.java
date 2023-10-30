package edu.hw2;

public sealed interface Expr {
    double evaluate();

    record Constant(double value) implements Expr {
        public double evaluate() {
            return value;
        }
    }

    record Negate(Expr exp) implements Expr {
        public double evaluate() {
            return -(exp.evaluate());
        }
    }

    record Exponent(Expr exp, int n) implements Expr {
        public double evaluate() {
            if (n < 0) {
                return 1 / exponent(exp.evaluate(), -n);
            }
            return exponent(exp.evaluate(), n);
        }

        private double exponent(double value, int n) {
            if (n == 0) {
                return 1;
            }
            return value * exponent(value, n - 1);
        }
    }

    record Addition(Expr left, Expr right) implements Expr {
        public double evaluate() {
            return left.evaluate() + right.evaluate();
        }
    }

    record Multiplication(Expr left, Expr right) implements Expr {
        public double evaluate() {
            return left.evaluate() * right.evaluate();
        }
    }
}
