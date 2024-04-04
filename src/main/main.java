package main;

import java.util.Scanner;

import controller.SinhVienController;
import view.SinhVienView;

public class main {
	    public static void main(String[] args) {
	        SinhVienController svcontroller = new SinhVienController();
	        SinhVienView sinhVienView = new SinhVienView(svcontroller);
	        Scanner scanner = new Scanner(System.in);
	        while (true) {
	            sinhVienView.hienThiMenu();
	            int luaChon = scanner.nextInt();
	            sinhVienView.thucHienChucNang(luaChon);
	        }
	    }
	}

