/*
 * Copyright (c) 2012 S.C. Axemblr Software Solutions S.R.L
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.provisionr.client;

import org.apache.provisionr.api.Provisionr;
import static com.google.common.base.Preconditions.checkNotNull;
import java.util.List;

public class ProvisionrClient {

    private final List<Provisionr> services;

    public ProvisionrClient(List<Provisionr> services) {
        this.services = checkNotNull(services, "services is null");
    }

    public List<Provisionr> getServices() {
        return services;
    }
}