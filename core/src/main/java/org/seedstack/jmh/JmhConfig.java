/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.jmh;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.options.TimeValue;
import org.openjdk.jmh.runner.options.WarmupMode;
import org.seedstack.coffig.Config;
import org.seedstack.coffig.SingleValue;

import java.io.File;
import java.util.concurrent.TimeUnit;

@Config("jmh")
public class JmhConfig {
    @SingleValue
    private String include;
    private String includeWarmup;
    private String exclude;
    private File result;
    private ResultFormatType resultFormat;
    private WarmupMode warmupMode = WarmupMode.BULK;
    private Mode mode = Mode.AverageTime;
    private Computation warmup = new Computation(0, 1, TimeValue.seconds(1), 0);
    private Computation measurement = new Computation(0, 1, TimeValue.seconds(1), 1);
    private int operationsPerInvocation = 1;
    private int threads = 1;
    private boolean failOnError = true;
    private boolean garbageCollection = true;
    private TimeValue timeout = TimeValue.seconds(10);
    private TimeUnit timeUnit = TimeUnit.MILLISECONDS;
    private String[] jvmArgs = new String[]{};

    public static class Computation {
        private int forks = 0;
        private int batchSize = 1;
        private TimeValue time = TimeValue.seconds(1);
        private int iterations = 1;

        public Computation() {
        }

        public Computation(int forks, int batchSize, TimeValue time, int iterations) {
            this.forks = forks;
            this.batchSize = batchSize;
            this.time = time;
            this.iterations = iterations;
        }

        public int getForks() {
            return forks;
        }

        public Computation setForks(int forks) {
            this.forks = forks;
            return this;
        }

        public int getBatchSize() {
            return batchSize;
        }

        public Computation setBatchSize(int batchSize) {
            this.batchSize = batchSize;
            return this;
        }

        public TimeValue getTime() {
            return time;
        }

        public Computation setTime(TimeValue time) {
            this.time = time;
            return this;
        }

        public int getIterations() {
            return iterations;
        }

        public Computation setIterations(int iterations) {
            this.iterations = iterations;
            return this;
        }
    }

    public String getInclude() {
        return include;
    }

    public JmhConfig setInclude(String include) {
        this.include = include;
        return this;
    }

    public String getIncludeWarmup() {
        return includeWarmup;
    }

    public JmhConfig setIncludeWarmup(String includeWarmup) {
        this.includeWarmup = includeWarmup;
        return this;
    }

    public String getExclude() {
        return exclude;
    }

    public JmhConfig setExclude(String exclude) {
        this.exclude = exclude;
        return this;
    }

    public File getResult() {
        return result;
    }

    public JmhConfig setResult(File result) {
        this.result = result;
        return this;
    }

    public ResultFormatType getResultFormat() {
        return resultFormat;
    }

    public JmhConfig setResultFormat(ResultFormatType resultFormat) {
        this.resultFormat = resultFormat;
        return this;
    }

    public WarmupMode getWarmupMode() {
        return warmupMode;
    }

    public JmhConfig setWarmupMode(WarmupMode warmupMode) {
        this.warmupMode = warmupMode;
        return this;
    }

    public Mode getMode() {
        return mode;
    }

    public JmhConfig setMode(Mode mode) {
        this.mode = mode;
        return this;
    }

    public Computation getWarmup() {
        return warmup;
    }

    public JmhConfig setWarmup(Computation warmup) {
        this.warmup = warmup;
        return this;
    }

    public Computation getMeasurement() {
        return measurement;
    }

    public JmhConfig setMeasurement(Computation measurement) {
        this.measurement = measurement;
        return this;
    }

    public int getOperationsPerInvocation() {
        return operationsPerInvocation;
    }

    public JmhConfig setOperationsPerInvocation(int operationsPerInvocation) {
        this.operationsPerInvocation = operationsPerInvocation;
        return this;
    }

    public int getThreads() {
        return threads;
    }

    public JmhConfig setThreads(int threads) {
        this.threads = threads;
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

    public TimeValue getTimeout() {
        return timeout;
    }

    public JmhConfig setTimeout(TimeValue timeout) {
        this.timeout = timeout;
        return this;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public JmhConfig setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
        return this;
    }

    public String[] getJvmArgs() {
        return jvmArgs == null ? null : jvmArgs.clone();
    }

    public JmhConfig setJvmArgs(String[] jvmArgs) {
        this.jvmArgs = jvmArgs == null ? null : jvmArgs.clone();
        return this;
    }
}
