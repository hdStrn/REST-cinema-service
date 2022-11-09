package cinema.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Ticket {

    private String token;
    private Seat ticket;
    private static List<Ticket> soldTickets = new ArrayList<>();

    public Ticket() {
    }

    public Ticket(Seat ticket) {
        this.token = UUID.randomUUID().toString();
        this.ticket = ticket;
        soldTickets.add(this);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Seat getTicket() {
        return ticket;
    }

    public void setTicket(Seat ticket) {
        this.ticket = ticket;
    }

    public static List<Ticket> getSoldTickets() {
        return soldTickets;
    }

    public static void setSoldTickets(List<Ticket> soldTickets) {
        Ticket.soldTickets = soldTickets;
    }
}
