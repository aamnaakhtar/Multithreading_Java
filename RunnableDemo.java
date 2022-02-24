class ThreadClass2 implements Runnable {
  
	public void run() {
		for (int j=0; j<2; j++) {
			try {
				Thread.sleep(300);
				System.out.println("The current thread name is: " + Thread.currentThread().getName());
			}
			catch (Exception e) {
				System.out.println("The exception has been caught: " + e);
			}
			System.out.println(j);
		}
	}
}

public class RunnableDemo { 
	public static void main(String argvs[]) {
  
		ThreadClass2 th = new ThreadClass2();
		Thread thread1 = new Thread(th);
		Thread thread2 = new Thread(th);
		Thread thread3 = new Thread(th);
		thread1.start();

		//Starting the second thread after the first thread th1 has ended or died.  
		try {
			System.out.println("The current thread name is: " + Thread.currentThread().getName());
			thread1.join();
		}
		catch (Exception e) {
			System.out.println("The exception has been caught " + e);
		}

		//Starting second thread  
		thread2.start();

		//Starting the second thread after the first thread has ended or died.   
		try {
			System.out.println("The current thread name is: " + Thread.currentThread().getName());
			thread2.join();
		}  
		catch (Exception e) {
			System.out.println("The exception has been caught " + e);
		}

		//Starting third thread 
		thread3.start();
	}
}