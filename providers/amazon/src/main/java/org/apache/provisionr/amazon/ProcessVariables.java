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

package org.apache.provisionr.amazon;

public final class ProcessVariables {

    private ProcessVariables() {
        /* singleton */
    }

    /**
     * ID of a base image from which to create the others in the pool
     */
    public static final String IMAGE_ID = "imageId";

    /**
     * The reservation ID for a pool as String
     *
     * @see org.apache.provisionr.amazon.activities.RunOnDemandInstances
     */
    public static final String RESERVATION_ID = "reservationId";

    /**
     * The amount the user is willing to pay for spot instances in the
     * Amazon pool he's trying to start. If set, the request is for spot
     * instances, if null the request is for on demand instances.
     *
     * @see org.apache.provisionr.amazon.activities.RunSpotInstances
     */
    public static final String SPOT_BID = "spotBid";

    /**
     * Flag that gets set when the process attempts to send spot requests
     * for the first time. Because the describe call is not consistent
     * until a reasonable delay passes, this will be used to timeout the
     * Activiti retries so that the requests are not resent if they were
     * successful.
     *
     * @see org.apache.provisionr.amazon.activities.RunSpotInstances
     */
    public static final String SPOT_REQUESTS_SENT = "spotRequestsSent";

    /**
     * List of request IDs as returned by Amazon for spot instances. These need to
     * be followed up to get the actual instance IDs.
     *
     * @see org.apache.provisionr.amazon.activities.RunSpotInstances
     */
    public static final String SPOT_INSTANCE_REQUEST_IDS = "spotInstanceRequestIds";

    /**
     * Have all spot instance requests been handled by Amazon? (none are pending)
     *
     * @see org.apache.provisionr.amazon.activities.CheckNoRequestsAreOpen
     */
    public static final String NO_SPOT_INSTANCE_REQUESTS_OPEN = "noSpotInstanceRequestsOpen";

    /**
     * Are all spot instance requests in an active state? (none cancelled, none terminated)
     *
     * @see org.apache.provisionr.amazon.activities.CheckAllRequestsAreActive
     */
    public static final String ALL_SPOT_INSTANCE_REQUESTS_ACTIVE = "allSpotInstanceRequestsActive";

    /**
     * List of instance IDs as returned by Amazon
     *
     * @see org.apache.provisionr.amazon.activities.RunOnDemandInstances
     */
    public static final String INSTANCE_IDS = "instanceIds";

    /**
     * List of requested EBS volume IDs
     *
     * @see org.apache.provisionr.amazon.activities.CreateEBSVolumes
     */
    public static final String VOLUME_IDS = "volumeIds";

    /**
     * Are all started instances running?
     *
     * @see org.apache.provisionr.amazon.activities.CheckAllInstancesAreRunning
     */
    public static final String ALL_INSTANCES_RUNNING = "allInstancesRunning";

    /**
     * Are all instances marked as terminated?
     *
     * @see org.apache.provisionr.amazon.activities.CheckAllInstancesAreTerminated
     */
    public static final String ALL_INSTANCES_TERMINATED = "allInstancesTerminated";

}
