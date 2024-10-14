# MiniProject_PBO
Nama : Muhammad Arifin Dava ( 2309116059 ) ...... TEMA PROJECT : Manajemen Sistem Rumah Sakit


Studi Kasus Manajemen Sistem Rumah Sakit:

Program ini dirancang untuk mengelola informasi pasien dan dokter dalam sebuah rumah sakit.
Pengguna dapat melakukan operasi CRUD (Create, Read, Update, Delete) untuk pasien dan dokter, yang memungkinkan rumah sakit untuk mengelola data secara efisien dan efekti

Pembagian Class dan Properties
Package hospital:
Kelas Patient:
Properties:
name: Nama pasien (String)
age: Usia pasien (int)
illness: Penyakit pasien (String)
Fungsi: Menyimpan dan mengelola data pasien, serta menampilkan informasi pasien.

Kelas Doctor:
Properties:
name: Nama dokter (String)
specialization: Spesialisasi dokter (String)
contactNumber: Nomor kontak dokter (String)
Fungsi: Menyimpan dan mengelola data dokter, serta menampilkan informasi dokter.
Package management:

Kelas Hospital:
Properties:
patients: Daftar pasien (ArrayList<Patient>)
doctors: Daftar dokter (ArrayList<Doctor>)
Fungsi: Menyediakan antarmuka pengguna untuk operasi CRUD, mengelola daftar pasien dan dokter.


Penjelasan Program :
Class Patient
public class Patient {
    private String name;
    private int age;
    private String illness;
Kode ini mendefinisikan kelas Patient yang menyimpan informasi tentang pasien. Tiga properti privat (name, age, dan illness) digunakan untuk menyimpan nama, usia, dan penyakit pasien.

public Patient(String name, int age, String illness) {
        this.name = name;
        this.age = age;
        this.illness = illness;
    }
Constructor Patient menginisialisasi objek baru dengan nilai yang diberikan. Ini memungkinkan setiap objek Patient untuk memiliki data yang unik dan terdefinisi saat dibuat.

public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Illness: " + illness);
    }
Metode displayInfo mencetak informasi pasien ke konsol. Ini memberikan cara mudah untuk menampilkan detail pasien tanpa perlu mengakses properti secara langsung.

     // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
Getter dan setter digunakan untuk mengakses dan memperbarui nilai properti. Getter memungkinkan pembacaan nilai, sedangkan setter memungkinkan pengubahan nilai, memberikan fleksibilitas dalam mengelola data pasien.
Getter dan setter dalam kelas Doctor memungkinkan akses dan pembaruan properti, memberikan kemampuan untuk mengelola informasi dokter dengan lebih baik.

Class Doctor:
public class Doctor {
    private String name;
    private String specialization;
    private String contactNumber;
Kode ini mendefinisikan kelas Doctor, yang menyimpan informasi tentang dokter. Tiga properti privat (name, specialization, dan contactNumber) digunakan untuk menyimpan nama dokter, spesialisasi, dan nomor kontak.

    public Doctor(String name, String specialization, String contactNumber) {
        this.name = name;
        this.specialization = specialization;
        this.contactNumber = contactNumber;
    }
Constructor Doctor menginisialisasi objek baru dengan nilai yang diberikan, sehingga setiap objek Doctor memiliki data spesifik yang terkait dengan identitas dan spesialisasi mereka.

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("Contact Number: " + contactNumber);
    }
Metode displayInfo mencetak informasi dokter ke konsol, mencakup nama, spesialisasi, dan nomor kontak, memungkinkan pengguna untuk dengan mudah melihat detail dokter yang terdaftar.

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
Getter dan setter dalam kelas Doctor memungkinkan akses dan pembaruan properti, memberikan kemampuan untuk mengelola informasi dokter dengan lebih baik.

Class Hospital :
import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
Kode ini mendefinisikan kelas Hospital, yang menyimpan daftar pasien dan dokter menggunakan ArrayList. Dua properti statis ini memungkinkan penyimpanan data dinamis.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
Metode main adalah titik masuk utama program. Di sini, objek Scanner digunakan untuk membaca input dari pengguna, dan variabel choice akan digunakan untuk menentukan pilihan pengguna dalam menu.

        do {
            System.out.println("Menu:");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Display Patients");
            System.out.println("4. Display Doctors");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
Program menampilkan menu dengan beberapa pilihan. Pengguna diminta untuk memasukkan angka yang sesuai dengan tindakan yang ingin dilakukan, seperti menambahkan pasien atau dokter.

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.next();
                    System.out.print("Enter patient age: ");
                    int patientAge = scanner.nextInt();
                    System.out.print("Enter patient illness: ");
                    String patientIllness = scanner.next();
                    patients.add(new Patient(patientName, patientAge, patientIllness));
                    break;
Di dalam pernyataan switch, program akan menangani pilihan pengguna. Jika pengguna memilih untuk menambahkan pasien, informasi pasien akan diminta, dan objek Patient baru akan dibuat dan ditambahkan ke daftar pasien.

                case 2:
                    System.out.print("Enter doctor name: ");
                    String doctorName = scanner.next();
                    System.out.print("Enter doctor specialization: ");
                    String doctorSpecialization = scanner.next();
                    System.out.print("Enter doctor contact number: ");
                    String doctorContact = scanner.next();
                    doctors.add(new Doctor(doctorName, doctorSpecialization, doctorContact));
                    break;
Jika pengguna memilih untuk menambahkan dokter, informasi dokter akan diminta, dan objek Doctor baru akan dibuat dan ditambahkan ke daftar dokter.

                case 3:
                    System.out.println("Patients List:");
                    for (Patient patient : patients) {
                        patient.displayInfo();
                    }
                    break;
Jika pengguna memilih untuk menampilkan daftar pasien, program akan mencetak semua informasi pasien menggunakan metode displayInfo dari setiap objek Patient dalam daftar.

                case 4:
                    System.out.println("Doctors List:");
                    for (Doctor doctor : doctors) {
                        doctor.displayInfo();
                    }
                    break;
Jika pengguna memilih untuk menampilkan daftar dokter, program akan mencetak semua informasi dokter menggunakan metode displayInfo dari setiap objek Doctor dalam daftar.

                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);
        
        scanner.close();
    }
}
Jika pengguna memilih untuk keluar, program akan menampilkan pesan keluar dan menghentikan eksekusi. Jika pilihan tidak valid dimasukkan, program memberikan umpan balik kepada pengguna. Loop do-while digunakan untuk terus menampilkan menu hingga pengguna memilih untuk keluar.



Penjelasan Output Program
![image](https://github.com/user-attachments/assets/18d7314e-cc28-4714-a47b-1c0f9f5aa97f)
Tampilan awal, memilih role Pasien ataupun Dokter, dimana dokter
