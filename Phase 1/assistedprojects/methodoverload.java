package assistedprojects;

public class methodoverload {
	public void area(int c, int d) {
		System.out.println("Area of Triangle : " + (0.5 * c * d));
	}

	public void area(int r) {
		System.out.println("Area of Circle : " + (3.14 * r * r));
	}

	public static void main(String[] args) {
		methodoverload obj = new methodoverload();
		obj.area(10, 12);
		obj.area(5);
	}
}
