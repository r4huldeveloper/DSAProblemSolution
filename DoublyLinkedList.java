public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;

    private class ListNode{
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int val){
            this.data = val;

        }
    }

    public DoublyLinkedList(){
        this.head=null;
        this.tail=null;
        this.length=0;
    }

    public boolean isEmpty() {
        return length == 0; //head=null
    }
    public int length() {
        return length;
    }

    public void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if (isEmpty()){
            head = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.previous = tail;
        tail = newNode;
        length++;
    }

    public void displayForward(){
        if (head == null){
            return;
        }
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.data+"-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void displayBackward(){
        if (tail == null){
            return;
        }
        ListNode temp = tail;
        while (temp != null){
            System.out.print(temp.data+"-->");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    // INSERT THE NODE AT BEGINNING OF DLL
    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        if (isEmpty())
        {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }


    //DELETE THE FIRST NODE IN DLL
    public ListNode deleteFirst() throws NoSuchFieldException {
        if (isEmpty()){
            throw new NoSuchFieldException();
        }
        ListNode temp = head;
        if (head == tail){
            tail = null;
        } else {
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }
    public static void main(String[] args) throws NoSuchFieldException {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertLast(1);
        dll.insertLast(10);
        dll.insertLast(15);


//        dll.insertLast(10);
//        dll.insertLast(15);
//        dll.insertLast(19);

//        dll.insertFirst(10);
        dll.displayForward();
//        dll.displayBackward();
//        dll.deleteFirst();
//        dll.deleteFirst();
//        dll.deleteFirst();
//        dll.deleteFirst();
        




    }
}
