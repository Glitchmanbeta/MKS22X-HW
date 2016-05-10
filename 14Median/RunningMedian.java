import java.util.NoSuchElementException;

public class RunningMedian{
    
    MyHeap<Integer> maxHeap, minHeap;

    public static void main(String[] medians){
	System.out.println("GOTTA GO FAAAAAAAAAAAAAAAAAAAAAAAAAAST");
    }

    public RunningMedian(){
	maxHeap = new MyHeap<Integer>(true);
	minHeap = new MyHeap<Integer>(false);
    }

    public double getMedian(){
	if(maxHeap.getSize() == 0 && minHeap.getSize() == 0){
	    throw new NoSuchElementException();
	}
	else if(maxHeap.getSize() == minHeap.getSize() - 1 || maxHeap.getSize() == minHeap.getSize + 1){
	    return minHeap.peek();
	}
	else{
	    return (minHeap.peek() + maxHeap.peek()) / 2;
	}
    }

    public void add(Integer x){
       
    }
}


/* If the addition > median, add to min heap
 */
