/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.bookify.service;

import com.liferay.bookify.exception.NoSuchBookException;
import com.liferay.bookify.model.Book;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Book. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see BookServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface BookService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.liferay.bookify.service.impl.BookServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the book remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link BookServiceUtil} if injection and service tracking are not available.
	 */
	public Book addBook(
			long groupId, String bookName, String bookAuthor,
			Date publicationDate)
		throws PortalException;

	public Book deleteById(long bookId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Book> getBookByBookName(String bookName)
		throws NoSuchBookException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Book> getBooksByAuthorName(String bookAuthor);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Book> getBooksByReaderrName(String readerName);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public Book updateBook(long bookId, Date publicationDate)
		throws PortalException;

	public Book updateBook(long bookId, long readerId, String readerName)
		throws PortalException;

}