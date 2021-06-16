package org.melchor.errander.web.api;

import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<?> createErrand(@RequestBody ErrandForm errandForm) {
        Long errandId = errandService.createErrand(errandForm);

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
    public ResponseEntity<?> updateErrand(@PathVariable Long id, ErrandForm errandForm) {
        errandService.update(id, errandForm);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteErrand(@PathVariable Long id) {
        errandService.delete(id);

        return ResponseEntity.noContent().build();
    }


}
