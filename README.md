# MiniProject_PBO
Nama : Muhammad Arifin Dava ( 2309116059 ) ...... TEMA PROJECT : Manajemen Sistem Rumah Sakit


Studi Kasus Manajemen Sistem Rumah Sakit:

Program ini dirancang untuk mengelola informasi pasien dan dokter dalam sebuah rumah sakit.
Pengguna dapat melakukan operasi CRUD (Create, Read, Update, Delete) untuk pasien dan dokter, yang memungkinkan rumah sakit untuk mengelola data secara efisien dan efekti

Inheritance (minimal terdapat 2 subclass):
Penjelasan: Inheritance (pewarisan) digunakan untuk membuat subclass yang mewarisi properti dan metode dari superclass-nya. Pada program ini, Doctor adalah superclass, dan ada dua subclass:
GeneralDoctor: Mewarisi dari Doctor.
Surgeon: Mewarisi dari Doctor dan menambahkan atribut serta metode spesifik untuk ahli bedah, seperti surgerySpecialization.
Contoh:
public class GeneralDoctor extends Doctor {
    // Kelas dokter umum
}

public class Surgeon extends Doctor {
    private String surgerySpecialization;
    // Kelas untuk dokter bedah
}

2. Encapsulation (getter dan setter):
Penjelasan: Encapsulation diterapkan dengan membuat properti dalam kelas bersifat private dan menyediakan akses melalui getter dan setter untuk menjaga kontrol akses data. Ini memastikan bahwa data tidak bisa diakses langsung dari luar kelas, melainkan harus melalui metode getter dan setter.
Contoh:
Pada kelas Doctor:
private String name;
private String specialization;
private String contactNumber;

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}
Begitu juga pada kelas Patient, encapsulation digunakan untuk menyimpan informasi pasien seperti umur, penyakit, dan nama.

3. Abstraction (Interface dan abstraction dapat dijadikan satu):
Penjelasan: Abstraction diterapkan dengan menggunakan interface CrudOperations yang mengabstraksi operasi CRUD (Create, Read, Update, Delete). Semua kelas yang terlibat dalam sistem ini (dokter, pasien, dan rumah sakit) menggunakan interface ini untuk menjalankan operasi tersebut, tanpa perlu mengkhawatirkan implementasi detail di luar kelas yang mengimplementasikan interface tersebut.
Contoh:
CrudOperations<Person> digunakan di kelas Hospital untuk memanipulasi data dokter, pasien, dan surgeon:
public interface CrudOperations<T> {
    void create(T entity);
    T read(String name);
    void update(String name, T newEntity);
    void delete(String name);
}

4. Interface (dapat diterapkan untuk CRUD):
Penjelasan: Interface CrudOperations digunakan untuk menerapkan metode CRUD (Create, Read, Update, Delete). Kelas Hospital mengimplementasikan interface ini untuk menangani dokter, surgeon, dan pasien. Setiap entitas (dokter, surgeon, pasien) dapat ditambahkan, diperbarui, dihapus, dan dilihat melalui metode yang diimplementasikan dalam kelas Hospital.
Contoh:
Dalam Hospital.java, interface CRUD diterapkan pada beberapa entitas:
@Override
public void create(Person person) {
    if (person instanceof Surgeon) {
        surgeons.add((Surgeon) person);
    }
    // Logika yang sama untuk entitas lain
}

5. Final keyword (class dan properti):
Penjelasan: Keyword final digunakan untuk memastikan bahwa kelas atau properti tertentu tidak dapat diubah. Dalam program ini:
Kelas Hospital dideklarasikan sebagai final, yang berarti tidak dapat diwarisi oleh kelas lain.
Beberapa properti dalam kelas seperti doctors, patients, dan surgeons juga menggunakan final untuk memastikan daftar ini tidak dapat direferensikan ulang ke objek lain setelah diinisialisasi.
Contoh:
public final class Hospital implements CrudOperations<Person> {
    private final List<Doctor> doctors;
    private final List<Patient> patients;
    private final List<Surgeon> surgeons;
}
Studi Kasus Program:
Program ini adalah sistem manajemen rumah sakit sederhana yang memungkinkan pengelolaan data dokter (umum dan surgeon), serta pasien. Administrator rumah sakit dapat melakukan operasi CRUD untuk dokter, surgeon, dan pasien melalui terminal.

Pembagian Kelas:
Kelas Hospital (Main Class):

Kelas ini bertanggung jawab untuk mengelola seluruh data dokter, surgeon, dan pasien, serta menyediakan metode CRUD untuk setiap entitas. Interface CrudOperations diterapkan di kelas ini.
Operasi seperti menambahkan, memperbarui, melihat, dan menghapus dokter/surgeon/pasien diatur melalui menu interaktif.
Kelas Person:

Sebagai kelas abstrak yang digunakan sebagai blueprint untuk entitas lainnya seperti Doctor dan Patient.
Properti umum seperti name dan contactNumber diatur di kelas ini.
Kelas Doctor (Superclass):

Mewakili dokter dengan properti seperti name, specialization, dan contactNumber. Kelas ini diwarisi oleh GeneralDoctor dan Surgeon.
Kelas GeneralDoctor (Subclass):

Kelas yang spesifik untuk dokter umum. Tidak menambahkan properti baru, hanya menggunakan properti dari kelas Doctor.
Kelas Surgeon (Subclass):

Kelas yang spesifik untuk dokter bedah. Menambahkan properti tambahan surgerySpecialization untuk membedakan spesialisasi bedah.
Kelas Patient:

Mewakili pasien dengan atribut seperti name, age, dan illness. Sama seperti entitas dokter, entitas pasien juga mendukung operasi CRUD.


Penjelasan Output Program
![image](https://github.com/user-attachments/assets/4ba41075-966a-48ca-8c3f-5f45a7b2d0e1)
Diawal terdapat welcome message pada menu utama dan juga pemilihan role, disini kita akan mencoba pilih 1 untuk Role Dokter, 
Kemudian pada role dokter, terdapat 8 menu, kemudian kita dapat memilih fitur 1 untuk menambahkan dokter umum yang hanya memiliki informasi data nama, nomor kontak saja karena termasuk dokter umum
Menu Dokter:
1. Tambah Dokter Umum
2. Tambah Surgeon
3. Lihat Dokter
4. Lihat Surgeon
5. Perbarui Dokter
6. Perbarui Surgeon
7. Hapus Dokter
8. Hapus Surgeon


![image](https://github.com/user-attachments/assets/f64e3cef-4638-4ed2-b300-f693e8c8b767)
Kemudian untuk opsi 2, yaitu penambahan surgeon atau dokter spesialis, terdapat nama, spesialisasi, nomor kontak, kemudian speasialisasi yang lebih spesifik

![image](https://github.com/user-attachments/assets/719752c7-dcf9-4a01-bef5-5e2d85973927)
Berikut tampilan untuk menampilkan dokter umum dan surgeon dengan opsi 3 dan 4

![image](https://github.com/user-attachments/assets/a804133a-edf3-434e-8389-7af995909fe0)
pada opsi 5 dan 6 untuk memperbarui data dokter ataupun surgeon berdasarkan nama dokter/surgeon tersebut

![image](https://github.com/user-attachments/assets/11c6def2-af77-4686-b219-5d94cc9903f2)
berikut hasil setelah diperbarui

![image](https://github.com/user-attachments/assets/8b9a7f24-d955-4bfa-8d16-cfcc5a392fc1)
Opsi 7 dan 8 yaitu fitur delete untuk menghapus dokter/surgeon

![image](https://github.com/user-attachments/assets/51f21ce7-d682-41bf-b2bd-7eb2fadf0f1a)
Ketika ditampilkan, tidak terdapat surgeon dan dokter karena sudah dihapus sebelumnya

Ketika input 0 maka langsung keluar dari role dokter, kemudian kembali ke menu utama, dan memilih 2 untuk masuk ke menu pasien, pada menu pasien terdapat 4 menu, kemudian memilih 1 untuk menambahkan pasien dengan data nama, umur, penyakit

Menu Pasien:
1. Tambah Pasien
2. Lihat Daftar Pasien
3. Perbarui Pasien
4. Hapus Pasien
0. Kembali

![image](https://github.com/user-attachments/assets/4ca2a0c5-96df-4d80-8be6-9b1fdadee83d)
Ketika input 3 maka dapat memperbarui data pasien berdasarkan nama pasien, kemudian update umur dan penyakit, dan input 2 untuk melihat data pasien yg telah diupdate

![image](https://github.com/user-attachments/assets/c47ac999-f125-4ec6-9e32-25137cdac245)
Di akhir ,terdapat input 4 untuk delete pasien berdasarkan nama juga, kemudian input 0 jika telah selesai menggunakan menu pasien, dan kembali ke menu utama dan kemudian input 0 untuk mengakhiri program
