package Day2;

public class ArithmeticImpl implements Arithmetic {

	public ArithmeticImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
	
		return a-b;
	}

	@Override
	public int mul(int a, int b) {
		
		return a*b;
	}

	@Override
	public int div(int a, int b) throws DivideByZeroException {
		if(b==0) {
			throw new DivideByZeroException("Zero cannot be used as denominator");
		}
		return a/b;
		
	}
	public static void main(String[] args)  {
		Arithmetic a=new ArithmeticImpl();
		System.out.println(a.add(2, 3));
		System.out.println(a.sub(4, 3));
		System.out.println(a.mul(2, 3));
		try {
			System.out.println(a.div(6, 0));
			
		} catch (DivideByZeroException e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("Always will be seen");
		}
	}

}
