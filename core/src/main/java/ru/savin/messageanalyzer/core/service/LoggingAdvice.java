package ru.savin.messageanalyzer.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.core.model.Debug;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
@AllArgsConstructor
public class LoggingAdvice {
    //private LogService logService;
    @Pointcut(value = "execution(* ru.savin.messageanalyzer.core.controller.*.*(..))")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object appLogger(ProceedingJoinPoint pjp) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Debug debug = new Debug();

        String methodName = pjp.getSignature().getName();
        String className = pjp.getClass().toString();

        Object[] arr = pjp.getArgs();

        debug.setSystemTypeId(3);
        debug.setMethodParams(className + methodName);
        //logService.writeInDebug(debug);
        log.info("Вызван метод: " + className + ": "
                + methodName + "()"
                + "с аргументами: "
                + objectMapper.writeValueAsString(arr));

        Object o = null;

        try {
            o = pjp.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        log.info(className + ": "
                + methodName + "()"
                + " Response: "
                + objectMapper.writeValueAsString(arr));

        /*//logService.writeInDebug(new Debug(UUID.randomUUID().getLeastSignificantBits(),
                UUID.randomUUID().getLeastSignificantBits(),
                4,
                methodName));*/
        return o;
    }
}
