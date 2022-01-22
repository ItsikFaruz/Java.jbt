package app.core.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	@Before("classAnnotation()")
	public void logAdvice(JoinPoint jp) {
		System.out.println(">>> log: " + jp);
	}
	
	@Pointcut("@annotation(app.core.annotations.MyLogAnnotation)")
	public void methodAnnotation() {
		
	}
	
	@Pointcut("@target(app.core.annotations.MyLogAnnotation)")
	public void classAnnotation() {
		
	}
	
//	@Before("execution(* *.find(..))")
//	public void logAdvice(JoinPoint jp) {
//		System.out.println(">>> log: " + jp);
//	}
	

			
			
}
