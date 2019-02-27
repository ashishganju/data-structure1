import java.security.spec.DSAGenParameterSpec;
import java.util.Scanner;
class CircularLinkedList {
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int x){
            data=x;
        }
    }
    public static CircularLinkedList insert(CircularLinkedList obj,int data){
        Node n=new Node(data);
        n.next=obj.head;
        Node tmp=obj.head;
        Node ptr=obj.head;
        if(obj.head==null){
            obj.head=n;
           n.next=obj.head;
            return obj;
        }
        else{
            ptr=obj.head;
            while(ptr.next!=obj.head){
                ptr=ptr.next;
            }
            ptr.next=n;
            n.next=obj.head;
        }
        return obj;
    }
    public static CircularLinkedList insertAtBeginnig(CircularLinkedList obj,int data){
        Node n=new Node(data);
        if(obj.head==null){
            obj.head=n;
            n.next=obj.head;
        }
        else{
            Node ptr=obj.head;
            while(ptr.next!=obj.head){
                ptr=ptr.next;
            }
            n.next=obj.head;
            ptr.next=n;
            obj.head=n;
        }
        return obj;
    }
    public static CircularLinkedList deleteNodeWithValue(CircularLinkedList obj,int data){
        Node current=obj.head,prev=null;
        Node next=current.next;
        do{
            if(current.data==data){
                if(prev==null){
                    Node ptr=obj.head;
                    while(ptr.next!=obj.head){
                        ptr=ptr.next;
                    }
                    obj.head=current.next;
                    ptr.next=obj.head;
                    return obj;
                }
                else if(current.next==obj.head){
                    prev.next=obj.head;
                    return obj;
                }
                else{
                    prev.next=current.next;
                    return obj;
                }
            }
            else{
                prev=current;
                current=current.next;
            }
        }while(current!=obj.head);
        System.out.println("No Such Data Found");
        return obj;
    }
    public static void Display(CircularLinkedList obj){
        Node ptr=obj.head;
        Node tmp=obj.head;
        do{
            System.out.print(ptr.data+" ");
            ptr=ptr.next;
        }while(ptr!=tmp);
    }
    public static void main(String[] args) {
        CircularLinkedList obj=new CircularLinkedList();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size");
        int size=sc.nextInt();
        for(int i=0;i<size;i++){
            System.out.println("Enter "+(i+1)+"th value");
            int value=sc.nextInt();
            obj=insert(obj,value);
        }
        Display(obj);
        System.out.println("\nEnter data to insert at Beginning");
        int x=sc.nextInt();
        obj=insertAtBeginnig(obj,x);
        Display(obj);
        System.out.println("\nEnter data to delete");
        int v=sc.nextInt();
        obj=deleteNodeWithValue(obj,v);
        Display(obj);
    }
}