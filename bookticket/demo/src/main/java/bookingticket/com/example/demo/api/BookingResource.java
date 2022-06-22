package bookingticket.com.example.demo.api;

import bookingticket.com.example.demo.entities.Booking;
import bookingticket.com.example.demo.entities.SeatingType;
import bookingticket.com.example.demo.exception.ResourceNotFoundException;
import bookingticket.com.example.demo.service.BookingDetailService;
import bookingticket.com.example.demo.service.BookingService;
import bookingticket.com.example.demo.service.dto.BookingDto;
import bookingticket.com.example.demo.service.mapper.BookingDetailMapper;
import bookingticket.com.example.demo.service.mapper.BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@PreAuthorize("hasRole('ADMIN')")
@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(BookingResource.PATH)
public class BookingResource {
    public static final String PATH = "/api/booking";

    @Autowired
    private BookingService bookingService;

    @Autowired
    private BookingDetailService bookingDetailService;

    @Autowired


    @GetMapping
    ResponseEntity<List<BookingDto>> getAll() {
        List<BookingDto> bookingDtos = BookingMapper.INSTANCE.toDtos(bookingService.getAll());
        for (BookingDto bookingDto :
                bookingDtos) {
            bookingDto.setBookingDetailDtos(BookingDetailMapper.INSTANCE.toDtos(bookingDetailService.findByBookingBookingId(bookingDto.getBookingId())));

        }


        return ResponseEntity.ok(bookingDtos);
    }

    @GetMapping("/{id}")
    ResponseEntity<BookingDto> getBookingById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Booking booking = bookingService.findBookingById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking id not found:" + id));
        return ResponseEntity.ok(BookingMapper.INSTANCE.toDto(booking));
    }

    @PostMapping
    ResponseEntity<BookingDto> create(@RequestBody Booking booking) {
        Booking createdBooking = bookingService.saveBooking(booking);
        return ResponseEntity.created(URI.create(BookingResource.PATH + "/" + createdBooking.getBookingId())).body(BookingMapper.INSTANCE.toDto(createdBooking));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Booking booking = bookingService.findBookingById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking id not found: " + id));
        bookingService.deleteBookingById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingDto> update(@PathVariable(value = "id") Integer id,
                                             @RequestBody Booking booking) throws ResourceNotFoundException {
        Booking editBooking = bookingService.findBookingById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking id not found :" + id));
        editBooking.setPaymentDate(booking.getPaymentDate());
        editBooking.setTotalPrice(booking.getTotalPrice());
        editBooking.setPaymentType(booking.getPaymentType());
        editBooking.setCustomer(booking.getCustomer());
        Booking saveBooking = bookingService.saveBooking(editBooking);
        return ResponseEntity.ok(BookingMapper.INSTANCE.toDto(saveBooking));
    }

    @GetMapping("/getTotalOfSeatTypeAndCinema")
    public ResponseEntity<Long>getTotalRevenueOfSeatType(@RequestParam String seatingType , String cinemaName){
        return ResponseEntity.ok(bookingService.getTotalRevenueOfSeatType(seatingType,cinemaName));
    }
}
