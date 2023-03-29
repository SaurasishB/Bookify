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

import com.liferay.bookify.model.Reader;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Reader in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ReaderCacheModel implements CacheModel<Reader>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ReaderCacheModel)) {
			return false;
		}

		ReaderCacheModel readerCacheModel = (ReaderCacheModel)object;

		if (readerId == readerCacheModel.readerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, readerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{readerId=");
		sb.append(readerId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", readerName=");
		sb.append(readerName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Reader toEntityModel() {
		ReaderImpl readerImpl = new ReaderImpl();

		readerImpl.setReaderId(readerId);
		readerImpl.setGroupId(groupId);
		readerImpl.setCompanyId(companyId);

		if (readerName == null) {
			readerImpl.setReaderName("");
		}
		else {
			readerImpl.setReaderName(readerName);
		}

		if (createDate == Long.MIN_VALUE) {
			readerImpl.setCreateDate(null);
		}
		else {
			readerImpl.setCreateDate(new Date(createDate));
		}

		readerImpl.resetOriginalValues();

		return readerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		readerId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		readerName = objectInput.readUTF();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(readerId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		if (readerName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(readerName);
		}

		objectOutput.writeLong(createDate);
	}

	public long readerId;
	public long groupId;
	public long companyId;
	public String readerName;
	public long createDate;

}