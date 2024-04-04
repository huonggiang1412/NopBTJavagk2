package object;

import java.io.Serializable;

public class TheMuon implements Serializable {
	private int maPhieuMuon;
    private int ngayMuon;
    private int hanTra;
    private int soHieuSach;
    private SinhVien sinhVienMuon;

    public TheMuon(int maPhieuMuon, int ngayMuon, int hanTra, int soHieuSach, SinhVien sinhVienMuon) {
        this.maPhieuMuon = maPhieuMuon;
        this.ngayMuon = ngayMuon;
        this.hanTra = hanTra;
        this.soHieuSach = soHieuSach;
        this.sinhVienMuon = sinhVienMuon;
    }

	public int getMaPhieuMuon() {
		return maPhieuMuon;
	}

	public void setMaPhieuMuon(int maPhieuMuon) {
		this.maPhieuMuon = maPhieuMuon;
	}

	public int getNgayMuon() {
		return ngayMuon;
	}

	public void setNgayMuon(int ngayMuon) {
		this.ngayMuon = ngayMuon;
	}

	public int getHanTra() {
		return hanTra;
	}

	public void setHanTra(int hanTra) {
		this.hanTra = hanTra;
	}

	public int getSoHieuSach() {
		return soHieuSach;
	}

	public void setSoHieuSach(int soHieuSach) {
		this.soHieuSach = soHieuSach;
	}

	public SinhVien getSinhVienMuon() {
		return sinhVienMuon;
	}

	public void setSinhVienMuon(SinhVien sinhVienMuon) {
		this.sinhVienMuon = sinhVienMuon;
	}

	@Override
	public String toString() {
		return this.maPhieuMuon +"\t"+this.ngayMuon+"\t\t"+this.hanTra+"\t"+this.soHieuSach+"\t\t"+sinhVienMuon;
	}
	
    
}
