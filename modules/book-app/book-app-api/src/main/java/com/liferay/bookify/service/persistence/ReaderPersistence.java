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

import com.liferay.bookify.exception.NoSuchReaderException;
import com.liferay.bookify.model.Reader;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the reader service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReaderUtil
 * @generated
 */
@ProviderType
public interface ReaderPersistence extends BasePersistence<Reader> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ReaderUtil} to access the reader persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the reader where readerId = &#63; or throws a <code>NoSuchReaderException</code> if it could not be found.
	 *
	 * @param readerId the reader ID
	 * @return the matching reader
	 * @throws NoSuchReaderException if a matching reader could not be found
	 */
	public Reader findByReaderId(long readerId) throws NoSuchReaderException;

	/**
	 * Returns the reader where readerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param readerId the reader ID
	 * @return the matching reader, or <code>null</code> if a matching reader could not be found
	 */
	public Reader fetchByReaderId(long readerId);

	/**
	 * Returns the reader where readerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param readerId the reader ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching reader, or <code>null</code> if a matching reader could not be found
	 */
	public Reader fetchByReaderId(long readerId, boolean useFinderCache);

	/**
	 * Removes the reader where readerId = &#63; from the database.
	 *
	 * @param readerId the reader ID
	 * @return the reader that was removed
	 */
	public Reader removeByReaderId(long readerId) throws NoSuchReaderException;

	/**
	 * Returns the number of readers where readerId = &#63;.
	 *
	 * @param readerId the reader ID
	 * @return the number of matching readers
	 */
	public int countByReaderId(long readerId);

	/**
	 * Caches the reader in the entity cache if it is enabled.
	 *
	 * @param reader the reader
	 */
	public void cacheResult(Reader reader);

	/**
	 * Caches the readers in the entity cache if it is enabled.
	 *
	 * @param readers the readers
	 */
	public void cacheResult(java.util.List<Reader> readers);

	/**
	 * Creates a new reader with the primary key. Does not add the reader to the database.
	 *
	 * @param readerId the primary key for the new reader
	 * @return the new reader
	 */
	public Reader create(long readerId);

	/**
	 * Removes the reader with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param readerId the primary key of the reader
	 * @return the reader that was removed
	 * @throws NoSuchReaderException if a reader with the primary key could not be found
	 */
	public Reader remove(long readerId) throws NoSuchReaderException;

	public Reader updateImpl(Reader reader);

	/**
	 * Returns the reader with the primary key or throws a <code>NoSuchReaderException</code> if it could not be found.
	 *
	 * @param readerId the primary key of the reader
	 * @return the reader
	 * @throws NoSuchReaderException if a reader with the primary key could not be found
	 */
	public Reader findByPrimaryKey(long readerId) throws NoSuchReaderException;

	/**
	 * Returns the reader with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param readerId the primary key of the reader
	 * @return the reader, or <code>null</code> if a reader with the primary key could not be found
	 */
	public Reader fetchByPrimaryKey(long readerId);

	/**
	 * Returns all the readers.
	 *
	 * @return the readers
	 */
	public java.util.List<Reader> findAll();

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
	public java.util.List<Reader> findAll(int start, int end);

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
	public java.util.List<Reader> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Reader>
			orderByComparator);

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
	public java.util.List<Reader> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Reader>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the readers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of readers.
	 *
	 * @return the number of readers
	 */
	public int countAll();

}