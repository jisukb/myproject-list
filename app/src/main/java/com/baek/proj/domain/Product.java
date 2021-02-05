package com.baek.proj.domain;

public class Product {
  private int no;
  private int category;
  private String name;
  private int price;
  private int stock;
  private String info;

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
