package hospital.entities;

public class Patient extends Person {
    private int age;
    private String illness;

    public Patient(String name, int age, String illness) {
        super(name);
        this.age = age;
        this.illness = illness;
    }

    @Override
    public void displayInfo() {
        System.out.println("Patient Name: " + getName() + ", Age: " + age + ", Illness: " + illness);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }
}
