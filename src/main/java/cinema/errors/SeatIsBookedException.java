package cinema.errors;

public class SeatIsBookedException extends RuntimeException {

    public SeatIsBookedException() {
        super("The ticket has been already purchased!");
    }
}
