package ru.javarush.tsebal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    //private UserRepository userRepository = Mockito.mock(UserRepository.class); //the same like upper string
    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    void registerShouldThrowExceptionIfConnectionToDatabaseLost() {
        Mockito.when(passwordEncoder.encode("password"))
                        .thenReturn("encodedPassword");
        Mockito.when(userRepository.save("login", "encodedPassword"))
                .thenThrow(new DataBaseConnectionException());

        Assertions.assertThrows(DataBaseConnectionException.class,
                () -> userService.register("login", "password"));

        Mockito.verify(userRepository).save("login", "encodedPassword");
    }

    @Test
    void register() {
        Mockito.when(passwordEncoder.encode("password"))
                .thenReturn("encodedPassword").thenReturn("blabla");
        System.out.println(passwordEncoder.encode("password"));
        System.out.println(passwordEncoder.encode("password"));
        System.out.println(passwordEncoder.encode("password"));
    }
}