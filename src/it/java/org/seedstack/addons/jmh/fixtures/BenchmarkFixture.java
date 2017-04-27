/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.addons.jmh.fixtures;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import javax.inject.Inject;
import javax.inject.Named;

@State(Scope.Thread)
public class BenchmarkFixture {

    @Inject
    @Named("adrien")
    private String adrien;

    @Benchmark
    public void toBenchmark() {
        for (int i = 0; i < 10; i++) {
            System.out.println(adrien + i);
        }
    }
}
