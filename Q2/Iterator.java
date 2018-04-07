public interface Iterator<E> {
    E next();
    boolean hasNext();
    int nextIndex();
    Iterator <E> itorator(int nextIndex);
}
