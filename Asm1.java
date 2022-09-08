package vn.funix.fx17332.java.asm01;

import java.util.*;

public class Asm1 {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        chucNangChinh();

    }

    public static void chucNangChinh() {
        System.out.println("+----------+-----------------------------------+---------+");
        System.out.println("| NGAN HANG SO  |  FX17332@v1.0.0                        |");
        System.out.println("+----------+-----------------------------------+---------+");
        System.out.println("| 1. Nhập CCCD:                                          |");
        System.out.println("| 0. Thoát:                                              |");
        System.out.println("+----------+-----------------------------------+---------+");
        System.out.print("Chức năng: ");
        int chon = sc.nextInt();
        if (chon == 1) {
            nhapMaXacThuc();
        } else if (chon == 0) {
            thoatChuongTrinh();
        } else{
            System.out.println("Không có chức năng này. Vui lòng chọn 0 để thoát, hoặc 1 để tiếp tục");

        }

    }

    public static void nhapMaXacThuc() {
//        int min = 100;
//        int max = 999;
//        int randomNum = (int) (Math.random() * (max - min + 1) + min);
//        int maxacthuc = sc.nextInt();

        int minChuHoa = 65;
        int maxChuThuong = 122 ;
        int doDai = 6;
        Random random = new Random();
        String randomString = random.ints(minChuHoa, maxChuThuong + 1).filter(i -> (i<=90 || i >= 97) && (i<=122 || i >= 97)).limit(doDai).collect(StringBuilder::new,StringBuilder::appendCodePoint, StringBuilder::append).toString();
        System.out.println("Nhập mã xác thực: " + randomString);
        String maXacThuc = "";
        do {
            maXacThuc= sc.next();
            if (maXacThuc.equals(randomString)) {
                checkId();
                break;
            } else {
                System.out.println("Mã xác thực không đúng. Vui lòng nhập lại: ");

            }
        }while (!maXacThuc.equals(randomString));

    }

    public static void checkId() {
        System.out.print("Vui lòng nhập số CCCD: ");
        String soCCCD = sc.next();
        //kiểm tra số CCCD hợp lệ
        for (int i = 0; i < soCCCD.length(); i++) {
            if (soCCCD.charAt(i) < '0' || soCCCD.charAt(i) > '9') {
                System.out.println("Số CCCD không hợp lệ.");
                nhapLaiOrThoat();
            }
            if (soCCCD.length() != 12) {
                System.out.println("Độ dài số CCCD không hợp lệ.");
                nhapLaiOrThoat();

            }
        }

        hienThiChucNangchinh();
        boolean thoat = false;
        int choice = 0;
        while (!thoat){
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    hienThiNoiSinh(soCCCD);
                    break;
                case 2:
                    hienThiGioiTinhNamSinh(soCCCD);
                    break;
                case 3:
                    soNgauNhien(soCCCD);
                    break;
                case 0:
                    thoat = true;
                    thoatChuongTrinh();
                    break;
                default:
                    System.out.println("Không có chức năng này. Vui lòng chọn đúng chức năng");
                    break;
            }
        }
    }

    public static void hienThiNoiSinh(String soCCCD) {
        String maTinh = soCCCD.substring(0, 3);
        Map<String, String> provinceMap = new HashMap<>();
        provinceMap.put("083", "Bến Tre");
        provinceMap.put("082", "Tiền Giang");
        provinceMap.put("001", "Hà Nội");
        provinceMap.put("079", "Hồ Chí Minh");
        provinceMap.put("037", "Ninh Bình");
        provinceMap.put("002", "Hà Giang");
        provinceMap.put("048", "Đà Nẳng");
        String tenTinh = provinceMap.get(maTinh);
            if (provinceMap.containsKey(maTinh)) {
                System.out.println("Nơi sinh: " + tenTinh);
                hienThiChucNangchinh();
            } else {
                System.out.println("Thông tin mã tỉnh thành không hợp lệ");
//                chucNangChinh();
                checkId();
            }

    }
    public static void hienThiGioiTinhNamSinh(String soCCCD){
        String gioiTinh = soCCCD.substring(3, 4);
        String namSinh = soCCCD.substring(4, 6);
        int gioiTinh1 = Integer.parseInt(gioiTinh);
        int namSinh1 = Integer.parseInt(namSinh);
            if (gioiTinh1 == 0) {
                System.out.println("Giới tính: Nam " + " | 19" + namSinh1);
            } else if (gioiTinh1 == 1) {
                System.out.println("Giới tính: Nữ " + " | 19" + namSinh1);
            } else if (gioiTinh1 == 2) {
                System.out.println("Giới tính: Nam " + " | 20" + namSinh1);
            } else if (gioiTinh1 == 3) {
                System.out.println("Giới tính: Nữ " + " | 20" + namSinh1);
            } else if (gioiTinh1 == 4) {
                System.out.println("Giới tính: Nam " + " | 21" + namSinh1);
            } else if (gioiTinh1 == 5) {
                System.out.println("Giới tính: Nữ " + " | 21" + namSinh1);
            } else if (gioiTinh1 == 6) {
                System.out.println("Giới tính: Nam " + " | 22" + namSinh1);
            } else if (gioiTinh1 == 7) {
                System.out.println("Giới tính: Nữ " + " | 22" + namSinh1);
            } else if (gioiTinh1 == 8) {
                System.out.println("Giới tính: Nam " + " | 23" + namSinh1);
            } else if (gioiTinh1 == 9) {
                System.out.println("Giới tính: Nữ " + " | 23" + namSinh1);
            } else {
                System.out.println("Thông tin không hợp lệ.");
            }
            hienThiChucNangchinh();
    }
    public static void soNgauNhien(String soCCCD){
        String soNgauNhien = soCCCD.substring(6, 12);
        System.out.println("Số ngẩu nhiên: " + soNgauNhien);
        hienThiChucNangchinh();
    }


    public static void hienThiChucNangchinh() {
        System.out.println("| 1. Kiểm tra nơi sinh");
        System.out.println("| 2. Kiểm tra tuổi, giới tính");
        System.out.println("| 3. Kiểm tra số ngẩu nhiên");
        System.out.println("| 0. Thoát");
        System.out.print("Chức năng: ");

    }

    public static void nhapLaiOrThoat() {
        System.out.println("Vui Lòng nhấn 1 để nhập lại, hoặc nhấn No để thoát");
        String str = sc.next();
        String s1 = "No";
        String s2 = "1";
        if (str.equalsIgnoreCase(s1)) {
            System.out.println("Bạn đã thoát khỏi chương trình");
            System.exit(0);
        } else if (str.equals(s2)) {
            checkId();
        }


    }

    public static void thoatChuongTrinh() {
        System.out.println("Bạn đã thoát khỏi chương trình");
//        printChoice();
        System.exit(0);
    }

}
