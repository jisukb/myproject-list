package com.baek.proj.handler;

import java.util.Iterator;
import java.util.List;
import com.baek.proj.domain.Review;

public class ReviewListHandler extends AbstractReviewHandler {

  public ReviewListHandler(List<Review> reviewList) {
    super(reviewList);
  }

  @Override
  public void service() {
    System.out.println("[리뷰 목록]");

    Iterator<Review> iterator = reviewList.iterator();
    while (iterator.hasNext()) {
      Review r = iterator.next();
      // 번호, 제목, 등록일, 작성자, 조회수
      System.out.printf("%d. %s, %s, %s, %d\n",
          r.getNo(), r.getTitle(), r.getRegistereDate(), r.getWriter(), r.getViewCount());
    }
  }
}
