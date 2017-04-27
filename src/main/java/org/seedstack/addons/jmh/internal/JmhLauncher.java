/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.addons.jmh.internal;

import io.nuun.kernel.api.Kernel;
import org.openjdk.jmh.runner.SeedJmhRunner;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.seedstack.addons.jmh.JmhConfig;
import org.seedstack.coffig.Coffig;
import org.seedstack.seed.core.Seed;
import org.seedstack.seed.spi.SeedLauncher;

public class JmhLauncher implements SeedLauncher {
    private Kernel kernel;

    @Override
    public void launch(String[] args) throws Exception {
        Coffig coffig = Seed.baseConfiguration();
        JmhConfig jmhConfig = coffig.get(JmhConfig.class);

        if (jmhConfig.getForks() == 0) {
            kernel = Seed.createKernel();
        }

        new SeedJmhRunner(
                new OptionsBuilder()
                        .include(jmhConfig.getBenchmarks())
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
                        .jvmArgs(jmhConfig.getJvmArgs())
                        .build())
                .run();
    }

    @Override
    public void shutdown() throws Exception {
        Seed.disposeKernel(kernel);
    }
}
