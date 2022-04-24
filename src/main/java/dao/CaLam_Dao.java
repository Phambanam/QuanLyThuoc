package dao;

import ConnectDB.ConnectDB;
import Entity.CaLam;
import Entity.NhanVien;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CaLam_Dao {
    public List<CaLam> getAllCaLam() {
        List<CaLam> caLams = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "Select * from calam";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maCaLam = rs.getString(1);
                String tenCaLam = rs.getString(2);
                String thoiGianBatDau = rs.getString(3);
                String thoiGianKetThuc = rs.getString(4);
                CaLam caLam = new CaLam(maCaLam,tenCaLam,thoiGianBatDau,thoiGianKetThuc);
                caLams.add(caLam);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return caLams;
    }
}
