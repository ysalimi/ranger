/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.ranger.plugin.store;

import org.apache.ranger.plugin.model.RangerPolicy;
import org.apache.ranger.plugin.model.RangerResource;
import org.apache.ranger.plugin.model.RangerTagDef;
import org.apache.ranger.plugin.util.SearchFilter;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Interface to backing store for the top-level TAG model objects
 */

public interface TagStore {
    void init() throws Exception;

    void setServiceStore(ServiceStore svcStore);

    RangerTagDef createTagDef(RangerTagDef tagDef) throws Exception;

    RangerTagDef updateTagDef(RangerTagDef TagDef) throws Exception;

    void deleteTagDef(String name) throws Exception;

    RangerTagDef getTagDef(String name) throws Exception;

    RangerTagDef getTagDefById(Long id) throws Exception;

    List<RangerTagDef> getTagDefs(SearchFilter filter) throws Exception;

    PList<RangerTagDef> getPaginatedTagDefs(SearchFilter filter) throws Exception;

    RangerResource createResource(RangerResource resource) throws Exception;

    RangerResource updateResource(RangerResource resource) throws Exception;

    void deleteResource(Long id) throws Exception;

    RangerResource getResource(Long id) throws Exception;

    public List<RangerResource> getResources(String componentType, Map<String, RangerPolicy.RangerPolicyResource> resourceSpec) throws Exception;

    List<RangerResource> getResources(String tagServiceName, String componentType) throws Exception;

    List<RangerResource> getResources(SearchFilter filter) throws Exception;

    PList<RangerResource> getPaginatedResources(SearchFilter filter) throws Exception;

    Set<String> getTags(String tagServiceName, String serviceType) throws Exception;

    Set<String> lookupTags(String tagServiceName, String serviceType, String tagNamePattern) throws Exception;
}
