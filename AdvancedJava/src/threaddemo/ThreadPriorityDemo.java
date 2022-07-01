package threaddemo;

public class ThreadPriorityDemo extends Thread {

	public void run(){
	     System.out.println("Running thread is "+Thread.currentThread().getName());
	     System.out.println("Running thread priority is "+Thread.currentThread().getPriority());
	  }
	
	public static void main(String[] args) {
		//child Threads
		ThreadPriorityDemo t1=new ThreadPriorityDemo();
		ThreadPriorityDemo t2=new ThreadPriorityDemo();
		ThreadPriorityDemo t3=new ThreadPriorityDemo();
		
		t1.setPriority(MIN_PRIORITY);
		t2.setPriority(MAX_PRIORITY);
		t3.setPriority(NORM_PRIORITY);
		
		t1.setName("Raj1");// giving name to Thread
		t2.setName("Raj2");
		t3.setName("Raj3");
		
		t1.start();
		t2.start();
		t3.start();
		

	}

}
