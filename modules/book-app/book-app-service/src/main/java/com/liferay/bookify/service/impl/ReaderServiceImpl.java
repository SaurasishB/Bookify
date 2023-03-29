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
import com.liferay.bookify.model.Reader;
import com.liferay.bookify.service.base.ReaderServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=bookify",
		"json.web.service.context.path=Reader"
	},
	service = AopService.class
)
public class ReaderServiceImpl extends ReaderServiceBaseImpl {
	@Override
	public Reader addReader(long groupId,String readerName) throws PortalException {
		return readerLocalService.addReader(groupId, readerName);
	}
	@Override
	public Reader updateReader(long readerId, String readerName) throws PortalException{
		return readerLocalService.updateReader(readerId, readerName);
	}
	@Override
	public Reader deleteById(long readerId) throws PortalException {
		return readerLocalService.deleteById(readerId);
	}
	@Override
	public Reader getReaderById(long readerId) throws PortalException {
		return readerLocalService.getReader(readerId);
	}
}

