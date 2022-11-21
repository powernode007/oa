package bjpn.bean;

import java.util.Objects;

public class Emp {
    private Integer empno;
    private String name;
    private String job;
    private String photo;
    private String hiredate;
    private String sal;
    private String deptno;

    public Emp(Integer empno, String name, String job, String photo, String hiredate, String sal, String deptno) {
        this.empno = empno;
        this.name = name;
        this.job = job;
        this.photo = photo;
        this.hiredate = hiredate;
        this.sal = sal;
        this.deptno = deptno;
    }

    public Emp() {
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return Objects.equals(empno, emp.empno) &&
                Objects.equals(name, emp.name) &&
                Objects.equals(job, emp.job) &&
                Objects.equals(photo, emp.photo) &&
                Objects.equals(hiredate, emp.hiredate) &&
                Objects.equals(sal, emp.sal) &&
                Objects.equals(deptno, emp.deptno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empno, name, job, photo, hiredate, sal, deptno);
    }

}
