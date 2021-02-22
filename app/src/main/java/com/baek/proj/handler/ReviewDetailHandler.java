package com.baek.proj.handler;

import java.util.List;
import com.baek.proj.domain.Review;
import com.baek.util.Prompt;

public class ReviewDetailHandler extends AbstractReviewHandler {

  public ReviewDetailHandler(List<Review> reviewList) {
    super(reviewList);
  }

  @Override
  public void service() {
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
} 
