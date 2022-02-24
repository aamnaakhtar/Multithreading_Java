
/* 
 * -----Question no. 3----
 * Use Synchronize method and synchronize block to enable synchronization 
 * between multiple threads trying to access method at same time.
 */

//////Synchronized Method

class Line{
	synchronized public void getLine(){
		for (int i = 0; i < 3; i++){
			System.out.println(i);
			try{
				Thread.sleep(400);
			}
			catch (Exception e){
				System.out.println(e);
			}
		}
	}
}

class Train extends Thread{
	Line line;

	Train(Line line){
		this.line = line;
	}

	@Override
	public void run(){
		line.getLine();
	}
}

class SynchronizedMethod{
	public static void main(String[] args){
		Line obj = new Line();

		Train train1 = new Train(obj);
		Train train2 = new Train(obj);

		train1.start();
		train2.start();
	}
}


