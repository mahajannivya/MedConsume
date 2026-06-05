package com.medconsume.controller;

import com.medconsume.model.Complaint;
import com.medconsume.repository.ComplaintRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class ComplaintController {

    private final ComplaintRepository complaintRepo;

    public ComplaintController(ComplaintRepository complaintRepo) {
        this.complaintRepo = complaintRepo;
    }

    @GetMapping("/complain")
    public String complaintsPage(Model model) {
        model.addAttribute("complaints", complaintRepo.findAll());
        return "complain";
    }

    @PostMapping("/updateComplaintStatus")
    public String updateComplaintStatus(@RequestParam Long id, @RequestParam String status) {
        complaintRepo.findById(id).ifPresent(c -> {
            c.setStatus(status);
            complaintRepo.save(c);
        });
        return "complain";
    }

}
