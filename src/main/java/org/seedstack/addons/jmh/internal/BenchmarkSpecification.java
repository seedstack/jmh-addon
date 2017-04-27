/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.addons.jmh.internal;

import org.kametic.specifications.AbstractSpecification;
import org.openjdk.jmh.annotations.Benchmark;
import org.seedstack.shed.reflect.Classes;

class BenchmarkSpecification extends AbstractSpecification<Class<?>> {
    static final BenchmarkSpecification INSTANCE = new BenchmarkSpecification();

    private BenchmarkSpecification() {
        // no direct instantiation allowed
    }

    @Override
    public boolean isSatisfiedBy(Class<?> candidate) {
        return Classes.from(candidate)
                .traversingSuperclasses()
                .methods()
                .anyMatch(method -> method.isAnnotationPresent(Benchmark.class));
    }
}
