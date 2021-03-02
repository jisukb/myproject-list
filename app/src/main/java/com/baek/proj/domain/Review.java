package com.baek.proj.domain;

import java.sql.Date;
import com.baek.util.CsvObject;

public class Review implements CsvObject {
  private int no;
  private String title;
  private String content;
  private String writer;
  private String product;
  private Date registereDate;
  private int viewCount;

  public Review() {}

  public Review(String csv) {
    String[] fields = csv.split(","); // 번호,제목,내용,작성자,상품명,등록일,조회수
    this.setNo(Integer.parseInt(fields[0]));
    this.setTitle(fields[1]);
    this.setContent(fields[2]);
    this.setWriter(fields[3]);
    this.setProduct(fields[4]);
    this.setRegistereDate(Date.valueOf(fields[5]));
    this.setViewCount(Integer.parseInt(fields[6]));
  }

  @Override
  public String toCsvString() {
    return String.format("%d,%s,%s,%s,%s,%s,%d",
        this.getNo(),
        this.getTitle(),
        this.getContent(),
        this.getWriter(),
        this.getProduct(),
        this.getRegistereDate().toString(),
        this.getViewCount());
  }

  public static Review valueOfCsv(String csv) {
    String[] fields = csv.split(","); // 번호,제목,내용,작성자,상품명,등록일,조회수
    Review r = new Review();
    r.setNo(Integer.parseInt(fields[0]));
    r.setTitle(fields[1]);
    r.setContent(fields[2]);
    r.setWriter(fields[3]);
    r.setProduct(fields[4]);
    r.setRegistereDate(Date.valueOf(fields[5]));
    r.setViewCount(Integer.parseInt(fields[6]));
    return r;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + no;
    result = prime * result + ((title == null) ? 0 : title.hashCode());
    result = prime * result + ((writer == null) ? 0 : writer.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Review other = (Review) obj;
    if (no != other.no)
      return false;
    if (title == null) {
      if (other.title != null)
        return false;
    } else if (!title.equals(other.title))
      return false;
    if (writer == null) {
      if (other.writer != null)
        return false;
    } else if (!writer.equals(other.writer))
      return false;
    return true;
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getWriter() {
    return writer;
  }
  public void setWriter(String writer) {
    this.writer = writer;
  }
  public String getProduct() {
    return product;
  }
  public void setProduct(String product) {
    this.product = product;
  }
  public Date getRegistereDate() {
    return registereDate;
  }
  public void setRegistereDate(Date registereDate) {
    this.registereDate = registereDate;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }

}
