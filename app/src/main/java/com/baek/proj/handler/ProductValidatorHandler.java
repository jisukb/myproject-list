package com.baek.proj.handler;

import java.util.List;
import com.baek.proj.domain.Product;
import com.baek.util.Prompt;

public class ProductValidatorHandler extends AbstractProductHandler {

  public ProductValidatorHandler(List<Product> productList) {
    super(productList);
  }

  @Override
  public void service() {

  }

  public String inputProduct(String promptTitle) {
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
}
