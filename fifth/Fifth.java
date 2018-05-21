package fifth;

import fifth.exceptions.*;


class Fifth {

    public static void main(String[] args) {
        boolean same_size = false, same_size_error = false;
        VectorClass v1 = new VectorClass();
        VectorClass v2 = new VectorClass();
        while(!same_size) {
            v1.setVector();
            v1.printVector();
            v2.setVector();
            v2.printVector();
            try {
                if (v1.getSize() != v2.getSize()) {
                    same_size_error = true;
                    throw new WektoryRoznejDlugosciException("Vectors have different sizes!", v1.getVector(), v2.getVector());
                }
                if (!same_size_error)
                    same_size = true;
            } catch (WektoryRoznejDlugosciException e) {
                System.err.println(e.getMessage());
                System.err.println("Vector1: " + e.getVector1Length());
                System.err.println("Vector2: " + e.getVector2Length());
                same_size_error = false;
            }
        }
        System.out.println("Vector1: ");
        v1.printVector();
        System.out.println("Vector2: ");
        v2.printVector();
        VectorClass vector_with_sums = new VectorClass(v1, v2);
        System.out.println("Vector3: ");
        vector_with_sums.printVector();
        FileClass file = new FileClass("Vector.txt", vector_with_sums);
        file.Write();
    }
}