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
 * This class is a wrapper for {@link Reader}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Reader
 * @generated
 */
public class ReaderWrapper
	extends BaseModelWrapper<Reader> implements ModelWrapper<Reader>, Reader {

	public ReaderWrapper(Reader reader) {
		super(reader);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("readerId", getReaderId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("readerName", getReaderName());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long readerId = (Long)attributes.get("readerId");

		if (readerId != null) {
			setReaderId(readerId);
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
	}

	@Override
	public Reader cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this reader.
	 *
	 * @return the company ID of this reader
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this reader.
	 *
	 * @return the create date of this reader
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this reader.
	 *
	 * @return the group ID of this reader
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the primary key of this reader.
	 *
	 * @return the primary key of this reader
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reader ID of this reader.
	 *
	 * @return the reader ID of this reader
	 */
	@Override
	public long getReaderId() {
		return model.getReaderId();
	}

	/**
	 * Returns the reader name of this reader.
	 *
	 * @return the reader name of this reader
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
	 * Sets the company ID of this reader.
	 *
	 * @param companyId the company ID of this reader
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this reader.
	 *
	 * @param createDate the create date of this reader
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this reader.
	 *
	 * @param groupId the group ID of this reader
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the primary key of this reader.
	 *
	 * @param primaryKey the primary key of this reader
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reader ID of this reader.
	 *
	 * @param readerId the reader ID of this reader
	 */
	@Override
	public void setReaderId(long readerId) {
		model.setReaderId(readerId);
	}

	/**
	 * Sets the reader name of this reader.
	 *
	 * @param readerName the reader name of this reader
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
	protected ReaderWrapper wrap(Reader reader) {
		return new ReaderWrapper(reader);
	}

}