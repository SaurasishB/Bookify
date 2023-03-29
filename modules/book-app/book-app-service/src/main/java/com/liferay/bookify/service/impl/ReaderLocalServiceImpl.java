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

import com.liferay.bookify.exception.NoSuchReaderException;
import com.liferay.bookify.model.Book;
import com.liferay.bookify.model.Reader;
import com.liferay.bookify.service.base.ReaderLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.bookify.model.Reader",
	service = AopService.class
)
public class ReaderLocalServiceImpl extends ReaderLocalServiceBaseImpl {
	@Override
	public Reader addReader(long groupId,String readerName) throws PortalException {
		Group group = groupLocalService.getGroup(groupId);
		long readerId = counterLocalService.increment(Reader.class.getName());
		Reader reader = createReader(readerId);
		reader.setReaderName(readerName);
		reader.setReaderId(readerId);
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		reader.setCreateDate(date);
		return readerLocalService.addReader(reader);
	}
	@Override
	public Reader updateReader(long readerId, String readerName) throws PortalException{
		Reader reader = getReader(readerId);
		return updateReader(reader);
	}
	@Override
	public Reader deleteById(long readerId) throws PortalException {
		return deleteReader(readerId);
	}
	@Override
	public Reader getReaderById(long readerId) throws NoSuchReaderException {
		return readerPersistence.findByReaderId(readerId);
	}
}