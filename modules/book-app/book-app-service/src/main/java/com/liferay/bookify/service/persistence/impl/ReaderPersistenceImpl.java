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

package com.liferay.bookify.service.persistence.impl;

import com.liferay.bookify.exception.NoSuchReaderException;
import com.liferay.bookify.model.Reader;
import com.liferay.bookify.model.ReaderTable;
import com.liferay.bookify.model.impl.ReaderImpl;
import com.liferay.bookify.model.impl.ReaderModelImpl;
import com.liferay.bookify.service.persistence.ReaderPersistence;
import com.liferay.bookify.service.persistence.ReaderUtil;
import com.liferay.bookify.service.persistence.impl.constants.BookifyPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the reader service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ReaderPersistence.class)
public class ReaderPersistenceImpl
	extends BasePersistenceImpl<Reader> implements ReaderPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ReaderUtil</code> to access the reader persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ReaderImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByReaderId;
	private FinderPath _finderPathCountByReaderId;

	/**
	 * Returns the reader where readerId = &#63; or throws a <code>NoSuchReaderException</code> if it could not be found.
	 *
	 * @param readerId the reader ID
	 * @return the matching reader
	 * @throws NoSuchReaderException if a matching reader could not be found
	 */
	@Override
	public Reader findByReaderId(long readerId) throws NoSuchReaderException {
		Reader reader = fetchByReaderId(readerId);

		if (reader == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("readerId=");
			sb.append(readerId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchReaderException(sb.toString());
		}

		return reader;
	}

	/**
	 * Returns the reader where readerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param readerId the reader ID
	 * @return the matching reader, or <code>null</code> if a matching reader could not be found
	 */
	@Override
	public Reader fetchByReaderId(long readerId) {
		return fetchByReaderId(readerId, true);
	}

	/**
	 * Returns the reader where readerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param readerId the reader ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching reader, or <code>null</code> if a matching reader could not be found
	 */
	@Override
	public Reader fetchByReaderId(long readerId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {readerId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByReaderId, finderArgs, this);
		}

		if (result instanceof Reader) {
			Reader reader = (Reader)result;

			if (readerId != reader.getReaderId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_READER_WHERE);

			sb.append(_FINDER_COLUMN_READERID_READERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(readerId);

				List<Reader> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByReaderId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {readerId};
							}

							_log.warn(
								"ReaderPersistenceImpl.fetchByReaderId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Reader reader = list.get(0);

					result = reader;

					cacheResult(reader);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Reader)result;
		}
	}

	/**
	 * Removes the reader where readerId = &#63; from the database.
	 *
	 * @param readerId the reader ID
	 * @return the reader that was removed
	 */
	@Override
	public Reader removeByReaderId(long readerId) throws NoSuchReaderException {
		Reader reader = findByReaderId(readerId);

		return remove(reader);
	}

	/**
	 * Returns the number of readers where readerId = &#63;.
	 *
	 * @param readerId the reader ID
	 * @return the number of matching readers
	 */
	@Override
	public int countByReaderId(long readerId) {
		FinderPath finderPath = _finderPathCountByReaderId;

		Object[] finderArgs = new Object[] {readerId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_READER_WHERE);

			sb.append(_FINDER_COLUMN_READERID_READERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(readerId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_READERID_READERID_2 =
		"reader.readerId = ?";

	public ReaderPersistenceImpl() {
		setModelClass(Reader.class);

		setModelImplClass(ReaderImpl.class);
		setModelPKClass(long.class);

		setTable(ReaderTable.INSTANCE);
	}

	/**
	 * Caches the reader in the entity cache if it is enabled.
	 *
	 * @param reader the reader
	 */
	@Override
	public void cacheResult(Reader reader) {
		entityCache.putResult(ReaderImpl.class, reader.getPrimaryKey(), reader);

		finderCache.putResult(
			_finderPathFetchByReaderId, new Object[] {reader.getReaderId()},
			reader);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the readers in the entity cache if it is enabled.
	 *
	 * @param readers the readers
	 */
	@Override
	public void cacheResult(List<Reader> readers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (readers.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Reader reader : readers) {
			if (entityCache.getResult(
					ReaderImpl.class, reader.getPrimaryKey()) == null) {

				cacheResult(reader);
			}
		}
	}

	/**
	 * Clears the cache for all readers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ReaderImpl.class);

		finderCache.clearCache(ReaderImpl.class);
	}

	/**
	 * Clears the cache for the reader.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Reader reader) {
		entityCache.removeResult(ReaderImpl.class, reader);
	}

	@Override
	public void clearCache(List<Reader> readers) {
		for (Reader reader : readers) {
			entityCache.removeResult(ReaderImpl.class, reader);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ReaderImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ReaderImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(ReaderModelImpl readerModelImpl) {
		Object[] args = new Object[] {readerModelImpl.getReaderId()};

		finderCache.putResult(
			_finderPathCountByReaderId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByReaderId, args, readerModelImpl);
	}

	/**
	 * Creates a new reader with the primary key. Does not add the reader to the database.
	 *
	 * @param readerId the primary key for the new reader
	 * @return the new reader
	 */
	@Override
	public Reader create(long readerId) {
		Reader reader = new ReaderImpl();

		reader.setNew(true);
		reader.setPrimaryKey(readerId);

		reader.setCompanyId(CompanyThreadLocal.getCompanyId());

		return reader;
	}

	/**
	 * Removes the reader with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param readerId the primary key of the reader
	 * @return the reader that was removed
	 * @throws NoSuchReaderException if a reader with the primary key could not be found
	 */
	@Override
	public Reader remove(long readerId) throws NoSuchReaderException {
		return remove((Serializable)readerId);
	}

	/**
	 * Removes the reader with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the reader
	 * @return the reader that was removed
	 * @throws NoSuchReaderException if a reader with the primary key could not be found
	 */
	@Override
	public Reader remove(Serializable primaryKey) throws NoSuchReaderException {
		Session session = null;

		try {
			session = openSession();

			Reader reader = (Reader)session.get(ReaderImpl.class, primaryKey);

			if (reader == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchReaderException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(reader);
		}
		catch (NoSuchReaderException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Reader removeImpl(Reader reader) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(reader)) {
				reader = (Reader)session.get(
					ReaderImpl.class, reader.getPrimaryKeyObj());
			}

			if (reader != null) {
				session.delete(reader);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (reader != null) {
			clearCache(reader);
		}

		return reader;
	}

	@Override
	public Reader updateImpl(Reader reader) {
		boolean isNew = reader.isNew();

		if (!(reader instanceof ReaderModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(reader.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(reader);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in reader proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Reader implementation " +
					reader.getClass());
		}

		ReaderModelImpl readerModelImpl = (ReaderModelImpl)reader;

		if (isNew && (reader.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				reader.setCreateDate(date);
			}
			else {
				reader.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(reader);
			}
			else {
				reader = (Reader)session.merge(reader);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(ReaderImpl.class, readerModelImpl, false, true);

		cacheUniqueFindersCache(readerModelImpl);

		if (isNew) {
			reader.setNew(false);
		}

		reader.resetOriginalValues();

		return reader;
	}

	/**
	 * Returns the reader with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the reader
	 * @return the reader
	 * @throws NoSuchReaderException if a reader with the primary key could not be found
	 */
	@Override
	public Reader findByPrimaryKey(Serializable primaryKey)
		throws NoSuchReaderException {

		Reader reader = fetchByPrimaryKey(primaryKey);

		if (reader == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchReaderException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return reader;
	}

	/**
	 * Returns the reader with the primary key or throws a <code>NoSuchReaderException</code> if it could not be found.
	 *
	 * @param readerId the primary key of the reader
	 * @return the reader
	 * @throws NoSuchReaderException if a reader with the primary key could not be found
	 */
	@Override
	public Reader findByPrimaryKey(long readerId) throws NoSuchReaderException {
		return findByPrimaryKey((Serializable)readerId);
	}

	/**
	 * Returns the reader with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param readerId the primary key of the reader
	 * @return the reader, or <code>null</code> if a reader with the primary key could not be found
	 */
	@Override
	public Reader fetchByPrimaryKey(long readerId) {
		return fetchByPrimaryKey((Serializable)readerId);
	}

	/**
	 * Returns all the readers.
	 *
	 * @return the readers
	 */
	@Override
	public List<Reader> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Reader> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Reader> findAll(
		int start, int end, OrderByComparator<Reader> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Reader> findAll(
		int start, int end, OrderByComparator<Reader> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Reader> list = null;

		if (useFinderCache) {
			list = (List<Reader>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_READER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_READER;

				sql = sql.concat(ReaderModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Reader>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the readers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Reader reader : findAll()) {
			remove(reader);
		}
	}

	/**
	 * Returns the number of readers.
	 *
	 * @return the number of readers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_READER);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "readerId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_READER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ReaderModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the reader persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByReaderId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByReaderId",
			new String[] {Long.class.getName()}, new String[] {"readerId"},
			true);

		_finderPathCountByReaderId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByReaderId",
			new String[] {Long.class.getName()}, new String[] {"readerId"},
			false);

		_setReaderUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setReaderUtilPersistence(null);

		entityCache.removeCache(ReaderImpl.class.getName());
	}

	private void _setReaderUtilPersistence(
		ReaderPersistence readerPersistence) {

		try {
			Field field = ReaderUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, readerPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = BookifyPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = BookifyPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = BookifyPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_READER =
		"SELECT reader FROM Reader reader";

	private static final String _SQL_SELECT_READER_WHERE =
		"SELECT reader FROM Reader reader WHERE ";

	private static final String _SQL_COUNT_READER =
		"SELECT COUNT(reader) FROM Reader reader";

	private static final String _SQL_COUNT_READER_WHERE =
		"SELECT COUNT(reader) FROM Reader reader WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "reader.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Reader exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Reader exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ReaderPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}