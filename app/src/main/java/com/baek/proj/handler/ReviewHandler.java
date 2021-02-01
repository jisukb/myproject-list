package com.baek.proj.handler;

import java.sql.Date;
import com.baek.proj.domain.Review;
import com.baek.util.Prompt;

public class ReviewHandler {

  static final int LENGTH = 100;

  ProductHandler productList;

  Review[] reviews = new Review[LENGTH];
  int index = 0;

  public ReviewHandler(ProductHandler productHandler) {
    this.productList = productHandler;
  }

  public void service() {
    loop: 
      while (true) {

        System.out.println("-----리뷰-----");
        System.out.println("1. 등록");
        System.out.println("2. 목록");
        System.out.println("3. 상세");
        System.out.println("4. 수정");
        System.out.println("5. 삭제");
        System.out.println("0. 메인");
        System.out.println("--------------");

        String command = com.baek.util.Prompt.inputString("리뷰> ");
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
    System.out.println("[리뷰 등록]");

    Review r = new Review();

    r.no = Prompt.inputInt("번호> ");
    r.title = Prompt.inputString("제목> ");
    r.writer = Prompt.inputString("작성자> ");
    r.content = Prompt.inputString("내용> ");
    r.product = inputProduct("상품명> ");
    if (r.product == null) {
      System.out.println("리뷰 등록을 취소하였습니다.");
      return;
    }
    r.registereDate = new Date(System.currentTimeMillis());

    this.reviews[this.index++] = r;

    System.out.println("리뷰를 등록하였습니다.");

  }

  public void list() {
    System.out.println("[리뷰 목록]");

    for (int i = 0; i < this.index; i++) {
      Review r = this.reviews[i];
      System.out.printf("%d. %s, %s, %s, %d\n",
          r.no, r.title, r.registereDate, r.writer, r.viewCount);
    }
  }

  public void detail() {
    System.out.println("[리뷰 상세]");

    int no = Prompt.inputInt("번호> ");
    Review review = findByNo(no);
    if (review == null) {
      System.out.println("해당 번호의 글이 없습니다.");
      return;
    }

    review.viewCount++;
    System.out.printf("제목: %s\n", review.title);
    System.out.printf("작성자: %s\n", review.writer);
    System.out.printf("상품명: %s\n", review.product);
    System.out.printf("내용: %s\n", review.content);
    System.out.printf("등록일: %s\n", review.registereDate);
    System.out.printf("조회수: %s\n", review.viewCount);
  }

  public void update() {
    System.out.println("[리뷰 수정]");

    int no = Prompt.inputInt("번호> ");
    Review review = findByNo(no);
    if (review == null) {
      System.out.println("해당 번호의 글이 없습니다.");
      return;
    }
    String title = Prompt.inputString(String.format("제목(%s)> ", review.title));
    String content = Prompt.inputString(String.format("내용(%s)> ", review.content));

    String input = Prompt.inputString("변경하시겠습니까?(Y/N) ");
    if (input.equalsIgnoreCase("Y")) {
      review.title = title;
      review.content = content;
      System.out.println("리뷰를 변경하였습니다.");
    } else {
      System.out.println("수정을 취소하였습니다.");
    }
  }

  public void delete() {
    System.out.println("[리뷰 삭제]");

    int no = Prompt.inputInt("번호> ");
    int i = indexOf(no);
    if (i == -1) {
      System.out.println("해당 번호의 글이 없습니다.");
      return;
    }
    String input = Prompt.inputString("삭제하시겠습니까?(Y/N) ");
    if (input.equalsIgnoreCase("Y")) {
      for (int x = i+1; x < this.index; x++) {
        this.reviews[x-1] = this.reviews[x]; 
      }
      reviews[--this.index] = null;
      System.out.println("리뷰를 삭제하였습니다.");
    } else {
      System.out.println("삭제를 취소하였습니다.");
    }
  }

  int indexOf(int reviewNo) {
    for (int i = 0; i < this.index; i++) {
      Review review = this.reviews[i];
      if (review != null && review.no == reviewNo) {
        return i;
      }
    }
    return -1;
  }

  Review findByNo(int reviewNo) {
    int i = indexOf(reviewNo);
    if (i == -1)
      return null;
    else
      return reviews[i];
  }

  String inputProduct(String promptTitle) {
    while (true) {
      String name = Prompt.inputString(promptTitle);
      if (name.length() == 0) {
        return null;
      } else if (this.productList.exist(name)) {
        return name;
      } else {
        System.out.println("등록된 상품이 아닙니다.");
      }
    }
  }
}
