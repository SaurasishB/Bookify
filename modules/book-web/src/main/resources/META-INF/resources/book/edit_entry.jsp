<%@include file="../init.jsp" %>
<% 
	long bookId = ParamUtil.getLong(renderRequest,"bookId"); 
	Book book = BookLocalServiceUtil.getBook(bookId);
%>

<portlet:actionURL>
	
</portlet:actionURL>

<aui:form action="<%= editEntryURL %>" name="<portlet:namespace />fm1">

<aui:model-context bean="<%= book %>" model="<%= Book.class %>" />

	<aui:fieldset>

		<aui:input name="bookName" />
		<aui:input name="email" />
		<aui:input name="message" />
		<aui:input name="entryId" type="hidden" />
		<aui:input name="guestbookId" type="hidden" value='<%= entry == null ? guestbookId : entry.getGuestbookId() %>'/>

	</aui:fieldset>

	<aui:button-row>

		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>

	</aui:button-row>
</aui:form>