package fifth.exceptions;

import java.util.Vector;

public class WektoryRoznejDlugosciException extends RuntimeException {

    private final Vector<Integer> vector1;
    private final Vector<Integer> vector2;

    public WektoryRoznejDlugosciException(String message, Vector<Integer> FirstVector, Vector<Integer> SecondVector) {
        super(message);
        this.vector1 = FirstVector;
        this.vector2 = SecondVector;
    }

    public int getVector1Length() { return vector1.size(); }

    public int getVector2Length() { return vector2.size(); }
}