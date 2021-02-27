/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccinterview;

/**
 *
 * @author DINESH
 */
public class LinkedList {

    public Node head;

    private class Node {

        int data;
        Node next = null;

        public Node(int data) {
            this.data = data;
        }
    }

    private void appendElement(int data) {
        Node current = head;
        if (current == null) {
            head = new Node(data);
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(data);
        }

    }

    private void display() {
        Node current = head;
        String prefix = "";
        while (current != null) {
            System.out.print(prefix);
            prefix = "->";
            System.out.print(current.data);
            current = current.next;

        }
    }

    private void removeDups() {

        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {//delete the node
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }

    }

    private Node reverseLinkedList(Node current) {
        if (current.next == null) {
            head = current;
            return current;
        } else {
            Node n = reverseLinkedList(current.next);
            current.next = null;
            n.next = current;
            return current;

        }

    }

    private boolean deleteNode(Node c) {
        if (c == null) {
            return false;
        } else {
            Node nextNode = c.next;
            c.data = nextNode.data;
            c.next = nextNode.next;
            return true;

        }

    }

    private Node partitionData(Node node, int x) {
        Node head = node;
        Node tail = node;

        Node current = node;

        while (current != null) {
            Node next = current.next;
            if (current.data < x) {
                current.next = head;
                head = current;
            } else {
                tail.next = current;
                tail = current;
            }

            current = next;
        }
        tail.next = null;
        return head;
    }

    private int sumDigits(Node top, Node bottom) {
        if (top == null || bottom == null) {
            if (top == null) {
                Node current = bottom;
                while (current != null) {
                    this.appendElement(current.data);
                    current = current.next;
                }
            } else if (bottom == null) {
                Node current = top;
                while (current != null) {
                    this.appendElement(current.data);
                    current = current.next;
                }
            }
            return 0;
        } else {
            int digit = top.data + bottom.data;
            digit += sumDigits(top.next, bottom.next);
            this.appendElement(digit % 10);
            return digit / 10;
        }
    }

    private TailNode getLength(Node n1) {
        int length = 0;
        while (n1 != null) {
            length++;
            n1 = n1.next;
        }
        return new TailNode(n1, length);
    }

    private class TailNode {

        Node tail;
        int length;

        public TailNode(Node tail, int length) {
            this.length = length;
            this.tail = tail;
        }
    }

    public Node findIntersection(Node n1, Node n2) {

        if (n1 == null || n2 == null) {
            return null;
        } else {

            Node tail1 = getLength(n1).tail;
            Node tail2 = getLength(n2).tail;
            int length1 = getLength(n1).length;
            int length2 = getLength(n2).length;

            if (tail1 != tail2) {
                return null;
            }

            Node longer = length1 > length2 ? n1 : n2;
            Node shorter = length1 > length2 ? n2 : n1;

            longer = seekPointer(longer, Math.abs(length1 - length2));

            while (shorter != longer) {
                shorter = shorter.next;
                longer = longer.next;
            }
            return longer;
        }

    }

    private Node seekPointer(Node longer, int distance) {
        Node current = longer;
        while (distance > 0) {
            current = current.next;
            distance--;
        }

        return current;
    }

    private class Result {

        Node node;
        boolean result;

        public Result(Node node, boolean val) {
            result = val;
            this.node = node;
        }
    }

    public Result isPalindrome(Node head, int length) {

        if (head == null || length == 0) {
            return new Result(head, true);
        } else if (length == 1) {
            return new Result(head.next, true);
        }

        Result res = isPalindrome(head.next, length - 2);

        if (!res.result || res.node == null) {
            return res;
        }

        res.result = (head.data == res.node.data);

        res.node = res.node.next;

        return res;
    }

    public Node findBeginning(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
           
            
            slow = slow.next;
            fast = fast.next.next;
           if(slow == fast) break; 
        }
        if(fast == null || fast.next == null){
            return null;
        }
        //They merge at k nodes from the beginning of the loop.
        fast = head;
        while(slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    
    public void testCase(){
        Node n1 = this.head;
        int i = 0;
        while(i<2){
            n1 = n1.next;
            i++;
        }
        Node tail = n1 ;
        while (tail.next != null){
        tail = tail.next;
        }
        tail.next = n1;
        
    }
    
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        int counter = 2;
        for (int i = 0; i < 7; i++) {
            list1.appendElement(i);
            //    list.appendElement(counter + 1);
            //  list.appendElement(counter++);
        }
        list1.display();
        list1.testCase();
        
        System.out.println("\nLoop began at :" + list1.findBeginning(list1.head).data);
        list1.display();
//        LinkedList list2 = new LinkedList();
//        for (int i = 5; i < 10; i++) {
//            list2.appendElement(i);
//        }
//        System.out.println("List2 :");
//        list2.display();
//        LinkedList sum = new LinkedList();
//        sum.sumDigits(list1.head, list2.head);
//        System.out.println("\n======================");
//        sum.reverseLinkedList(sum.head);
//        //System.out.println(sum.head);
//        sum.display();
//        list.head = list.partitionData(list.head, 5);

//  list.deleteNode(list.head.next.next);
        //      list.display();
    }

}
