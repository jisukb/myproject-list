package com.baek.proj.handler;

import java.util.List;
import com.baek.proj.domain.Review;

public abstract class AbstractReviewHandler implements Command {

  protected List<Review> reviewList;

  public AbstractReviewHandler(List<Review> reviewList) {
    this.reviewList = reviewList;
  }

  protected Review findByNo(int reviewNo) {
    Review[] list = reviewList.toArray(new Review[reviewList.size()]);
    for (Review r : list) {
      if (r.getNo() == reviewNo) {
        return r;
      }
    }
    return null;
  }
}
