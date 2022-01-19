package app.core.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Gym {

	private RunningTrainer runningTrainer;
	private SwimmingTrainer swimmingTrainer;
	private TennisTrainer tennisTrainer;
	
	public Gym(RunningTrainer runningTrainer, SwimmingTrainer swimmingTrainer, TennisTrainer tennisTrainer) {
		super();
		this.runningTrainer = runningTrainer;
		this.swimmingTrainer = swimmingTrainer;
		this.tennisTrainer = tennisTrainer;
	}

	public RunningTrainer getRunningTrainer() {
		return runningTrainer;
	}

	public SwimmingTrainer getSwimmingTrainer() {
		return swimmingTrainer;
	}

	public TennisTrainer getTennisTrainer() {
		return tennisTrainer;
	}

	
}		
	
	