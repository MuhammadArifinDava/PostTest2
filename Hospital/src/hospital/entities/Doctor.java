package hospital.entities;

import hospital.interfaces.CrudOperations;

public class Doctor extends Person implements CrudOperations<Doctor> {
    private String specialization;
    private String contactNumber;

    public Doctor(String name, String specialization, String contactNumber) {
        super(name);
        this.specialization = specialization;
        this.contactNumber = contactNumber;
    }

    @Override
    public void displayInfo() {
        System.out.println("Doctor Name: " + getName() + ", Specialization: " + specialization + ", Contact: " + contactNumber);
    }

    @Override
    public void create(Doctor doctor) {
    }

    @Override
    public Doctor read(String name) {
        return null;
    }

    @Override
    public void update(String name, Doctor newDoctor) {
    }

    @Override
    public void delete(String name) {
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
