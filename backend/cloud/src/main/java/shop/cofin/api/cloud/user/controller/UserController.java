package shop.cofin.api.cloud.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import  org.modelmapper.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import shop.cofin.api.cloud.common.CommonController;
import shop.cofin.api.cloud.user.domain.User;
import shop.cofin.api.cloud.user.domain.UserDto;
import shop.cofin.api.cloud.user.repository.UserRepository;
import shop.cofin.api.cloud.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController implements CommonController<User, Long> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserDto user){
        return ResponseEntity.ok(
                userService.login(user.getUserName(), user.getPassword()).orElse(new User()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable long id) {
        System.out.println("--------");
        User user = userService.findById(id).get();
        UserDto userSerializer = UserDto.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .password(user.getPassword())
                .name(user.getName())
                .email(user.getEmail())
                .regDate(user.getRegDate())
                .build();
        return new ResponseEntity<>(userSerializer, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        logger.info(String.format("회원수정 정보: %s", user.toString()));
        userRepository.save(user);
        return ResponseEntity.ok(userRepository.getById(user.getUserId()));
    }
    @GetMapping()
    @Override
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @Override
    public ResponseEntity<User> getById(Long id) {
        return ResponseEntity.ok(userRepository.getById(id));
    }

    @PostMapping
    @Override
    public ResponseEntity<String> save(@RequestBody User user) {
        logger.info(String.format("회원가입 정보: %s", user.toString()));
        userRepository.save(user);
        return ResponseEntity.ok("SUCCESS");
    }

    @Override
    public ResponseEntity<Optional<User>> findById(Long id) {
        return ResponseEntity.ok(userRepository.findById(id));
    }

    @Override
    public ResponseEntity<Boolean> existsById(Long id) {
        return ResponseEntity.ok(userRepository.existsById(id));
    }

    @Override
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(userRepository.count());
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok("SUCCESS");
    }
}