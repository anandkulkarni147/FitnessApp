package app.fitnessapp.controller;

import app.fitnessapp.model.Goals;
import app.fitnessapp.service.GoalsService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class GoalsController {

    @Autowired
    private GoalsService goalsService;

    @PostMapping("/goals")
    public ResponseEntity<String> setGoals(@RequestBody Map<String, Object> requestBody) {
        try {
            String goal = (String) requestBody.get("goal");
            String activity = (String) requestBody.get("activity");
            String goalType = (String) requestBody.get("goalType");
            int goalTarget = (Integer) requestBody.get("goalTarget");
            String email = (String) requestBody.get("email");
            Goals userGoals = new Goals(goal, goalType, activity, goalTarget, email, 0, 0);
            goalsService.saveUserGoals(userGoals);
            return new ResponseEntity<>("ok", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("exit", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/goals")
    public ResponseEntity<Map<String, Object>> getGoals(@RequestParam("email") String email) {
        try {
            List<Goals> l = goalsService.getAllGoalsByEmail(email);
            l.stream().filter(goal -> goal.getEmail().equals(email)).collect(Collectors.toList());
            JSONObject goalsJson = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            l.forEach(e -> {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("activity", e.getActivity());
                jsonObject.put("goalType", e.getGoalType());
                jsonObject.put("goalTarget", e.getTarget());
                jsonObject.put("progress", e.getProgress());
                jsonObject.put("daysLeft", e.getDaysleft());
                jsonArray.put(jsonObject);
            });
            goalsJson.put("goals", jsonArray);
            return new ResponseEntity<>(goalsJson.toMap(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
