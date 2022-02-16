import java.util.NoSuchElementException;

public class FIFO implements Queue {

    private Node first;
    private Node last;
    private int size = 0;
    private int maxSize = 0;

    @Override
    public void add(Object item) {
        Node node = new Node(item);
        if (first == null) {
            first = node;
            last = node;
        } else if (first.getNext() == null) {
            last = node;
            first.setNext(node);
        } else {
            last.setNext(node);
            last = node;
        }
        size++;
        if (size >= maxSize) {
            maxSize = size;
        }
    }

    @Override
    public void removeFirst() throws NoSuchElementException {
        if (first != null) {
            this.first = first.getNext();
            size--;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Object first() throws NoSuchElementException {
        if (first != null) {
            return first.getValue();
        }
        throw new NoSuchElementException();
    }

    @Override
    public int maxSize() {
        return maxSize;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object f) {
        FIFO newFIFO = (FIFO) f;
        if (this.size == newFIFO.size) {
            Node fIFONode = first;
            Node fNode = newFIFO.first;
            while (fIFONode != null) {
                if (!(fIFONode.equals(fNode))) {
                    return false;
                }
                fIFONode = fIFONode.getNext();
                fNode = fNode.getNext();
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        Node node = first;
        String queue = "Queue: ";
        while (node != null) {
            queue = queue +"(" + node.getValue() + ") ";
            node = node.getNext();
        }
        return queue;
    }
}

