package cinema.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Statistics {

    private int currentIncome;
    private int numberOfAvailableSeats;
    private int numberOfPurchasedTickets;
    private MovieTheatre movieTheatre;

    public Statistics() {
    }

    public Statistics(MovieTheatre movieTheatre) {
        this.movieTheatre = movieTheatre;
        this.numberOfAvailableSeats = movieTheatre.getAvailableSeats().size();
    }

    public int getCurrentIncome() {
        return currentIncome;
    }

    public void setCurrentIncome(int currentIncome) {
        this.currentIncome = currentIncome;
    }

    public int getNumberOfAvailableSeats() {
        return numberOfAvailableSeats;
    }

    public void setNumberOfAvailableSeats(int numberOfAvailableSeats) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }

    public int getNumberOfPurchasedTickets() {
        return numberOfPurchasedTickets;
    }

    public void setNumberOfPurchasedTickets(int numberOfPurchasedTickets) {
        this.numberOfPurchasedTickets = numberOfPurchasedTickets;
    }

    @JsonIgnore
    public MovieTheatre getMovieTheatre() {
        return movieTheatre;
    }

    public void setMovieTheatre(MovieTheatre movieTheatre) {
        this.movieTheatre = movieTheatre;
    }

    public void plusIncome(int income) {
        currentIncome += income;
    }

    public void minusIncome(int income) {
        currentIncome -= income;
    }

    public void updateNumberOfAvailableSeats() {
        int totalSeats = movieTheatre.getAvailableSeats().size();
        this.numberOfAvailableSeats = totalSeats - numberOfPurchasedTickets;
    }

    public void updateStatAfterPurchase(int income, int numberOfPurchasedTickets) {
        plusIncome(income);
        setNumberOfPurchasedTickets(numberOfPurchasedTickets + 1);
        updateNumberOfAvailableSeats();
    }

    public void updateStatAfterReturn(int income, int numberOfPurchasedTickets) {
        minusIncome(income);
        setNumberOfPurchasedTickets(numberOfPurchasedTickets);
        updateNumberOfAvailableSeats();
    }
}
