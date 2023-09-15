package com.qltv;

import java.time.LocalDate;

public class Sach {
    private Long id;
    private String tenSach;
    private String tacGia;
    private LocalDate ngayNhap;
    private NhanVien nhanVien;

    public Sach() {
    }

    public Sach(Long id, String tenSach, String tacGia, LocalDate ngayNhap, NhanVien nhanVien) {
        this.id = id;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.ngayNhap = ngayNhap;
        this.nhanVien = nhanVien;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
}
