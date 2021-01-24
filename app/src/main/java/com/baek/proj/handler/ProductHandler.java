package com.baek.proj.handler;

import com.baek.proj.domain.Product;
import com.baek.util.Prompt;

public class ProductHandler {

  static final int LENGTH = 100;
  Product[] products = new Product[LENGTH];
  int index = 0;

  public void add() {
    System.out.println("[제품 등록]");

    Product p = new Product();
    p.no = Prompt.inputInt("번호> ");
    p.category = Prompt.inputString("카테고리> ");
    p.name = Prompt.inputString("제품명> ");
    p.price = Prompt.inputInt("가격> ");
    p.stock = Prompt.inputInt("재고상태\n0: 예약\n1: 판매중\n2: 품절\n> ");
    this.products[this.index++] = p;
  }

  public void list() {
    System.out.println("[제품 목록]");
    for (int i = 0; i < this.index; i++) {
      Product p = this.products[i];
      String state = null;
      switch (p.stock) {
        case 1:
          state = "판매중";
          break;
        case 2:
          state = "품절";
          break;
        default:
          state = "예약";
      }
      System.out.printf("%d. %s> %s %d원, %s\n",
          p.no, p.category, p.name, p.price, state);
    }
  }
}
