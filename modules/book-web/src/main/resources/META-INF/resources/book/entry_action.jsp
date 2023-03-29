<%@ include file= "../init.jsp" %>
<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Book book = (Book)row.getObject(); 
%>

<liferay-ui:icon-menu>

        <portlet:renderURL var="editURL">
            <portlet:param name="bookId"
                value="<%= String.valueOf(book.getBookId()) %>" />
            <portlet:param name="mvcPath" value="/book/edit_entry.jsp" />
        </portlet:renderURL>

        <liferay-ui:icon image="edit" message="Edit"
            url="<%=editURL.toString() %>" />

        <portlet:actionURL name="deleteEntry" var="deleteURL">
            <portlet:param name="bookId"
                value="<%= String.valueOf(book.getBookId()) %>" />
        </portlet:actionURL>

        <liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />

</liferay-ui:icon-menu>