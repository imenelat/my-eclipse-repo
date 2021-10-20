package demo;

public class ExceptionHandlingDemo {

	public static void main(String[] args) {

		try {
			System.out.println("hello world");
			int i = 1/0;
			System.out.println("completed");

		} catch (Exception exp) {
			System.out.println("hkemtek");
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		finally {
			System.out.println("completed finally");
		}
	}
}
