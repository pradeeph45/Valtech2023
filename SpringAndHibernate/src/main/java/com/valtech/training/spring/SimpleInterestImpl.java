package com.valtech.training.spring;

public class SimpleInterestImpl implements SimpleInterest {
	public SimpleInterestImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Arithmetic arithmetic;

	

	public SimpleInterestImpl(Arithmetic arithmetic2) {
		this.arithmetic=arithmetic2;
	}

	public void setArithmetic(Arithmetic arithmetic) {
		this.arithmetic = arithmetic;
	}

	public double computeSimpleInterest(int prin, int roi, int duration){
		int result = arithmetic.mul(prin, roi);
		result = arithmetic.mul(result, duration);
		return arithmetic.div(result, 100);
	}

	public static void main(String[] args) {
		Arithmetic arithmetic=new ArithmeticImpl();
		SimpleInterest s1=new SimpleInterestImpl(arithmetic);
		System.out.println(s1.computeSimpleInterest(200, 3, 4));
	}
}
