// Koushik Krishnan 9/25 Linear Equation
/*This class will be able to create a linear equation using either a,b,and c or
 *the slope and yIntercept. This equations will be printed out in slope intercept form.
 *It will also be able to return the inverse of a given equation as well as the composition of
 *two equations. It can also find x or y values for an equation given a value for x or y.
*/
public class LinearEquation {
	private double a;
	private double b;
	private double c;
	//build a line based on a,b,c
    public LinearEquation(double a, double b, double c) {
    	this.a = a;
    	this.b = b;
    	this.c = c;
    }
    //builds a line based on slope and yInt
    public LinearEquation(double slope, double yInt){
    	this.a = -slope;
    	this.b = 1;
    	this.c = yInt;
    }
    public LinearEquation(){
    	this.a = 0;
    	this.b = 0;
    	this.c = 0;
    }
	public double getSlope(){
		double slope = (-a)/b;
		return slope;
	}
	public double getYInt(){
		double yInt = c/b;
		return yInt;
	}
	//calculates y values if given x
	public double findY (double xValue) {

		double y = getSlope()*xValue + getYInt();
		return y;
	}
	//calculates x value if given y
	public double findX (double yValue){
		//in a line y=x, if the yValue given is not equal to the xValue in the equation
		//y=x, the result is "undefined" and NotANumber
		if ( -this.a/this.b == 0){
			if ( yValue != this.c/this.b){
				return Double.NaN;
			}
			return Double.POSITIVE_INFINITY;
		}
		return (yValue - (c/b))/getSlope();
	}
	public double getA (){
		return a;
	}
	public double getB (){
		return b;
	}
	public double getC (){
		return c;
	}
	public String toString(){
		String s;
		// vertical line
		if (b == 0){
			s = "x = " + c/a;
			return s;
		}
		//if yInt is 0 and slope is 1
		if (c/b == 0 && -a/b == 1){
			s = "y = " + "x";
			return s;
		}
		// if slope = -1 and yInt is negative
		if ( -1*(a/b) == -1 && c/b < 0){
			s = "y = " + "-x " + c/b;
			return s;
		}
		//if slope = 1 and yInt is negative
		if (-1*(a/b) == 1 && c/b < 0){
			s = "y = " + "x" + c/b;
			return s;
		}
		// if slope is 0 and yInt is negative
		if (c/b < 0 && -a/b == 0){
			s = "y = " + "x " + c/b;
			return s;
		}
		//if slope is 1
		if (-1*(a/b) == 1){
			s = "y = " + "x + " + c/b;
			return s;
		}
		// if slope -1
		if ( -a/b == -1){
			s = "y = " + "-x + " + c/b;
			return s;
		}
		//if yInt is negative
		if ( c/b < 0){
			s = "y = " + -a/b + "x " + c/b;
			return s;
		}
		//if slope is 0
		if ( -a/b == 0){
			return s = "y = " + c/b;
		}
		//if yInt is 0
		if ( c/b == 0){
			s = "y = " + -a/b + "x";
			return s;
		}

		return "y = " + -a/b + "x + " + c/b;
		}
	//find inverse of an equation
	public LinearEquation inverse(){
		LinearEquation i = new LinearEquation(-b/a, c/a);
		return i;
	}
	// find composition t(f(x)) assuming f is this object
	public LinearEquation composition(LinearEquation t){

		double newA = -1*a*t.getA();
		double newB = b*t.getB();
		double newC = t.getC()*b - t.getA()*c;
		LinearEquation d = new LinearEquation(newA, newB, newC);

		return d;
	}


}//Linear