package br.com.tony.springaoplogging.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Loggable {

    private static final Logger LOGGER = LoggerFactory.getLogger(Loggable.class);

    @Pointcut("@annotation(br.com.tony.logger.log.Log)")
    public void annotationLog(){}

    @Before("annotationLog()")
    public void aspectBefore(JoinPoint joinPoint) {
        LOGGER.info("Iniciando execução {}.{}", joinPoint.getTarget().getClass().getCanonicalName(),
                joinPoint.getSignature().getName());
    }

    @AfterReturning("annotationLog()")
    public void aspectAfterReturning(JoinPoint joinPoint) {
        Object[] objects = joinPoint.getArgs();
        LOGGER.info("Usuário criado");
    }
}
