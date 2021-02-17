package com.baek.proj.handler;

import java.sql.Date;
import java.util.Iterator;
import java.util.LinkedList;
import com.baek.proj.domain.Review;
import com.baek.util.Prompt;

public class ReviewHandler {

  private LinkedList<Review> reviewList = new LinkedList<>();

  private ProductHandler productHandler;

  public ReviewHandler(ProductHandler productHandler) {
    this.productHandler = productHandler;
  }

  public void service() throws CloneNotSupportedException {
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

    r.setNo(Prompt.inputInt("번호> "));
    r.setTitle(Prompt.inputString("제목> "));
    r.setWriter(Prompt.inputString("작성자> "));
    r.setContent(Prompt.inputString("내용> "));
    r.setProduct(productHandler.inputProduct("상품명> "));
    if (r.getProduct() == null) {
      System.out.println("리뷰 등록을 취소하였습니다.");
      return;
    }
    r.setRegistereDate(new Date(System.currentTimeMillis()));

    reviewList.add(r);
    System.out.println("리뷰를 등록하였습니다.");

  }

  public void list() throws CloneNotSupportedException {
    System.out.println("[리뷰 목록]");

    Iterator<Review> iterator = reviewList.iterator();
    while (iterator.hasNext()) {
      Review r = iterator.next();
      // 번호, 제목, 등록일, 작성자, 조회수
      System.out.printf("%d. %s, %s, %s, %d\n",
          r.getNo(), r.getTitle(), r.getRegistereDate(), r.getWriter(), r.getViewCount());
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
    review.setViewCount(review.getViewCount() + 1);
    System.out.printf("제목: %s\n", review.getTitle());
    System.out.printf("작성자: %s\n", review.getWriter());
    System.out.printf("상품명: %s\n", review.getProduct());
    System.out.printf("내용: %s\n", review.getContent());
    System.out.printf("등록일: %s\n", review.getRegistereDate());
    System.out.printf("조회수: %s\n", review.getViewCount());
  }

  public void update() {
    System.out.println("[리뷰 수정]");

    int no = Prompt.inputInt("번호> ");
    Review review = findByNo(no);
    if (review == null) {
      System.out.println("해당 번호의 글이 없습니다.");
      return;
    }
    String title = Prompt.inputString(String.format("제목(%s)> ", review.getTitle()));
    String content = Prompt.inputString(String.format("내용(%s)> ", review.getContent()));

    String input = Prompt.inputString("변경하시겠습니까?(Y/N) ");
    if (input.equalsIgnoreCase("Y")) {
      review.setTitle(title);
      review.setContent(content);
      System.out.println("리뷰를 변경하였습니다.");
    } else {
      System.out.println("수정을 취소하였습니다.");
    }
  }

  public void delete() {
    System.out.println("[리뷰 삭제]");

    int no = Prompt.inputInt("번호> ");
    Review review = findByNo(no);
    if (review == null) {
      System.out.println("해당 번호의 글이 없습니다.");
      return;
    }
    String input = Prompt.inputString("삭제하시겠습니까?(Y/N) ");
    if (input.equalsIgnoreCase("Y")) {
      reviewList.remove(review);
      System.out.println("리뷰를 삭제하였습니다.");
    } else {
      System.out.println("삭제를 취소하였습니다.");
    }
  }

  private Review findByNo(int reviewNo) {
    Review[] list = reviewList.toArray(new Review[reviewList.size()]);
    for (Review r : list) {
      if (r.getNo() == reviewNo) {
        return r;
      }
    }
    return null;
  }
}
