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
package org.apache.rave.portal.model;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Tests the Page class.
 */
public class PageTest {
	private Page page;
	private long id;
	private String testName;
	private User testOwner;
	private PageLayout pageLayout;
	private long renderSequence;
	private List<Region> regions;
	
	@Before
	public void setup(){
		page=new Page();
		id=19191991L;
		testName="testName";
		testOwner=new User(id);
		pageLayout=new PageLayout();
		renderSequence=1223L;
		
		regions=new ArrayList<Region>();
		regions.add(new Region());
		regions.add(new Region());
		
		page.setId(id);
		page.setName(testName);
		page.setOwner(testOwner);
		page.setPageLayout(pageLayout);
		page.setRenderSequence(renderSequence);
		page.setRegions(regions);
	}
	
	@After
	public void tearDown(){
		page=null;
	}
	
	@Test
	public void testAccessorMethods() {
		assertTrue(page.getId()==id);
		assertTrue(page.getName().equals(testName));
		assertTrue(page.getOwner().equals(testOwner));
		assertTrue(page.getPageLayout().equals(pageLayout));
		assertTrue(page.getRenderSequence()==renderSequence);
	}

	@Test
	public void testRegions(){
		assertTrue(page.getRegions().containsAll(regions));
	}
}
