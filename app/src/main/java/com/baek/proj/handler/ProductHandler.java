package com.baek.proj.handler;

import com.baek.util.Prompt;

public class ProductHandler {

  static class Product {
    int no;
    String category;
    String name;
    int price;
    int stock;
  }

  static final int LENGTH = 100;
  static Product[] products = new Product[LENGTH];
  static int index = 0;

  public static void add() {
    System.out.println("[제품 등록]");

    Product p = new Product();
    p.no = Prompt.inputInt("번호> ");
    p.category = Prompt.inputString("카테고리> ");
    p.name = Prompt.inputString("제품명> ");
    p.price = Prompt.inputInt("가격> ");
    p.stock = Prompt.inputInt("재고상태\n0: 예약\n1: 판매중\n2: 품절\n> ");
    products[index++] = p;
  }

  public static void list() {
    System.out.println("[제품 목록]");
    for (int i = 0; i < index; i++) {
      Product p = products[i];
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
