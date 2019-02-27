import java.security.spec.DSAGenParameterSpec;
import java.util.Scanner;
class IsLinkedListPalindrome {
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
    public static IsLinkedListPalindrome insert(IsLinkedListPalindrome obj,int data){
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
    public static boolean checkPalindrome(IsLinkedListPalindrome obj){
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
    public static void Display(IsLinkedListPalindrome obj){
        Node ptr=obj.head;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr=ptr.next;
        }
    }
    public static void main(String[] args) {
        IsLinkedListPalindrome obj=new IsLinkedListPalindrome();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size");
        int size=sc.nextInt();
        for(int i=0;i<size;i++){
            System.out.println("Enter "+(i+1)+"th value");
            int value=sc.nextInt();
            obj=insert(obj,value);
        }
        Display(obj);
        if(checkPalindrome(obj)){
            System.out.println("\nPalindrome");
        }
        else{
            System.out.println("\nNot Palindrome");
        }
    }
}

//check Palindrome or NOT for STRINGS



//import java.security.spec.DSAGenParameterSpec;
//        import java.util.Scanner;
//class IsLinkedListPalindrome {
//    Node head;
//    Node tail;
//    static class Node{
//        char data;
//        Node next,prev;
//        Node(char x){
//            data=x;
//            next=null;
//            prev=null;
//        }
//    }
//    public static IsLinkedListPalindrome insert(IsLinkedListPalindrome obj,char data){
//        Node n=new Node(data);
//        Node ptr=obj.head;
//        if(obj.head==null){
//            obj.head=n;
//            obj.tail=n;
//            return obj;
//        }
//        else{
//            ptr=obj.head;
//            while(ptr.next!=null){
//                ptr=ptr.next;
//            }
//            ptr.next=n;
//            n.prev=ptr;
//            obj.tail=n;
//        }
//        return obj;
//    }
//    public static boolean checkPalindrome(IsLinkedListPalindrome obj){
//        Node first=obj.head;
//        Node last=obj.tail;
//        Node ptr=obj.head;
//        int len=0;
//        while(ptr!=null){
//            len++;
//            ptr=ptr.next;
//        }
//        len=len/2;
//        while(len>0){
//            if(first.data!=last.data){
//                return false;
//            }
//            first=first.next;
//            last=last.prev;
//            len--;
//        }
//        return true;
//    }
//    public static void Display(IsLinkedListPalindrome obj){
//        Node ptr=obj.head;
//        while(ptr!=null){
//            System.out.print(ptr.data);
//            ptr=ptr.next;
//        }
//    }
//    public static void main(String[] args) {
//        IsLinkedListPalindrome obj=new IsLinkedListPalindrome();
//        Scanner sc=new Scanner(System.in);
//        System.out.println("Enter Your String");
//        String str=sc.next();
//        for(int i=0;i<str.length();i++){
//            obj=insert(obj,str.charAt(i));
//        }
//        Display(obj);
//        if(checkPalindrome(obj)){
//            System.out.println("\nPalindrome");
//        }
//        else{
//            System.out.println("\nNot Palindrome");
//        }
//    }
//}
