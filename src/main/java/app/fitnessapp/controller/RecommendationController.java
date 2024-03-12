package app.fitnessapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
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
