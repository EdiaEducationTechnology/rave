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

import org.apache.rave.portal.model.BasicEntity;
import org.apache.rave.portal.repository.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.apache.rave.portal.repository.impl.util.JpaUtil.saveOrUpdate;

/**
 * Provides generic implementations of {@link org.apache.rave.portal.repository.Repository} methods
 */
public abstract class AbstractJpaRepository<T extends BasicEntity> implements Repository<T> {

    @PersistenceContext
    protected EntityManager manager;

    private final Class<T> type;

    protected AbstractJpaRepository(Class<T> type) {
        this.type = type;
    }

    @Override
    public void delete(T item) {
        manager.remove(item);
    }

    @Override
    public T save(T item) {
        return saveOrUpdate(item.getId(), manager, item);
    }

    @Override
    public T get(long id) {
        return manager.find(type, id);
    }
}