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

package org.apache.provisionr.cloudstack.commands;

import com.google.common.collect.Sets;
import java.util.Set;
import static org.fest.assertions.api.Assertions.assertThat;
import org.jclouds.cloudstack.domain.DiskOffering;
import org.jclouds.cloudstack.domain.NetworkOffering;
import org.jclouds.cloudstack.domain.ServiceOffering;
import org.jclouds.cloudstack.features.OfferingClient;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OfferingsCommandTest extends CommandTestSupport {

    final Set<ServiceOffering> serviceOfferings = Sets.newHashSet(ServiceOffering.builder()
        .id("service-1")
        .name("service-one")
        .build());

    final Set<DiskOffering> diskOfferings = Sets.newHashSet(DiskOffering.builder()
        .id("disk-1")
        .name("disk-one")
        .build());

    final Set<NetworkOffering> networkOfferings = Sets.newHashSet(NetworkOffering.builder()
        .id("network-1")
        .name("network-one")
        .build());

    @Test
    public void testOfferingCommandWithNoOptionSpecified() throws Exception {
        final OfferingsCommand offeringsCommand = new OfferingsCommand(defaultProviderConfig);
        offeringsCommand.doExecuteWithContext(client, out);
        out.close();
        assertThat(byteArrayOutputStream.toString()).contains("No option specified");
    }

    @Test
    public void testOfferingCommandsPrintsServiceOfferings() throws Exception {
        final OfferingClient offeringClient = mock(OfferingClient.class);
        when(client.getOfferingClient()).thenReturn(offeringClient);
        when(offeringClient.listServiceOfferings()).thenReturn(serviceOfferings);

        final OfferingsCommand offeringsCommand = new OfferingsCommand(defaultProviderConfig);
        offeringsCommand.setServiceOffering(true);
        offeringsCommand.doExecuteWithContext(client, out);
        out.close();

        assertThat(byteArrayOutputStream.toString())
            .contains("service-1")
            .contains("service-one")
            .doesNotContain("No option");
    }

    @Test
    public void testOfferingsCommandWithAllOptions() throws Exception {
        final OfferingClient offeringClient = mock(OfferingClient.class);

        when(client.getOfferingClient()).thenReturn(offeringClient);
        when(offeringClient.listServiceOfferings()).thenReturn(serviceOfferings);
        when(offeringClient.listDiskOfferings()).thenReturn(diskOfferings);
        when(offeringClient.listNetworkOfferings()).thenReturn(networkOfferings);

        final OfferingsCommand offeringsCommand = new OfferingsCommand(defaultProviderConfig);

        offeringsCommand.setServiceOffering(true);
        offeringsCommand.setDiskOffering(true);
        offeringsCommand.setNetworkOffering(true);

        offeringsCommand.doExecuteWithContext(client, out);

        out.close();

        assertThat(byteArrayOutputStream.toString())
            .contains("service-1")
            .contains("service-one")
            .contains("disk-1")
            .contains("network-1")
            .doesNotContain("No option");
    }
}
