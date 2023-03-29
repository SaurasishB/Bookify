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

import com.liferay.bookify.model.Reader;
import com.liferay.portal.kernel.exception.PortalException;

/**
 * Provides the remote service utility for Reader. This utility wraps
 * <code>com.liferay.bookify.service.impl.ReaderServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ReaderService
 * @generated
 */
public class ReaderServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.bookify.service.impl.ReaderServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Reader addReader(long groupId, String readerName)
		throws PortalException {

		return getService().addReader(groupId, readerName);
	}

	public static Reader deleteById(long readerId) throws PortalException {
		return getService().deleteById(readerId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Reader getReaderById(long readerId) throws PortalException {
		return getService().getReaderById(readerId);
	}

	public static Reader updateReader(long readerId, String readerName)
		throws PortalException {

		return getService().updateReader(readerId, readerName);
	}

	public static ReaderService getService() {
		return _service;
	}

	private static volatile ReaderService _service;

}