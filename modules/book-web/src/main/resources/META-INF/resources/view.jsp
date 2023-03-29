<%@ include file="/init.jsp" %>

<%-- <div class = "container-fluid-1280">
	
	<h1><liferay-ui:message key= "Books"/></h1>
	<clay:management-toolbar
	diabled="${bookCount eq 0 }"
	displayContext = "${bookManagemenToolbarDisplayContext}"
	itemsTotal="${bookCount }"
	searchContainerId="bookEntries"
	selectable="false"
	/>	
	
	<liferay-ui:search-container
		emptyResultMessage="no-Book"
		id = "bookEntries"
		iteratorURL= "${portletURL }"
		total = "${bookCount}"/>
	
	<liferay-ui:search-container-results results= "${books }"/>
	<liferay-ui:search_container-row
		className="com.liferay.bookify.model.Book"
		modelVar= "entry"/>
</div> --%>

<%--getting the url to render --%>
<portlet:renderURL var="addEntryURL">
    <portlet:param name="mvcPath" value="/book/edit_entry.jsp"></portlet:param>
</portlet:renderURL>

<%--the button after clicking this the redering will be done --%>
<aui:button-row>
    <aui:button cssClass = "ml-5" onClick="<%= addEntryURL.toString() %>" value="Add Entry"></aui:button>
</aui:button-row>


<%-- the table to show the data --%>
<liferay-ui:search-container cssClass="m-2">
<liferay-ui:search-container-results
    results="<%=BookLocalServiceUtil.getBooks( searchContainer.getStart(),
                    searchContainer.getEnd())%>" />

<liferay-ui:search-container-row
    className="com.liferay.bookify.model.Book" modelVar="book">

    <liferay-ui:search-container-column-text property="bookName" name="Books"/>

    <liferay-ui:search-container-column-text property="bookAuthor" name="Name to the author"/>
    <liferay-ui:search-container-column-text property="bookPublicationDate" name="Date of Publication" />
	<liferay-ui:search-container-column-jsp
        align="right" 
        path="/book/entry_action.jsp" />
</liferay-ui:search-container-row>

<liferay-ui:search-iterator />

</liferay-ui:search-container>