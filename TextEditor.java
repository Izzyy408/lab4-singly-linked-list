public class TextEditor {

    private static class Node {
        String textState;
        Node prev;
        Node next;

        Node(String textState, Node prev, Node next) {
            this.textState = textState;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node currentNode;

    public TextEditor() {
        Node initialNode = new Node("", null, null);
        currentNode = initialNode;
    }

    public void add(String newText) {
        String updatedText = currentNode.textState + newText;

        Node newNode = new Node(updatedText, currentNode, null);

        // Clear redo history
        currentNode.next = null;

        // Connect current node to new node
        currentNode.next = newNode;

        // Move current node forward
        currentNode = newNode;
    }

    public String undo() {
        if (currentNode.prev != null) {
            currentNode = currentNode.prev;
            return currentNode.textState;
        }

        return currentNode.textState;
    }

    public String redo() {
        if (currentNode.next != null) {
            currentNode = currentNode.next;
            return currentNode.textState;
        }

        return currentNode.textState;
    }

    public void printCurrent() {
        System.out.println("Current text: " + currentNode.textState);
    }
}