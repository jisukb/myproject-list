package com.baek.proj.handler;

import com.baek.proj.domain.Product;
import com.baek.util.List;
import com.baek.util.Prompt;

public class ProductHandler {

  private List productList = new List();

  public List getProductList() {
    return this.productList;
  }

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
    p.setNo(Prompt.inputInt("번호> "));
    p.setCategory(Prompt.inputInt("카테고리\n0: 서적\n1: 굿즈\n2: 음반\n> "));
    p.setName(Prompt.inputString("상품명> "));
    p.setPrice(Prompt.inputInt("가격> "));
    p.setStock(Prompt.inputInt("재고상태\n0: 예약\n1: 판매중\n2: 품절\n> "));
    p.setInfo(Prompt.inputString("설명> "));

    productList.add(p);
    System.out.println("상품을 등록하였습니다.");
  }

  public void list() {
    System.out.println("[상품 목록]");

    Object[] list = productList.toArray();
    for (Object obj : list) {
      Product p = (Product) obj;
      // 번호, 카테고리, 상품명, 가격, 재고상태
      System.out.printf("%d. %s> %s\t%d원, %s\n",
          p.getNo(), getChoiceCate(p.getCategory()), p.getName(), 
          p.getPrice(), getState(p.getStock()));
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
    System.out.printf("카테고리: %s\n", getChoiceCate(product.getCategory()));
    System.out.printf("상품명: %s\n", product.getName());
    System.out.printf("가격: %s\n", product.getPrice());
    System.out.printf("재고상태: %s\n", getState(product.getStock()));
    System.out.printf("설명: %s\n", product.getInfo());
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
        "카테고리\n0: 서적\n1: 굿즈\n2: 음반\n> ", getChoiceCate(product.getCategory())));
    String name = Prompt.inputString(String.format("상품명(%s)> ", product.getName()));
    int price = Prompt.inputInt(String.format("가격(%s)> ", product.getPrice()));
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

  public void delete() {
    System.out.println("[상품 삭제]");

    int no = Prompt.inputInt("번호> ");
    Product product = findByNo(no);
    if (product == null) {
      System.out.println("해당 번호의 상품이 없습니다.");
      return;
    }
    String input = Prompt.inputString("삭제하시겠습니까?(Y/N) ");
    if (input.equalsIgnoreCase("Y")) {
      productList.delete(product);
      System.out.println("상품 정보를 삭제하였습니다.");
    } else {
      System.out.println("삭제를 취소하였습니다.");
    }
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

  String inputProduct(String promptTitle) {
    while (true) {
      String name = Prompt.inputString(promptTitle);
      if (name.length() == 0) {
        return null;
      } else if (findByName(name) != null) {
        return name;
      } else {
        System.out.println("등록된 상품이 아닙니다.");
      }
    }
  }

  private Product findByNo(int productNo) {
    Object[] list = productList.toArray();
    for (Object obj : list) {
      Product p = (Product) obj;
      if (p.getNo() == productNo) {
        return p;
      }
    }
    return null;
  }

  private Product findByName(String name) {
    Object[] list = productList.toArray();
    for (Object obj : list) {
      Product p = (Product) obj;
      if (p.getName().equals(name)) {
        return p;
      }
    }
    return null;
  }
}
