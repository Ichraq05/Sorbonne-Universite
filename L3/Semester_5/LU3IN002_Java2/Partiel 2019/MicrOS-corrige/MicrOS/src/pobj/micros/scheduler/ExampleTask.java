package pobj.micros.scheduler;

import pobj.micros.errors.OSError;

public class ExampleTask implements ITask {

	private int n;

	public ExampleTask(int n) {
		this.n = n;
	}

	@Override
	public void exec(IScheduler ctx) throws OSError {
		System.out.print(n);
		if (n > 0) {
			ITask t = new ExampleTask(n-1);
			ctx.postTask(t);
			ctx.postTask(t);
		}
	}

}
