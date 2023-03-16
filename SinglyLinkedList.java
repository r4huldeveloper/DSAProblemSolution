public class SinglyLinkedList {

    private  ListNode head;

    private static class ListNode{
        private int data;
        private ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
        }
    }

    // INSERT NODE AT HEAD IN LIST
    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }
        // INSERT NODE AT LAST IN LIST
        public void insertLast(int value){
            ListNode newNode = new ListNode(value);
            if(head == null) {
                head = newNode;
                return;
            }
            ListNode current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
         // INSERT THE VALUE ANYWHERE IN THE LINKED-LIST
        public void insert(int position, int value){
        //old: 1 -> 4 -> 5
        //new: 1 -> 6 -> 4 -> 5 after insert 6 at 2nd position
            ListNode node = new ListNode(value);

            if (position==1){
                node.next = head;
                head = node;
            } else{
                 ListNode previous = head;
                int count = 1;

                while (count < position - 1){
                    previous = previous.next;
                    count++;
                }
                ListNode current = previous.next;
                previous.next = node;
                node.next = current;
            }
        }

        // DELETE THE FIRST NODE IN LL
    public ListNode deleteFirst(){
        if (head == null){
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    // DELETE THE LAST NODE IN LL
    public ListNode deleteLast(){
        if (head == null || head.next == null){
            return head;
        }
        ListNode current = head;
        ListNode previous = null;

        while (current.next != null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

    // Delete a node at a given position
    public void deletePositon(int position){
        if(position == 1){
            head = head.next;
        } else {
            ListNode previous = head;
            int count = 1 ;
            while (count < position -1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
    }

    // SEARCHING THE ELEMENT IN LL
    public boolean searchElement(int searchKey){
        if(head == null){
            return false;
        }
        ListNode current = head;
        while (current != null){
            if (current.data == searchKey){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // REVERSE A SINGLY LL
    public ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    // GETTING THE MIDDLE NODE OF LL

    public ListNode getMiddleNode(){
        if (head == null){
            return null;
        }
        ListNode ptr1 = head;
        ListNode ptr2 = head;

        while (ptr1 != null && ptr1.next != null){
            ptr2 = ptr2.next;
            ptr1 = ptr1.next.next;
        }
        return ptr2;
    }

    // FIND THE Kth NODE FROM A SLL

    public ListNode getNthNodeFromEnd(int n){
        if (head == null){
            return null;
        }
        if (n <= 0){
            throw new IllegalArgumentException("Invalid value: n = "+ n);
        }
        ListNode mainPtr = head;
        ListNode refPtr  = head;
        int count = 0;
        while (count < n){
            if(refPtr == null){
                throw new IllegalArgumentException(n+" is greater than the number of nodes in list");
            }
            refPtr = refPtr.next;
            count++;
        }
        while (refPtr != null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    public void removeDuplicates(){
        if (head == null){
            return;
        }
        ListNode current = head;
        while (current != null && current.next != null){
            if (current.data == current.next.data){
                current.next = current.next.next;
            } else{
                current = current.next;
            }
        }
    }
      // INSERT THE NODE IN A SORTED LL (MAINTAIN THE ORDER OF LIST)
    public ListNode insertInSortedList(int value){
        ListNode newNode = new ListNode(value);
        if(head == null){
            return newNode;
        }
        ListNode current = head;
        ListNode temp = null;
        while(current != null && current.data < newNode.data){
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
        return head;
    }

    // REMOVING/DELETING THE KEY FROM THE LL
    public void deleteNode(int key){
        ListNode current = head;
        ListNode temp = null;
        if (head==null){
            return;
        }
        while (current != null && current.data != key){
            temp = current;
            current = current.next;
        }
        if (current == null) return;
        temp.next = current.next;
    }

    // DETECT A LOOP IN A LIST
    public void createALoopInLL(){
        ListNode firstListNode = new ListNode(1);
        ListNode secondListNode = new ListNode(2);
        ListNode thirdListNode = new ListNode(3);
        ListNode forthListNode = new ListNode(4);
        ListNode fifthListNode = new ListNode(5);
        ListNode sixListNode = new ListNode(6);

        head = firstListNode;
        firstListNode.next = secondListNode;
        secondListNode.next = thirdListNode;
        thirdListNode.next = forthListNode;
        forthListNode.next = fifthListNode;
        fifthListNode.next = sixListNode;
        sixListNode.next = thirdListNode;

    }

    public boolean detectLoop(){
        ListNode fastptr = head;
        ListNode slowptr = head;
        
        while (fastptr != null && fastptr.next != null){
            fastptr = fastptr.next.next;
            slowptr = slowptr.next;
            if (slowptr == fastptr){
                return true;
            }

        }
        return false;
    }

    // START NODE OF THE LOOP IN LL

    public ListNode startNodeInLoop(){
        ListNode fastptr = head;
        ListNode slowptr = head;

        while (fastptr != null && fastptr.next != null){
            fastptr = fastptr.next.next;
            slowptr = slowptr.next;
            if (slowptr == fastptr){
                return getStartingNode(slowptr);
            }
        }
        return null;
    }

    private ListNode getStartingNode(ListNode slowptr) {
        ListNode temp = head;
        while (temp != slowptr){
            temp = temp.next;
            slowptr = slowptr.next;
        }
        return temp;
    }

    // REMOVE THE LOOP FROM SLL

    public void removeLoop() {
        ListNode fastptr = head;
        ListNode slowptr = head;

        while (fastptr != null && fastptr.next != null) {
            fastptr = fastptr.next.next;
            slowptr = slowptr.next;
            if (slowptr == fastptr) {
                removeLoop(slowptr);
                return;
            }
        }
    }
      
     // MERGE THE TWO SORTED SINGLY LINKED LIST      
    public static ListNode merge(ListNode a , ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (a != null && b != null){
            if(a.data <= b.data){
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        if(a == null) {
            tail.next = b;
        } else {
            tail.next = a;
        }
        return dummy.next;
    }

    private void removeLoop(ListNode slowptr){
        ListNode temp = head;
        while (temp.next != slowptr.next){
            temp = temp.next;
            slowptr = slowptr.next;
        }
        slowptr.next = null;
    }
    // Displaying in The linked-list format
    public void display(){
        ListNode current = head;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public int length(){
        int count = 0;
        ListNode  current = head;
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }
    public static void main(String[] args) {
        //SinglyLinkedList sll = new SinglyLinkedList();
//        ListNode  head = new ListNode(10);
//        ListNode second = new ListNode(1);
//        ListNode third  = new ListNode(8);
//        ListNode fourth = new ListNode(11);


//        sll.insertLast(11);
//        sll.insertLast(9);
//        sll.insertLast(4);
//        sll.insertLast(0);


        // Now we will connect them together to form a chain

//        head.next = second; // 10-->1
//        second.next = third; // 10-->1-->8
//        third.next = fourth; // 10 -->1 -->8 -->11 -->null

//        sll.display();
//        System.out.println();
//        System.out.println("Length is - "+sll.length());

//        sll.insert(1,3);
//        sll.insert(2,5);
//        sll.insert(3,2);
//        sll.insert(4,4);
//        sll.insert(5,7);
       // sll.deleteFirst();
        //sll.deleteLast();
        //sll.deletePositon(2);
       // System.out.println(sll.searchElement(5));
        // sll.insertFirst(7);
        // sll.insertFirst(6);
        // sll.insertFirst(3);
        // sll.insertFirst(2);
        // sll.insertFirst(1);
    //    sll.display(head);
        //sll.removeDuplicates();
    //    sll.insertInSortedList(8);
    //   sll.deleteNode(7);
    //    sll.display(head);
        // sll.createALoopInLL();
        // System.out.println(sll.detectLoop());
        // System.out.println(sll.startNodeInLoop().data);
        // sll.removeLoop();
        // sll.display();

//        ListNode reverseListHead = sll.reverse(head);
//       sll.display(reverseListHead);
//        System.out.println(sll.getMiddleNode().data);
//        ListNode findNElement = sll.getNthNodeFromEnd(4);
//        System.out.println(findNElement.data);

          SinglyLinkedList sll1 = new SinglyLinkedList();
          sll1.insertLast(1);
          sll1.insertLast(4);
          sll1.insertLast(8);

          SinglyLinkedList sll2 = new SinglyLinkedList();
          sll2.insertLast(3);
          sll2.insertLast(5);
          sll2.insertLast(8);

        //   sll1.display();
        //   sll2.display();

          SinglyLinkedList result = new SinglyLinkedList();

          result.head = merge(sll1.head, sll2.head);

          result.display();





    }
}
