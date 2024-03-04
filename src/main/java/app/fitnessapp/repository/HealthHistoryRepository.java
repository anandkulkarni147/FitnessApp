package app.fitnessapp.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HealthHistoryRepository {

    public static String[] medicalEvents = {
            "hospitalizations",
            "surgeries",
            "accidentsOrInjuries",
            "majorIllnesses",
            "pregnancyAndChildbirth",
            "emergencyRoomVisits",
            "routineCheckUpsOrScreenings"
    };

    // Medical Conditions
    public static String[] medicalConditions = {
            "chronicDiseases",
            "mentalHealthConditions",
            "autoimmuneDisorders",
            "infectiousDiseases",
            "neurologicalDisorders",
            "respiratoryConditions",
            "skinConditions"
    };

    // Treatments
    public static String[] treatments = {
            "prescriptionMedications",
            "overTheCounterMedications",
            "surgicalProcedures",
            "physicalTherapySessions",
            "rehabilitationPrograms",
            "counselingOrPsychotherapySessions",
            "alternativeOrComplementaryTherapies"
    };

    // Allergies
    public static String[] allergies = {
            "foodAllergies",
            "medicationAllergies",
            "environmentalAllergies",
            "latexAllergy",
            "insectStingAllergies",
            "materialAllergies",
            "plantOrChemicalAllergies"
    };

    public static List<String> healthHistory() {
        List<String> healthHistory = new ArrayList<>();
        Collections.addAll(healthHistory, medicalEvents);
        Collections.addAll(healthHistory, medicalConditions);
        Collections.addAll(healthHistory, allergies);
        Collections.addAll(healthHistory, treatments);
        return healthHistory;
    }

}
