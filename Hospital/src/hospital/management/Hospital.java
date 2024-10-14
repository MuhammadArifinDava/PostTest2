package hospital.management;

import hospital.entities.Doctor;
import hospital.entities.Patient;
import hospital.entities.Surgeon;
import hospital.entities.GeneralDoctor;
import hospital.entities.Person;
import hospital.interfaces.CrudOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Hospital implements CrudOperations<Person> {
    private final List<Doctor> doctors;
    private final List<Patient> patients;
    private final List<Surgeon> surgeons;

    public Hospital() {
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
        surgeons = new ArrayList<>();
    }

    @Override
    public void create(Person person) {
        if (person instanceof Surgeon) {
            surgeons.add((Surgeon) person);
            System.out.println("Surgeon added successfully.");
        } else if (person instanceof GeneralDoctor) {
            doctors.add((GeneralDoctor) person);
            System.out.println("Doctor added successfully.");
        } else if (person instanceof Patient) {
            patients.add((Patient) person);
            System.out.println("Patient added successfully.");
        }
    }

    @Override
    public Person read(String name) {
        for (Doctor doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(name)) {
                return doctor;
            }
        }
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                return patient;
            }
        }
        for (Surgeon surgeon : surgeons) {
            if (surgeon.getName().equalsIgnoreCase(name)) {
                return surgeon;
            }
        }
        return null;
    }

    @Override
    public void update(String name, Person newPerson) {
        if (newPerson instanceof Surgeon) {
            for (Surgeon surgeon : surgeons) {
                if (surgeon.getName().equalsIgnoreCase(name)) {
                    surgeon.setSpecialization(((Surgeon) newPerson).getSpecialization());
                    surgeon.setContactNumber(((Surgeon) newPerson).getContactNumber());
                    surgeon.setSurgerySpecialization(((Surgeon) newPerson).getSurgerySpecialization());
                    System.out.println("Surgeon updated successfully.");
                }
            }
        } else if (newPerson instanceof GeneralDoctor) {
            for (Doctor doctor : doctors) {
                if (doctor.getName().equalsIgnoreCase(name)) {
                    doctor.setSpecialization(((GeneralDoctor) newPerson).getSpecialization());
                    doctor.setContactNumber(((GeneralDoctor) newPerson).getContactNumber());
                    System.out.println("Doctor updated successfully.");
                }
            }
        } else if (newPerson instanceof Patient) {
            for (Patient patient : patients) {
                if (patient.getName().equalsIgnoreCase(name)) {
                    patient.setAge(((Patient) newPerson).getAge());
                    patient.setIllness(((Patient) newPerson).getIllness());
                    System.out.println("Patient updated successfully.");
                }
            }
        }
    }

    @Override
    public void delete(String name) {
        boolean removed = false;
        
        if (surgeons.removeIf(s -> s.getName().equalsIgnoreCase(name))) {
            removed = true;
            System.out.println("Surgeon deleted successfully.");
        }
        if (doctors.removeIf(d -> d.getName().equalsIgnoreCase(name))) {
            removed = true;
            System.out.println("Doctor deleted successfully.");
        }
        if (patients.removeIf(p -> p.getName().equalsIgnoreCase(name))) {
            removed = true;
            System.out.println("Patient deleted successfully.");
        }

        if (!removed) {
            System.out.println("Person not found.");
        }
    }

    // Method to display doctors
    public void displayDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("Belum ada dokter yang terdaftar.");
        } else {
            System.out.println("===============================================");
            System.out.println("||              DAFTAR DOKTER                ||");
            System.out.println("===============================================");
            System.out.printf("|| %-20s || %-20s || %-10s ||\n", "Nama", "Spesialisasi", "Kontak");
            System.out.println("===============================================");
            for (Doctor doctor : doctors) {
                System.out.printf("|| %-20s || %-20s || %-10s ||\n",
                        doctor.getName(), doctor.getSpecialization(), doctor.getContactNumber());
            }
            System.out.println("===============================================");
        }
    }

    // Method to display surgeons
    public void displaySurgeons() {
        if (surgeons.isEmpty()) {
            System.out.println("Belum ada surgeon yang terdaftar.");
        } else {
            System.out.println("===============================================");
            System.out.println("||             DAFTAR SURGEON                ||");
            System.out.println("===============================================");
            System.out.printf("|| %-20s || %-20s || %-10s || %-25s ||\n", "Nama", "Spesialisasi", "Kontak", "Surgery Specialization");
            System.out.println("===============================================");
            for (Surgeon surgeon : surgeons) {
                System.out.printf("|| %-20s || %-20s || %-10s || %-25s ||\n",
                        surgeon.getName(), surgeon.getSpecialization(), surgeon.getContactNumber(), surgeon.getSurgerySpecialization());
            }
            System.out.println("===============================================");
        }
    }

    // Method to display patients
    public void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println("Belum ada pasien yang terdaftar.");
        } else {
            System.out.println("===============================================");
            System.out.println("||              DAFTAR PASIEN                ||");
            System.out.println("===============================================");
            System.out.printf("|| %-20s || %-10s || %-20s ||\n", "Nama", "Umur", "Penyakit");
            System.out.println("===============================================");
            for (Patient patient : patients) {
                System.out.printf("|| %-20s || %-10d || %-20s ||\n",
                        patient.getName(), patient.getAge(), patient.getIllness());
            }
            System.out.println("===============================================");
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Scanner scanner = new Scanner(System.in);
        int roleChoice;

        do {
            System.out.println("===================================");
            System.out.println("Selamat Datang di Sistem Rumah Sakit");
            System.out.println("===================================");
            System.out.println("Apakah Anda seorang Dokter atau Pasien?");
            System.out.println("1. Dokter");
            System.out.println("2. Pasien");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi (1/2/0): ");
            roleChoice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            int choice;
            switch (roleChoice) {
                case 1: // Bagian dokter
                    do {
                        System.out.println("\nMenu Dokter:");
                        System.out.println("1. Tambah Dokter Umum");
                        System.out.println("2. Tambah Surgeon");
                        System.out.println("3. Lihat Dokter");
                        System.out.println("4. Lihat Surgeon");
                        System.out.println("5. Perbarui Dokter");
                        System.out.println("6. Perbarui Surgeon");
                        System.out.println("7. Hapus Dokter");
                        System.out.println("8. Hapus Surgeon");
                        System.out.println("0. Kembali");
                        System.out.print("Pilih opsi: ");
                        choice = scanner.nextInt();
                        scanner.nextLine();  // Consume newline

                        switch (choice) {
                            case 1:
                                System.out.print("Masukkan nama dokter: ");
                                String generalDoctorName = scanner.nextLine();
                                System.out.print("Masukkan nomor kontak: ");
                                String generalDoctorContact = scanner.nextLine();
                                GeneralDoctor generalDoctor = new GeneralDoctor(generalDoctorName, generalDoctorContact);
                                hospital.create(generalDoctor);
                                break;
                            case 2:
                                System.out.print("Masukkan nama surgeon: ");
                                String surgeonName = scanner.nextLine();
                                System.out.print("Masukkan spesialisasi: ");
                                String surgeonSpecialization = scanner.nextLine();
                                System.out.print("Masukkan nomor kontak: ");
                                String surgeonContact = scanner.nextLine();
                                System.out.print("Masukkan spesialisasi bedah: ");
                                String surgerySpecialization = scanner.nextLine();
                                Surgeon surgeon = new Surgeon(surgeonName, surgeonSpecialization, surgeonContact, surgerySpecialization);
                                hospital.create(surgeon);
                                break;
                            case 3:
                                hospital.displayDoctors();
                                break;
                            case 4:
                                hospital.displaySurgeons();
                                break;
                            case 5:
                                System.out.print("Masukkan nama dokter yang ingin diperbarui: ");
                                String updateDoctorName = scanner.nextLine();
                                System.out.print("Masukkan nomor kontak baru: ");
                                String newDoctorContact = scanner.nextLine();
                                GeneralDoctor updatedGeneralDoctor = new GeneralDoctor(updateDoctorName, newDoctorContact);
                                hospital.update(updateDoctorName, updatedGeneralDoctor);
                                break;
                            case 6:
                                System.out.print("Masukkan nama surgeon yang ingin diperbarui: ");
                                String updateSurgeonName = scanner.nextLine();
                                System.out.print("Masukkan nomor kontak baru: ");
                                String newSurgeonContact = scanner.nextLine();
                                System.out.print("Masukkan spesialisasi baru: ");
                                String newSurgerySpecialization = scanner.nextLine();
                                                                Surgeon updatedSurgeon = new Surgeon(updateSurgeonName, newSurgeonContact, newSurgerySpecialization, newSurgerySpecialization);
                                hospital.update(updateSurgeonName, updatedSurgeon);
                                break;
                            case 7:
                                System.out.print("Masukkan nama dokter yang ingin dihapus: ");
                                String deleteDoctorName = scanner.nextLine();
                                hospital.delete(deleteDoctorName);
                                break;
                            case 8:
                                System.out.print("Masukkan nama surgeon yang ingin dihapus: ");
                                String deleteSurgeonName = scanner.nextLine();
                                hospital.delete(deleteSurgeonName);
                                break;
                        }
                    } while (choice != 0);
                    break;

                case 2: // Bagian pasien
                    do {
                        System.out.println("\nMenu Pasien:");
                        System.out.println("1. Tambah Pasien");
                        System.out.println("2. Lihat Daftar Pasien");
                        System.out.println("3. Perbarui Pasien");
                        System.out.println("4. Hapus Pasien");
                        System.out.println("0. Kembali");
                        System.out.print("Pilih opsi: ");
                        choice = scanner.nextInt();
                        scanner.nextLine();  // Consume newline

                        switch (choice) {
                            case 1:
                                System.out.print("Masukkan nama pasien: ");
                                String patientName = scanner.nextLine();
                                System.out.print("Masukkan umur pasien: ");
                                int patientAge = scanner.nextInt();
                                scanner.nextLine();  // Consume newline
                                System.out.print("Masukkan penyakit pasien: ");
                                String patientIllness = scanner.nextLine();
                                Patient patient = new Patient(patientName, patientAge, patientIllness);
                                hospital.create(patient);
                                break;
                            case 2:
                                hospital.displayPatients();
                                break;
                            case 3:
                                System.out.print("Masukkan nama pasien yang ingin diperbarui: ");
                                String updatePatientName = scanner.nextLine();
                                System.out.print("Masukkan umur baru: ");
                                int newAge = scanner.nextInt();
                                scanner.nextLine();  // Consume newline
                                System.out.print("Masukkan penyakit baru: ");
                                String newIllness = scanner.nextLine();
                                Patient updatedPatient = new Patient(updatePatientName, newAge, newIllness);
                                hospital.update(updatePatientName, updatedPatient);
                                break;
                            case 4:
                                System.out.print("Masukkan nama pasien yang ingin dihapus: ");
                                String deletePatientName = scanner.nextLine();
                                hospital.delete(deletePatientName);
                                break;
                        }
                    } while (choice != 0);
                    break;
            }
        } while (roleChoice != 0);
        System.out.println("Terima kasih telah menggunakan sistem kami.");
    }
}

