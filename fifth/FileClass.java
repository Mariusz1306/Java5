package fifth;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

class FileClass {
    private String path;
    private VectorClass vector;

    public FileClass(String path, VectorClass vector) {
        this.path = path;
        this.vector = vector;
    }

    public String getPath() {
        return path;
    }

    private void setPath(String path) {
        this.path = path;
    }

    public VectorClass getVector() {
        return vector;
    }

    private void setVector(VectorClass vector) {
        this.vector = vector;
    }

    public void Write(){
        try {
            Path file = Paths.get(getPath());
            Files.deleteIfExists(file);
            Files.createFile(file);
            for (int i = 0; i < vector.getSize(); i++) {
                String x = String.valueOf(vector.getElementAt(i));
                Files.write(file, x.getBytes(), StandardOpenOption.APPEND);
                Files.write(file, " ".getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
