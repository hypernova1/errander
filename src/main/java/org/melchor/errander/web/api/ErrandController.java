package org.melchor.errander.web.api;

import lombok.RequiredArgsConstructor;
import org.melchor.errander.config.security.AuthUser;
import org.melchor.errander.config.security.AuthenticatedUser;
import org.melchor.errander.domain.User;
import org.melchor.errander.service.ErrandService;
import org.melchor.errander.web.payload.ErrandForm;
import org.melchor.errander.web.payload.ErrandResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/errand")
@RequiredArgsConstructor
public class ErrandController {

    private final ErrandService errandService;

    @PostMapping("/")
    public ResponseEntity<?> createErrand(@RequestBody ErrandForm errandForm, @AuthUser User user) {
        Long errandId = errandService.createErrand(errandForm, user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/errand/{id}")
                .buildAndExpand(errandId)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getErrand(@PathVariable Long id) {
        ErrandResponse errand = errandService.getById(id);

        return ResponseEntity.ok(errand);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateErrand(@PathVariable Long id, ErrandForm errandForm, @AuthUser User user) {
        errandService.update(id, errandForm, user);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteErrand(@PathVariable Long id, @AuthUser User user) {
        errandService.delete(id, user);

        return ResponseEntity.noContent().build();
    }


}
