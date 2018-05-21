package fifth;

import java.util.Vector;
import java.util.Scanner;

class VectorClass {
    private Vector <Integer> vector;

    VectorClass(){
        vector = new Vector<>();
    }

    VectorClass(VectorClass vector1, VectorClass vector2){
        setVector(vector1, vector2);
    }

    public Vector<Integer> getVector() {
        return vector;
    }

    public void setVector() {
        int i;
        boolean is_proper_number = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Input vector as an integer; Press enter to end input");
        String str_vector = scan.next();
        try {
            Integer.parseInt(str_vector);
            is_proper_number = true;
            if((str_vector.charAt(0)=='+')||(str_vector.charAt(0)=='-'))
                str_vector = str_vector.substring(1);
        } catch (NumberFormatException e){
            System.out.println("Input error! Please try again");
            this.setVector();
        }
        if (is_proper_number) {
            Vector<Integer> v = new Vector<>();
            for (i = 0; i < str_vector.length(); i++) {
                Integer x = str_vector.charAt(i) - '0';
                v.add(x);
            }
            this.vector = v;
            System.out.println("Vector set successfully");
        }
    }

    private void setVector(VectorClass vector1, VectorClass vector2){
        Vector <Integer> v = new Vector<>();
        for (int i = 0; i < vector1.getSize(); i++)
            v.add(vector1.vector.get(i) + vector2.vector.get(i));
        this.vector = v;
    }

    public int getSize(){
        return vector.size();
    }

    void printVector(){
        for (int i = 0; i < this.getSize(); i++)
            System.out.print(vector.elementAt(i) + " ");
        System.out.println();
    }

    public int getElementAt(int i){
        return vector.elementAt(i);
    }
}
