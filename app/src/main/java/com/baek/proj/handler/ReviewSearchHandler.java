package com.baek.proj.handler;

import java.util.ArrayList;
import java.util.List;
import com.baek.proj.domain.Review;
import com.baek.util.Prompt;

public class ReviewSearchHandler extends AbstractReviewHandler {

  public ReviewSearchHandler(List<Review> reviewList) {
    super(reviewList);
  }

  @Override
  public void service() {
    String keyword = Prompt.inputString("검색어> ");

    if (keyword.length() == 0) {
      System.out.println("검색어를 입력하세요.");
      return;
    }

    ArrayList<Review> list = new ArrayList<>();

    Review[] reviews = reviewList.toArray(new Review[reviewList.size()]);
    for (Review r : reviews) {
      if (r.getTitle().contains(keyword) || 
          r.getContent().contains(keyword) ||
          r.getWriter().contains(keyword) ||
          r.getProduct().contains(keyword)) {
        list.add(r);
      }
    }

    if (list.isEmpty()) {
      System.out.println("해당하는 글이 없습니다.");
      return;
    }

    for (Review r : list) {
      System.out.printf("%d. %s, %s, %s, %d\n",
          r.getNo(), r.getTitle(), r.getRegistereDate(), r.getWriter(), r.getViewCount());
    }
  }
}
