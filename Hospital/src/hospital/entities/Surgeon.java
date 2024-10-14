package hospital.entities;

public class Surgeon extends Doctor {
    private String surgerySpecialization;

    public Surgeon(String name, String specialization, String contactNumber, String surgerySpecialization) {
        super(name, specialization, contactNumber);
        this.surgerySpecialization = surgerySpecialization;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Surgery Specialization: " + surgerySpecialization);
    }

    public String getSurgerySpecialization() {
        return surgerySpecialization;
    }

    public void setSurgerySpecialization(String surgerySpecialization) {
        this.surgerySpecialization = surgerySpecialization;
    }
}
