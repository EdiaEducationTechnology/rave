/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.rave.portal.repository.impl;

import org.apache.rave.persistence.jpa.AbstractJpaRepository;
import org.apache.rave.portal.model.PageLayout;
import org.apache.rave.portal.repository.PageLayoutRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

import java.util.List;

import static org.apache.rave.persistence.jpa.util.JpaUtil.getSingleResult;


/**
 */
@Repository
public class JpaPageLayoutRepository extends AbstractJpaRepository<PageLayout> implements PageLayoutRepository{

    public JpaPageLayoutRepository() {
        super(PageLayout.class);
    }

    @Override
    public PageLayout getByPageLayoutCode(String codename){
        TypedQuery<PageLayout>query = manager.createNamedQuery(PageLayout.PAGELAYOUT_GET_BY_LAYOUT_CODE,PageLayout.class);
        query.setParameter("code",codename);
        return getSingleResult(query.getResultList());
    }

    @Override
    public List<PageLayout> getAll() {
        return manager.createNamedQuery(PageLayout.PAGELAYOUT_GET_ALL, PageLayout.class).getResultList();
    }

    @Override
    public List<PageLayout> getAllUserSelectable() {
        return manager.createNamedQuery(PageLayout.PAGELAYOUT_GET_ALL_USER_SELECTABLE, PageLayout.class).getResultList();
    }
}
