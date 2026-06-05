package com.medconsume.controller;

import com.medconsume.model.Medicine;
import com.medconsume.repository.MedicineRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admins")
public class MedicinePageController {

    private final MedicineRepository medRepo;

    public MedicinePageController(MedicineRepository medRepo) {
        this.medRepo = medRepo;
    }

    // Open Medicines Page
    @GetMapping("/medicine")
    public String medicinePage(Model model, @RequestParam(required = false) String msg) {
        List<Medicine> medicines = (List<Medicine>) medRepo.findAll();
        model.addAttribute("medicines", medicines);
        model.addAttribute("msg", msg); // optional message
        return "medicinesedit";
    }

    // Add Medicine
    @PostMapping("/addMedicine")
    public String addMedicine(@ModelAttribute Medicine medicine) {
        medRepo.save(medicine);
        return "medicinesedit";

    }

    // Delete Medicine
    @PostMapping("/deleteMedicine")
    public String deleteMedicine(@RequestParam Long id) {
        if (medRepo.existsById(id)) {
            medRepo.deleteById(id);
            return "medicinesedit";

        }
        return "redirect:/admins/medicine?msg=notfound";
    }
}
