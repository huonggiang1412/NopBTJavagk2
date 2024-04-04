package controller;
import java.util.ArrayList;
import java.util.Scanner;

import model.QuanLyMuonTra;
import object.SinhVien;
import object.TheMuon;

public class SinhVienController {
	QuanLyMuonTra quanLyMuonTra;
	private ArrayList<TheMuon> dstm;
	
	public SinhVienController() {
        quanLyMuonTra = new QuanLyMuonTra();
        dstm = quanLyMuonTra.getDanhSachTheMuon();
    }

	public QuanLyMuonTra getQuanLyMuonTra() {
		return quanLyMuonTra;
	}

	public void setQuanLyMuonTra(QuanLyMuonTra quanLyMuonTra) {
		this.quanLyMuonTra = quanLyMuonTra;
	}

	public void hienThiThongTin() {
        dstm.forEach(theMuon -> {
            System.out.println("Mã phiếu mượn: " + theMuon.getMaPhieuMuon());
            System.out.println("Ngày mượn: " + theMuon.getNgayMuon());
            System.out.println("Hạn trả: " + theMuon.getHanTra());
            System.out.println("Số hiệu sách: " + theMuon.getSoHieuSach());
            System.out.println("Thông tin sinh viên:");
            SinhVien sinhVien = theMuon.getSinhVienMuon();
            System.out.println("Họ tên: " + sinhVien.getHoTen());
            System.out.println("Tuổi: " + sinhVien.getTuoi());
            System.out.println("Lớp: " + sinhVien.getLop());
            System.out.println("--------------------------");
        });
    }
	public void themTheMuon(Scanner scanner) {
        System.out.print("Nhập mã phiếu mượn: ");
        int maPhieuMuon = scanner.nextInt();
        System.out.print("Nhập ngày mượn: ");
        int ngayMuon = scanner.nextInt();
        System.out.print("Nhập hạn trả: ");
        int hanTra = scanner.nextInt();
        System.out.print("Nhập số hiệu sách: ");
        int soHieuSach = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Nhập họ và tên sinh viên: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhập tuổi sinh viên: ");
        int tuoi = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Nhập lớp sinh viên: ");
        String lop = scanner.nextLine();
        SinhVien sinhVien = new SinhVien(hoTen, tuoi, lop);
        TheMuon theMuon = new TheMuon(maPhieuMuon, ngayMuon, hanTra, soHieuSach, sinhVien);
        quanLyMuonTra.themTheMuon(theMuon);
        System.out.println("Thêm thẻ mượn thành công.");
    }

    public void xoaTheMuon(Scanner scanner) {
        System.out.print("Nhập mã phiếu mượn cần xóa: ");
        int maPhieuMuon = scanner.nextInt();
		quanLyMuonTra.xoaTheMuon(maPhieuMuon);
        System.out.println("Xóa thẻ mượn thành công.");
    }
    public void TestLuuFile() {
	hienThiThongTin();
	boolean kt = IOStream.luuFile(dstm, "D:\\QLSV.txt");
	if (kt == true) {
		System.out.println("Đã lưu file thành công");
	} else {
		System.out.println("Lưu file thất bại");

	} 
    
    }
    public void TestDocFile() {
    dstm = IOStream.docFile("D:\\QLSV.txt");
	System.out.println("Danh sách sinh viên nạp vào máy tính là:");
	System.out.println("Mã\tNgày mượn\tHạn trả\tHiệu sách\tTên\tTuổi\tLớp");
	for (TheMuon themuon : dstm) {
		System.out.println(themuon);
	}
}
}
