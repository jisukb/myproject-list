package com.baek.proj.handler;

import java.util.List;
import com.baek.proj.domain.Product;

public abstract class AbstractProductHandler implements Command {

  protected List<Product> productList;

  public AbstractProductHandler(List<Product> productList) {
    this.productList = productList;
  }

  protected String getChoiceCate(int category) {
    switch (category) {
      case 1:
        return "굿즈";
      case 2:
        return "음반";
      default:
        return "서적";
    }
  }

  protected String getState(int stock) {
    switch (stock) {
      case 1:
        return "판매 중입니다.";
      case 2:
        return "품절입니다.";
      default:
        return "예약상품입니다.";
    }
  }

  protected Product findByNo(int productNo) {
    Product[] list = productList.toArray(new Product[productList.size()]);
    for (Product p : list) {
      if (p.getNo() == productNo) {
        return p;
      }
    }
    return null;
  }

  protected Product findByName(String name) {
    Product[] list = productList.toArray(new Product[productList.size()]);
    for (Product p : list) {
      if (p.getName().equals(name)) {
        return p;
      }
    }
    return null;
  }
}
