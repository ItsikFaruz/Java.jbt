package app.core.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Gym {
	
	private RunningTrainer running;
	
	private SwimmingTrainer swimm;
	
	private TennisTrainer tennis;
	
	
	
	public Gym(RunningTrainer running, SwimmingTrainer swimm, TennisTrainer tennis) {
		super();
		this.running = running;
		this.swimm = swimm;
		this.tennis = tennis;
	}



	public RunningTrainer getRunning() {
		return running;
	}



	public void setRunning(RunningTrainer running) {
		this.running = running;
	}



	public SwimmingTrainer getSwimm() {
		return swimm;
	}



	public void setSwimm(SwimmingTrainer swimm) {
		this.swimm = swimm;
	}



	public TennisTrainer getTennis() {
		return tennis;
	}



	public void setTennis(TennisTrainer tennis) {
		this.tennis = tennis;
	}
	
	
	
	

}
