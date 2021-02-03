package com.baek.proj.handler;

import com.baek.proj.domain.Review;

public class ReviewList {

  private Node first;
  private Node last;
  private int size = 0;

  public void add(Review r) {
    Node node = new Node(r);

    if (last == null) {
      last = node;
      first = node;
    } else {
      last.next = node;
      node.prev = last;
      last = node;
    }
    size++;
  }

  public Review[] toArray() {
    Review[] arr = new Review[size];

    Node cursor = this.first;
    int i = 0;

    while (cursor != null) {
      arr[i++] = cursor.review;
      cursor = cursor.next;
    }
    return arr;
  }

  public Review get(int reviewNo) {
    Node cursor = first;
    while (cursor != null) {
      Review r = cursor.review;
      if (r.getNo() == reviewNo) {
        return r;
      }
      cursor = cursor.next;
    }
    return null;
  }

  public void delete(int reviewNo) {
    Node cursor = first;
    while (cursor != null) {
      if (cursor.review.getNo() == reviewNo) {
        this.size--;
        if (first == last) {
          first = last = null;
          break;
        }
        if (cursor == first) {
          first = cursor.next;
          cursor.prev = null;
        } else {
          cursor.prev.next = cursor.next;
          if (cursor.next != null) {
            cursor.next.prev = cursor.prev;
          }
        }
        if (cursor == last) {
          last = cursor.prev;
        }
        break;
      }
      cursor = cursor.next;
    }
  }

  static class Node {
    Review review;
    Node next;
    Node prev;

    Node(Review r) {
      this.review = r;
    }
  }
}
