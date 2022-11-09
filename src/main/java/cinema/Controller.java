package cinema;

import cinema.errors.SeatIsBookedException;
import cinema.errors.SeatOutOfBoundsException;
import cinema.errors.WrongPasswordException;
import cinema.errors.WrongTokenException;
import cinema.objects.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    private MovieTheatre movieTheatre = new MovieTheatre(9, 9);
    private Statistics statistics = new Statistics(movieTheatre);
    private final String PASSWORD = "super_secret";

    @GetMapping("/seats")
    public MovieTheatre getSeats() {
        return movieTheatre;
    }

    @PostMapping("/purchase")
    public Ticket bookSeat(@RequestBody Seat wantedSeat) {
        if (!wantedSeat.isSeatExists(movieTheatre)) {
            throw new SeatOutOfBoundsException();
        }
        for (Seat seat : movieTheatre.getAvailableSeats()) {
            if (seat.getRow() == wantedSeat.getRow()
                    && seat.getColumn() == wantedSeat.getColumn()) {
                if (seat.isBooked()) {
                    throw new SeatIsBookedException();
                } else {
                    statistics.updateStatAfterPurchase(
                            seat.getPrice(),
                            Ticket.getSoldTickets().size()
                    );
                    seat.setBooked(true);
                    return new Ticket(seat);
                }
            }
        }
        return null;
    }

    @PostMapping("/return")
    public ReturnedTicket returnTicket(@RequestBody Token token) {
        for (Ticket soldTicket : Ticket.getSoldTickets()) {
            if (token.getToken().equals(soldTicket.getToken())) {
                soldTicket.getTicket().setBooked(false);
                Ticket.getSoldTickets().remove(soldTicket);
                statistics.updateStatAfterReturn(
                        soldTicket.getTicket().getPrice(),
                        Ticket.getSoldTickets().size()
                );
                return new ReturnedTicket(soldTicket.getTicket());
            }
        }
        throw new WrongTokenException();
    }

    @PostMapping("/stats")
    public Statistics getStatistics(@RequestParam (required = false) String password) {
        if (password == null) throw new WrongPasswordException();
        if (password.equals(this.PASSWORD)) {
            return statistics;
        } else {
            throw new WrongPasswordException();
        }
    }
}
