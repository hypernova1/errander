package org.melchor.errander.web.api;

import lombok.RequiredArgsConstructor;
import org.melchor.errander.repository.UserService;
import org.melchor.errander.web.payload.UserDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> registerUser(@PathVariable Long id) {
        UserDetail userDetail = userService.findById(id);
        return ResponseEntity.ok(userDetail);
    }

}
