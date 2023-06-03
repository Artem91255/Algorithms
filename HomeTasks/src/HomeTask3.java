public class HomeTask3<E>{
    private Node<E> head;


    public static void main(String[] args) {
        HomeTask3<Integer> integerHomeTask3 = new HomeTask3<>();
        integerHomeTask3.add(55);
        integerHomeTask3.add(26);
        integerHomeTask3.add(13);
        integerHomeTask3.add(98);
        integerHomeTask3.revert();
    }

    public void add(E value) {
        Node newNode = new Node();
        newNode.value = value;
        if (head != null) {
            newNode.nextNode = head;

        }
        head = newNode;
    }

    public void revert(){
        if(head != null && head.nextNode !=null){
            Node temp = head;
            revert(head.nextNode, head);
            temp.nextNode = null;
        }
    }

    private void revert(Node currentNode, Node previousNode){
        if (currentNode.nextNode ==null){
            head = currentNode;
        }else{
            revert(currentNode.nextNode, currentNode);
            previousNode.nextNode = null;
        }
    }
    public class Node<E> {

        E value;
        Node<E> nextNode;


    }

}
