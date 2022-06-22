package bookingticket.com.example.demo.security.service;

import bookingticket.com.example.demo.security.service.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();
}
