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

import com.liferay.bookify.model.Book;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * Provides the remote service utility for Book. This utility wraps
 * <code>com.liferay.bookify.service.impl.BookServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see BookService
 * @generated
 */
public class BookServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.bookify.service.impl.BookServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Book addBook(
			long groupId, String bookName, String bookAuthor,
			java.util.Date publicationDate)
		throws PortalException {

		return getService().addBook(
			groupId, bookName, bookAuthor, publicationDate);
	}

	public static Book deleteById(long bookId) throws PortalException {
		return getService().deleteById(bookId);
	}

	public static List<Book> getBookByBookName(String bookName)
		throws com.liferay.bookify.exception.NoSuchBookException {

		return getService().getBookByBookName(bookName);
	}

	public static List<Book> getBooksByAuthorName(String bookAuthor) {
		return getService().getBooksByAuthorName(bookAuthor);
	}

	public static List<Book> getBooksByReaderrName(String readerName) {
		return getService().getBooksByReaderrName(readerName);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Book updateBook(long bookId, java.util.Date publicationDate)
		throws PortalException {

		return getService().updateBook(bookId, publicationDate);
	}

	public static Book updateBook(long bookId, long readerId, String readerName)
		throws PortalException {

		return getService().updateBook(bookId, readerId, readerName);
	}

	public static BookService getService() {
		return _service;
	}

	private static volatile BookService _service;

}