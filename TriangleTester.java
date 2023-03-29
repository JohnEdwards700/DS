// Class for testing our Triangle class

class TriangleTester{
    public static void main(String[] args){
	
	// vvv Declaring the type of the variable
	Triangle myFirstTriangle = new Triangle();
	myFirstTriangle.a = 3;
	myFirstTriangle.b = 4;
	myFirstTriangle.c = 5;
	
	System.out.println("myFirstTriangle = " + myFirstTriangle);

	System.out.println("The area of the triangle is " + myFirstTriangle.area());

	Triangle t2 = new Triangle(5, 12, 13);
	System.out.println("The area of the second triangle is " + t2.area());

	System.out.println("An 8-15-17 triangle has area " + Triangle.area(8, 15, 17));
	System.out.println("An 8-15-17 triangle still has area " + Triangle.area(8, 15));

    }
}
