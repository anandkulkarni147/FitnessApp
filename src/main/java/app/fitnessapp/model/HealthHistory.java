package app.fitnessapp.model;

import java.util.HashMap;
import java.util.Map;

public class HealthHistory {

    Map<String, String [] > healthHistoryMap;

    public HealthHistory() {
        String[] medicalEvents = {
                "hospitalizations",
                "surgeries",
                "accidentsOrInjuries",
                "majorIllnesses",
                "pregnancyAndChildbirth",
                "emergencyRoomVisits",
                "routineCheckUpsOrScreenings"
        };

        // Medical Conditions
        String[] medicalConditions = {
                "chronicDiseases",
                "mentalHealthConditions",
                "autoimmuneDisorders",
                "infectiousDiseases",
                "neurologicalDisorders",
                "respiratoryConditions",
                "skinConditions"
        };

        // Treatments
        String[] treatments = {
                "prescriptionMedications",
                "overTheCounterMedications",
                "surgicalProcedures",
                "physicalTherapySessions",
                "rehabilitationPrograms",
                "counselingOrPsychotherapySessions",
                "alternativeOrComplementaryTherapies"
        };

        // Allergies
        String[] allergies = {
                "foodAllergies",
                "medicationAllergies",
                "environmentalAllergies",
                "latexAllergy",
                "insectStingAllergies",
                "materialAllergies",
                "plantOrChemicalAllergies"
        };


        healthHistoryMap = new HashMap<>();
        healthHistoryMap.put("medicalConditions", medicalConditions);
        healthHistoryMap.put("medicalEvents", medicalEvents);
        healthHistoryMap.put("allergies", allergies);
        healthHistoryMap.put("treatments", treatments);
    }

    public Map<String, String[]> getHealthHistoryMap() {
        return healthHistoryMap;
    }

    public void setHealthHistoryMap(Map<String, String[]> healthHistoryMap) {
        this.healthHistoryMap = healthHistoryMap;
    }
}
