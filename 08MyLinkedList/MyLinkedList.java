public class MyLinkedList{
    
    private LNode start;
    private int size;
    private LNode end;

    public static void main(String[] args){
        System.out.println("Guess I got a bad habit");
        MyLinkedList test = new MyLinkedList(0);
        System.out.println(test.toString());
        test.add(1);
        System.out.println(test.toString());
    }

    public MyLinkedList(int x){
        start = new LNode(x);
        end = start.getNext();
        System.out.println(end);
        size = 1;
    }
    
    public boolean add(int value){
        end = new LNode(value);
        size++;
        end = end.getNext();
        System.out.println(end);
        return true;
    }
    
    public String toString(){
        String s = "[";
        LNode current = start;
        for(int i = 0; i < size; i++){
            System.out.println(s);
            s = s + current.getValue() + " ";
            current = current.getNext();
        }
        s += "]";
        return s;
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

        public LNode(int x){
            value = x;
        }

        public int getValue(){
            return value;
        }

        public LNode getNext(){
            return next;
        }
    }
}