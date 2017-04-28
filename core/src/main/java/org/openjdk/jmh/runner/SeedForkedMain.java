/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.openjdk.jmh.runner;

import io.nuun.kernel.api.Kernel;
import org.seedstack.jmh.internal.JmhErrorCode;
import org.seedstack.seed.SeedException;
import org.seedstack.seed.core.Seed;

class SeedForkedMain {
    public static void main(String[] args) {
        Kernel kernel;
        try {
            kernel = Seed.createKernel();
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    Seed.disposeKernel(kernel);
                    Seed.close();
                } catch (Exception e) {
                    handleException(e);
                }
            }));
            ForkedMain.main(args);
        } catch (Exception e) {
            handleException(e);
            System.exit(-1);
        }
    }

    private static void handleException(Exception e) {
        Seed.diagnostic().dumpDiagnosticReport(e);
        if (e instanceof SeedException) {
            e.printStackTrace(System.err);
        } else {
            SeedException.wrap(e, JmhErrorCode.UNEXPECTED_EXCEPTION_DURING_FORKED_BENCHMARK).printStackTrace(System.err);
        }
    }

}
