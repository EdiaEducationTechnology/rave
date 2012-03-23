<%--
  Licensed to the Apache Software Foundation (ASF) under one
  or more contributor license agreements.  See the NOTICE file
  distributed with this work for additional information
  regarding copyright ownership.  The ASF licenses this file
  to you under the Apache License, Version 2.0 (the
  "License"); you may not use this file except in compliance
  with the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing,
  software distributed under the License is distributed on an
  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
  KIND, either express or implied.  See the License for the
  specific language governing permissions and limitations
  under the License.

--%>
<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>

<portal:render-script location="${'BEFORE_LIB'}" />
<%-- json script --%>
<script src="//cdnjs.cloudflare.com/ajax/libs/json2/20110223/json2.js"></script>
<%-- jquery scripts --%>
<script src="//ajax.aspnetcdn.com/ajax/jQuery/jquery-1.6.4.min.js"></script>
<script src="//ajax.aspnetcdn.com/ajax/jquery.ui/1.8.16/jquery-ui.min.js"></script>
<script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.8.1/jquery.validate.min.js"></script>
<%-- google css3 mediaqueries script --%>
<!--[if lt IE 9]><script src=//css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js></script><![endif]-->
<%-- google html5 script --%>
<!--[if lt IE 9]><script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<portal:render-script location="${'AFTER_LIB'}" />
<%-- local rave scripts --%>
<portal:render-script location="${'BEFORE_RAVE'}" />
<script src="<spring:url value="/script/rave.js"/>"></script>
<script src="<spring:url value="/script/rave_api.js"/>"></script>
<script src="<spring:url value="/script/rave_opensocial.js"/>"></script>
<script src="<spring:url value="/script/rave_wookie.js"/>"></script>
<script src="<spring:url value="/script/rave_layout.js"/>"></script>
<script src="<spring:url value="/script/rave_forms.js"/>"></script>
<script src="<spring:url value="/script/rave_person_profile.js"/>"></script>
<script src="<spring:url value="/script/rave_store.js"/>"></script>
<script src="<spring:url value="/script/rave_admin.js"/>"></script>
<script src="<spring:url value="/app/messagebundle/rave_client_messages.js"/>"></script>
<portal:render-script location="${'AFTER_RAVE'}" />
<%-- common javascript to execute on all pages --%>
<script>
    rave.setContext("<spring:url value="/app/" />");
</script>
