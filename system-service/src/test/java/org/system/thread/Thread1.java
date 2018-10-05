package org.system.thread;

public class Thread1 extends Thread{
	
	@SuppressWarnings("unused")
	private boolean stop = false;  
    public Thread1(String threadName) {  
        super(threadName);  
    }  
 
    @Override 
    public void run() {  
          
        for (int j = 0; j < 100; j++) {  
            if(this.isInterrupted()) break;  
            System.out.println(Thread.currentThread().getName()+":"+j);  
            try {  
                Thread.sleep(1000);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
          
    }  
      
    public void setStop() {  
        this.stop = true;  
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread1 t = new Thread1("���߳�");  
        t.start();  
          
        for (int i = 0; i < 10; i++) {  
            System.out.println(Thread.currentThread().getName()+":"+i);  
        }  
        System.out.println("....................");  
        t.interrupt();
	}

}
