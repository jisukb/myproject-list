package com.baek.proj.handler;

import com.baek.proj.domain.Employee;

public class EmployeeList {

  Node first;
  Node last;
  int size = 0;

  void add(Employee e) {
    Node node = new Node(e);

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

  Employee[] toArray() {
    Employee[] arr = new Employee[size];

    Node cursor = this.first;
    int i = 0;

    while (cursor != null) {
      arr[i++] = cursor.employee;
      cursor = cursor.next;
    }
    return arr;
  }

  Employee get(int employeeNo) {
    Node cursor = first;
    while (cursor != null) {
      Employee e = cursor.employee;
      if (e.no == employeeNo) {
        return e;
      }
      cursor = cursor.next;
    }
    return null;
  }

  void delete(int employeeNo) {
    Employee employee = get(employeeNo);
    if (employee == null) {
      return;
    }

    Node cursor = first;
    while (cursor != null) {
      if (cursor.employee == employee) {
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
      Employee e = cursor.employee;
      if (e.name.equals(name)) {
        return true;
      }
      cursor = cursor.next;
    }
    return false;
  }

  static class Node {
    Employee employee;
    Node next;
    Node prev;

    Node(Employee e) {
      this.employee = e;
    }
  }
}
