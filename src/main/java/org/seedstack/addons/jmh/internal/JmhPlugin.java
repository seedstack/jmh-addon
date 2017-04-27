/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.addons.jmh.internal;

import io.nuun.kernel.api.plugin.InitState;
import io.nuun.kernel.api.plugin.context.Context;
import io.nuun.kernel.api.plugin.context.InitContext;
import io.nuun.kernel.api.plugin.request.ClasspathScanRequest;
import org.seedstack.addons.jmh.JmhConfig;
import org.seedstack.seed.core.internal.AbstractSeedPlugin;

import java.util.Collection;

public class JmhPlugin extends AbstractSeedPlugin {
    private JmhConfig jmhConfig;

    @Override
    public String name() {
        return "jmh";
    }
    
    @Override
    public InitState initialize(InitContext initContext) {
        jmhConfig = getConfiguration(JmhConfig.class);

        // TODO: place add-on initialization code here if any

        return InitState.INITIALIZED;
    }

    @Override
    public Object nativeUnitModule() {
        return new JmhModule();
    }

    @Override
    public void start(Context context) {
        // TODO: place add-on startup code here if any
    }

    @Override
    public void stop() {
        // TODO: place add-on shutdown code here if any
    }
}
