package com.xinhuanet.common.datasource;

import com.xinhuanet.mapper.LoginMapper;
import com.xinhuanet.mapper.NameOrderMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MultipleDataSourceAspectAdvice {

    @Around("execution(* com.xinhuanet.mapper.*.*(..))")
    public Object doAround(ProceedingJoinPoint jp) throws Throwable {
        if (jp.getTarget() instanceof LoginMapper) {
            MultipleDataSource.setDataSourceKey(DatabaseType.storeDB.toString());
        } else if (jp.getTarget() instanceof NameOrderMapper) {
            MultipleDataSource.setDataSourceKey(DatabaseType.storeDB1.toString());
        } else {
            MultipleDataSource.setDataSourceKey(DatabaseType.storeDB.toString());
        }
        return jp.proceed();
    }

}
