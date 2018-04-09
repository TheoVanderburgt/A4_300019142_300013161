/**
*  @author Marcel Turcotte
*/

import java.util.NoSuchElementException;

public class BinarySearchTree<E extends Comparable<E>> {

  private static class Node<T> {
    private T value;
    private Node<T> left;
    private Node<T> right;
    private Node(T value) {
      this.value = value;
      left = null;
      right = null;
    }
  }

  private Node<E> root = null;

  /**
  * Inserts an object into this BinarySearchTree.
  *
  * @param elem item to be added
  * @return true if the object has been added and false otherwise
  */

  public boolean add(E elem) {

    // pre-condtion:

    if (elem == null) {
      throw new NullPointerException();
    }

    // special case:

    if (root == null) {
      root = new Node<E>(elem);
      return true;
    }

    // general case:

    return add(elem, root);
  }

  // Helper method

  private boolean add(E elem, Node<E> current) {

    boolean result;
    int test = elem.compareTo(current.value);

    if (test == 0) {
      result = false; // already exists, not added
    } else if (test < 0) {
      if (current.left == null) {
        current.left = new Node<E>(elem);
        result = true;
      } else {
        result = add(elem, current.left);
      }
    } else {
      if (current.right == null) {
        current.right = new Node<E>(elem);
        result = true;
      } else {
        result = add(elem, current.right);
      }
    }
    return result;
  }

  //Create method add
  public int count(E low, E high){
    int counter=0;
    Node<E> current =root;
    return count(counter,low,high,current);
  }
  //private helper case
  /*
  private int count(int counter,E low, E high,Node<E> current, boolean foundLow){
  if (foundLow==false){ //this finds lowest element
  if (current.value==low){
  counter++;
  current=root;
  return count(counter,low,high,current,true);//current.root does not exsist
}else if (low.compareTo(current.left.value)>0){
return count(counter,low,high,current.left,false);
}else{
return count(counter,low,high,current.right,false);
}
}

if (low.compareTo(current.left.value)>0  &&  high.compareTo(current.left.value)<0){
counter++;
if (current.right.value==null){
current=root;
}
return count(counter,low,high,current.left,true);
}
if (low.compareTo(current.right.value)>0  &&  high.compareTo(current.right.value)<0){
counter++;
if (current.right.value==null){
current=root;
}
return count(counter,low,high,current.right,true);
}
if (current.value==high){
return counter++;
}
return counter;
}
*/
private int count(int counter, E low, E high,Node<E> current){
  if (current != null){
    counter += count(counter,low,high,current.left);
    counter += count(counter,low,high,current.right);

    //System.out.println(current.value);
    //System.out.println(counter);
    if (low.compareTo(current.value)>0 && high.compareTo(current.value)>0){

      return counter+1;
    }

  }
  return counter;
}


public String toString() {
  return toString(root);
}

private String toString(Node<E> current) {

  if (current == null) {
    return "()";
  }

  return "(" + toString(current.left) + current.value + toString(current.right) + ")";
}

}
