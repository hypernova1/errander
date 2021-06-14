package org.melchor.errander.web.api;

import lombok.RequiredArgsConstructor;
import org.melchor.errander.repository.UserService;
import org.melchor.errander.web.payload.JoinForm;
import org.melchor.errander.web.payload.LeaveForm;
import org.melchor.errander.web.payload.UpdateForm;
import org.melchor.errander.web.payload.UserDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserDetail(@PathVariable Long id) {
        UserDetail userDetail = userService.findById(id);
        return ResponseEntity.ok(userDetail);
    }

    @PostMapping("/")
    public ResponseEntity<?> registerUser(@RequestBody JoinForm joinForm) {
        Long userId = userService.register(joinForm);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/user/{id}")
                .buildAndExpand(userId)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id, @RequestBody LeaveForm leaveForm) {
        userService.deleteById(id, leaveForm);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, UpdateForm updateForm) {
        userService.update(id, updateForm);

        return ResponseEntity.noContent().build();
    }


}
