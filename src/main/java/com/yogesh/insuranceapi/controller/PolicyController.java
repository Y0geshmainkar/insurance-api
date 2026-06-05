package com.yogesh.insuranceapi.controller;

import com.yogesh.insuranceapi.model.Policy;
import com.yogesh.insuranceapi.service.PolicyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    private final PolicyService service;

    public PolicyController(PolicyService service) {
        this.service = service;
    }

    @GetMapping
    public List<Policy> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Policy> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Policy create(@RequestBody Policy policy) {
        return service.create(policy);
    }

    @PutMapping("/{id}")
    public Policy update(@PathVariable Long id, @RequestBody Policy policy) {
        return service.update(id, policy);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
