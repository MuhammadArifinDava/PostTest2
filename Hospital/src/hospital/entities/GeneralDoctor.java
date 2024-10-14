package hospital.entities;

// Kelas GeneralDoctor yang merupakan subclass dari Doctor
public class GeneralDoctor extends Doctor {
    // Constructor untuk GeneralDoctor
    public GeneralDoctor(String name, String contactNumber) {
        super(name, "General", contactNumber); // Set spesialisasi sebagai "General"
    }

    @Override
    public void displayInfo() {
        // Menampilkan informasi dokter umum
        System.out.println("General Doctor Name: " + getName() + ", Contact: " + getContactNumber());
    }
}
