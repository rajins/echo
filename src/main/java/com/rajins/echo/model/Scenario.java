package com.rajins.echo.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.function.Consumer;

import static org.springframework.util.CollectionUtils.isEmpty;

public class Scenario {
    private String name;
    private String description;
    private String environment;
    private String landingUrl;
    private long implicitWaitInMillis;
    private String createdBy;
    private Date createdDate;
    private LinkedList<Step> steps;

    private Scenario(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.environment = builder.environment;
        this.landingUrl = builder.landingUrl;
        this.implicitWaitInMillis = builder.implicitWaitInMillis;
        this.createdBy = builder.createdBy;
        this.createdDate = builder.createdDate;
        this.steps = builder.steps;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getLandingUrl() {
        return landingUrl;
    }

    public long getImplicitWaitInMillis() {
        return implicitWaitInMillis;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public LinkedList<Step> getSteps() {
        return steps;
    }

    public static class Builder {

        public String name;
        public String description;
        public String environment;
        public long implicitWaitInMillis;
        public String landingUrl;
        public String createdBy;
        public Date createdDate;
        public LinkedList<Step> steps;

        public Builder with(Consumer<Builder> consumer) {
            consumer.accept(this);
            return this;
        }

        public Builder addStep(Step step) {
            if (!isEmpty(this.steps)) {
                this.steps = new LinkedList<>();
            }
            this.steps.add(step);
            return this;
        }

        public Scenario build() {
            return new Scenario(this);
        }
    }
}
