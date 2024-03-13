package app.fitnessapp.service;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

public class RecommendationService {

    public static Map<String, Object> createJsonWorkoutFor18To30() {
        JSONObject workoutData = new JSONObject();

        // Plans
        JSONArray plansArray = new JSONArray();

        JSONObject plan1 = new JSONObject();
        plan1.put("exercise", "Strength and Endurance Plan");
        plan1.put("fitnessGoal", "Improve overall fitness and endurance");
        plan1.put("activity", "Combination of strength training and cardiovascular exercise");
        plan1.put("image", "cycling_18");
        JSONArray weeklyPlan1 = new JSONArray();
        weeklyPlan1.put("3 days of strength training (full-body workouts with weights or bodyweight exercises)");
        weeklyPlan1.put("2 days of cardiovascular exercise (running, cycling, or HIIT workouts)");
        weeklyPlan1.put("1 day of active recovery (yoga, stretching, or light activity)");
        plan1.put("weeklyPlan", weeklyPlan1);


        JSONObject plan2 = new JSONObject();
        plan2.put("exercise", "High-Intensity Interval Training (HIIT) Plan");
        plan2.put("fitnessGoal", "Burn fat and improve cardiovascular health");
        plan2.put("activity", "HIIT workouts targeting different muscle groups");
        plan2.put("image", "hiit_18");
        JSONArray weeklyPlan2 = new JSONArray();
        weeklyPlan2.put("4 days of HIIT workouts (e.g., Tabata intervals, circuit training)");
        weeklyPlan2.put("1 day of low-intensity steady-state cardio (e.g., brisk walking)");
        weeklyPlan2.put("1 day of rest or optional light activity");
        plan2.put("weeklyPlan", weeklyPlan2);

        JSONObject plan3 = new JSONObject();
        plan3.put("exercise", "Flexibility and Mobility Plan");
        plan3.put("fitnessGoal", "Enhance flexibility, mobility, and joint health");
        plan3.put("activity", "Yoga, Pilates, and mobility exercises");
        plan3.put("image", "hiking_18");
        JSONArray weeklyPlan3 = new JSONArray();
        weeklyPlan3.put("3 days of yoga or Pilates sessions focusing on flexibility and core strength");
        weeklyPlan3.put("2 days of mobility exercises (foam rolling, dynamic stretches)");
        weeklyPlan3.put("2 days of rest or light activity (walking, hiking)");
        plan3.put("weeklyPlan", weeklyPlan3);

        plansArray.put(plan1);
        plansArray.put(plan2);
        plansArray.put(plan3);

        workoutData.put("plans", plansArray);
        return workoutData.toMap();
    }

    public static Map<String, Object> createJsonWorkoutFor30To45() {
        JSONObject workoutData = new JSONObject();

        // Plans
        JSONArray plansArray = new JSONArray();

        JSONObject plan1 = new JSONObject();
        plan1.put("exercise", "Weight Loss and Cardio Plan");
        plan1.put("fitnessGoal", "Achieve weight loss and improve cardiovascular health");
        plan1.put("activity", "Combination of cardio and strength training");
        plan1.put("image", "swimming_30");

        JSONArray weeklyPlan1 = new JSONArray();
        weeklyPlan1.put("4 days of cardiovascular exercise (running, cycling, or swimming)");
        weeklyPlan1.put("2 days of strength training (full-body workouts with weights)");
        weeklyPlan1.put("1 day of active recovery (gentle yoga, stretching)");
        plan1.put("weeklyPlan", weeklyPlan1);

        JSONObject plan2 = new JSONObject();
        plan2.put("exercise", "Functional Fitness and Core Strength Plan");
        plan2.put("fitnessGoal", "Enhance functional fitness and core strength");
        plan2.put("activity", "Functional exercises targeting major muscle groups and core");
        plan2.put("image", "pushup_30");
        JSONArray weeklyPlan2 = new JSONArray();
        weeklyPlan2.put("3 days of functional strength training (e.g., squats, lunges, push-ups)");
        weeklyPlan2.put("2 days of core-focused workouts (planks, Russian twists, stability ball exercises)");
        weeklyPlan2.put("2 days of rest or light activity (walking, biking)");
        plan2.put("weeklyPlan", weeklyPlan2);

        JSONObject plan3 = new JSONObject();
        plan3.put("exercise", "Interval Training and Flexibility Plan");
        plan3.put("fitnessGoal", "Improve metabolism, flexibility, and overall fitness");
        plan3.put("activity", "Interval training and flexibility exercises");
        plan3.put("image", "yoga_30");
        JSONArray weeklyPlan3 = new JSONArray();
        weeklyPlan3.put("3 days of interval training (HIIT workouts, sprint intervals)");
        weeklyPlan3.put("2 days of flexibility and mobility exercises (yoga, dynamic stretches)");
        weeklyPlan3.put("2 days of rest or optional light activity");
        plan3.put("weeklyPlan", weeklyPlan3);

        plansArray.put(plan1);
        plansArray.put(plan2);
        plansArray.put(plan3);

        workoutData.put("plans", plansArray);

        return workoutData.toMap();
    }

    public static Map<String, Object> createJsonWorkoutForAbove45() {
        JSONObject workoutData = new JSONObject();

        // Plans
        JSONArray plansArray = new JSONArray();

        JSONObject plan1 = new JSONObject();
        plan1.put("exercise", "Low-Impact Cardio and Strength Plan");
        plan1.put("fitnessGoal", "Improve cardiovascular health and muscle strength without stressing joints");
        plan1.put("activity", "Low-impact cardio and strength training with modified exercises");
        plan1.put("image", "walking_45");
        JSONArray weeklyPlan1 = new JSONArray();
        weeklyPlan1.put("3 days of low-impact cardio (walking, swimming, or cycling)");
        weeklyPlan1.put("2 days of strength training using resistance bands or light weights");
        weeklyPlan1.put("2 days of rest or gentle stretching and mobility exercises");
        plan1.put("weeklyPlan", weeklyPlan1);

        JSONObject plan2 = new JSONObject();
        plan2.put("exercise", "Balance and Stability Plan");
        plan2.put("fitnessGoal", "Enhance balance, stability, and joint mobility");
        plan2.put("activity", "Exercises focusing on balance, proprioception, and core strength");
        plan2.put("image", "pilates_45");
        JSONArray weeklyPlan2 = new JSONArray();
        weeklyPlan2.put("3 days of balance and stability exercises (Tai Chi, stability ball exercises)");
        weeklyPlan2.put("2 days of gentle yoga or Pilates for flexibility and core strength");
        weeklyPlan2.put("2 days of rest or light activity (gentle walks, leisurely bike rides)");
        plan2.put("weeklyPlan", weeklyPlan2);

        JSONObject plan3 = new JSONObject();
        plan3.put("exercise", "Functional Movement and Flexibility Plan");
        plan3.put("fitnessGoal", "Maintain functional movement patterns and improve flexibility");
        plan3.put("activity", "Functional exercises and flexibility training");
        plan3.put("image", "squats_45");
        JSONArray weeklyPlan3 = new JSONArray();
        weeklyPlan3.put("3 days of functional movement exercises (e.g., squats, lunges, step-ups)");
        weeklyPlan3.put("2 days of flexibility training (yoga, static stretching)");
        weeklyPlan3.put("2 days of rest or light recreational activity");
        plan3.put("weeklyPlan", weeklyPlan3);

        plansArray.put(plan1);
        plansArray.put(plan2);
        plansArray.put(plan3);

        workoutData.put("plans", plansArray);
        return workoutData.toMap();
    }
}
