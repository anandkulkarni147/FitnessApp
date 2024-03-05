package app.fitnessapp.controller;

import app.fitnessapp.model.HealthHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medical-data")
public class HealthHistoryController {

    @Autowired
    private JsonService jsonService;

    @PostMapping
    public void saveMedicalData(@RequestBody HealthHistory medicalData) throws Exception {
        String jsonString = jsonService.toJsonString(medicalData);

    }


}
