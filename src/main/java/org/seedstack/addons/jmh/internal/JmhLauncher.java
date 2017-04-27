/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.addons.jmh.internal;

import org.openjdk.jmh.runner.SeedJmhRunner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.seedstack.addons.jmh.JmhConfig;
import org.seedstack.coffig.Coffig;
import org.seedstack.seed.core.Seed;
import org.seedstack.seed.spi.SeedLauncher;

public class JmhLauncher implements SeedLauncher {
    @Override
    public void launch(String[] args) throws Exception {

        Coffig coffig = Seed.baseConfiguration();
        JmhConfig jmhConfig = coffig.get(JmhConfig.class);

        Options opt = new OptionsBuilder()
                .include(jmhConfig.getInclude())
                .mode(jmhConfig.getMode())
                .timeUnit(jmhConfig.getTimeUnit())
                .warmupTime(jmhConfig.getWarmupTime())
                .warmupIterations(jmhConfig.getWarmupIterations())
                .measurementTime(jmhConfig.getMeasurementTime())
                .measurementIterations(jmhConfig.getMeasurementIterations())
                .threads(jmhConfig.getThreads())
                .forks(jmhConfig.getForks())
                .shouldFailOnError(jmhConfig.isShouldFailOnError())
                .shouldDoGC(jmhConfig.isShouldDoGC())
                .jvmArgs(jmhConfig.getJvmArgs())
                .build();

        new SeedJmhRunner(opt).run();
    }

    @Override
    public void shutdown() throws Exception {
        // nothing to do
    }
}
