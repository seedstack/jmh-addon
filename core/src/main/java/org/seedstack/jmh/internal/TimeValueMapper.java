/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.jmh.internal;

import org.openjdk.jmh.runner.options.TimeValue;
import org.seedstack.coffig.TreeNode;
import org.seedstack.coffig.node.ValueNode;
import org.seedstack.coffig.spi.ConfigurationMapper;

import java.lang.reflect.Type;

public class TimeValueMapper implements ConfigurationMapper {
    @Override
    public boolean canHandle(Type type) {
        return type instanceof Class && TimeValue.class.isAssignableFrom((Class<?>) type);
    }

    @Override
    public Object map(TreeNode treeNode, Type type) {
        return TimeValue.fromString(treeNode.value());
    }

    @Override
    public TreeNode unmap(Object object, Type type) {
        return new ValueNode(object.toString());
    }
}
