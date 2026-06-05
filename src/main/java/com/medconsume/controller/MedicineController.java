package com.medconsume.controller;

import com.medconsume.model.Medicine;
import com.medconsume.repository.MedicineRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

    private final MedicineRepository medRepo;

    public MedicineController(MedicineRepository medRepo) {
        this.medRepo = medRepo;
    }


    @GetMapping("/search")
    public List<Medicine> search(@RequestParam String name) {
        return medRepo.findByMedicineNameContainingIgnoreCase(name);
    }

    @GetMapping
    public List<Medicine> getAll() {
        return medRepo.findAll();
    }
}
