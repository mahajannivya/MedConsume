
package com.medconsume.controller;

        import com.medconsume.model.Feedback;
        import com.medconsume.repository.FeedbackRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.*;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @GetMapping("/feedback")
    public String showFeedbackForm() {
        return "feedback";
    }

    @PostMapping("/feedback")
    public String submitFeedback(@ModelAttribute Feedback feedback) {
        feedbackRepository.save(feedback);
        return "redirect:/feedback?success"; // redirect after saving
    }
}
