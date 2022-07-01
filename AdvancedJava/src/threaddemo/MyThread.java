package threaddemo;

//Program to create a Thread by extending Thread Class
public class MyThread extends Thread {
	
	public void run()
	{
		for(int i=1; i<=10; i++) {
			   System.out.println("User Thread Value:"+i);
		}
	}

	public static void main(String[] args) {
		System.out.println("Hello World - Single Main Thread");
		
		MyThread t1=new MyThread();  // creating Thread Object
		t1.start();  // ready state -- invoke run() method automatically
		
	}

}
