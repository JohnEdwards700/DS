// This class is meant to just describe a Triangle object
// Not meant to be run.

class Triangle {

  // Three fields of our triangle class
  int a;
  int b;
  int c;

  /** 
	Default constructor - no parameters
    */
  public Triangle() {}

  /** 
	Constructor that takes the sides as parameters
    */
  public Triangle(int side1, int side2, int side3) {
    // the "this" keyword is a reference to the object currently
    // running the method, in this case, a constructor
    this.a = side1;
    this.b = side2;
    this.c = side3;
  }

  /**
       Compute the area of this triangle object
    */
  double area() {
    // Heron's formula
    double s = (a + b + c) / 2.0; // semiperimeter
    // Divide by 2.0 because in Java, int/int rounds to an int
    return Math.sqrt(s * (s - a) * (s - b) * (s - c));
  }

  static double area(int a, int b, int c) {
    // Heron's formula
    double s = (a + b + c) / 2.0; // semiperimeter
    // Divide by 2.0 because in Java, int/int rounds to an int
    return Math.sqrt(s * (s - a) * (s - b) * (s - c));
  }

  // Produces the area of a right triangle with legs a and b
  static double area(int a, int b) {
    return a * b / 2.0 + 10000;
  }
}
