public class MyLinkedList{
    
    private LNode start;
    private int size;
    
    public static void main(String[] args){
        System.out.println("Guess I got a bad habit");
    }
    
    public boolean add(int value){
        return false;
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
        int value;
        LNode next;
    }
}