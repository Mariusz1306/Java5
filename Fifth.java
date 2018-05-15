import java.util.Scanner;
import java.util.Vector;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;

class WektoryRoznejDlugosciException extends Exception {

    private final String vector1;
    private final String vector2;

    public WektoryRoznejDlugosciException(String message, String FirstVector, String SecondVector) {
        super(message);
        this.vector1 = FirstVector;
        this.vector2 = SecondVector;
    }

    public int getVector1Length() { return vector1.length(); }

    public int getVector2Length() { return vector2.length(); }
}

public class Fifth {

    private static Vector <Integer> AddToVector(String string, Vector<Integer> vector){
        int i;
        try{
            for (i = 0; i < string.length(); i++){
                Integer x = string.charAt(i) - '0';
                vector.add(x);
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Someone changed conditions on for loop!");
        }
        return vector;
    }

    private static String ScanForVector(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Input vector as an integer; Press enter to end input");
        String str_vector = scan.next();
        try {
            if(Integer.parseInt(str_vector) < 0)
                str_vector = str_vector.substring(1);
        } catch (NumberFormatException e){
            System.out.println("Input error! Please try again");
            str_vector = ScanForVector();
        }
        return str_vector;
    }

    private static Vector<Integer> VectorAdding(){
        Vector<Integer> SumsVector = new Vector<>();
        try{
            Vector<Integer> vector1 = new Vector<>();
            Vector<Integer> vector2 = new Vector<>();
            String str_vector1 = ScanForVector();
            String str_vector2 = ScanForVector();
            if(str_vector1.length() != str_vector2.length())
                throw new WektoryRoznejDlugosciException("Vectors have different sizes!", str_vector1, str_vector2);
            vector1 = AddToVector(str_vector1, vector1);
            vector2 = AddToVector(str_vector2, vector2);
            for (int i = 0; i < vector1.size(); i++)
                SumsVector.add(vector1.get(i) + vector2.get(i));
        } catch (WektoryRoznejDlugosciException e){
            System.err.println(e.getMessage());
            System.err.println("Vector1: " + e.getVector1Length());
            System.err.println("Vector2: " + e.getVector2Length());
            SumsVector = VectorAdding();
        }
        return SumsVector;
    }

    public static void main(String[] args) {
        try {
            Vector<Integer> SumsVector = new Vector<>();
            SumsVector = VectorAdding();

            /*Professional Debug*/
            for (int i = 0; i < SumsVector.size(); i++)
                System.out.println("SumsVector on " + i + ": " + SumsVector.get(i));
            /*/Professional Debug*/
            Path file = Paths.get("Vector.txt");
            Files.deleteIfExists(file);
            Files.createFile(file);
            for (Integer element : SumsVector) {
                String x = String.valueOf(element);
                Files.write(file, x.getBytes(), StandardOpenOption.APPEND);
                Files.write(file, " ".getBytes(), StandardOpenOption.APPEND);
            }        
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}

//oddzielna klasa dla vectorow i dla plików
