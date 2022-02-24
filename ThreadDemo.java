/*
 * ----Question no. 1----
 * Create and Run a Thread using Runnable Interface and Thread class 
 * and show usage of sleep and join methods in the created threads.
 * 
 */

class ThreadClass extends Thread { 
	public void run() {
		for (int j = 0; j < 2; j++) {
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

public class ThreadDemo { 
	public static void main(String argvs[]) {
  
		ThreadClass th1 = new ThreadClass();
		ThreadClass th2 = new ThreadClass();
		ThreadClass th3 = new ThreadClass();

		//Starting first thread
		th1.start();

		//Starting the second thread after the first thread th1 has ended or died.  
		try {
			System.out.println("The current thread name is: " + Thread.currentThread().getName());
			th1.join();
		}
		catch (Exception e) {
			System.out.println("The exception has been caught " + e);
		}

	//Starting thread th2 
		th2.start();

	//Starting the second thread after the first thread th1 has ended or died.   
		try {
			System.out.println("The current thread name is: " + Thread.currentThread().getName());
			th2.join();
		}  
		catch (Exception e) {
			System.out.println("The exception has been caught " + e);
		}

		//Starting thread th3 
		th3.start();
	}
}