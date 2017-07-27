/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.jmh.internal;

import com.google.inject.AbstractModule;
import org.openjdk.jmh.runner.Runner;

class JmhModule extends AbstractModule {
    private final Runner runner;

    JmhModule(Runner runner) {
        this.runner = runner;
    }

    @Override
    protected void configure() {
        bind(Runner.class).toInstance(runner);
    }
}