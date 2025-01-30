package com.acadpendragon.system.services;


import com.acadpendragon.system.dto.UserDTO;
import com.acadpendragon.system.entities.User;
import com.acadpendragon.system.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        System.out.println(userRepository.findAll());
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(this::convertToDTO).orElse(null);
    }

    public UserDTO updateUserPayment(Long id, boolean payment) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setPagamento(payment);
            userRepository.save(user);
            return convertToDTO(user);
        }
        return null;
    }

    public List<UserDTO> getUsersWithPaymentFalse() {
        List<User> users = userRepository.findByPaymentFalse();
        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setNome(user.getNome());
        userDTO.setEmail(user.getEmail());
        userDTO.setPagamento(user.isPagamento());
        userDTO.setRegistrationDate(user.getDataMatricula());
        userDTO.setTimeSinceRegistration(user.getTimeSinceRegistration());
        userDTO.setTurma(user.getTurma());
        return userDTO;
    }
}