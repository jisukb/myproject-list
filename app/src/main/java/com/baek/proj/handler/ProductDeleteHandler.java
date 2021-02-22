package com.baek.proj.handler;

import java.util.List;
import com.baek.proj.domain.Product;
import com.baek.util.Prompt;

public class ProductDeleteHandler extends AbstractProductHandler {

  public ProductDeleteHandler(List<Product> productList) {
    super(productList);
  }

  @Override
  public void service() {
    System.out.println("[상품 삭제]");

    int no = Prompt.inputInt("번호> ");
    Product product = findByNo(no);
    if (product == null) {
      System.out.println("해당 번호의 상품이 없습니다.");
      return;
    }
    String input = Prompt.inputString("삭제하시겠습니까?(Y/N) ");
    if (input.equalsIgnoreCase("Y")) {
      productList.remove(product);
      System.out.println("상품 정보를 삭제하였습니다.");
    } else {
      System.out.println("삭제를 취소하였습니다.");
    }
  }
}
