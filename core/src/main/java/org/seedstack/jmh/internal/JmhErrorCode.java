/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.jmh.internal;

import org.seedstack.shed.exception.ErrorCode;

public enum JmhErrorCode implements ErrorCode {
    UNEXPECTED_EXCEPTION_DURING_FORKED_BENCHMARK,
    MISSING_JMH_PLUGIN, UNABLE_TO_SET_INJECTOR
}
