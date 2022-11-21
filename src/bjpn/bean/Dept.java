package bjpn.bean;

import java.util.Objects;

public class Dept {
    private int deptNo;
    private String deptName;
    private String deptLoc;

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptLoc() {
        return deptLoc;
    }

    public void setDeptLoc(String deptLoc) {
        this.deptLoc = deptLoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dept dept = (Dept) o;
        return deptNo == dept.deptNo &&
                Objects.equals(deptName, dept.deptName) &&
                Objects.equals(deptLoc, dept.deptLoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptNo, deptName, deptLoc);
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptNo=" + deptNo +
                ", deptName='" + deptName + '\'' +
                ", deptLoc='" + deptLoc + '\'' +
                '}';
    }

    public Dept(int deptNo, String deptName, String deptLoc) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.deptLoc = deptLoc;
    }
    public Dept(){}
}
