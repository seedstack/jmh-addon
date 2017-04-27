/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.addons.jmh.fixtures;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.seedstack.seed.Install;

@Install
public class JmhModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(String.class).annotatedWith(Names.named("adrien")).toInstance("I'm the big boss");
    }
}
