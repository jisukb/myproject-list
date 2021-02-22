package com.baek.proj.handler;

import java.util.List;
import com.baek.proj.domain.Review;
import com.baek.util.Prompt;

public class ReviewUpdateHandler extends AbstractReviewHandler {

  private ProductValidatorHandler productValidatorHandler;

  public ReviewUpdateHandler(List<Review> reviewList, ProductValidatorHandler productValidatorHandler) {
    super(reviewList);
    this.productValidatorHandler = productValidatorHandler;
  }

  public void service() {
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
}
