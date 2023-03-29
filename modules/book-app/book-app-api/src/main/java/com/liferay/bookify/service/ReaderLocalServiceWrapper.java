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
 * Provides a wrapper for {@link ReaderLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ReaderLocalService
 * @generated
 */
public class ReaderLocalServiceWrapper
	implements ReaderLocalService, ServiceWrapper<ReaderLocalService> {

	public ReaderLocalServiceWrapper() {
		this(null);
	}

	public ReaderLocalServiceWrapper(ReaderLocalService readerLocalService) {
		_readerLocalService = readerLocalService;
	}

	@Override
	public com.liferay.bookify.model.Reader addReader(
			long groupId, String readerName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _readerLocalService.addReader(groupId, readerName);
	}

	/**
	 * Adds the reader to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReaderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param reader the reader
	 * @return the reader that was added
	 */
	@Override
	public com.liferay.bookify.model.Reader addReader(
		com.liferay.bookify.model.Reader reader) {

		return _readerLocalService.addReader(reader);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _readerLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new reader with the primary key. Does not add the reader to the database.
	 *
	 * @param readerId the primary key for the new reader
	 * @return the new reader
	 */
	@Override
	public com.liferay.bookify.model.Reader createReader(long readerId) {
		return _readerLocalService.createReader(readerId);
	}

	@Override
	public com.liferay.bookify.model.Reader deleteById(long readerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _readerLocalService.deleteById(readerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _readerLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the reader with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReaderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param readerId the primary key of the reader
	 * @return the reader that was removed
	 * @throws PortalException if a reader with the primary key could not be found
	 */
	@Override
	public com.liferay.bookify.model.Reader deleteReader(long readerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _readerLocalService.deleteReader(readerId);
	}

	/**
	 * Deletes the reader from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReaderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param reader the reader
	 * @return the reader that was removed
	 */
	@Override
	public com.liferay.bookify.model.Reader deleteReader(
		com.liferay.bookify.model.Reader reader) {

		return _readerLocalService.deleteReader(reader);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _readerLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _readerLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _readerLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _readerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.bookify.model.impl.ReaderModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _readerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.bookify.model.impl.ReaderModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _readerLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _readerLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _readerLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.bookify.model.Reader fetchReader(long readerId) {
		return _readerLocalService.fetchReader(readerId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _readerLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _readerLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _readerLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _readerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the reader with the primary key.
	 *
	 * @param readerId the primary key of the reader
	 * @return the reader
	 * @throws PortalException if a reader with the primary key could not be found
	 */
	@Override
	public com.liferay.bookify.model.Reader getReader(long readerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _readerLocalService.getReader(readerId);
	}

	@Override
	public com.liferay.bookify.model.Reader getReaderById(long readerId)
		throws com.liferay.bookify.exception.NoSuchReaderException {

		return _readerLocalService.getReaderById(readerId);
	}

	/**
	 * Returns a range of all the readers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.bookify.model.impl.ReaderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of readers
	 * @param end the upper bound of the range of readers (not inclusive)
	 * @return the range of readers
	 */
	@Override
	public java.util.List<com.liferay.bookify.model.Reader> getReaders(
		int start, int end) {

		return _readerLocalService.getReaders(start, end);
	}

	/**
	 * Returns the number of readers.
	 *
	 * @return the number of readers
	 */
	@Override
	public int getReadersCount() {
		return _readerLocalService.getReadersCount();
	}

	@Override
	public com.liferay.bookify.model.Reader updateReader(
			long readerId, String readerName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _readerLocalService.updateReader(readerId, readerName);
	}

	/**
	 * Updates the reader in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReaderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param reader the reader
	 * @return the reader that was updated
	 */
	@Override
	public com.liferay.bookify.model.Reader updateReader(
		com.liferay.bookify.model.Reader reader) {

		return _readerLocalService.updateReader(reader);
	}

	@Override
	public ReaderLocalService getWrappedService() {
		return _readerLocalService;
	}

	@Override
	public void setWrappedService(ReaderLocalService readerLocalService) {
		_readerLocalService = readerLocalService;
	}

	private ReaderLocalService _readerLocalService;

}