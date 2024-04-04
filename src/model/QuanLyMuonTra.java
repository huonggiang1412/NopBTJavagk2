package model;

import java.util.ArrayList;

import object.TheMuon;

public class QuanLyMuonTra {
	private ArrayList<TheMuon> danhSachTheMuon;
	
	public ArrayList<TheMuon> getDanhSachTheMuon() {
        return danhSachTheMuon;
    }
	public QuanLyMuonTra(ArrayList<TheMuon> danhSachTheMuon) {
		super();
		this.danhSachTheMuon = danhSachTheMuon;
	}
	public QuanLyMuonTra() {
		super();
		this.danhSachTheMuon = new ArrayList<> ();
	}
	public void themTheMuon(TheMuon theMuon) {
        danhSachTheMuon.add(theMuon);
    }

    public void xoaTheMuon(int maPhieuMuon) {
        danhSachTheMuon.removeIf(theMuon -> theMuon.getMaPhieuMuon() == maPhieuMuon);
    }


	
	
}

