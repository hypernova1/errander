package org.melchor.errander.web.api;

import lombok.RequiredArgsConstructor;
import org.melchor.errander.config.security.AuthUser;
import org.melchor.errander.domain.User;
import org.melchor.errander.service.UserService;
import org.melchor.errander.web.payload.JoinForm;
import org.melchor.errander.web.payload.LeaveForm;
import org.melchor.errander.web.payload.UpdateForm;
import org.melchor.errander.web.payload.UserDetail;
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
    public ResponseEntity<?> deleteUser(@PathVariable Long id, @RequestBody LeaveForm leaveForm, @AuthUser User user) {
        userService.deleteById(id, leaveForm, user);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, UpdateForm updateForm, @AuthUser User user) {
        userService.update(id, updateForm, user);

        return ResponseEntity.noContent().build();
    }


}
