<%@ include file= "../init.jsp" %>
<%
	
%>
<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="addEntry" var="addEntryURL" />
<aui:form action="<%= addEntryURL %>" name="<portlet:namespace />fm">

	<aui:fieldset>
		<aui:input label="Enter Book Name" name="bookName" />
	    <aui:input name="authorName" label = "Enter Author Name"/>
	    <aui:input name="bookPublicationDate" placeholder= "YYYY-MM-DD" label = "Enter Publication Date"></aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button cssClass= "ml-5" type="submit" value="Submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL.toString() %>" value= "Cancel"></aui:button>
	</aui:button-row>
</aui:form>
<%

%>



