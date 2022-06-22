package bookingticket.com.example.demo.exception;

public class SeatUnavailable extends Exception{
    public SeatUnavailable(String message) {
        super(message);
    }
}
