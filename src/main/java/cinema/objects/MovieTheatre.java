package cinema.objects;

import java.util.ArrayList;
import java.util.List;

public class MovieTheatre {

    private int totalRows;
    private int totalColumns;
    private List<Seat> availableSeats;

    public MovieTheatre(int totalRows, int totalColumns) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        availableSeats = new ArrayList<>();
        fillSeats();
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<Seat> availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void fillSeats() {
        int row = 1;
        int column = 1;
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                availableSeats.add(new Seat(row, column++));
            }
            row++;
            column = 1;
        }
    }
}
