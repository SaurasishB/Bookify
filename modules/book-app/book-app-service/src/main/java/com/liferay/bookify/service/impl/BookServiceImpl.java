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

package com.liferay.bookify.service.impl;

import com.liferay.bookify.exception.NoSuchBookException;
import com.liferay.bookify.model.Book;
import com.liferay.bookify.service.base.BookServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=bookify",
		"json.web.service.context.path=Book"
	},
	service = AopService.class
)
public class BookServiceImpl extends BookServiceBaseImpl {
	@Override
	public Book addBook(long groupId, String bookName, String bookAuthor, Date publicationDate) throws PortalException{
		return bookLocalService.addBook(groupId, bookName, bookAuthor, publicationDate);
	}
	@Override
	public Book updateBook(long bookId, Date publicationDate) throws PortalException{
		return bookLocalService.updateBook(bookId, publicationDate);
	}
	@Override
	public Book updateBook(long bookId, long readerId, String readerName) throws PortalException {
		return bookLocalService.updateBook(bookId, readerId, readerName);
	}
	@Override
	public List<Book> getBooksByAuthorName(String bookAuthor){
		return bookLocalService.getBooksByAuthorName(bookAuthor);
	}
	@Override
	public List<Book> getBookByBookName(String bookName) throws NoSuchBookException {
		return bookLocalService.getBookByBookName(bookName);
	}
	@Override
	public List<Book> getBooksByReaderrName(String readerName){
		return bookLocalService.getBooksByReaderrName(readerName);
	}
	@Override
	public Book deleteById(long bookId) throws PortalException {
		return bookLocalService.deleteBYId(bookId);
	}
}