package pobj.micros.scheduler;

import java.util.LinkedList;
import java.util.List;

import pobj.micros.errors.OSError;

public class Scheduler implements IScheduler {

	private List<ITask> tasks = new LinkedList<ITask>();
	private IStrategy strategy;

	public Scheduler(IStrategy strategy) {
		this.strategy = strategy;
	}
		
	@Override
	public void postTask(ITask task) {
		tasks.add(0, task);
	}

	@Override
	public void setStrategy(IStrategy strategy) {
		this.strategy = strategy;
	}

	@Override
	public boolean execNext() throws OSError {
		ITask task = strategy.selectTask(tasks);
		if (task == null) return false;
		task.exec(this);
		return true;
	}
}
