package com.baek.proj.handler;

import java.util.List;
import com.baek.proj.domain.Product;
import com.baek.util.Prompt;

public class ProductDetailHandler extends AbstractProductHandler {

  public ProductDetailHandler(List<Product> productList) {
    super(productList);
  }

  @Override
  public void service() {
    System.out.println("[상품 상세]");

    int no = Prompt.inputInt("번호> ");
    Product product = findByNo(no);
    if (product == null) {
      System.out.println("해당 번호의 상품이 없습니다.");
      return;
    }
    System.out.printf("카테고리: %s\n", getChoiceCate(product.getCategory()));
    System.out.printf("상품명: %s\n", product.getName());
    System.out.printf("가격: %,d\n", product.getPrice());
    System.out.printf("재고상태: %s\n", getState(product.getStock()));
    System.out.printf("설명: %s\n", product.getInfo());
  }
} 
