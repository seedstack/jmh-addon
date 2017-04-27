/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.addons.jmh.internal;

import com.google.inject.Injector;
import io.nuun.kernel.api.plugin.context.Context;
import org.seedstack.addons.jmh.AbstractBenchmark;
import org.seedstack.seed.SeedException;
import org.seedstack.seed.core.internal.AbstractSeedPlugin;

import javax.inject.Inject;
import java.lang.reflect.Field;

public class JmhPlugin extends AbstractSeedPlugin {
//    private static final Logger LOGGER = LoggerFactory.getLogger(JmhPlugin.class);
//    private final Collection<Class<?>> benchmarkClasses = new ArrayList<>();

    @Inject
    private Injector injector;

    @Override
    public String name() {
        return "jmh";
    }

//    @Override
//    public Collection<ClasspathScanRequest> classpathScanRequests() {
//        return classpathScanRequestBuilder()
//                .specification(BenchmarkSpecification.INSTANCE)
//                .build();
//    }
//
//    @Override
//    public InitState initialize(InitContext initContext) {
//        benchmarkClasses.addAll(initContext.scannedTypesBySpecification().get(BenchmarkSpecification.INSTANCE));
//        for (Class<?> benchmarkClass : benchmarkClasses) {
//            LOGGER.trace("Detected benchmark class {}", benchmarkClass.getName());
//        }
//        LOGGER.debug("Detected {} benchmark classes", benchmarkClasses.size());
//        return InitState.INITIALIZED;
//    }

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
}
