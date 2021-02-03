package com.baek.proj.handler;

import com.baek.proj.domain.Product;

public class ProductList {

  private Node first;
  private Node last;
  private int size = 0;

  public void add(Product p) {
    Node node = new Node(p);

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

  public Product[] toArray() {
    Product[] arr = new Product[size];

    Node cursor = this.first;
    int i = 0;

    while (cursor != null) {
      arr[i++] = cursor.product;
      cursor = cursor.next;
    }
    return arr;
  }

  public Product get(int productNo) {
    Node cursor = first;
    while (cursor != null) {
      Product p = cursor.product;
      if (p.getNo() == productNo) {
        return p;
      }
      cursor = cursor.next;
    }
    return null;
  }

  public void delete(int productNo) {
    Node cursor = first;
    while (cursor != null) {
      if (cursor.product.getNo() == productNo) {
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

  public boolean exist(String name) {
    Node cursor = first;
    while (cursor != null) {
      Product p = cursor.product;
      if (p.getName().equals(name)) {
        return true;
      }
      cursor = cursor.next;
    }
    return false;
  }

  static class Node {
    Product product;
    Node next;
    Node prev;

    Node(Product p) {
      this.product = p;
    }
  }
}
