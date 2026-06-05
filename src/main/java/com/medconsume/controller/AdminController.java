package com.medconsume.controller;

import com.medconsume.model.*;
import com.medconsume.repository.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final MedicineRepository medRepo;

    private final UserRepository userRepo;

    public AdminController(MedicineRepository medRepo,
 UserRepository userRepo) {
        this.medRepo = medRepo;
        this.userRepo = userRepo;
    }


    @GetMapping("/dashboard")
    public ResponseEntity<Map<String, Object>> dashboard() {
        Map<String, Object> m = new HashMap<>();

        m.put("totalMedicines", medRepo.count());
        m.put("pendingMedicines",
                medRepo.findAll().stream().filter(x -> "PENDING".equals(x.getStatus())).count()
        );
        m.put("totalUsers", userRepo.count());

        return ResponseEntity.ok(m);
    }

    @GetMapping("/pending-users")
    public ResponseEntity<List<User>> getPendingUsers() {
        List<User> list = userRepo.findByStatus("PENDING");
        return ResponseEntity.ok(list);
    }

    @PostMapping("/approve/{id}")
    public ResponseEntity<String> approveUser(@PathVariable Long id) {
        User user = userRepo.findById(id)
                .orElse(null);

        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        user.setStatus("APPROVED");
        userRepo.save(user);

        return ResponseEntity.ok("User approved successfully");
    }


    @PostMapping("/reject/{id}")
    public ResponseEntity<String> rejectUser(@PathVariable Long id) {
        User user = userRepo.findById(id)
                .orElse(null);

        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        user.setStatus("REJECTED");
        userRepo.save(user);

        return ResponseEntity.ok("User rejected successfully");
    }
}
