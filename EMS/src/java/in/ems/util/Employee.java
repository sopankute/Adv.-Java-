
package in.ems.util;

/**
 *
 * @author sadhu
 */
public class Employee {
    private int eid;
    private String name;
    private String pwd;
    private String cpwd;
    private String email;
    private int mobile;

    @Override
    public String toString() {
        return "Employee{" + "eid=" + eid + ", name=" + name + ", pwd=" + pwd + ", cpwd=" + cpwd + ", email=" + email + ", mobile=" + mobile + '}';
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCpwd() {
        return cpwd;
    }

    public void setCpwd(String cpwd) {
        this.cpwd = cpwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
}
