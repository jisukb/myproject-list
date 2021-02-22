package com.baek.proj.handler;

import java.util.List;
import com.baek.proj.domain.Review;
import com.baek.util.Prompt;

public class ReviewDeleteHandler extends AbstractReviewHandler {

  public ReviewDeleteHandler(List<Review> reviewList) {
    super(reviewList);
  }

  @Override
  public void service() {
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
}
