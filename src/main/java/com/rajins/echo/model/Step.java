package com.rajins.echo.model;

import com.rajins.echo.constants.BySelector;
import com.rajins.echo.events.Action;

import java.util.LinkedList;
import java.util.function.Consumer;

import static org.springframework.util.CollectionUtils.isEmpty;

public class Step {
    private BySelector selector;
    private String value;
    private LinkedList<Action> actions;
    private long waitTime;

    private Step(Builder builder) {
        this.selector = builder.selector;
        this.value = builder.value;
        this.actions = builder.actions;
        this.waitTime = builder.waitTime;
    }

    public BySelector getSelector() {
        return selector;
    }

    public String getValue() {
        return value;
    }

    public LinkedList<Action> getActions() {
        return actions;
    }

    public long getWaitTime() {
        return waitTime;
    }

    public static class Builder {
        public BySelector selector;
        public String value;
        public LinkedList<Action> actions;
        public long waitTime;

        public Builder with(Consumer<Builder> consumer) {
            consumer.accept(this);
            return this;
        }

        public Builder addStep(Action action) {
            if (!isEmpty(this.actions)) {
                this.actions = new LinkedList<>();
            }
            this.actions.add(action);
            return this;
        }

        public Step build() {
            return new Step(this);
        }
    }
}
