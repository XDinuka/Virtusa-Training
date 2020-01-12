import java.io.*;

public class UppercaseFileWriter extends FileWriter {

    public UppercaseFileWriter(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void write(int c) throws IOException {
        if (97 <= c && c <= 122) {
            c -= 32;
        }
        super.write(c); 
    }

}