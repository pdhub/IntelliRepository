import java.util.Arrays;

/**
 * Created by PDeb on 11/26/2016.
 */
public class OneNodeProbls {

    NodeHere Reverse(NodeHere head) {

        if (head == null || head.next == null) {
            return head;
        }

        NodeHere prev, curr, next;
        prev = null;
        curr = head;
        while (curr != null) {
            //prev = curr;
            NodeHere temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head = prev;
        return head;

    }

    NodeHere head;
    void reverseRecurse(NodeHere p){
        if(p.next==null){
            head = p;
            return;
        }
        reverseRecurse(p.next);
        NodeHere q = p.next;
        q.next = p;
        p.next = null;
    }

    public static void main(String[] args) {
        int arr[] = {1,2, 3, 4, 5,6 ,7};
        arr = Arrays.copyOfRange(arr, 4, arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

class NodeHere {
    int data;
    NodeHere next;
}