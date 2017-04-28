/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.jmh.internal;

import com.google.inject.Injector;
import io.nuun.kernel.api.plugin.InitState;
import io.nuun.kernel.api.plugin.context.Context;
import io.nuun.kernel.api.plugin.context.InitContext;
import org.openjdk.jmh.runner.Runner;
import org.seedstack.jmh.AbstractBenchmark;
import org.seedstack.jmh.JmhConfig;
import org.seedstack.seed.SeedException;
import org.seedstack.seed.core.internal.AbstractSeedPlugin;

import javax.inject.Inject;
import java.lang.reflect.Field;

public class JmhPlugin extends AbstractSeedPlugin {
    static final String NAME = "jmh";
    private Runner runner;

    @Inject
    private Injector injector;

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public InitState initialize(InitContext initContext) {
        runner = new JmhRunnerFactory().createRunner(getConfiguration(JmhConfig.class));
        return InitState.INITIALIZED;
    }

    @Override
    public Object nativeUnitModule() {
        return new JmhModule(runner);
    }

    @Override
    public void start(Context context) {
        try {
            Field injectorField = AbstractBenchmark.class.getDeclaredField("injector");
            injectorField.setAccessible(true);
            injectorField.set(null, injector);
        } catch (Exception e) {
            throw SeedException.wrap(e, JmhErrorCode.UNABLE_TO_SET_INJECTOR);
        }
    }

    Runner getRunner() {
        return runner;
    }
}
