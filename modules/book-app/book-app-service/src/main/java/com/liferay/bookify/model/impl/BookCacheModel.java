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

package com.liferay.bookify.model.impl;

import com.liferay.bookify.model.Book;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Book in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BookCacheModel implements CacheModel<Book>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BookCacheModel)) {
			return false;
		}

		BookCacheModel bookCacheModel = (BookCacheModel)object;

		if (bookId == bookCacheModel.bookId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bookId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{bookId=");
		sb.append(bookId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", readerName=");
		sb.append(readerName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", bookName=");
		sb.append(bookName);
		sb.append(", bookAuthor=");
		sb.append(bookAuthor);
		sb.append(", bookPublicationDate=");
		sb.append(bookPublicationDate);
		sb.append(", readerId=");
		sb.append(readerId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Book toEntityModel() {
		BookImpl bookImpl = new BookImpl();

		bookImpl.setBookId(bookId);
		bookImpl.setGroupId(groupId);
		bookImpl.setCompanyId(companyId);

		if (readerName == null) {
			bookImpl.setReaderName("");
		}
		else {
			bookImpl.setReaderName(readerName);
		}

		if (createDate == Long.MIN_VALUE) {
			bookImpl.setCreateDate(null);
		}
		else {
			bookImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			bookImpl.setModifiedDate(null);
		}
		else {
			bookImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (bookName == null) {
			bookImpl.setBookName("");
		}
		else {
			bookImpl.setBookName(bookName);
		}

		if (bookAuthor == null) {
			bookImpl.setBookAuthor("");
		}
		else {
			bookImpl.setBookAuthor(bookAuthor);
		}

		if (bookPublicationDate == Long.MIN_VALUE) {
			bookImpl.setBookPublicationDate(null);
		}
		else {
			bookImpl.setBookPublicationDate(new Date(bookPublicationDate));
		}

		bookImpl.setReaderId(readerId);

		bookImpl.resetOriginalValues();

		return bookImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bookId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		readerName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		bookName = objectInput.readUTF();
		bookAuthor = objectInput.readUTF();
		bookPublicationDate = objectInput.readLong();

		readerId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(bookId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		if (readerName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(readerName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (bookName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bookName);
		}

		if (bookAuthor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bookAuthor);
		}

		objectOutput.writeLong(bookPublicationDate);

		objectOutput.writeLong(readerId);
	}

	public long bookId;
	public long groupId;
	public long companyId;
	public String readerName;
	public long createDate;
	public long modifiedDate;
	public String bookName;
	public String bookAuthor;
	public long bookPublicationDate;
	public long readerId;

}