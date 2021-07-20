package LinkedList;

public class ImplementationSingleLL {
    public class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    int size = 0;
    public Node Head = null, Tail = null;

    public int size() {
        return size;
    }
    public void addfirst(int data) {
        Node temp = new Node(data);
        if (Head == null && Tail == null) {
            Head = temp;
            Tail = temp;
        } else {
            temp.next = Head;
            Head = temp;
        }
        size ++;
    }

    public void addlast(int data) {
        Node temp = new Node(data);
        if(Head == null && Tail == null) {
            Head = temp;
            Tail = temp;
        } else {
            Tail.next = temp;
            Tail = temp;
        }
        size ++;
    }
    public void display(Node Head) {
        while (Head != null) {
            System.out.print(Head.data + " ");
            Head = Head.next;
        }
    }

    public Node reverseLinkedList(Node Head) {
        if (Head == null)
            return null;

        Node prev = null, curr = Head;
        while (curr != null) {
            Node frwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = frwd;
        }
        Head = prev;
        return Head;
    }

    public Node mid(Node Head) {
        if (Head == null)
            return null;

        Node slow = Head, fast = Head;
        while (fast.next != null || fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ImplementationSingleLL LL = new ImplementationSingleLL();
        // LL.addfirst(10);
        // LL.addfirst(12);
        // LL.addfirst(15);
        // LL.addfirst(25);
        // LL.addfirst(30);
        // LL.addfirst(36);
        // LL.addfirst(40);
        // LL.addfirst(45);
        // // display(Head);
        // Node temp = LL.reverseLinkedList(Head);
        // LL.display(temp);

        LL.addlast(10);
        LL.addlast(12);
        LL.addlast(15);
        LL.addlast(25);
        LL.addlast(30);
        LL.addlast(36);
        LL.display(LL.Head);
    }
}
