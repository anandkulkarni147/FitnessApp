package app.fitnessapp.repository;

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

}
