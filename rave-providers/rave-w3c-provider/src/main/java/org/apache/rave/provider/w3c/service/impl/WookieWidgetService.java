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

package org.apache.rave.provider.w3c.service.impl;

import org.apache.rave.portal.model.User;
import org.apache.rave.portal.model.Widget;
import org.apache.rave.portal.service.WidgetProviderService;
/*import org.apache.wookie.connector.framework.WidgetInstance;
import org.apache.wookie.connector.framework.WookieConnectorException;
import org.apache.wookie.connector.framework.WookieConnectorService;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

//import org.apache.wookie.connector.framework.WidgetInstance;
//import org.apache.wookie.connector.framework.WookieConnectorException;

@Service
public class WookieWidgetService implements WidgetProviderService {
  private static Logger logger = LoggerFactory.getLogger(WookieWidgetService.class);
	  
    // FIXME: shouldn't hard code the server location
    private static final String WOOKIE_SERVER_URL = "http://bombax.oucs.ox.ac.uk:8888/wookie";
    private static final String WOOKIE_API_KEY = "TEST"; 
    private static final String WOOKIE_SHARED_DATA_KEY = "mysharedkey";
    //private static WookieConnectorService  connectorService;
    
    public WookieWidgetService(){
    }

    /* (non-Javadoc)
     * @see org.apache.rave.portal.service.WidgetProviderService#getWidget(org.apache.rave.portal.model.User)
     */
    @Override
    public Widget getWidget(User viewer, String context, Widget widget) {
        if (widget.getType().equals("W3C")) {
          return getWidgetForViewer(widget, context, viewer);
        } else {
          return null;
        }
    }
    
    private Widget getWidgetForViewer(Widget widget, String context, User viewer){
      /*  try {
            // TODO: parameters for WookieConnectorService should not be fixed in code.
            connectorService = getWookieConnectorService(WOOKIE_SERVER_URL, WOOKIE_API_KEY, WOOKIE_SHARED_DATA_KEY);
            org.apache.wookie.connector.framework.User user = new org.apache.wookie.connector.framework.User(String.valueOf(viewer.getUsername()), viewer.getUsername());
            connectorService.setCurrentUser(user);
            
            logger.debug("Getting widget:"+widget.getUrl()+" from:" +connectorService.getConnection().getURL());
            WidgetInstance instance = connectorService.getOrCreateInstance(widget.getUrl());
            return createWidget(instance);
        } catch (WookieConnectorException e) {
            logger.error("Unable to connect to Wookie server", e);
            // FIXME: provide a real error widget
            return createWidget(new WidgetInstance("error", "error", e.getMessage(), "100", "100"));
        } catch (IOException e) {
            logger.error("Problem communicating with Wookie server", e);
            // FIXME: provide a real error widget
            return createWidget(new WidgetInstance("error", "error", e.getMessage(), "100", "100"));
        }*/
        //TODO Remove
        return null;
    }

    /**
     * Create a Rave Widget object for the widget instance.
     * This is a transient object and is not persisted
     * @return
     */
    /*private Widget createWidget(WidgetInstance instance){
        Widget widget = new Widget();
        widget.setUrl(instance.getUrl());
        widget.setTitle(instance.getTitle());
        widget.setType("W3C");
        return widget;
    }
    
    
    // Get the wookie service connector
    private WookieConnectorService getWookieConnectorService(String serverURL, String apiKey, String sharedDataKey ) throws WookieConnectorException {
      if (connectorService == null) {
        connectorService = new WookieConnectorService(serverURL, apiKey, sharedDataKey);
      }
      return connectorService;
    }*/
    

}