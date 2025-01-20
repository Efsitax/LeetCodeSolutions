public class MergeTwoSortedLists_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode();
        ListNode current = mergedList;
        while(list1 != null && list2 != null){

            if (list1.val <= list2.val){
                current.next = list1;
                list1 = list1.next;
            }
            else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if(list1 != null) current.next = list1;
        else if (list2 != null) current.next = list2;
        return mergedList.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode () {}
    ListNode (int val) {this.val = val;}
    ListNode (int val, ListNode next) {this.val = val; this.next = next;}
}
