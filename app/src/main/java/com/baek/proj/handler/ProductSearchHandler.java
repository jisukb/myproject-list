package com.baek.proj.handler;

import java.util.ArrayList;
import java.util.List;
import com.baek.proj.domain.Product;
import com.baek.util.Prompt;

public class ProductSearchHandler extends AbstractProductHandler {

  public ProductSearchHandler(List<Product> productList) {
    super(productList);
  }

  @Override
  public void service() {
    String keyword = Prompt.inputString("검색어> ");

    if (keyword.length() == 0) {
      System.out.println("검색어를 입력하세요.");
      return;
    }

    ArrayList<Product> list = new ArrayList<>();

    Product[] products = productList.toArray(new Product[productList.size()]);
    for (Product p : products) {
      if (p.getName().contains(keyword)) {
        list.add(p);
      }
    }

    if (list.isEmpty()) {
      System.out.println("해당 상품이 없습니다.");
      return;
    }

    for (Product p : list) {
      System.out.printf("%d. %s> %s %,d원 %s\n",
          p.getNo(), getChoiceCate(p.getCategory()), p.getName(), 
          p.getPrice(), getState(p.getStock()));
    }
  }
} 
