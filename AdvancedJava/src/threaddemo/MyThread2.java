package threaddemo;

//Program to create a Thread by implementing Runnable Interface
public class MyThread2 implements Runnable {

	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			   System.out.println("User Thread Value:"+i);
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("Hello World - Single Main Thread");
		
		// display info about currently executing thread
		Thread m=Thread.currentThread();
		System.out.println(m);
		System.out.println(m.getName());
		System.out.println(m.getPriority());
		System.out.println(m.getThreadGroup());
		
		MyThread t1=new MyThread();
		Thread  t=new Thread(t1);
		
		t.start();
	}

	

}
