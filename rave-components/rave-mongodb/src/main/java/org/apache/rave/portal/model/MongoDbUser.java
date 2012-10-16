/*
 * Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.rave.portal.model;

import com.google.common.collect.Lists;
import org.apache.rave.portal.model.impl.UserImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

/**
 */
public class MongoDbUser extends UserImpl {

    private List<String> authorityCodes;
    private List<MongoDbPersonAssociation> friends;

    public MongoDbUser(long id) {
        super(id);
    }

    public MongoDbUser() {
    }

    public List<String> getAuthorityCodes() {
        return authorityCodes;
    }

    public void setAuthorityCodes(List<String> authorityCodes) {
        this.authorityCodes = authorityCodes;
    }

    public List<MongoDbPersonAssociation> getFriends() {
        return friends;
    }

    public void setFriends(List<MongoDbPersonAssociation> friends) {
        this.friends = friends;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        if (authorityCodes != null) {
            for (String code : authorityCodes) {
                grantedAuthorities.add(new SimpleGrantedAuthority(code));
            }
        }
        return grantedAuthorities;
    }
}
