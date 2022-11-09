package cinema.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Seat {

    private int row;
    private int column;
    private int price;
    private boolean isBooked;

    public Seat() {
    }

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        if (row < 5) {
            price = 10;
        } else {
            price = 8;
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @JsonIgnore
    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public boolean isSeatExists(MovieTheatre movieTheatre) {
        return row <= movieTheatre.getTotalRows() && row > 0
                && column <= movieTheatre.getTotalColumns() && column > 0;
    }
}
