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

package org.apache.rave.portal.web.controller;

import org.apache.rave.portal.model.PageLayout;
import org.apache.rave.portal.model.Page;
import org.apache.rave.portal.model.User;
import org.apache.rave.portal.service.PageService;
import org.apache.rave.portal.service.UserService;
import org.apache.rave.portal.web.util.ModelKeys;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertThat;

public class PageControllerTest {
    private UserService userService;
    private PageService pageService;
    private PageController pageController;
    
    private Model model;
    private Page defaultPage, otherPage;
    private List<Page> allPages;
    
    private final Long DEFAULT_PAGE_ID = 99L;
    private final Long OTHER_PAGE_ID = 22L;
    private final Long USER_ID = 1L;
    private final String HOME_VIEW = "home";
    private final String VALID_PAGE_LAYOUT_CODE = "layout98";
    private User validUser;
    private PageLayout validPageLayout;

    @Before
    public void setup() {
        userService = createMock(UserService.class);
        pageService = createMock(PageService.class);
        pageController = new PageController(pageService, userService);
        model = new ExtendedModelMap();
        
        defaultPage = new Page(DEFAULT_PAGE_ID);
        otherPage = new Page(OTHER_PAGE_ID);
        
        allPages = new ArrayList<Page>();
        allPages.add(defaultPage);   
        allPages.add(otherPage);            
        
        validPageLayout = new PageLayout();
        validPageLayout.setEntityId(33L);
        validPageLayout.setCode(VALID_PAGE_LAYOUT_CODE);
        
        validUser = new User(USER_ID);
        validUser.setDefaultPageLayout(validPageLayout);
    }

    @Test
    public void view_pageId() {
        expect(userService.getAuthenticatedUser()).andReturn(validUser).anyTimes(); 
        expect(pageService.getAllPages(USER_ID)).andReturn(allPages);
        expect(pageService.getPageFromList(OTHER_PAGE_ID, allPages)).andReturn(otherPage);
        replay(userService, pageService);       

        String results = pageController.view(OTHER_PAGE_ID, model);
        
        assertThat(results, equalTo(HOME_VIEW));
        assertThat((Page) model.asMap().get(ModelKeys.PAGE), sameInstance(otherPage));
        assertThat((List<Page>) model.asMap().get(ModelKeys.PAGES), sameInstance(allPages));
        
        verify(userService, pageService);
    }
    
    @Test
    public void view_pageId_zeroExistingPages() {
        List<Page> pages = new ArrayList<Page>();
        
        assertThat(pages.isEmpty(), is(true));
        expect(userService.getAuthenticatedUser()).andReturn(validUser).anyTimes(); 
        expect(pageService.getAllPages(USER_ID)).andReturn(pages).times(2);
        expect(pageService.addNewDefaultPage(validUser.getEntityId())).andReturn(defaultPage);
        expect(pageService.getPageFromList(OTHER_PAGE_ID, pages)).andReturn(defaultPage);
        replay(userService, pageService);         
        
        String results = pageController.view(OTHER_PAGE_ID, model);
        
        assertThat(results, equalTo(HOME_VIEW));
        assertThat((Page) model.asMap().get(ModelKeys.PAGE), sameInstance(defaultPage));
        assertThat((List<Page>) model.asMap().get(ModelKeys.PAGES), sameInstance(pages));
        
        verify(userService, pageService);
    }    
    
    @Test
    public void viewDefault_pageId() {
        expect(userService.getAuthenticatedUser()).andReturn(validUser).anyTimes(); 
        expect(pageService.getAllPages(USER_ID)).andReturn(allPages);
        expect(pageService.getDefaultPageFromList(allPages)).andReturn(defaultPage);
        replay(userService, pageService);

        String results = pageController.viewDefault(model);
        
        assertThat(results, equalTo(HOME_VIEW));
        assertThat((Page) model.asMap().get(ModelKeys.PAGE), sameInstance(defaultPage));
        assertThat((List<Page>) model.asMap().get(ModelKeys.PAGES), sameInstance(allPages));
        
        verify(userService, pageService);
    }
    
    @Test
    public void viewDefault_pageId_zeroExistingPages() {
        List<Page> pages = new ArrayList<Page>();
        
        assertThat(pages.isEmpty(), is(true));
        expect(userService.getAuthenticatedUser()).andReturn(validUser).anyTimes(); 
        expect(pageService.getAllPages(USER_ID)).andReturn(pages).times(2);
        expect(pageService.addNewDefaultPage(validUser.getEntityId())).andReturn(defaultPage);
        expect(pageService.getDefaultPageFromList(pages)).andReturn(defaultPage);
        replay(userService, pageService);

        String results = pageController.viewDefault(model);
        
        assertThat(results, equalTo(HOME_VIEW));
        assertThat((Page) model.asMap().get(ModelKeys.PAGE), sameInstance(defaultPage));
        assertThat((List<Page>) model.asMap().get(ModelKeys.PAGES), sameInstance(pages));
        
        verify(userService, pageService);
    }    
}