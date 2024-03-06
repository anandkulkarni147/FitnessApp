package app.fitnessapp.controller;

import app.fitnessapp.model.Recommendation;
import app.fitnessapp.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

//    @Autowired
//    private RecommendationService recommendationService;
//
//    @GetMapping("/generate")
//    public ResponseEntity<Recommendation> generateRecommendation(@RequestParam String username) {
//        Recommendation recommendation = recommendationService.generateRecommendation(username);
//        return ResponseEntity.ok(recommendation);
//    }
}
