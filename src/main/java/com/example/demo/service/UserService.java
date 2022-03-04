package com.example.demo.service;

import com.example.demo.domain.dto.UserDTO;
import com.example.demo.domain.dto.UserLoginDTO;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll() {
        Iterable<User> users = userRepository.findAll();

        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            UserDTO userDTO = new UserDTO();

            userDTO.setCode(user.getCode());
            userDTO.setUsername(user.getUsername());
            userDTO.setFirstname(user.getFirstname());
            userDTO.setLastname(user.getLastname());
            userDTO.setEmail(user.getEmail());
            userDTO.setRole(user.getRole());
            userDTOs.add(userDTO);
        }

        return userDTOs;
    }

    public UserDTO findOne(int id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            User found = user.get();
            UserDTO userDTO = new UserDTO();

            userDTO.setCode(found.getCode());
            userDTO.setUsername(found.getUsername());
            userDTO.setFirstname(found.getFirstname());
            userDTO.setLastname(found.getLastname());
            userDTO.setEmail(found.getEmail());
            userDTO.setRole(found.getRole());

            return userDTO;
        }

        return null;
    }

    public UserDTO create(UserDTO userDTO) {
        User user = new User();

        user.setCode(userDTO.getCode());
        user.setUsername(userDTO.getUsername());
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());

        userRepository.save(user);

        return userDTO;
    }

    public UserDTO update(int id, UserDTO userDTO) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            User found = user.get();

            found.setCode(userDTO.getCode());
            found.setUsername(userDTO.getUsername());
            found.setFirstname(userDTO.getFirstname());
            found.setLastname(userDTO.getLastname());
            found.setEmail(userDTO.getEmail());
            found.setRole(userDTO.getRole());

            userRepository.save(found);

            return userDTO;
        }

        return null;
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }

    public boolean login(UserLoginDTO userLoginDTO) {
        Optional<User> user = userRepository.findByUsername(userLoginDTO.getUsername());

        return user.isPresent();
    }
}
