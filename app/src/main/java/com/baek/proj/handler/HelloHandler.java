package com.baek.proj.handler;

public class HelloHandler implements Command {

  @Override
  public void service() {
    System.out.println("안녕하세요!"); 
  }
}
