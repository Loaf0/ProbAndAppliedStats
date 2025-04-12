package GenericTree;

public interface Tree<E> {
    public void insert(E data);
    public boolean contains(E data);
    public E get(E data);
    public void clear();
}
