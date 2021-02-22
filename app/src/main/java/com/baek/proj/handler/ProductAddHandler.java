package com.baek.proj.handler;

import java.util.List;
import com.baek.proj.domain.Product;
import com.baek.util.Prompt;

public class ProductAddHandler extends AbstractProductHandler {

  public ProductAddHandler(List<Product> productList) {
    super(productList);
  }

  @Override
  public void service() {
    System.out.println("[상품 등록]");

    Product p = new Product();
    p.setNo(Prompt.inputInt("번호> "));
    p.setCategory(Prompt.inputInt("카테고리\n0: 서적\n1: 굿즈\n2: 음반\n> "));
    p.setName(Prompt.inputString("상품명> "));
    p.setPrice(Prompt.inputInt("가격> "));
    p.setStock(Prompt.inputInt("재고상태\n0: 예약\n1: 판매중\n2: 품절\n> "));
    p.setInfo(Prompt.inputString("설명> "));

    productList.add(p);
    System.out.println("상품을 등록하였습니다.");
  }
}
