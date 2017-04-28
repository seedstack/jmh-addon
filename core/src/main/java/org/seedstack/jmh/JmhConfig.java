/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.jmh;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.options.TimeValue;
import org.seedstack.coffig.Config;
import org.seedstack.coffig.SingleValue;

import java.util.concurrent.TimeUnit;

@Config("jmh")
public class JmhConfig {
    @SingleValue
    private String include;
    private Mode mode = Mode.AverageTime;
    private TimeUnit timeUnit = TimeUnit.MILLISECONDS;
    private TimeValue warmupTime = TimeValue.seconds(1);
    private int warmupIterations = 0;
    private TimeValue measurementTime = TimeValue.seconds(1);
    private int measurementIterations = 1;
    private int threads = 1;
    private int forks = 0;
    private boolean failOnError = true;
    private boolean garbageCollection = true;
    private String[] jvmArgs = new String[]{};

    public String getInclude() {
        return include;
    }

    public JmhConfig setInclude(String include) {
        this.include = include;
        return this;
    }

    public Mode getMode() {
        return mode;
    }

    public JmhConfig setMode(Mode mode) {
        this.mode = mode;
        return this;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public JmhConfig setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
        return this;
    }

    public TimeValue getWarmupTime() {
        return warmupTime;
    }

    public JmhConfig setWarmupTime(TimeValue warmupTime) {
        this.warmupTime = warmupTime;
        return this;
    }

    public int getWarmupIterations() {
        return warmupIterations;
    }

    public JmhConfig setWarmupIterations(int warmupIterations) {
        this.warmupIterations = warmupIterations;
        return this;
    }

    public TimeValue getMeasurementTime() {
        return measurementTime;
    }

    public JmhConfig setMeasurementTime(TimeValue measurementTime) {
        this.measurementTime = measurementTime;
        return this;
    }

    public int getMeasurementIterations() {
        return measurementIterations;
    }

    public JmhConfig setMeasurementIterations(int measurementIterations) {
        this.measurementIterations = measurementIterations;
        return this;
    }

    public int getThreads() {
        return threads;
    }

    public JmhConfig setThreads(int threads) {
        this.threads = threads;
        return this;
    }

    public int getForks() {
        return forks;
    }

    public JmhConfig setForks(int forks) {
        this.forks = forks;
        return this;
    }

    public boolean isFailOnError() {
        return failOnError;
    }

    public JmhConfig setFailOnError(boolean failOnError) {
        this.failOnError = failOnError;
        return this;
    }

    public boolean isGarbageCollection() {
        return garbageCollection;
    }

    public JmhConfig setGarbageCollection(boolean garbageCollection) {
        this.garbageCollection = garbageCollection;
        return this;
    }

    public String[] getJvmArgs() {
        return jvmArgs;
    }

    public JmhConfig setJvmArgs(String[] jvmArgs) {
        this.jvmArgs = jvmArgs;
        return this;
    }
}
