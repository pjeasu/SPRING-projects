package edu.bit.ex;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable{
		
		String signatureStr = joinPoint.getSignature().toShortString();
		System.out.println(signatureStr + "is start.");
		
		long st = System.currentTimeMillis();
		
		try {
			Object obj = joinPoint.proceed();
			//ProceedingJoinPoint �ȿ� �ִ� proceed �Լ��� ����
			
			return obj;
		}finally {
			long et = System.currentTimeMillis();
			
			System.out.println(signatureStr + " is finished.");
			System.out.println(signatureStr + " �ɸ��� �ð�  : " + (et - st));
		}
		
	}

}
