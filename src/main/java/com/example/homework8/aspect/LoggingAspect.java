package com.example.homework8.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Класс с реализацией аннотации TrackUserAction
 */
@Aspect
@Component
public class LoggingAspect {

    /**
     * Выводит в консоль имя вызванного метода
     * @param joinPoint Принимает точку внедрения
     * @return Возвращает выполненный метод
     * @throws Throwable для отлова любых исключений
     */
    @Around("@annotation(com.example.homework8.aspect.TrackUserAction)")
    @Order(1)
    public Object methodNameUserAction(ProceedingJoinPoint joinPoint) throws Throwable {

        Object process = joinPoint.proceed();
        System.out.println("Имя метода: " + joinPoint.getSignature().getName());
        return process;
    }


    /**
     * Выводит в консоль название класса, в котором вызван метод с аннотацией TrackUserAction
     * @param joinPoint Принимает точку внедрения
     * @return Возвращает выполненный метод
     * @throws Throwable для отлова любых исключений
     */
    @Around("@annotation(com.example.homework8.aspect.TrackUserAction)")
    @Order(2)
    public Object targetNameUserAction(ProceedingJoinPoint joinPoint) throws Throwable {

        Object process = joinPoint.proceed();
        System.out.println("Вызван классом: " + joinPoint.getTarget().getClass());
        return process;
    }


    /**
     * Выводит в консоль аргументы, переданные в метод с аннотацией TrackUserAction
     * @param joinPoint Принимает точку внедрения
     * @return Возвращает выполненный метод
     * @throws Throwable для отлова любых исключений
     */
    @Around("@annotation(com.example.homework8.aspect.TrackUserAction)")
    @Order(3)
    public Object argsNameByMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        Object process = joinPoint.proceed();
        System.out.println("Переданные аргументы: " + Arrays.asList(joinPoint.getArgs()));
        return process;
    }

    /**
     * Выводит в консоль время затраченное на выполнение метода
     * @param joinPoint Принимает точку внедрения
     * @return Возвращает выполненный метод
     * @throws Throwable для отлова любых исключений
     */
    @Around("@annotation(com.example.homework8.aspect.TrackUserAction)")
    @Order(4)
    public Object methodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object process = joinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("Время выполнения метода - " + elapsedTime + " миллисекунд");
        return process;
    }
}
