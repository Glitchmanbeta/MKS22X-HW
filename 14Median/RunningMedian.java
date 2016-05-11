import java.util.NoSuchElementException;

public class RunningMedian{
    
    MyHeap<Integer> maxHeap, minHeap;

    public RunningMedian(){
		maxHeap = new MyHeap<Integer>(true);
		minHeap = new MyHeap<Integer>(false);
    }

    public double getMedian(){
		if(maxHeap.getSize() == 0 && minHeap.getSize() == 0){
	    	throw new NoSuchElementException();
		}
		else if(maxHeap.getSize() == 1 && minHeap.getSize() == 0){
			return maxHeap.peek();
		}
		else if(maxHeap.getSize() == minHeap.getSize() - 1 || maxHeap.getSize() == minHeap.getSize() + 1){
	    	return minHeap.peek();
		}
		else{
	    	return (minHeap.peek() + maxHeap.peek()) / 2;
		}
    }

    public void add(Integer x){
    	try{
    		if(x > getMedian()){
    			minHeap.add(x);
    		}
    		else{
    			maxHeap.add(x);
    		}
    	}
    	catch(NoSuchElementException e){
    		maxHeap.add(x);
    	}
    	if(maxHeap.getSize() > minHeap.getSize() + 1){
    		minHeap.add(maxHeap.delete());
    	}
    	else if(minHeap.getSize() > maxHeap.getSize() + 1){
    		maxHeap.add(minHeap.delete());
    	}
    }
}


/* If the addition > median, add to min heap
 */
