package com.yogesh.insuranceapi.service;

import com.yogesh.insuranceapi.model.Policy;
import com.yogesh.insuranceapi.repository.PolicyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {

    private final PolicyRepository repository;

    public PolicyService(PolicyRepository repository) {
        this.repository = repository;
    }

    public List<Policy> getAll() {
        return repository.findAll();
    }

    public Optional<Policy> getById(Long id) {
        return repository.findById(id);
    }

    public Policy create(Policy policy) {
        return repository.save(policy);
    }

    public Policy update(Long id, Policy updated) {
        return repository.findById(id).map(p -> {
            p.setPolicyNumber(updated.getPolicyNumber());
            p.setHolderName(updated.getHolderName());
            p.setType(updated.getType());
            p.setPremium(updated.getPremium());
            p.setStatus(updated.getStatus());
            return repository.save(p);
        }).orElseThrow(() -> new RuntimeException("Policy not found: " + id));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
