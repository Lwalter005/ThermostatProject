package org.fooddoodsinc.thermostatproject;

import javafx.concurrent.Task;

import java.util.Objects;

public class CounterTask extends Task<Integer> {
    private final Integer target;
    private Integer current;

    public CounterTask(Integer target, Integer current) {
        this.target = target;
        this.current = current;
    }

    @Override
    protected Integer call() throws InterruptedException {
        while (!Objects.equals(current, target)) {
            if (isCancelled()) {
                break;
            } else if (current < target) {
                Thread.sleep(1000);
                current += 1;
            } else {
                Thread.sleep(1000);
                current -= 1;
            }
            updateValue(current);
        }
        return current;
    }
}
