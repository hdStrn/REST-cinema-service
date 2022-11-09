package cinema.errors;

public class WrongPasswordException extends RuntimeException {

    public WrongPasswordException() {
        super("The password is wrong!");
    }
}
