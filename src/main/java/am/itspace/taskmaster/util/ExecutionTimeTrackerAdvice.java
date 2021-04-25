package am.itspace.taskmaster.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeTrackerAdvice {

    Logger logger = LoggerFactory.getLogger(ExecutionTimeTrackerAdvice.class);

    @Around("@annotation(am.itspace.taskmaster.util.TrackExecutionTime)")
    public Object trackTime(ProceedingJoinPoint point){

        try {
            long startTime = System.currentTimeMillis();
            Object obj = point.proceed();
            long endTime = System.currentTimeMillis();
            logger.info("Method name: " + point.getSignature() + ", time taken: " + (endTime - startTime));
            return obj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }



}
