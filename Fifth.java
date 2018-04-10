import java.util.Scanner;
import java.util.Vector;

class WektoryRoznejDlugosciException extends Exception {

    public WektoryRoznejDlugosciException(String message) {
        super(message);
	}
}

public class Fifth {

	static int CheckLeadingZeros(String vector){
		int i, LeadingZeros=0;
		for (i = 0; i < vector.length(); i++){
			if(vector.charAt(i)=='0')
				LeadingZeros++;
			else 
				break;
		}
		return LeadingZeros;
	}

	static Vector AddToVector(Vector vector, int number){
		while(number>0){
			vector.add(number%10);
			number=number/10;
		}
		return vector;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Vector<Integer> vector1 = new Vector<>();
		Vector<Integer> vector2 = new Vector<>();
		System.out.println("Podaj dwa wektory jako liczby; Podawanie werktora zakonczone jest enterem");
		String str_vector1 = scan.next();
		String str_vector2 = scan.next();
		int int_vector1 = Integer.parseInt(str_vector1);
		int int_vector2 = Integer.parseInt(str_vector2);
		
		vector1 = AddToVector(vector1, int_vector1);
		vector2 = AddToVector(vector2, int_vector2);
		
		/*Professional Debug*/
		System.out.println(str_vector1);
		System.out.println(str_vector2);
		System.out.println(CheckLeadingZeros(str_vector1));
		System.out.println(CheckLeadingZeros(str_vector2));
		for (int i = 0; i < vector1.size(); i++)
			System.out.println(vector1.get(i));
		/*/Professional Debug*/
	}
}
