package com.example.thicketmanaging.dataservices;


import com.example.thicketmanaging.entities.User;
import com.example.thicketmanaging.enums.UserRole;
import com.example.thicketmanaging.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllManagers() {
        return userRepository.findByRole(UserRole.THICKET_MANAGER);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User manager) {
        return userRepository.save(manager);
    }

    public Optional<User> updateUser(Long id, User handler) {
        User user = userRepository.findById(id).get();
        user.setUsername(handler.getUsername());
        user.setPassword(handler.getPassword());
        user.setUserRole(handler.getUserRole());
        userRepository.save(user);
        return Optional.of(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getAllHandlers() {
        return userRepository.findByRole(UserRole.THICKET_HANDLER);
    }
}
