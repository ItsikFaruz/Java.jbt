package app.core.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class RunningTrainer implements Trainer {

	@Value("${trainer.run}")
	String program ;
	
	
	@Override
	public String getTrainProgram() {
		return this.program;
	}


	
}
