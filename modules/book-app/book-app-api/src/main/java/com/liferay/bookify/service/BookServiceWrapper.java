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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BookService}.
 *
 * @author Brian Wing Shun Chan
 * @see BookService
 * @generated
 */
public class BookServiceWrapper
	implements BookService, ServiceWrapper<BookService> {

	public BookServiceWrapper() {
		this(null);
	}

	public BookServiceWrapper(BookService bookService) {
		_bookService = bookService;
	}

	@Override
	public com.liferay.bookify.model.Book addBook(
			long groupId, String bookName, String bookAuthor,
			java.util.Date publicationDate)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookService.addBook(
			groupId, bookName, bookAuthor, publicationDate);
	}

	@Override
	public com.liferay.bookify.model.Book deleteById(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookService.deleteById(bookId);
	}

	@Override
	public java.util.List<com.liferay.bookify.model.Book> getBookByBookName(
			String bookName)
		throws com.liferay.bookify.exception.NoSuchBookException {

		return _bookService.getBookByBookName(bookName);
	}

	@Override
	public java.util.List<com.liferay.bookify.model.Book> getBooksByAuthorName(
		String bookAuthor) {

		return _bookService.getBooksByAuthorName(bookAuthor);
	}

	@Override
	public java.util.List<com.liferay.bookify.model.Book> getBooksByReaderrName(
		String readerName) {

		return _bookService.getBooksByReaderrName(readerName);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bookService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.bookify.model.Book updateBook(
			long bookId, java.util.Date publicationDate)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookService.updateBook(bookId, publicationDate);
	}

	@Override
	public com.liferay.bookify.model.Book updateBook(
			long bookId, long readerId, String readerName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookService.updateBook(bookId, readerId, readerName);
	}

	@Override
	public BookService getWrappedService() {
		return _bookService;
	}

	@Override
	public void setWrappedService(BookService bookService) {
		_bookService = bookService;
	}

	private BookService _bookService;

}