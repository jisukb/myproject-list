package com.baek.proj.domain;

import java.sql.Date;
import com.baek.util.CsvObject;

public class Employee implements CsvObject {
  private int no;
  private String name;
  private String dept;
  private String email;
  private String phone;
  private Date joinDate;

  public Employee() {}

  public Employee(String csv) {
    String[] fields = csv.split(","); // 번호,이름,부서,이메일,전화,입사일
    this.setNo(Integer.parseInt(fields[0]));
    this.setName(fields[1]);
    this.setDept(fields[2]);
    this.setEmail(fields[3]);
    this.setPhone(fields[4]);
    this.setJoinDate(Date.valueOf(fields[5]));
  }

  @Override
  public String toCsvString() {
    return String.format("%d,%s,%s,%s,%s,%s",
        this.getNo(),
        this.getName(),
        this.getDept(),
        this.getEmail(),
        this.getPhone(),
        this.getJoinDate());
  }

  // factory method pattern
  public static Employee valueOfCsv(String csv) {
    String[] fields = csv.split(","); // 번호,이름,부서,이메일,전화,입사일
    Employee e = new Employee();
    e.setNo(Integer.parseInt(fields[0]));
    e.setName(fields[1]);
    e.setDept(fields[2]);
    e.setEmail(fields[3]);
    e.setPhone(fields[4]);
    e.setJoinDate(Date.valueOf(fields[5]));
    return e;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + no;
    result = prime * result + ((phone == null) ? 0 : phone.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Employee other = (Employee) obj;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (no != other.no)
      return false;
    if (phone == null) {
      if (other.phone != null)
        return false;
    } else if (!phone.equals(other.phone))
      return false;
    return true;
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getDept() {
    return dept;
  }
  public void setDept(String dept) {
    this.dept = dept;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  public Date getJoinDate() {
    return joinDate;
  }
  public void setJoinDate(Date joinDate) {
    this.joinDate = joinDate;
  }

}
