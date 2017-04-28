/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.jmh.internal;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.SeedJmhRunner;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.seedstack.jmh.JmhConfig;

import java.util.Optional;

class JmhRunnerFactory {
    Runner createRunner(JmhConfig jmhConfig) {
        OptionsBuilder optionsBuilder = new OptionsBuilder();
        Optional.ofNullable(jmhConfig.getInclude()).ifPresent(optionsBuilder::include);
        optionsBuilder
                .mode(jmhConfig.getMode())
                .timeUnit(jmhConfig.getTimeUnit())
                .warmupTime(jmhConfig.getWarmupTime())
                .warmupIterations(jmhConfig.getWarmupIterations())
                .measurementTime(jmhConfig.getMeasurementTime())
                .measurementIterations(jmhConfig.getMeasurementIterations())
                .threads(jmhConfig.getThreads())
                .forks(jmhConfig.getForks())
                .shouldFailOnError(jmhConfig.isFailOnError())
                .shouldDoGC(jmhConfig.isGarbageCollection())
                .jvmArgs(jmhConfig.getJvmArgs());
        return new SeedJmhRunner(optionsBuilder.build());
    }
}
