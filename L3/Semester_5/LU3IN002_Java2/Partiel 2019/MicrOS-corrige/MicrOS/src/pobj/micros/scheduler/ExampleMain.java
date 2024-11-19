package pobj.micros.scheduler;

public class ExampleMain {
	
	public static void main(String[] args) {
		Scheduler sch = new Scheduler(new FIFOStrategy());
		sch.postTask(new ExampleTask(3));
		TaskRunner.run(sch);
	}

}
