package app.core.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class StatisticAspect {

    private int numberOfCalls;
	
    // match on any method that accepts Company parameter
	@Before("execution(* *.*(app.core.dao.company.Company))")
	public void counterAdvice() {
		numberOfCalls++;
		
		
	}

	public int getNumberOfAddCalls() {
		return numberOfCalls;
	}
	
	
}
