package org.schola.spring.reception.microservice.router.controller;

import org.schola.spring.reception.microservice.data.model.Reception;
import org.schola.spring.reception.microservice.data.service.ReceptionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/receptions")
public class ReceptionController {

    private final ReceptionService service;

    public ReceptionController(ReceptionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Reception> newReception(@RequestBody Reception reception) {
        service.save(reception);
        return ResponseEntity.status(201).body(reception);
    }

    @GetMapping
    public ResponseEntity<Page<Reception>> getReceptions(Pageable pageable) {
        Page<Reception> receptions = service.getAll(pageable);
        return ResponseEntity.ok(receptions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reception> getReceptionById(@PathVariable String id) {
        Reception reception = service.get(id);
        return ResponseEntity.ok(reception);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReception(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Reception>> getReceptionsByUser(@RequestParam String user) {
        List<Reception> receptions = service.getWithUser(user);
        return ResponseEntity.ok(receptions);
    }
}
