package com.tracker.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.demo.model.medicine;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MedicineController {

    private List<medicine> medicines = new ArrayList<>();
    private Long currentId = 1L;

    @PostMapping("/add")
    public medicine addMedicine(@RequestBody medicine m) {
        m.setId(currentId++);
        medicines.add(m);
        return m;
    }

    @GetMapping("/all")
    public List<medicine> getAll() {
        return medicines;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMedicine(@PathVariable Long id) {
        medicines.removeIf(m -> m.getId().equals(id));
        return "Deleted";
    }

    @PutMapping("/taken/{id}")
    public medicine markTaken(@PathVariable Long id) {

        for (medicine m : medicines) {
            if (m.getId().equals(id)) {
                m.setStatus("Taken");
                return m;
            }
        }

        return null;
    }

    @GetMapping("/")
    public String home() {
        return "Medicine Reminder System Running Successfully";
    }
}
