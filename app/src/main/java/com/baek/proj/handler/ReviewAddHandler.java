package com.baek.proj.handler;

import java.sql.Date;
import java.util.List;
import com.baek.proj.domain.Review;
import com.baek.util.Prompt;

public class ReviewAddHandler extends AbstractReviewHandler {

  private ProductValidatorHandler productValidatorHandler;

  public ReviewAddHandler(List<Review> reviewList, ProductValidatorHandler productValidatorHandler) {
    super(reviewList);
    this.productValidatorHandler = productValidatorHandler;
  }

  @Override
  public void service() {
    System.out.println("[리뷰 등록]");

    Review r = new Review();

    r.setNo(Prompt.inputInt("번호> "));
    r.setTitle(Prompt.inputString("제목> "));
    r.setWriter(Prompt.inputString("작성자> "));
    r.setContent(Prompt.inputString("내용> "));
    r.setProduct(productValidatorHandler.inputProduct("상품명> "));
    if (r.getProduct() == null) {
      System.out.println("리뷰 등록을 취소하였습니다.");
      return;
    }
    r.setRegistereDate(new Date(System.currentTimeMillis()));

    reviewList.add(r);
    System.out.println("리뷰를 등록하였습니다.");

  }
} 
