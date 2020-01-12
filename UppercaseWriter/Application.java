import java.io.FileReader;
import java.io.IOException;

public class Application{

    public static void main(String[]args) throws IOException{
        FileReader fileReader = new FileReader("ipsum.txt");
        UppercaseFileWriter uppercaseFileWriter = new UppercaseFileWriter("ipsum-uppercase.txt");
        int x = fileReader.read();
        while(x>0){
            uppercaseFileWriter.write(x);
            x = fileReader.read();
        }
        fileReader.close();
        uppercaseFileWriter.close();
        
    }
}