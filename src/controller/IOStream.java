package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import object.TheMuon;
public class IOStream {
	public static boolean luuFile(ArrayList<TheMuon> dskh, String path) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            // Sử dụng OutputStreamWriter để ghi UTF-8
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            // ObjectOutputStream cho phép ghi đối tượng xuống ổ cứng
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            // Ghi danh sách khách hàng xuống file
            objectOutputStream.writeObject(dskh);
            // Đóng outputStreamWriter và objectOutputStream
            outputStreamWriter.close();
            objectOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<TheMuon> docFile(String path) {
        ArrayList<TheMuon> dskh = new ArrayList<TheMuon>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            // Sử dụng InputStreamReader để đọc UTF-8
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object data = objectInputStream.readObject();
            dskh = (ArrayList<TheMuon>) data;
            // Đóng inputStreamReader và objectInputStream
            inputStreamReader.close();
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dskh;
    }

}
