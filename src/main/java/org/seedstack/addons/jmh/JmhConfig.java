/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.addons.jmh;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.options.TimeValue;
import org.seedstack.coffig.Config;
import org.seedstack.coffig.SingleValue;

import javax.validation.constraints.NotNull;
import java.util.concurrent.TimeUnit;

@Config("jmh")
public class JmhConfig {

    @SingleValue
    @NotNull
    private String include = ".*";

    private Mode mode = Mode.AverageTime;

    private TimeUnit timeUnit = TimeUnit.MILLISECONDS;

    private TimeValue warmupTime = TimeValue.seconds(1);

    private int warmupIterations = 0;

    private TimeValue measurementTime = TimeValue.seconds(1);

    private int measurementIterations = 1;

    private int threads = 1;

    private int forks = 0;

    private boolean shouldFailOnError = true;

    private boolean shouldDoGC = false;

    private String[] jvmArgs = new String[]{};

    public String getInclude() {
        return include;
    }

    public Mode getMode() {
        return mode;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public TimeValue getWarmupTime() {
        return warmupTime;
    }

    public int getWarmupIterations() {
        return warmupIterations;
    }

    public TimeValue getMeasurementTime() {
        return measurementTime;
    }

    public int getMeasurementIterations() {
        return measurementIterations;
    }

    public int getThreads() {
        return threads;
    }

    public int getForks() {
        return forks;
    }

    public boolean isShouldFailOnError() {
        return shouldFailOnError;
    }

    public boolean isShouldDoGC() {
        return shouldDoGC;
    }

    public String[] getJvmArgs() {
        return jvmArgs;
    }
}
