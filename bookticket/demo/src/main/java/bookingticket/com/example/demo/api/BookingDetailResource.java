package bookingticket.com.example.demo.api;

import bookingticket.com.example.demo.api.request.BookingDetailRequest;
import bookingticket.com.example.demo.entities.BookingDetail;
import bookingticket.com.example.demo.exception.ResourceNotFoundException;
import bookingticket.com.example.demo.service.BookingDetailService;
import bookingticket.com.example.demo.service.BookingService;
import bookingticket.com.example.demo.service.ScheduleService;
import bookingticket.com.example.demo.service.SeatsService;
import bookingticket.com.example.demo.service.dto.BookingDetailDto;
import bookingticket.com.example.demo.service.mapper.BookingDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@PreAuthorize("hasRole('ADMIN')")
@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(BookingDetailResource.PATH)
public class BookingDetailResource {
    public static final String PATH = "/api/bookingdetail";

    @Autowired
    BookingDetailService bookingDetailService;

    @Autowired
    BookingService bookingService;

    @Autowired
    SeatsService seatsService;

    @Autowired
    ScheduleService scheduleService;

    @GetMapping
    ResponseEntity<List<BookingDetailDto>> getAll() {
        return ResponseEntity.ok(BookingDetailMapper.INSTANCE.toDtos(bookingDetailService.getAll()));
    }

    @GetMapping("/{id}")
    ResponseEntity<BookingDetailDto> getBookingDetailById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        BookingDetail bookingDetail = bookingDetailService.findBookingDetailById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BookingDetail id not found :" + id));
        return ResponseEntity.ok(BookingDetailMapper.INSTANCE.toDto(bookingDetail));
    }

    @PostMapping
    public ResponseEntity<BookingDetailDto> create(@RequestBody BookingDetailRequest bookingDetailRequest) throws ResourceNotFoundException {
        BookingDetail createBookingDetail = new BookingDetail();
        createBookingDetail.setBooking(bookingService.findBookingById(bookingDetailRequest.getBookingId()).orElseThrow(() -> new ResourceNotFoundException("Booking not found " + bookingDetailRequest.getBookingId())));
        createBookingDetail.setSchedule(scheduleService.findScheduleById(bookingDetailRequest.getScheduleId()).orElseThrow(() -> new ResourceNotFoundException("Schedule not found " + bookingDetailRequest.getScheduleId())));
        createBookingDetail.setSeats(seatsService.findSeatsById(bookingDetailRequest.getSeatsId()).orElseThrow(() -> new ResourceNotFoundException("Seats not found " + bookingDetailRequest.getSeatsId())));
        return ResponseEntity.created(URI.create(BookingDetailResource.PATH + "/" + createBookingDetail.getDetailId())).body(BookingDetailMapper.INSTANCE.toDto(bookingDetailService.saveBookingDetail(createBookingDetail)));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        BookingDetail bookingDetail = bookingDetailService.findBookingDetailById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BookingDetail id not found :" + id));
        bookingDetailService.deleteBookingById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    ResponseEntity<BookingDetailDto> update(@PathVariable(value = "id") Integer id,
                                            @RequestBody BookingDetail bookingDetail) throws ResourceNotFoundException {
        BookingDetail editBookingDetail = bookingDetailService.findBookingDetailById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BookingDetail id not found :" + id));
        editBookingDetail.setBooking(bookingDetail.getBooking());
        editBookingDetail.setSchedule(bookingDetail.getSchedule());
        editBookingDetail.setSeats(bookingDetail.getSeats());
        BookingDetail saveBookingDetail = bookingDetailService.saveBookingDetail(editBookingDetail);
        return ResponseEntity.ok(BookingDetailMapper.INSTANCE.toDto(saveBookingDetail));
    }

}
