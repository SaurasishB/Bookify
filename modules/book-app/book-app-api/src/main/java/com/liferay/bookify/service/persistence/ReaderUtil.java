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

package com.liferay.bookify.service.persistence;

import com.liferay.bookify.model.Reader;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the reader service. This utility wraps <code>com.liferay.bookify.service.persistence.impl.ReaderPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReaderPersistence
 * @generated
 */
public class ReaderUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Reader reader) {
		getPersistence().clearCache(reader);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Reader> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Reader> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Reader> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Reader> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Reader> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Reader update(Reader reader) {
		return getPersistence().update(reader);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Reader update(Reader reader, ServiceContext serviceContext) {
		return getPersistence().update(reader, serviceContext);
	}

	/**
	 * Returns the reader where readerId = &#63; or throws a <code>NoSuchReaderException</code> if it could not be found.
	 *
	 * @param readerId the reader ID
	 * @return the matching reader
	 * @throws NoSuchReaderException if a matching reader could not be found
	 */
	public static Reader findByReaderId(long readerId)
		throws com.liferay.bookify.exception.NoSuchReaderException {

		return getPersistence().findByReaderId(readerId);
	}

	/**
	 * Returns the reader where readerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param readerId the reader ID
	 * @return the matching reader, or <code>null</code> if a matching reader could not be found
	 */
	public static Reader fetchByReaderId(long readerId) {
		return getPersistence().fetchByReaderId(readerId);
	}

	/**
	 * Returns the reader where readerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param readerId the reader ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching reader, or <code>null</code> if a matching reader could not be found
	 */
	public static Reader fetchByReaderId(
		long readerId, boolean useFinderCache) {

		return getPersistence().fetchByReaderId(readerId, useFinderCache);
	}

	/**
	 * Removes the reader where readerId = &#63; from the database.
	 *
	 * @param readerId the reader ID
	 * @return the reader that was removed
	 */
	public static Reader removeByReaderId(long readerId)
		throws com.liferay.bookify.exception.NoSuchReaderException {

		return getPersistence().removeByReaderId(readerId);
	}

	/**
	 * Returns the number of readers where readerId = &#63;.
	 *
	 * @param readerId the reader ID
	 * @return the number of matching readers
	 */
	public static int countByReaderId(long readerId) {
		return getPersistence().countByReaderId(readerId);
	}

	/**
	 * Caches the reader in the entity cache if it is enabled.
	 *
	 * @param reader the reader
	 */
	public static void cacheResult(Reader reader) {
		getPersistence().cacheResult(reader);
	}

	/**
	 * Caches the readers in the entity cache if it is enabled.
	 *
	 * @param readers the readers
	 */
	public static void cacheResult(List<Reader> readers) {
		getPersistence().cacheResult(readers);
	}

	/**
	 * Creates a new reader with the primary key. Does not add the reader to the database.
	 *
	 * @param readerId the primary key for the new reader
	 * @return the new reader
	 */
	public static Reader create(long readerId) {
		return getPersistence().create(readerId);
	}

	/**
	 * Removes the reader with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param readerId the primary key of the reader
	 * @return the reader that was removed
	 * @throws NoSuchReaderException if a reader with the primary key could not be found
	 */
	public static Reader remove(long readerId)
		throws com.liferay.bookify.exception.NoSuchReaderException {

		return getPersistence().remove(readerId);
	}

	public static Reader updateImpl(Reader reader) {
		return getPersistence().updateImpl(reader);
	}

	/**
	 * Returns the reader with the primary key or throws a <code>NoSuchReaderException</code> if it could not be found.
	 *
	 * @param readerId the primary key of the reader
	 * @return the reader
	 * @throws NoSuchReaderException if a reader with the primary key could not be found
	 */
	public static Reader findByPrimaryKey(long readerId)
		throws com.liferay.bookify.exception.NoSuchReaderException {

		return getPersistence().findByPrimaryKey(readerId);
	}

	/**
	 * Returns the reader with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param readerId the primary key of the reader
	 * @return the reader, or <code>null</code> if a reader with the primary key could not be found
	 */
	public static Reader fetchByPrimaryKey(long readerId) {
		return getPersistence().fetchByPrimaryKey(readerId);
	}

	/**
	 * Returns all the readers.
	 *
	 * @return the readers
	 */
	public static List<Reader> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the readers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReaderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of readers
	 * @param end the upper bound of the range of readers (not inclusive)
	 * @return the range of readers
	 */
	public static List<Reader> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the readers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReaderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of readers
	 * @param end the upper bound of the range of readers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of readers
	 */
	public static List<Reader> findAll(
		int start, int end, OrderByComparator<Reader> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the readers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReaderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of readers
	 * @param end the upper bound of the range of readers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of readers
	 */
	public static List<Reader> findAll(
		int start, int end, OrderByComparator<Reader> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the readers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of readers.
	 *
	 * @return the number of readers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ReaderPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ReaderPersistence _persistence;

}