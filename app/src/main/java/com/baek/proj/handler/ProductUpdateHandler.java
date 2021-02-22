package com.baek.proj.handler;

import java.util.List;
import com.baek.proj.domain.Product;
import com.baek.util.Prompt;

public class ProductUpdateHandler extends AbstractProductHandler {

  public ProductUpdateHandler(List<Product> productList) {
    super(productList);
  }

  @Override
  public void service() {
    System.out.println("[상품 수정]");

    int no = Prompt.inputInt("번호> ");
    Product product = findByNo(no);
    if (product == null) {
      System.out.println("해당 번호의 상품이 없습니다.");
      return;
    } 
    int category = Prompt.inputInt(String.format(
        "카테고리\n0: 서적\n1: 굿즈\n2: 음반\n> ", getChoiceCate(product.getCategory())));
    String name = Prompt.inputString(String.format("상품명(%s)> ", product.getName()));
    int price = Prompt.inputInt(String.format("가격(%,d)> ", product.getPrice()));
    int stock = Prompt.inputInt(String.format(
        "재고상태\n0: 예약상품\n1: 판매중\n2: 품절\n> ", getState(product.getStock())));
    String info = Prompt.inputString(String.format("설명(%s)> ", product.getInfo()));

    String input = Prompt.inputString("변경하시겠습니까?(Y/N) ");
    if (input.equalsIgnoreCase("Y")) {
      product.setCategory(category);
      product.setName(name);
      product.setPrice(price);
      product.setStock(stock);
      product.setInfo(info);
      System.out.println("상품 정보를 변경하였습니다.");
    } else {
      System.out.println("수정을 취소하였습니다.");
    }
  }
}
