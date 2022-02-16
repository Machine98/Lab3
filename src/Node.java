public class Node {

    Object value;
    private Node next;

    public Node(Object x) {
        this.value = x;
    }

    public Object getValue() {
        return value;
    }

    public void setNext(Node node) {
        next = node;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node input) {
            if (this.value == null) {
                if(input.value == null){
                    return true;
                }
                return false;
            }
            return this.value.equals(input.value);
        }
        return false;
    }

    public Node getNext() {
        return this.next;
    }
}
