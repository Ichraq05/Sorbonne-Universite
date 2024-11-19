package pobj.micros.scheduler;

import java.util.List;

public class MostRecentStrategy implements IStrategy { 
	@Override
	public	ITask selectTask(List<ITask> tasks) {
		return tasks.isEmpty() ? null : tasks.remove(0);
	}
}
