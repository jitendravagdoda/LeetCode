package LeetCode;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        next=null;
    }
}

public class ReOrderLinkedList {
    public static void main(String args[]){
        ListNode head=new ListNode(1);
        ListNode t1=new ListNode(2);
        ListNode t2=new ListNode(3);
        ListNode t3=new ListNode(4);
        ListNode t4=new ListNode(5);
        ListNode t5=new ListNode(6);
        ListNode t6=new ListNode(7);

        head.next=t1;
        t1.next=t2;
        t2.next=t3;
        t3.next=t4;
        t4.next=t5;
      //  t5.next=t6;
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.val+ " ");
            temp=temp.next;
        }
        ReOrderLinkedList reOrderLinkedList=new ReOrderLinkedList();
        reOrderLinkedList.reOrder(head);
        temp=head;
        System.out.println();
        while(temp!=null){
            System.out.print(temp.val+ " ");
            temp=temp.next;
        }
    }
    public void reOrder(ListNode head){
        if(head==null || head.next==null)
            return;
        ListNode slow=head, fast=head.next;
        while(fast!=null && fast.next !=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode reverse=reverse(slow);
        ListNode ite=head,next;
        while(ite!=null){
            next=ite.next;
            ite.next=reverse;
            reverse=reverse.next;
            ite.next.next=next;
            ite=next;
        }
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null, current=head,next;
        while(current!=null ){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;

        }
        return prev;
    }
}

