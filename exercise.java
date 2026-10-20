import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; this.next = next; }
}

 class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the numbers for the linked list separated by spaces (e.g., 1 2 3 4 5):");
        String inputLine = scanner.nextLine();

        if (inputLine.trim().isEmpty()) {
            System.out.println("No input provided.");
            scanner.close();
            return;
        }
        String[] values = inputLine.trim().split("\\s+");

        ListNode head = null;
        ListNode tail = null;
        for (String valStr : values) {
            int val = Integer.parseInt(valStr);
            ListNode newNode = new ListNode(val);

            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }

        scanner.close();
        OddEvenLinkedList solver = new OddEvenLinkedList();
        ListNode result = solver.oddEvenList(head);
        System.out.println("\nReordered Odd-Even List:");
        ListNode current = result;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}