
import java.util.Random;

public class ExceptionExample {

    public static void main(String[] args) {
        
        //Exceptions that extend from RuntimeException is not checked in compile time
        tryCatchExample();
    }

    // using throws to signify that an exception may be thrown 
    private static void tryCatchExample() throws ExampleRuntimeException{
        Random random = new Random();

        //try catch syntax
        try {
            switch (random.nextInt() % 4) {
                case 0:
                    throw new IllegalArgumentException();
                case 1:
                    throw new RuntimeException();
                case 2:
                    throw new Exception();
            }

        } catch (IllegalArgumentException illegalArgumentException) {
            throw new ExampleRuntimeException("Some Error Occured", illegalArgumentException);// Rethrowing
        } catch (RuntimeException runtimeException) {
            throw new ExampleRuntimeException("Some Error Occured", runtimeException);// Rethrowing
        } catch (Exception exception) {
            throw new ExampleRuntimeException("Some Error Occured", exception);// Rethrowing
        }finally{
            System.out.println("Code Executed");
        }
    }
}


class ExampleRuntimeException extends RuntimeException {

    public ExampleRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

}
