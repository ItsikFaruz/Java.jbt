package app.core.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisTrainer implements Trainer{

	@Value("${trainer.tennis}")
	String program ;
	
	
	@Override
	public String getTrainProgram() {
		return this.program;
	}



	

}
