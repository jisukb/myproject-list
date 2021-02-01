package com.baek.proj.handler;

import com.baek.proj.domain.Review;

public class ReviewList {

  Node first;
  Node last;
  int size = 0;

  void add(Review r) {
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

  Review[] toArray() {
    Review[] arr = new Review[size];

    Node cursor = this.first;
    int i = 0;

    while (cursor != null) {
      arr[i++] = cursor.review;
      cursor = cursor.next;
    }
    return arr;
  }

  Review get(int reviewNo) {
    Node cursor = first;
    while (cursor != null) {
      Review r = cursor.review;
      if (r.no == reviewNo) {
        return r;
      }
      cursor = cursor.next;
    }
    return null;
  }

  void delete(int reviewNo) {
    Review review = get(reviewNo);

    if (review == null) {
      return;
    }

    Node cursor = first;
    while (cursor != null) {
      if (cursor.review == review) {
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
