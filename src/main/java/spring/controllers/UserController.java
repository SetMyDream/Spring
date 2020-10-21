package spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.dto.UserResponseDto;
import spring.model.User;
import spring.service.UserService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/inject")
    public void inject() {
        userService.add(new User("Den", "Den@mail.org", "11"));
        userService.add(new User("Ben", "Ben@mail.org", "1l"));
        userService.add(new User("Pen", "Pen@mail.org", "ll"));
        userService.add(new User("Ten", "Ten@mail.org", "10"));
    }

    @GetMapping(value = "/{userId}")
    public UserResponseDto get(@PathVariable String userId) {
        return getUserDto(userService.getById(Long.parseLong(userId)).get());
    }

    List<UserResponseDto> getAll() {
        return userService.listUsers().stream()
                .map(this::getUserDto)
                .collect(Collectors.toList());
    }

    private UserResponseDto getUserDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setUserId(user.getId());
        return userResponseDto;
    }
}
