/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.apache.shindig.social.opensocial.jpa;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;

import org.apache.shindig.social.opensocial.jpa.api.DbObject;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;


/**
 * An application data map is the map of data for a single key within an application.
 */
@Entity
@Table(name="application_datamap")
public class ApplicationDataMapDb implements DbObject {
  /**
   * The object needs to be seializable (map).
   */
  private static final long serialVersionUID = 8017568825925047318L;

  public static final String FINDBY_ALL_GROUP = null;

  public static final String FINDBY_FRIENDS_GROUP = "select am from ApplicationDataMapDb am where am.personId in (select f.friend.id from PersonDb p, FriendDb f where p.objectId = f.person.objectId and ";

  public static final String FINDBY_GROUP_GROUP = null;

  public static final String FINDBY_SELF_GROUP = "select am from ApplicationDataMapDb am where ";

  /**
   * The internal object ID used for references to this object. Should be generated by the
   * underlying storage mechanism
   */
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "oid")
  protected long objectId;

  /**
   * An optimistic locking field.
   */
  @Version
  @Column(name = "version")
  protected long version;

  /**
   * A Application Data Map belongs to a set of maps associated with an application.
   * The link from Application to DataMap is not navigable since it may contain 1000's of entries.
   */
  @ManyToOne(targetEntity=ApplicationDb.class)
  @JoinColumn(name="application_id", referencedColumnName="oid")
  protected ApplicationDb application;

  /**
   * Create map using ApplicationDataMapValueDb such that ApplicationDataMapDb are joined on oid ->
   * application_datamap_id and then the name value becomes the key, and the value becomes the value
   * unfortunately JPA wont do Map<String,String> so this is handled in the prePersist and postLoad
   * hook.
   */
  @OneToMany(targetEntity=ApplicationDataMapValueDb.class, mappedBy="applicationDataMap", cascade = ALL)
  @MapKey(name="name")
  protected Map<String, ApplicationDataMapValueDb> valuesDb = new MapMaker().makeMap();

  /**
   * The transient store for values loaded by the postLoad hook and persisted by the
   * prePersist hook.
   */
  @Transient
  protected Map<String, String> values;

  @Basic
  @Column(name="person_id", length=255)
  protected String personId;

  /**
   * persist the state of object before sending to the db.
   */
  @PrePersist
  public void prePersist() {
    // add new entries
    for (Entry<String, String> e : values.entrySet()) {
      ApplicationDataMapValueDb a = valuesDb.get(e.getKey());
      if (a == null) {
        a = new ApplicationDataMapValueDb();
        a.name = e.getKey();
        a.value = e.getValue();
        a.applicationDataMap = this;
        valuesDb.put(e.getKey(), a);
      } else {
        a.value = e.getValue();
      }
    }
    // remove old entries
    List<String> toRemove = Lists.newArrayList();
    for (Entry<String, ApplicationDataMapValueDb> e : valuesDb.entrySet()) {
      if (!values.containsKey(e.getKey())) {
        toRemove.add(e.getKey());
      }
    }
    for (String r : toRemove) {
      valuesDb.remove(r);
    }
  }

  /**
   * set the state of the object after load
   */
  @PostLoad
  public void postLoad() {
    values = new MapMaker().makeMap();
    for (Entry<String, ApplicationDataMapValueDb> e : valuesDb.entrySet()) {
      values.put(e.getKey(), e.getValue().value);
    }
  }

  /**
   * @return the application
   */
  public ApplicationDb getApplication() {
    return application;
  }

  /**
   * @param applicationData the applicationData to set
   */
  public void setApplication(ApplicationDb application) {
    this.application = application;
  }

  /**
   * @return the values
   */
  public Map<String, String> getValues() {
    return values;
  }

  /**
   * @param values the values to set
   */
  public void setValues(Map<String, String> values) {
    this.values = values;
  }

  /**
   * @return the objectId
   */
  public long getObjectId() {
    return objectId;
  }

  /**
   * @return the version
   */
  public long getVersion() {
    return version;
  }

  /**
   * @return the personId
   */
  public String getPersonId() {
    return personId;
  }

  /**
   * @param personId the personId to set
   */
  public void setPersonId(String personId) {
    this.personId = personId;
  }


}
