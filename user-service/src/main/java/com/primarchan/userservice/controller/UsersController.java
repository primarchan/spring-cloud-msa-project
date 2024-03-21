package com.primarchan.userservice.controller;

import com.primarchan.userservice.dto.ResponseUser;
import com.primarchan.userservice.dto.UserDto;
import com.primarchan.userservice.entity.UserEntity;
import com.primarchan.userservice.service.UserService;
import com.primarchan.userservice.vo.Greeting;
import com.primarchan.userservice.dto.RequestUser;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UsersController {

    private final Greeting greeting;
    private final Environment env;
    private final UserService userService;

    @GetMapping("/health_check")
    public String status() {
        return String.format("It's working in USER-SERVICE on PORT %s", env.getProperty("local.server.port"));
    }

    @GetMapping("/welcome")
    public String greeting() {
        return greeting.getMessage();
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = mapper.map(user, UserDto.class);
        userService.createUser(userDto);

        ResponseUser responseUser = mapper.map(userDto, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<ResponseUser>> getUsers() {
        Iterable<UserEntity> userEntities = userService.getUserByAll();
        List<ResponseUser> result = new ArrayList<>();
        userEntities.forEach(entity -> {
            result.add(new ModelMapper().map(entity, ResponseUser.class));
        });

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable("userId") String userId) {
        UserDto userDto = userService.getUserByUserId(userId);
        ResponseUser responseUser = new ModelMapper().map(userDto, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.OK).body(responseUser);
    }

}
