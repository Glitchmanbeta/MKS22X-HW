//Windows NT 10.0.10586 "10"
public class Recursion implements hw01{

	/*public static void main(String[]args){
		Recursion x = new Recursion();
		System.out.println(x.name());
		int test = 10;
		System.out.println("Guess: " + x.sqrt(100));
		System.out.println("Actual: 10");
	}*/

	public String name(){
		return "Almawaldi,Sammy";
	}

	public double sqrt(double n){
		return sqrtFormula(n, 1);
	}

	private double sqrtFormula(double n, double guess){
		if(percentError(Math.pow(guess, 2), n) < 0.000001){
			return guess;
		}
		else{
			return sqrtFormula(n, (n / guess + guess) / 2);
		}
	}

	private double percentError(double guess, double actual){
		return Math.abs((guess - actual) / guess) * 100;
	}
}