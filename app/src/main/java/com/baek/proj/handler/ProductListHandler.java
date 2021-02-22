package com.baek.proj.handler;

import java.util.Iterator;
import java.util.List;
import com.baek.proj.domain.Product;

public class ProductListHandler extends AbstractProductHandler {

  public ProductListHandler(List<Product> productList) {
    super(productList);
  }

  @Override
  public void service() {
    System.out.println("[상품 목록]");

    Iterator<Product> iterator = productList.iterator();
    while (iterator.hasNext()) {
      Product p = iterator.next();
      // 번호, 카테고리, 상품명, 가격, 재고상태
      System.out.printf("%d. %s> %s %,d원 %s\n",
          p.getNo(), getChoiceCate(p.getCategory()), p.getName(), 
          p.getPrice(), getState(p.getStock()));
    }
  }
} 
