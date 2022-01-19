package app.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

//	@Before("execution (void addCompany (int, String))")
//	public void logAdvice() {
//		System.out.println(">>> Log specific for addCompany(in , String");
//		
//	}

//	@Before("execution (void add* (..))")
//	public void logAddAdvice() {
////		System.out.println("\t>>> Log for advice()");
//		
//	}
	
//	@Before("execution (void *.* ())") 
//	public void logAddAdvice() {
//		System.out.println("\t>>> Log for zero parameters ()");
//		
//	}
	
//	@Before("execution (void *.do* (..))")
//	public void logAddAdvice() {
//		System.out.println("\t>>> Log for do addvice()");
//		
//	}
	
//	@Before("execution (void *.*d* (..))")
//	public void logAddAdviceInclodeD(JoinPoint jp) {
//		
//		System.out.println("\t>>> Log for method name: " +jp.getSignature().getName());
//		
//	}
	
	@Before("execution (void addCompany (..,int,..))") 
	public void logAdvice(JoinPoint jp) {
		System.out.println("\t>>> Log for method name: " +jp.getSignature());
		
	}
	
	
	/**
	 *      *       1 general type
	 * 		*       2 general class
	 * 		.*      3 general method
	 * 		(..)    any parameters
 	 */
	@Before("execution (* *.* (..))")
	public void LogAdviceGeneral() {
		System.out.println("\t>>> Log for all method");
	}
}
