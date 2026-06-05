
package com.medconsume.controller;

        import com.medconsume.service.MedicineService;
        import com.medconsume.model.Medicine;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestParam;

        import java.util.List;

@Controller
public class SearchPageController {

    private final MedicineService medicineService;

    public SearchPageController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping("/search")
    public String searchPage(@RequestParam(required = false) String keyword, Model model) {
        List<Medicine> medicines;

        if (keyword != null && !keyword.isEmpty()) {
            medicines = medicineService.searchMedicine(keyword);
        } else {
            // Show first 15 medicines if nothing is searched
            medicines = medicineService.getFirst15Medicines();
        }

        model.addAttribute("medicines", medicines);
        model.addAttribute("keyword", keyword);
        return "search";
    }
}
