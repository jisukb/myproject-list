package com.baek.proj.domain;

import com.baek.util.CsvObject;

public class Store implements CsvObject {
  private int no;
  private String name;
  private String address;
  private String tel;
  private String time;
  private String manager;

  public Store() {}

  public Store(String csv) {
    String[] fields = csv.split(","); // 번호,지점명,주소,전화,시간,매니저
    this.setNo(Integer.parseInt(fields[0]));
    this.setName(fields[1]);
    this.setAddress(fields[2]);
    this.setTel(fields[3]);
    this.setTime(fields[4]);
    this.setManager(fields[5]);
  }

  @Override
  public String toCsvString() {
    return String.format("%d,%s,%s,%s,%s,%s",
        this.getNo(),
        this.getName(),
        this.getAddress(),
        this.getTel(),
        this.getTime(),
        this.getManager());
  }

  public static Store valueOfCsv(String csv) {
    String[] fields = csv.split(","); // 번호,지점명,주소,전화,시간,매니저
    Store s = new Store();
    s.setNo(Integer.parseInt(fields[0]));
    s.setName(fields[1]);
    s.setAddress(fields[2]);
    s.setTel(fields[3]);
    s.setTime(fields[4]);
    s.setManager(fields[5]);
    return s;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((address == null) ? 0 : address.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + no;
    result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
    Store other = (Store) obj;
    if (address == null) {
      if (other.address != null)
        return false;
    } else if (!address.equals(other.address))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (no != other.no)
      return false;
    if (tel == null) {
      if (other.tel != null)
        return false;
    } else if (!tel.equals(other.tel))
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
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public String getTime() {
    return time;
  }
  public void setTime(String time) {
    this.time = time;
  }
  public String getManager() {
    return manager;
  }
  public void setManager(String manager) {
    this.manager = manager;
  }

}
