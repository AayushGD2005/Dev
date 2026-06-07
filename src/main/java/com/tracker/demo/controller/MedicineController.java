package com.tracker.demo.controller;

import com.tracker.demo.model.medicine;
import com.tracker.demo.repository.medrep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MedicineController {

    @Autowired
    private medrep repo;

    @PostMapping("/add")
    public medicine addMedicine(@RequestBody medicine m) {
        return repo.save(m);
    }

    @GetMapping("/all")
    public List<medicine> getAll() {
        return repo.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMedicine(@PathVariable Long id) {
        repo.deleteById(id);
        return "Deleted";
    }
    @PutMapping("/taken/{id}")
    public medicine markTaken(@PathVariable Long id) {
        medicine m = repo.findById(id).orElse(null);
        if (m != null) {
            m.setStatus("Taken");
            return repo.save(m);
        }
        return null;
    }
}