/*
 * ----Question no. 2----
 * Use a singleThreadExecutor, newCachedThreadPool() and newFixedThreadPool() 
 * to submit a list of tasks and wait for completion of all tasks.
 */

/////SingleThreadExecuter

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool1 {
	public static void main(String[] args) throws InterruptedException {
	      ExecutorService executor = Executors.newSingleThreadExecutor();

	      try {
	         executor.submit(new Task());
	         System.out.println("Shutdown executor");
	         executor.shutdown();
	         executor.awaitTermination(5, TimeUnit.SECONDS);
	      } 
	      catch (InterruptedException e) {
	         System.err.println("tasks interrupted");
	      } 
	      finally {
	         if (!executor.isTerminated()) {
	            System.err.println("cancel non-finished tasks");
	         }
	         executor.shutdownNow();
	         System.out.println("shutdown finished");
	      }
	   }

		static class Task implements Runnable { 
	      public void run() {
	         try {
	            Long duration = (long) (Math.random() * 20);
	            System.out.println("Running Task!");
	            TimeUnit.SECONDS.sleep(duration);
	         } 
	         catch (InterruptedException e) {
	            e.printStackTrace();
	         }
	      }
	   }
}
