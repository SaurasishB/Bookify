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
import com.liferay.bookify.service.BookLocalServiceUtil;
import com.liferay.bookify.service.base.BookLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Group;
import org.osgi.service.component.annotations.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.bookify.model.Book",
	service = AopService.class
)
public class BookLocalServiceImpl extends BookLocalServiceBaseImpl {
	@Override
	public Book addBook(long groupId, String bookName, String bookAuthor, Date publicationDate) throws PortalException {
		Group group = groupLocalService.getGroup(groupId);
		long bookId = counterLocalService.increment(Book.class.getName());
		Book book = createBook(bookId);
		book.setBookAuthor(bookAuthor);
		book.setBookName(bookName);
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		book.setBookPublicationDate(publicationDate);
		book.setCreateDate(date);
		book.setGroupId(groupId);
		return bookLocalService.addBook(book);
	}
	@Override
	public Book updateBook(long bookId, Date publicationDate) throws PortalException {
		Book book = getBook(bookId);
		book.setBookPublicationDate(publicationDate);
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		book.setModifiedDate(date);
		return bookLocalService.updateBook(book);
	}
	@Override
	public Book updateBook(long bookId, long readerId, String readerName) throws PortalException {
		Book book = getBook(bookId);
		book.setReaderId(readerId);
		book.setReaderName(readerName);
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		book.setModifiedDate(date);
		return bookLocalService.updateBook(book);
	}
	@Override
	public List<Book> getBooksByAuthorName(String bookAuthor){
		return bookPersistence.findByAuthorName(bookAuthor);
	}
	@Override
	public List<Book> getBookByBookName(String bookName) throws NoSuchBookException {
		return bookPersistence.findByBookName(bookName);
	}
	@Override
	public List<Book> getBooksByReaderrName(String readerName){
		return bookPersistence.findByReaderName(readerName);
	}
	@Override
	public Book deleteBYId(long bookId) throws PortalException {
		return bookLocalService.deleteBook(bookId);
	}
//	@Override
//	 public List<Book> findAllBook(){
//	        Session session= null;
//	        List<Book> entries = null;
//	        try{
//	            session = openSession();
//	            ClassLoader classLoader= getClass().getClassLoader();
//	            DynamicQuery entryQuery = DynamicQueryFactoryUtil.forClass(Book.class,classLoader);
//	            entries= BookLocalServiceUtil.dynamicQuery(entryQuery);
//
//	        }catch(Exception e) {
//	            try {
//	                throw new SystemException(e);
//	            }
//	            catch (SystemException se) {
//	                se.printStackTrace();
//	            }
//
//	        }
//	        finally{
//	            closeSession(session);
//	        }
//	        return entries;
//	    }
}