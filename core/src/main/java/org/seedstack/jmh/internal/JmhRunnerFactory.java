/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.jmh.internal;

import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.SeedJmhRunner;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.seedstack.jmh.JmhConfig;

import java.io.File;
import java.util.Optional;

class JmhRunnerFactory {
    Runner createRunner(JmhConfig jmhConfig) {
        OptionsBuilder optionsBuilder = new OptionsBuilder();
        Optional.ofNullable(jmhConfig.getInclude()).ifPresent(optionsBuilder::include);
        Optional.ofNullable(jmhConfig.getIncludeWarmup()).ifPresent(optionsBuilder::includeWarmup);
        Optional.ofNullable(jmhConfig.getExclude()).ifPresent(optionsBuilder::exclude);
        Optional.ofNullable(jmhConfig.getResult()).map(File::getAbsolutePath).ifPresent(optionsBuilder::result);
        Optional.ofNullable(jmhConfig.getResultFormat()).ifPresent(optionsBuilder::resultFormat);
        optionsBuilder
                .warmupMode(jmhConfig.getWarmupMode())
                .warmupForks(jmhConfig.getWarmup().getForks())
                .warmupBatchSize(jmhConfig.getWarmup().getBatchSize())
                .warmupTime(jmhConfig.getWarmup().getTime())
                .warmupIterations(jmhConfig.getWarmup().getIterations())
                .mode(jmhConfig.getMode())
                .forks(jmhConfig.getMeasurement().getForks())
                .measurementBatchSize(jmhConfig.getMeasurement().getBatchSize())
                .measurementTime(jmhConfig.getMeasurement().getTime())
                .measurementIterations(jmhConfig.getMeasurement().getIterations())
                .operationsPerInvocation(jmhConfig.getOperationsPerInvocation())
                .threads(jmhConfig.getThreads())
                .shouldFailOnError(jmhConfig.isFailOnError())
                .shouldDoGC(jmhConfig.isGarbageCollection())
                .timeout(jmhConfig.getTimeout())
                .timeUnit(jmhConfig.getTimeUnit())
                .jvmArgs(jmhConfig.getJvmArgs());
        return new SeedJmhRunner(optionsBuilder.build());
    }
}
