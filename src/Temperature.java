//Koushik Krishnan Period 5
/*This program will test the functions of class LinearEquation. It will
 *also be able to convert between degrees F to degrees C and bewtween
 *degrees F and Kelvin
*/
public class Temperature {
	private LinearEquation f2c;
	private LinearEquation c2k;
	public Temperature (){
		f2c = new LinearEquation(1.8, 32);
		c2k = new LinearEquation(1, 273.15);
	}
	//finds F given kelvin
    public String KelvinToF(double K){
		LinearEquation w = c2k.inverse().composition(f2c);
		return w.findY(K) + " degrees Fahrenheit";
	}
	//finds Kelvin given F
	public String FToKelvin(double F){
		LinearEquation w = f2c.inverse().composition(c2k);
		return w.findY(F) + " Kelvin";
	}
	//calculates F given C
	public String FindF(double C){
		return f2c.inverse().findX(C) + " degrees Celcius";
	}
	//calculates C given F
	public String FindC(double F){
		return f2c.findX(F) + " degrees Fahrenheit";
	}
    // TESTER METHODS
    public String testConstructor1(){
		LinearEquation f = new LinearEquation (4.5, 32);
		return f.toString();
	}
	public String testConstructor2(){
		LinearEquation b = new LinearEquation (5,0,3);
		return b.toString();
	}
	public String testFindXAndY(){
		LinearEquation d = new LinearEquation (0,3);
		return "In the equation " + d.toString() + ", y = " + d.findY(7) + " when x is 7. And x = " + d.findX(3) + " when y is 3";
	}
	public LinearEquation testInverse(){
		LinearEquation e = new LinearEquation (3,4);
		return e.inverse();
	}
	public String testComposition(){
		LinearEquation f = new LinearEquation(2,-3);
		return "The composition of " + f.toString() + " and "+ f.inverse() + " is " + f.composition(f.inverse());
	}

public static void main(String [] agrs){

	Temperature t = new Temperature();
		//print all tester methods
		System.out.println(t.testConstructor1());
		System.out.println(t.testConstructor2());
		System.out.println(t.testFindXAndY());
		System.out.println(t.testInverse());
		System.out.println(t.testComposition());

		System.out.println("---------------------");
		//print all methods relating to temperature conversions
		System.out.println(t.FindF(100));
		System.out.println(t.FindC(212));
		System.out.println(t.KelvinToF(10));
		System.out.println(t.FToKelvin(400));



}
}