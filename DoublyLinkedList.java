import java.security.spec.DSAGenParameterSpec;
import java.util.Scanner;
class DoublyLinkedList {
    Node head;
    Node tail;
    static class Node{
        int data;
        Node next,prev;
        Node(int x){
            data=x;
            next=null;
            prev=null;
        }
    }
    public static DoublyLinkedList insert(DoublyLinkedList obj,int data){
        Node n=new Node(data);
        Node ptr=obj.head;
        if(obj.head==null){
            obj.head=n;
            obj.tail=n;
            return obj;
        }
        else{
            ptr=obj.head;
            while(ptr.next!=null){
                ptr=ptr.next;
            }
            ptr.next=n;
            n.prev=ptr;
            obj.tail=n;
        }
        return obj;
    }
    public static DoublyLinkedList insertAtStart(DoublyLinkedList obj,int data){
        Node n=new Node(data);
        Node ptr=obj.head;
        n.next=ptr;
        ptr.prev=n;
        obj.head=n;
        while(ptr.next!=null){
            ptr=ptr.next;
        }
        obj.tail=ptr;
        return obj;
    }
    public static DoublyLinkedList deleteNodeWithValue(DoublyLinkedList obj,int data){
        Node current=obj.head,prev=null;
        Node next=current.next;
        while(current!=null){
            if(current.data==data){
                if(prev==null){
                    obj.head=current.next;
                    current.next.prev=null;
                    return obj;
                }
                else if(current.next==null){
                    prev.next=null;
                    obj.tail=prev;
                    return obj;
                }
                else{
                    prev.next=current.next;
                    current.next.prev=prev;
                    return obj;
                }
            }
            else{
                prev=current;
                current=current.next;
            }
        }
        System.out.println("No Such Data Found");
        return obj;
    }
    public static DoublyLinkedList deleteNodeWithPos(DoublyLinkedList obj,int pos){
        Node current=obj.head,prev=null;
        Node next=current.next;
        if(pos==0){
            obj.head=current.next;
            current.next.prev=null;
            return obj;
        }
        else {
            while (pos > 0) {
                prev = current;
                current = current.next;
                pos--;
            }
            if(current==null){
                System.out.println("Not a Valid Position");
            }
            else if(current.next==null){
                prev.next=null;
                obj.tail=prev;
                return obj;
            }
            else{
                prev.next=current.next;
                current.next.prev=prev;
                return obj;
            }

        }
        return obj;
    }
    public static void backTrack(DoublyLinkedList obj){
        Node ptr=obj.head;
        while(ptr.next!=null)
            ptr=ptr.next;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr=ptr.prev;
        }
    }
    public static boolean checkPalindrome(DoublyLinkedList obj){
        Node first=obj.head;
        Node last=obj.tail;
        Node ptr=obj.head;
        int len=0;
        while(ptr!=null){
            len++;
            ptr=ptr.next;
        }
        len=len/2;
        while(len>0){
            if(first.data!=last.data){
                return false;
            }
            first=first.next;
            last=last.prev;
            len--;
        }
        return true;
    }
    public static void Display(DoublyLinkedList obj){
        Node ptr=obj.head;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr=ptr.next;
        }
    }
    public static void main(String[] args) {
        DoublyLinkedList obj=new DoublyLinkedList();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size");
        int size=sc.nextInt();
        for(int i=0;i<size;i++){
            System.out.println("Enter "+(i+1)+"th value");
            int value=sc.nextInt();
            obj=insert(obj,value);
        }
        Display(obj);
        System.out.println("\nEnter value to insert at first");
        int num=sc.nextInt();
        insertAtStart(obj,num);
        Display(obj);
        System.out.println("\nEnter the data to delete");
        int deldata=sc.nextInt();
        obj=deleteNodeWithValue(obj,deldata);
        Display(obj);
        System.out.println("\nEnter the positon to delete (Remember List start with zero)");
        int delposition=sc.nextInt();
        obj=deleteNodeWithPos(obj,delposition);
        Display(obj);
        System.out.println("\nReversed order");
        backTrack(obj);
        if(checkPalindrome(obj)){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not Palindrome");
        }
    }
}
