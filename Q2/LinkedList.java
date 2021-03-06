import java.util.NoSuchElementException;

public class LinkedList <E> implements List <E> {

  private static class Node <T> {

    private T value;
    private Node <T> prev;
    private Node <T> next;

    private Node (T value, Node <T> prev, Node <T> next) {
      this.value = value;
      this.prev = prev;
      this.next = next;
    }
  }

  private Node <E> head;
  private int size;

  public LinkedList () {
    head = new Node <E> (null, null, null); // dummy node!
    head.prev = head.next = head;
    size = 0;
  }

  private class LinkedListIterator implements Iterator <E> {

    private Node <E> current = head;
    private int pointer;

    public boolean hasNext () {
      return (current.next != head);
    }

    public E next () {

      if (! hasNext ()) {
        throw new NoSuchElementException ();
      }

      current = current.next;

      return current.value;
    }

    public int nextIndex(){
      Node <E> current = head.next;
      for (int i = 0; i<=pointer ; i ++) {
        pointer++;
      }
      return pointer++;
    }

    public Iterator <E> itorator(int nexIndex){
      try{
        this.nextIndex();
      }catch (IndexOutOfBoundsException someName) {
        return null;
      }
      LinkedListIterator temp=new LinkedListIterator();
      this.pointer = nexIndex;
      return this;
    }

    //new Iterator


  }
  public Iterator <E> iterator () {
    return new LinkedListIterator ();
  }

  public Iterator <E> iterator(Iterator <E> other){
    Iterator <E> temp=iterator ();
    return temp;
  }

  public int size () {
    return size;
  }

  public E get (int index) {

    if (index <0 || index >= size) {
      throw new IndexOutOfBoundsException (Integer.toString (index));
    }

    Node <E> p = head.next;

    for (int i = 0; i <index; i ++) {
      p = p.next;
    }

    return p.value;
  }

  public void addFirst (E elem) {

    if (elem == null) {
      throw new NullPointerException ();
    }

    Node <E> second = head.next;

    head.next = new Node <E> (elem, head, second);
    second.prev = head.next;

    size ++;
  }

  public void add(E elem){
    Node <E> temp = head.prev;
    temp.prev=head.prev;
    temp.next = head;
    head.prev = temp;
    size ++;
  }


}
