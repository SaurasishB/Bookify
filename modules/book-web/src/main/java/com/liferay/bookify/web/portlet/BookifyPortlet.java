package com.liferay.bookify.web.portlet;

import com.liferay.bookify.model.Book;
import com.liferay.bookify.service.BookLocalService;
import com.liferay.bookify.web.constants.BookifyPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.ActionRequestFactory;

import java.util.Date;
import java.util.List;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author me
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.training",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Bookify",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + BookifyPortletKeys.BOOKIFY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class BookifyPortlet extends MVCPortlet {
	
	public void addEntry(ActionRequest request, ActionResponse response) throws PortletException, PortalException, ParseException{
		String bookName = ParamUtil.getString(request, "bookName");
		String authorName = ParamUtil.getString(request, "authorName");
		String date = ParamUtil.getString(request, "bookPublicationDate");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date publicationDate = format.parse(date);
		_bookLocalService.addBook(20121L, bookName, authorName, publicationDate);
	}
	public void deleteEntry(ActionRequest request, ActionResponse response) throws PortalException{
		long bookId = ParamUtil.getLong(request, "bookId");
		_bookLocalService.deleteBYId(bookId);
	}
	@Reference
	public BookLocalService _bookLocalService;
	
}