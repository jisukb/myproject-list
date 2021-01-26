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
    p.category = Prompt.inputInt("카테고리\n1: 서적 2: 굿즈 3: 음반\n> ");
    p.name = Prompt.inputString("제품명> ");
    p.price = Prompt.inputInt("가격> ");
    p.stock = Prompt.inputInt("재고상태\n0: 예약\n1: 판매중\n2: 품절\n> ");
    this.products[this.index++] = p;
  }

  public void list() {
    System.out.println("[제품 목록]");
    for (int i = 0; i < this.index; i++) {
      Product p = this.products[i];
      String choicecate = null;
      switch (p.category) {
        case 1:
          choicecate = "서적";
          break;
        case 2:
          choicecate = "굿즈";
          break;
        case 3:
          choicecate = "음반";
          break;
      }
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
          p.no, choicecate, p.name, p.price, state);
    }
  }
}
