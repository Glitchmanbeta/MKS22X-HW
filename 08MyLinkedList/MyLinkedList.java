public class MyLinkedList{
    
    private LNode start;
    private int size;
    private LNode current;
    private static boolean DEBUG = true;
    
    public static void main(String[] args){
        System.out.println("Guess I got a bad habit");
        MyLinkedList test = new MyLinkedList(4);
    }

    public MyLinkedList(int x){
        start = new LNode(x);
        size = 1;
        current = start;
        if(DEBUG){
            System.out.println(size);
            System.out.println(x);
        }
    }
    
    public boolean add(int value){
        current.next = new LNode(value);
        size++;
        return true;
    }
    
    public String toString(){
        return "Nope.";
    }
    
    public int get(int index){
        return index;
    }
    
    public int set(int index, int newValue){
        return index;
    }
    
    private class LNode{
        private int value;
        private LNode next;

        public LNode(int x, LNode y){
            value = x;
            next = y;
        }

        public LNode(int x){
            value = x;
        }
    }
}