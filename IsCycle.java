import java.security.spec.DSAGenParameterSpec;
import java.util.Scanner;
class IsCycle {
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
    public static IsCycle insert(IsCycle obj,int data){
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
    public static boolean checkCycle(IsCycle obj){
        Node slow=obj.head;
        Node fast=obj.head;
        do{
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }while(slow!=fast || slow!=null);
        if(slow==null)
        return false;
        else
            return true;
    }
    public static void Display(IsCycle obj){
        Node ptr=obj.head;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr=ptr.next;
        }
    }
    public static void main(String[] args) {
        IsCycle obj=new IsCycle();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size");
        int size=sc.nextInt();
        for(int i=0;i<size;i++){
            System.out.println("Enter "+(i+1)+"th value");
            int value=sc.nextInt();
            obj=insert(obj,value);
        }
        Display(obj);
        if(checkCycle(obj)){
            System.out.println("\nCycle Found");
        }
        else{
            System.out.println("\nNot a Cycle");
        }
    }
}
