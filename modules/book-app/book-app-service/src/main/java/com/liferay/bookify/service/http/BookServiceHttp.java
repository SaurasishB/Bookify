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

package com.liferay.bookify.service.http;

import com.liferay.bookify.service.BookServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>BookServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BookServiceHttp {

	public static com.liferay.bookify.model.Book addBook(
			HttpPrincipal httpPrincipal, long groupId, String bookName,
			String bookAuthor, java.util.Date publicationDate)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				BookServiceUtil.class, "addBook", _addBookParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, bookName, bookAuthor, publicationDate);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.bookify.model.Book)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.bookify.model.Book updateBook(
			HttpPrincipal httpPrincipal, long bookId,
			java.util.Date publicationDate)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				BookServiceUtil.class, "updateBook",
				_updateBookParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, bookId, publicationDate);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.bookify.model.Book)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.bookify.model.Book updateBook(
			HttpPrincipal httpPrincipal, long bookId, long readerId,
			String readerName)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				BookServiceUtil.class, "updateBook",
				_updateBookParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, bookId, readerId, readerName);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.bookify.model.Book)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.bookify.model.Book>
		getBooksByAuthorName(HttpPrincipal httpPrincipal, String bookAuthor) {

		try {
			MethodKey methodKey = new MethodKey(
				BookServiceUtil.class, "getBooksByAuthorName",
				_getBooksByAuthorNameParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, bookAuthor);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.bookify.model.Book>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.bookify.model.Book>
			getBookByBookName(HttpPrincipal httpPrincipal, String bookName)
		throws com.liferay.bookify.exception.NoSuchBookException {

		try {
			MethodKey methodKey = new MethodKey(
				BookServiceUtil.class, "getBookByBookName",
				_getBookByBookNameParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, bookName);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.bookify.exception.NoSuchBookException) {

					throw (com.liferay.bookify.exception.NoSuchBookException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.bookify.model.Book>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.bookify.model.Book>
		getBooksByReaderrName(HttpPrincipal httpPrincipal, String readerName) {

		try {
			MethodKey methodKey = new MethodKey(
				BookServiceUtil.class, "getBooksByReaderrName",
				_getBooksByReaderrNameParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, readerName);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.bookify.model.Book>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.bookify.model.Book deleteById(
			HttpPrincipal httpPrincipal, long bookId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				BookServiceUtil.class, "deleteById",
				_deleteByIdParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey, bookId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.bookify.model.Book)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(BookServiceHttp.class);

	private static final Class<?>[] _addBookParameterTypes0 = new Class[] {
		long.class, String.class, String.class, java.util.Date.class
	};
	private static final Class<?>[] _updateBookParameterTypes1 = new Class[] {
		long.class, java.util.Date.class
	};
	private static final Class<?>[] _updateBookParameterTypes2 = new Class[] {
		long.class, long.class, String.class
	};
	private static final Class<?>[] _getBooksByAuthorNameParameterTypes3 =
		new Class[] {String.class};
	private static final Class<?>[] _getBookByBookNameParameterTypes4 =
		new Class[] {String.class};
	private static final Class<?>[] _getBooksByReaderrNameParameterTypes5 =
		new Class[] {String.class};
	private static final Class<?>[] _deleteByIdParameterTypes6 = new Class[] {
		long.class
	};

}