package pobj.micros.scheduler;

import java.util.List;

public class FIFOStrategy implements IStrategy { 
	@Override
	public	ITask selectTask(List<ITask> tasks) {		
		return tasks.isEmpty() ? null : tasks.remove(tasks.size() - 1);
	}
}
