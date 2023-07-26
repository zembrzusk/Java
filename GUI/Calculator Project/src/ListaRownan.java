public class ListaRownan {
    Node head;

    public ListaRownan() {
        head = null;
    }

    public void add(Rownanie data) {
        head = new Node(data,head);
    }

    public Node getHead() {
        return head;
    }


}

class Node {
    Rownanie data;
    Node next;

    Node(Rownanie data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(Rownanie data) {
        this(data, null);
    }

    boolean hasNext() {
        if(next!=null)
            return true;
        else return false;
    }
}
