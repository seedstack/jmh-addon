/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.openjdk.jmh.runner;

import org.openjdk.jmh.infra.BenchmarkParams;
import org.openjdk.jmh.profile.ExternalProfiler;
import org.openjdk.jmh.runner.format.OutputFormat;
import org.openjdk.jmh.runner.options.Options;

import java.util.ArrayList;
import java.util.List;

public class SeedJmhRunner extends Runner {
    private static final String FORKED_MAIN_CLASS_NAME = ForkedMain.class.getName();

    private static final String SEED_FORKED_MAIN_CLASS_NAME = SeedForkedMain.class.getName();

    public SeedJmhRunner(Options options, OutputFormat format) {
        super(options, format);
    }

    public SeedJmhRunner(Options options) {
        super(options);
    }

    @Override
    List<String> getForkedMainCommand(BenchmarkParams benchmark, List<ExternalProfiler> profilers, String host, int port) {
        List<String> forkedMainCommand = super.getForkedMainCommand(benchmark, profilers, host, port);
        List<String> alteredCommand = new ArrayList<>();
        for (String arg : forkedMainCommand) {
            if (FORKED_MAIN_CLASS_NAME.equals(arg)) {
                alteredCommand.add(SEED_FORKED_MAIN_CLASS_NAME);
            } else {
                alteredCommand.add(arg);
            }
        }
        return alteredCommand;
    }
}
