package com.baek.proj.handler;

import com.baek.proj.domain.Product;
import com.baek.util.Prompt;

public class ProductHandler {

  static final int LENGTH = 100;
  Product[] products = new Product[LENGTH];
  int index = 0;

  public void service() {
    loop: 
      while (true) {

        System.out.println("-----상품-----");
        System.out.println("1. 등록");
        System.out.println("2. 목록");
        System.out.println("3. 상세");
        System.out.println("4. 수정");
        System.out.println("5. 삭제");
        System.out.println("0. 메인");
        System.out.println("--------------");

        String command = com.baek.util.Prompt.inputString("상품> ");
        System.out.println();
        switch (command) {
          case "1":
            this.add();
            break;
          case "2":
            this.list();
            break;
          case "3":
            this.detail();
            break;
          case "4":
            this.update();
            break;
          case "5":
            this.delete();
            break;
          case "0":
            break loop;
          default:
            System.out.println("해당 번호가 없습니다.");
        }

        System.out.println();
      }
  }

  public void add() {
    System.out.println("[상품 등록]");

    Product p = new Product();
    p.no = Prompt.inputInt("번호> ");
    p.category = Prompt.inputInt("카테고리\n0: 서적 1: 굿즈 2: 음반\n> ");
    p.name = Prompt.inputString("상품명> ");
    p.price = Prompt.inputInt("가격> ");
    p.stock = Prompt.inputInt("재고상태\n0: 예약\n1: 판매중\n2: 품절\n> ");
    this.products[this.index++] = p;
  }

  public void list() {
    System.out.println("[상품 목록]");
    for (int i = 0; i < this.index; i++) {
      Product p = this.products[i];
      System.out.printf("%d. %s> %s %d원, %s\n",
          p.no, getChoiceCate(p.category), p.name, p.price, getState(p.stock));
    }
  }

  public void detail() {
    System.out.println("[상품 상세]");

    int no = Prompt.inputInt("번호> ");
    Product product = findByNo(no);
    if (product == null) {
      System.out.println("해당 번호의 상품이 없습니다.");
      return;
    }
    System.out.printf("카테고리: %s\n", getChoiceCate(product.category));
    System.out.printf("상품명: %s\n", product.name);
    System.out.printf("가격: %s\n", product.price);
    System.out.printf("재고상태: %s\n", getState(product.stock));
  }

  public void update() {
    System.out.println("[상품 수정]");

    int no = Prompt.inputInt("번호> ");
    Product product = findByNo(no);
    if (product == null) {
      System.out.println("해당 번호의 상품이 없습니다.");
      return;
    }
    int category = Prompt.inputInt(String.format(
        "카테고리\n0: 서적 1: 굿즈 2: 음반\n> ", getChoiceCate(product.category)));
    String name = Prompt.inputString(String.format("상품명(%s)> ", product.name));
    int price = Prompt.inputInt(String.format("가격(%s)> ", product.price));
    int stock = Prompt.inputInt(String.format(
        "재고상태\n0: 예약상품\n1: 판매중\n2: 품절\n> ", getState(product.stock)));

    String input = Prompt.inputString("변경하시겠습니까?(Y/N) ");
    if (input.equalsIgnoreCase("Y")) {
      product.category = category;
      product.name = name;
      product.price = price;
      product.stock = stock;
      System.out.println("상품 정보를 변경하였습니다.");
    } else {
      System.out.println("수정을 취소하였습니다.");
    }
  }

  public void delete() {
    System.out.println("[상품 삭제]");

    int no = Prompt.inputInt("번호> ");
    int i = indexOf(no);
    if (i == -1) {
      System.out.println("해당 번호의 상품이 없습니다.");
      return;
    }
    String input = Prompt.inputString("삭제하시겠습니까?(Y/N) ");
    if (input.equalsIgnoreCase("Y")) {
      for (int x = i+1; x < this.index; x++) {
        this.products[x-1] = this.products[x]; 
      }
      products[--this.index] = null;
      System.out.println("상품 정보를 삭제하였습니다.");
    } else {
      System.out.println("삭제를 취소하였습니다.");
    }
  }

  int indexOf(int productNo) {
    for (int i = 0; i < this.index; i++) {
      Product product = this.products[i];
      if (product != null && product.no == productNo) {
        return i;
      }
    }
    return -1;
  }

  Product findByNo(int productNo) {
    int i = indexOf(productNo);
    if (i == -1)
      return null;
    else
      return products[i];
  }

  String getChoiceCate(int category) {
    switch (category) {
      case 1:
        return "굿즈";
      case 2:
        return "음반";
      default:
        return "서적";
    }
  }

  String getState(int stock) {
    switch (stock) {
      case 1:
        return "판매 중입니다.";
      case 2:
        return "품절입니다.";
      default:
        return "예약상품입니다.";
    }
  }

}
