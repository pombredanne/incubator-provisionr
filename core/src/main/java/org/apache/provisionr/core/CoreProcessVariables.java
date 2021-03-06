/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.provisionr.core;

public final class CoreProcessVariables {

    private CoreProcessVariables() {
    }

    /**
     * Provider ID as returned by the Provisionr object
     *
     * @see org.apache.provisionr.api.Provisionr
     */
    public static final String PROVIDER = "provider";

    /**
     * Pool configuration description
     *
     * @see org.apache.provisionr.api.pool.Pool
     */
    public static final String POOL = "pool";

    /**
     * Contains a list of machines that are running
     *
     * @see org.apache.provisionr.api.pool.Machine
     */
    public static final String MACHINES = "machines";

    /**
     * Pool status stored as process variable
     * <p/>
     * This can be an arbitrary string. We will restrict the domain later on.
     */
    public static final String STATUS = "status";

    /**
     * Variable to store the pool business key. The key is passed as a process variable to all processes that take
     * part in setting up the pool.
     */
    public static final String POOL_BUSINESS_KEY = "poolBusinessKey";

    /**
     * Configurable value for the interval of time in which to wait for the pool
     * to become available.
     */
    public static final String BOOTSTRAP_TIMEOUT = "bootstrapTimeout";

    /**
     * Flag that indicates if the image the machines are being built from already has all its software
     * installed and there's no need to download and install the packages and files.
     */
    public static final String IS_CACHED_IMAGE = "isCachedImage";
}
