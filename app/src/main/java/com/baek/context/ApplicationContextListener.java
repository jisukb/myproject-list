package com.baek.context;

import java.util.Map;

public interface ApplicationContextListener {
  // 애플리케이션이 시작될 때 호출
  void contextInitialized(Map<String,Object> context);
  // 애플리케이션이 종료될 때 호출
  void contextDestroyed(Map<String,Object> context);
}
