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
 * Provides a wrapper for {@link ReaderService}.
 *
 * @author Brian Wing Shun Chan
 * @see ReaderService
 * @generated
 */
public class ReaderServiceWrapper
	implements ReaderService, ServiceWrapper<ReaderService> {

	public ReaderServiceWrapper() {
		this(null);
	}

	public ReaderServiceWrapper(ReaderService readerService) {
		_readerService = readerService;
	}

	@Override
	public com.liferay.bookify.model.Reader addReader(
			long groupId, String readerName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _readerService.addReader(groupId, readerName);
	}

	@Override
	public com.liferay.bookify.model.Reader deleteById(long readerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _readerService.deleteById(readerId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _readerService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.bookify.model.Reader getReaderById(long readerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _readerService.getReaderById(readerId);
	}

	@Override
	public com.liferay.bookify.model.Reader updateReader(
			long readerId, String readerName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _readerService.updateReader(readerId, readerName);
	}

	@Override
	public ReaderService getWrappedService() {
		return _readerService;
	}

	@Override
	public void setWrappedService(ReaderService readerService) {
		_readerService = readerService;
	}

	private ReaderService _readerService;

}