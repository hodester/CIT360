
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class threads {

	 public static void main(String[] args) {
		 
		 //Threads Example
		 Runnable runnable = () -> {
			    try {
			        String name = Thread.currentThread().getName();
			        System.out.println("First Thread: Start " + name);
			        TimeUnit.SECONDS.sleep(1);
			        System.out.println("First Thread: End " + name);
			    }
			    catch (InterruptedException e) {
			        e.printStackTrace();
			    }
			};

			Thread thread = new Thread(runnable);
			thread.start();
			
			
			System.out.println();
			
			
			//Executor Example
		 
	        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 2; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
          }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Executor: Finished all threads");
    }

		 
	 }
