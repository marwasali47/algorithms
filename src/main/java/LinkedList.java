public class LinkedList {

    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next!=null && runner.next.next!=null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner) return true;
        }
        return false;

    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null ) return head;
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return head;
    }

    public ListNode deleteDuplicatesFromLinkedList(ListNode head) {
        ListNode current = head;
        while( current != null){
            if(current.next == null) return head;
            if(current.val == current.next.val ){
                current.next = current.next.next;
            }
            else current = current.next;
        }
        return head ;

    }

}


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }



