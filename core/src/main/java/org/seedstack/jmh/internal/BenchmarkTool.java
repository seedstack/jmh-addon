/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.jmh.internal;

import org.openjdk.jmh.runner.Runner;
import org.seedstack.seed.core.internal.AbstractSeedTool;

import javax.inject.Inject;

public class BenchmarkTool extends AbstractSeedTool {
    @Inject
    private Runner runner;

    @Override
    public String toolName() {
        return "benchmark";
    }

    @Override
    public StartMode startMode() {
        return StartMode.FULL;
    }

    @Override
    public Integer call() throws Exception {
        runner.run();
        return 0;
    }
}
