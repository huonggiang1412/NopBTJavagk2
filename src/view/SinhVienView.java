package view;

import java.util.Scanner;

import controller.SinhVienController;

public class SinhVienView {
    private SinhVienController svController;

    public SinhVienView(SinhVienController svController) {
        this.svController = svController;
    }

    public void hienThiMenu() {
        System.out.println("----- Quản lý mượn trả sách -----");
        System.out.println("1. Thêm thẻ mượn");        
        System.out.println("2. Hiển thị danh sách thẻ mượn");
        System.out.println("3. Xóa thẻ mượn");
        System.out.println("4. Lưu danh sách thẻ mượn xuống file");
        System.out.println("5. Tải danh sách thẻ mượn từ file");
        System.out.println("0. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    public void thucHienChucNang(int luaChon) {
        Scanner scanner = new Scanner(System.in);
        switch (luaChon) {
            case 1:
            	svController.themTheMuon(scanner);
                break;
            case 2:
                svController.hienThiThongTin();
                break;
            case 3:
                svController.xoaTheMuon(scanner);
                break;
            case 4:
               svController.TestLuuFile();
                break;
            case 5:
            	svController.TestDocFile();
                break;
            case 0:
                System.out.println("Thoát chương trình.");
                System.exit(0);
                break;
            default:
                System.out.println("Chức năng không hợp lệ.");
        }
    }
}
