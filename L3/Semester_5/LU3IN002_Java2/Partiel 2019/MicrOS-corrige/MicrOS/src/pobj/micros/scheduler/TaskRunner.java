package pobj.micros.scheduler;

import pobj.micros.errors.OSError;

public class TaskRunner {

	static public void run(IScheduler scheduler) {
		while (true) {
			try {
				if (!scheduler.execNext()) return;
			} catch (OSError e) {
				System.out.println(e.getMessage());
			}
		}
	}	

}
