/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.orchestration.center.instance.handler;

import org.apache.shardingsphere.orchestration.center.exception.OrchestrationException;
import org.apache.zookeeper.KeeperException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.fail;

public class CuratorZookeeperExceptionHandlerTest {

    @Test
    public void assertHandleException() {
        CuratorZookeeperExceptionHandler.handleException(null);
        CuratorZookeeperExceptionHandler.handleException(new KeeperException.NoNodeException());
        CuratorZookeeperExceptionHandler.handleException(new Exception(new KeeperException.NoNodeException()));

        try {
            CuratorZookeeperExceptionHandler.handleException(new Exception());
            fail("must be failed handle new Exception().");
            // CHECKSTYLE:OFF
        } catch (final Exception ex) {
            // CHECKSTYLE:ON
            Assert.assertTrue(ex instanceof OrchestrationException);
        }
    }
}
