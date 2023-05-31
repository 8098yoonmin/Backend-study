package com.nhnacademy.springbootstudent.actuator;

import io.micrometer.core.lang.Nullable;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Component
@Endpoint(id="counter")
public class CounterEndPoint {

    private AtomicLong count = new AtomicLong(0);

    @ReadOperation
    public long count() {
        return count.get();
    }

    @WriteOperation
    public long increment(@Nullable Long delta) {
        if(delta == null){
            return count.incrementAndGet();
        }
        return count.addAndGet(delta);
    }

    @DeleteOperation
    public long reset() {
        count.set(0);
        return count.get();
    }


}
