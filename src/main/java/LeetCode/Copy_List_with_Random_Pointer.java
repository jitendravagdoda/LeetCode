package LeetCode;

public class Copy_List_with_Random_Pointer {
    public static void main(String arg[]) {

        Copy_List_with_Random_Pointer main = new Copy_List_with_Random_Pointer();
        RandomNode node1 = new RandomNode(1);
        RandomNode node2 = new RandomNode(2);
        RandomNode node3 = new RandomNode(3);
        node1.next = node2;
        node2.next = node3;
        node1.random = node3;
        node3.random = node1;
        RandomNode temp = main.helper(node1);
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public RandomNode helper(RandomNode head) {
        RandomNode itr = head, next;
        // adding new list to old list
        while (itr != null) {
            next = itr.next;
            RandomNode copy = new RandomNode(itr.val + 10);
            itr.next = copy;
            copy.next = next;
            itr = next;
        }
        // Copy the random pointer now;
        itr = head;
        while (itr != null) {
            if (itr.random != null) {
                itr.next.random = itr.random.next;
            }
            itr = itr.next.next;
        }

        // Extracting old ane copy list.


        RandomNode copy=head.next;
        RandomNode copyitr=copy, olditr=head;
        itr=head.next.next;

        while(itr!=null){
            next=itr.next.next;

            olditr.next=itr;
            copyitr.next=itr.next;

            olditr=olditr.next;
            copyitr=copyitr.next;

            itr=next;

        }
        olditr.next=null;

        return head;
    }
}
class RandomNode{
    int val;
    RandomNode next;
    RandomNode random;

    RandomNode(int val){
        this.val=val;
    }

    @Override
    public String toString() {
        return "RandomNode{" +
                "val=" + val;
    }
}