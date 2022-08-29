package ru.javarush.tsebal;

import java.util.Objects;

public class MockitoExample {
    public static void main(String[] args) {
        UserRepository userRepository = (login, password) -> new User(1, login, password);
        PasswordEncoder passwordEncoder = new StupidPasswordEncoder();
        UserService userService = new UserService(userRepository, passwordEncoder);
    }
}

class User {
    private final Integer id;
    private final String login;
    private final String password;
    public User(Integer id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }
}

interface UserRepository {
    User save(String login, String password);
}

interface PasswordEncoder {
    String encode(String rawPassword);
    boolean isMatched(String rawPassword, String encodePassword);
}

class DataBaseConnectionException extends RuntimeException {

}

class StupidPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(String rawPassword) {
        return rawPassword;
    }

    @Override
    public boolean isMatched(String rawPassword, String encodePassword) {
        return Objects.equals(rawPassword, encodePassword);
    }
}

class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(String login, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        User user = userRepository.save(login, encodedPassword);
        return user;
    }
}
