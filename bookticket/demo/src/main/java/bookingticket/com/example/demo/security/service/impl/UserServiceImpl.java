package bookingticket.com.example.demo.security.service.impl;

import bookingticket.com.example.demo.security.mapper.UserMapper;
import bookingticket.com.example.demo.security.repository.UserRepository;
import bookingticket.com.example.demo.security.service.UserService;
import bookingticket.com.example.demo.security.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<UserDTO> getUsers() {
        return UserMapper.INSTANCE.mapToDtos(userRepository.findAll());

    }
}
