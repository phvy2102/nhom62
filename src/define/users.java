/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package define;

/**
 *
 * @author ADMIN
 */
public class users {
    private int id;
    private String tenTK, matKhau, fullname, DoB, sdt, gioiTinh, bank, stk;
    
    public users(){
        
    }

    public users(users user) {
        this.id = user.id;
        this.tenTK = user.tenTK;
        this.matKhau = user.matKhau;
        this.fullname = user.fullname;
        this.DoB = user.DoB;
        this.sdt = user.sdt;
        this.gioiTinh = user.gioiTinh;
        this.bank = user.bank;
        this.stk = user.stk;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDoB() {
        return DoB;
    }

    public void setDoB(String DoB) {
        this.DoB = DoB;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getStk() {
        return stk;
    }

    public void setStk(String stk) {
        this.stk = stk;
    }
    
    
}
