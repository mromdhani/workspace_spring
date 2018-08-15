package be.businesstraining.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(* be.businesstraining.service.Calcul.*(..))")
	public void logItBefore(JoinPoint point) {
		String methodName = point.getSignature().getName();
		for (Object arg : point.getArgs()) {
			System.out.println("Argument : "+ arg);
		}
		System.out.println(">>>>> A l'entrée de la méthode : "+methodName);
	}
	
//	@After("execution(* be.businesstraining.service.Calcul.*(..))")
//	public void logItAfter() {
//		String methodName = point.getSignature().getName();
//		System.out.println("<<<< A la sortie de la méthode");
//	}

}
