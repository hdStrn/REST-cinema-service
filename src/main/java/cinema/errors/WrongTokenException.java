package cinema.errors;

public class WrongTokenException extends RuntimeException {

    public WrongTokenException() {
        super("Wrong token!");
    }
}
