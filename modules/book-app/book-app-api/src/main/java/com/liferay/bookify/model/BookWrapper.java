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

package com.liferay.bookify.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Book}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Book
 * @generated
 */
public class BookWrapper
	extends BaseModelWrapper<Book> implements Book, ModelWrapper<Book> {

	public BookWrapper(Book book) {
		super(book);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bookId", getBookId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("readerName", getReaderName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("bookName", getBookName());
		attributes.put("bookAuthor", getBookAuthor());
		attributes.put("bookPublicationDate", getBookPublicationDate());
		attributes.put("readerId", getReaderId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bookId = (Long)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String readerName = (String)attributes.get("readerName");

		if (readerName != null) {
			setReaderName(readerName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String bookName = (String)attributes.get("bookName");

		if (bookName != null) {
			setBookName(bookName);
		}

		String bookAuthor = (String)attributes.get("bookAuthor");

		if (bookAuthor != null) {
			setBookAuthor(bookAuthor);
		}

		Date bookPublicationDate = (Date)attributes.get("bookPublicationDate");

		if (bookPublicationDate != null) {
			setBookPublicationDate(bookPublicationDate);
		}

		Long readerId = (Long)attributes.get("readerId");

		if (readerId != null) {
			setReaderId(readerId);
		}
	}

	@Override
	public Book cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the book author of this book.
	 *
	 * @return the book author of this book
	 */
	@Override
	public String getBookAuthor() {
		return model.getBookAuthor();
	}

	/**
	 * Returns the book ID of this book.
	 *
	 * @return the book ID of this book
	 */
	@Override
	public long getBookId() {
		return model.getBookId();
	}

	/**
	 * Returns the book name of this book.
	 *
	 * @return the book name of this book
	 */
	@Override
	public String getBookName() {
		return model.getBookName();
	}

	/**
	 * Returns the book publication date of this book.
	 *
	 * @return the book publication date of this book
	 */
	@Override
	public Date getBookPublicationDate() {
		return model.getBookPublicationDate();
	}

	/**
	 * Returns the company ID of this book.
	 *
	 * @return the company ID of this book
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this book.
	 *
	 * @return the create date of this book
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this book.
	 *
	 * @return the group ID of this book
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this book.
	 *
	 * @return the modified date of this book
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this book.
	 *
	 * @return the primary key of this book
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reader ID of this book.
	 *
	 * @return the reader ID of this book
	 */
	@Override
	public long getReaderId() {
		return model.getReaderId();
	}

	/**
	 * Returns the reader name of this book.
	 *
	 * @return the reader name of this book
	 */
	@Override
	public String getReaderName() {
		return model.getReaderName();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the book author of this book.
	 *
	 * @param bookAuthor the book author of this book
	 */
	@Override
	public void setBookAuthor(String bookAuthor) {
		model.setBookAuthor(bookAuthor);
	}

	/**
	 * Sets the book ID of this book.
	 *
	 * @param bookId the book ID of this book
	 */
	@Override
	public void setBookId(long bookId) {
		model.setBookId(bookId);
	}

	/**
	 * Sets the book name of this book.
	 *
	 * @param bookName the book name of this book
	 */
	@Override
	public void setBookName(String bookName) {
		model.setBookName(bookName);
	}

	/**
	 * Sets the book publication date of this book.
	 *
	 * @param bookPublicationDate the book publication date of this book
	 */
	@Override
	public void setBookPublicationDate(Date bookPublicationDate) {
		model.setBookPublicationDate(bookPublicationDate);
	}

	/**
	 * Sets the company ID of this book.
	 *
	 * @param companyId the company ID of this book
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this book.
	 *
	 * @param createDate the create date of this book
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this book.
	 *
	 * @param groupId the group ID of this book
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this book.
	 *
	 * @param modifiedDate the modified date of this book
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this book.
	 *
	 * @param primaryKey the primary key of this book
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reader ID of this book.
	 *
	 * @param readerId the reader ID of this book
	 */
	@Override
	public void setReaderId(long readerId) {
		model.setReaderId(readerId);
	}

	/**
	 * Sets the reader name of this book.
	 *
	 * @param readerName the reader name of this book
	 */
	@Override
	public void setReaderName(String readerName) {
		model.setReaderName(readerName);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected BookWrapper wrap(Book book) {
		return new BookWrapper(book);
	}

}