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

package org.apache.rave.portal.repository.impl;

import org.apache.rave.portal.model.MongoDbPageLayout;
import org.apache.rave.portal.model.PageLayout;
import org.apache.rave.portal.repository.PageLayoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class MongoDbPageLayoutRepository implements PageLayoutRepository {
    @Autowired
    private MongoOperations template;

    @Override
    public PageLayout getByPageLayoutCode(String codename) {
        return template.findOne(new Query(where("code").is(codename)), MongoDbPageLayout.class);
    }

    @Override
    public List<PageLayout> getAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<PageLayout> getAllUserSelectable() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Class<? extends PageLayout> getType() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PageLayout get(long id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PageLayout save(PageLayout item) {
        template.save(item);
        return item;
    }

    @Override
    public void delete(PageLayout item) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}