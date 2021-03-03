package com.baek.proj.domain;

import com.baek.util.CsvObject;

public class Product implements CsvObject {
  private int no;
  private int category;
  private String name;
  private int price;
  private int stock;
  private String info;

  public Product() {}

  public Product(String csv) {
    String[] fields = csv.split(","); // 번호,카테고리,상품명,가격,상태,설명
    this.setNo(Integer.parseInt(fields[0]));
    this.setCategory(Integer.parseInt(fields[1]));
    this.setName(fields[2]);
    this.setPrice(Integer.parseInt(fields[3]));
    this.setStock(Integer.parseInt(fields[4]));
    this.setInfo(fields[5]);
  }

  @Override
  public String toString() {
    return "Product [no=" + no + ", category=" + category + ", name=" + name + ", price=" + price
        + ", stock=" + stock + ", info=" + info + "]";
  }

  @Override
  public String toCsvString() {
    return String.format("%d,%d,%s,%d,%d,%s",
        this.getNo(),
        this.getCategory(),
        this.getName(),
        this.getPrice(),
        this.getStock(),
        this.getInfo());
  }

  public static Product valueOfCsv(String csv) {
    String[] fields = csv.split(","); // 번호,카테고리,상품명,가격,상태,설명
    Product p = new Product();
    p.setNo(Integer.parseInt(fields[0]));
    p.setCategory(Integer.parseInt(fields[1]));
    p.setName(fields[2]);
    p.setPrice(Integer.parseInt(fields[3]));
    p.setStock(Integer.parseInt(fields[4]));
    p.setInfo(fields[5]);
    return p;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((info == null) ? 0 : info.hashCode());
    result = prime * result + no;
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
    Product other = (Product) obj;
    if (info == null) {
      if (other.info != null)
        return false;
    } else if (!info.equals(other.info))
      return false;
    if (no != other.no)
      return false;
    return true;
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getCategory() {
    return category;
  }
  public void setCategory(int category) {
    this.category = category;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  public int getStock() {
    return stock;
  }
  public void setStock(int stock) {
    this.stock = stock;
  }
  public String getInfo() {
    return info;
  }
  public void setInfo(String info) {
    this.info = info;
  }

}
