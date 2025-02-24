import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SinhVien {
    String firstName;
    String lastName;
    String birthDate;
    String address;
    String className;
    double lapTrinhHD;
    double quanLyDuAn;
    double hocMay;
    double coSoDuLieu;
    double lapTrinhTBD;

    // Constructor
    public SinhVien(String firstName, String lastName, String birthDate, String address, String className,
                    double lapTrinhHD, double quanLyDuAn, double hocMay, double coSoDuLieu, double lapTrinhTBD) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.className = className;
        this.lapTrinhHD = lapTrinhHD;
        this.quanLyDuAn = quanLyDuAn;
        this.hocMay = hocMay;
        this.coSoDuLieu = coSoDuLieu;
        this.lapTrinhTBD = lapTrinhTBD;
    }

    // Tính điểm trung bình
    public double tinhDiemTrungBinh() {
        return (lapTrinhHD + quanLyDuAn + hocMay + coSoDuLieu + lapTrinhTBD) / 5;
    }

    // Xác định rank của sinh viên
    public String xacDinhRank() {
        double diemTB = tinhDiemTrungBinh();
        if (diemTB >= 8) {
            return "A";
        } else if (diemTB >= 7) {
            return "B";
        } else if (diemTB >= 6) {
            return "C";
        } else if (diemTB >= 5) {
            return "D";
        } else {
            return "<D";
        }
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " - " + "Rank: " + xacDinhRank() + " - Diem TB: " + tinhDiemTrungBinh();
    }
}

class LopHoc {
    String classCode;
    String className;
    List<SinhVien> danhSachSinhVien;

    // Constructor
    public LopHoc(String classCode, String className) {
        this.classCode = classCode;
        this.className = className;
        this.danhSachSinhVien = new ArrayList<>();
    }

    // Thêm sinh viên vào lớp
    public void themSinhVien(SinhVien sinhVien) {
        danhSachSinhVien.add(sinhVien);
    }

    // Tính số sinh viên theo rank
    public void tinhSoSinhVienTheoRank() {
        int countA = 0, countB = 0, countC = 0, countD = 0, countLessD = 0;
        for (SinhVien sinhVien : danhSachSinhVien) {
            String rank = sinhVien.xacDinhRank();
            switch (rank) {
                case "A": countA++; break;
                case "B": countB++; break;
                case "C": countC++; break;
                case "D": countD++; break;
                case "<D": countLessD++; break;
            }
        }
        System.out.println("Danh sách sinh viên theo rank:");
        System.out.println("Rank A: " + countA);
        System.out.println("Rank B: " + countB);
        System.out.println("Rank C: " + countC);
        System.out.println("Rank D: " + countD);
        System.out.println("Rank <D: " + countLessD);
    }

    // In danh sách sinh viên trong lớp
    public void hienThiDanhSachSinhVien() {
        System.out.println("Danh sách sinh viên lớp: " + className);
        for (SinhVien sinhVien : danhSachSinhVien) {
            System.out.println(sinhVien);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tạo các lớp học
        LopHoc lop1 = new LopHoc("IT101", "Lớp CNTT 1");
        LopHoc lop2 = new LopHoc("IT102", "Lớp CNTT 2");

        // Thêm sinh viên vào các lớp học
        lop1.themSinhVien(new SinhVien("Nguyen", "Anh", "01/01/2000", "Hà Nội", "Lớp CNTT 1", 8, 7.5, 8, 6.5, 7));
        lop1.themSinhVien(new SinhVien("Tran", "Bich", "15/02/2001", "Hà Nội", "Lớp CNTT 1", 7.5, 8, 7, 6, 7.5));
        lop2.themSinhVien(new SinhVien("Le", "Nam", "10/03/2000", "Hồ Chí Minh", "Lớp CNTT 2", 5, 6, 7.5, 6.5, 5.5));
        lop2.themSinhVien(new SinhVien("Pham", "Mai", "25/04/2001", "Đà Nẵng", "Lớp CNTT 2", 9, 8.5, 9, 7.5, 8.5));

        // Hiển thị các lớp học
        System.out.println("Danh sách lớp học:");
        System.out.println("1. Lớp CNTT 1");
        System.out.println("2. Lớp CNTT 2");

        System.out.print("Chọn lớp để xem danh sách sinh viên (nhập số lớp): ");
        int luaChon = scanner.nextInt();

        if (luaChon == 1) {
            lop1.hienThiDanhSachSinhVien();
            lop1.tinhSoSinhVienTheoRank();
        } else if (luaChon == 2) {
            lop2.hienThiDanhSachSinhVien();
            lop2.tinhSoSinhVienTheoRank();
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }

        scanner.close();
    }
}
