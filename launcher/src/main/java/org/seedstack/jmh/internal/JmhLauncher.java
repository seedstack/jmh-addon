/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.jmh.internal;

import io.nuun.kernel.api.Kernel;
import io.nuun.kernel.api.Plugin;
import org.seedstack.coffig.Coffig;
import org.seedstack.jmh.JmhConfig;
import org.seedstack.seed.SeedException;
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
            JmhPlugin jmhPlugin = getJmhPlugin(kernel);
            jmhPlugin.getRunner().run();
        } else {
            new JmhRunnerFactory()
                    .createRunner(jmhConfig)
                    .run();
        }
        System.exit(0);
    }

    @Override
    public void shutdown() throws Exception {
        Seed.disposeKernel(kernel);
    }

    private JmhPlugin getJmhPlugin(Kernel kernel) {
        JmhPlugin jmhPlugin = null;
        Plugin plugin = kernel.plugins().get(JmhPlugin.NAME);
        if (plugin instanceof JmhPlugin) {
            jmhPlugin = (JmhPlugin) plugin;
        }
        if (jmhPlugin == null) {
            throw SeedException.createNew(JmhErrorCode.MISSING_JMH_PLUGIN);
        }
        return jmhPlugin;
    }
}
