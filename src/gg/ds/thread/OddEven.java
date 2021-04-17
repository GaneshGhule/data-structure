package gg.ds.thread;



import java.util.*;

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

class duplicates
{
    Node head;
    Node tail;

    public void addToTheLast(Node node)
    {
        if (head == null)
        {
            head = node;
            tail = node;
        }
        else
        {
            tail.next = node;
            tail = node;
        }
    }
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    /* Drier program to test above functions */
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Try");
            return;
        }catch (Exception e){
            System.out.println("Catch");
            return;
        }finally {
            System.out.println("Finally");
        }
       // System.out.println("out");
//        int t=sc.nextInt();
//        while(t>0)
//        {
//            int N = sc.nextInt();
//            duplicates llist = new duplicates();
//            int a1=sc.nextInt();
//            Node head= new Node(a1);
//            llist.addToTheLast(head);
//            for (int i = 1; i < N; i++)
//            {
//                int a = sc.nextInt();
//                llist.addToTheLast(new Node(a));
//            }
//
//            Solution ob = new Solution();
//            head = ob.removeAllDuplicates(llist.head);
//            llist.printList();
//
//            t--;
//        }
    }

}

class Solution
{
    public static Node removeAllDuplicates(Node head)
    {
        Node current = head;

        Node dHead = new Node(0);

        dHead.next = head;

        Node prev = dHead;

        while(current != null){
            while(current.next != null && current.data == current.next.data){
                current = current.next;
                //System.out.println(current.data+"inn");
            }



            if(prev.next == current){
                //System.out.println(current.data+"in");
                prev = prev.next;
            }else {
                //System.out.println(current.data);
                prev.next = current.next;

            }
            current = current.next;
        }

        return dHead.next;
    }
}