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

import com.liferay.bookify.exception.NoSuchBookException;
import com.liferay.bookify.model.Book;
import com.liferay.bookify.model.BookTable;
import com.liferay.bookify.model.impl.BookImpl;
import com.liferay.bookify.model.impl.BookModelImpl;
import com.liferay.bookify.service.persistence.BookPersistence;
import com.liferay.bookify.service.persistence.BookUtil;
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

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the book service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = BookPersistence.class)
public class BookPersistenceImpl
	extends BasePersistenceImpl<Book> implements BookPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BookUtil</code> to access the book persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BookImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByAuthorName;
	private FinderPath _finderPathWithoutPaginationFindByAuthorName;
	private FinderPath _finderPathCountByAuthorName;

	/**
	 * Returns all the books where bookAuthor = &#63;.
	 *
	 * @param bookAuthor the book author
	 * @return the matching books
	 */
	@Override
	public List<Book> findByAuthorName(String bookAuthor) {
		return findByAuthorName(
			bookAuthor, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the books where bookAuthor = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookModelImpl</code>.
	 * </p>
	 *
	 * @param bookAuthor the book author
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @return the range of matching books
	 */
	@Override
	public List<Book> findByAuthorName(String bookAuthor, int start, int end) {
		return findByAuthorName(bookAuthor, start, end, null);
	}

	/**
	 * Returns an ordered range of all the books where bookAuthor = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookModelImpl</code>.
	 * </p>
	 *
	 * @param bookAuthor the book author
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching books
	 */
	@Override
	public List<Book> findByAuthorName(
		String bookAuthor, int start, int end,
		OrderByComparator<Book> orderByComparator) {

		return findByAuthorName(
			bookAuthor, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the books where bookAuthor = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookModelImpl</code>.
	 * </p>
	 *
	 * @param bookAuthor the book author
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching books
	 */
	@Override
	public List<Book> findByAuthorName(
		String bookAuthor, int start, int end,
		OrderByComparator<Book> orderByComparator, boolean useFinderCache) {

		bookAuthor = Objects.toString(bookAuthor, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAuthorName;
				finderArgs = new Object[] {bookAuthor};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAuthorName;
			finderArgs = new Object[] {
				bookAuthor, start, end, orderByComparator
			};
		}

		List<Book> list = null;

		if (useFinderCache) {
			list = (List<Book>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Book book : list) {
					if (!bookAuthor.equals(book.getBookAuthor())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_BOOK_WHERE);

			boolean bindBookAuthor = false;

			if (bookAuthor.isEmpty()) {
				sb.append(_FINDER_COLUMN_AUTHORNAME_BOOKAUTHOR_3);
			}
			else {
				bindBookAuthor = true;

				sb.append(_FINDER_COLUMN_AUTHORNAME_BOOKAUTHOR_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BookModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindBookAuthor) {
					queryPos.add(bookAuthor);
				}

				list = (List<Book>)QueryUtil.list(
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
	 * Returns the first book in the ordered set where bookAuthor = &#63;.
	 *
	 * @param bookAuthor the book author
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	@Override
	public Book findByAuthorName_First(
			String bookAuthor, OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException {

		Book book = fetchByAuthorName_First(bookAuthor, orderByComparator);

		if (book != null) {
			return book;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bookAuthor=");
		sb.append(bookAuthor);

		sb.append("}");

		throw new NoSuchBookException(sb.toString());
	}

	/**
	 * Returns the first book in the ordered set where bookAuthor = &#63;.
	 *
	 * @param bookAuthor the book author
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book, or <code>null</code> if a matching book could not be found
	 */
	@Override
	public Book fetchByAuthorName_First(
		String bookAuthor, OrderByComparator<Book> orderByComparator) {

		List<Book> list = findByAuthorName(bookAuthor, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last book in the ordered set where bookAuthor = &#63;.
	 *
	 * @param bookAuthor the book author
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	@Override
	public Book findByAuthorName_Last(
			String bookAuthor, OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException {

		Book book = fetchByAuthorName_Last(bookAuthor, orderByComparator);

		if (book != null) {
			return book;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bookAuthor=");
		sb.append(bookAuthor);

		sb.append("}");

		throw new NoSuchBookException(sb.toString());
	}

	/**
	 * Returns the last book in the ordered set where bookAuthor = &#63;.
	 *
	 * @param bookAuthor the book author
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book, or <code>null</code> if a matching book could not be found
	 */
	@Override
	public Book fetchByAuthorName_Last(
		String bookAuthor, OrderByComparator<Book> orderByComparator) {

		int count = countByAuthorName(bookAuthor);

		if (count == 0) {
			return null;
		}

		List<Book> list = findByAuthorName(
			bookAuthor, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the books before and after the current book in the ordered set where bookAuthor = &#63;.
	 *
	 * @param bookId the primary key of the current book
	 * @param bookAuthor the book author
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	@Override
	public Book[] findByAuthorName_PrevAndNext(
			long bookId, String bookAuthor,
			OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException {

		bookAuthor = Objects.toString(bookAuthor, "");

		Book book = findByPrimaryKey(bookId);

		Session session = null;

		try {
			session = openSession();

			Book[] array = new BookImpl[3];

			array[0] = getByAuthorName_PrevAndNext(
				session, book, bookAuthor, orderByComparator, true);

			array[1] = book;

			array[2] = getByAuthorName_PrevAndNext(
				session, book, bookAuthor, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Book getByAuthorName_PrevAndNext(
		Session session, Book book, String bookAuthor,
		OrderByComparator<Book> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BOOK_WHERE);

		boolean bindBookAuthor = false;

		if (bookAuthor.isEmpty()) {
			sb.append(_FINDER_COLUMN_AUTHORNAME_BOOKAUTHOR_3);
		}
		else {
			bindBookAuthor = true;

			sb.append(_FINDER_COLUMN_AUTHORNAME_BOOKAUTHOR_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(BookModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindBookAuthor) {
			queryPos.add(bookAuthor);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(book)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Book> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the books where bookAuthor = &#63; from the database.
	 *
	 * @param bookAuthor the book author
	 */
	@Override
	public void removeByAuthorName(String bookAuthor) {
		for (Book book :
				findByAuthorName(
					bookAuthor, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(book);
		}
	}

	/**
	 * Returns the number of books where bookAuthor = &#63;.
	 *
	 * @param bookAuthor the book author
	 * @return the number of matching books
	 */
	@Override
	public int countByAuthorName(String bookAuthor) {
		bookAuthor = Objects.toString(bookAuthor, "");

		FinderPath finderPath = _finderPathCountByAuthorName;

		Object[] finderArgs = new Object[] {bookAuthor};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BOOK_WHERE);

			boolean bindBookAuthor = false;

			if (bookAuthor.isEmpty()) {
				sb.append(_FINDER_COLUMN_AUTHORNAME_BOOKAUTHOR_3);
			}
			else {
				bindBookAuthor = true;

				sb.append(_FINDER_COLUMN_AUTHORNAME_BOOKAUTHOR_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindBookAuthor) {
					queryPos.add(bookAuthor);
				}

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

	private static final String _FINDER_COLUMN_AUTHORNAME_BOOKAUTHOR_2 =
		"book.bookAuthor = ?";

	private static final String _FINDER_COLUMN_AUTHORNAME_BOOKAUTHOR_3 =
		"(book.bookAuthor IS NULL OR book.bookAuthor = '')";

	private FinderPath _finderPathWithPaginationFindByBookName;
	private FinderPath _finderPathWithoutPaginationFindByBookName;
	private FinderPath _finderPathCountByBookName;

	/**
	 * Returns all the books where bookName = &#63;.
	 *
	 * @param bookName the book name
	 * @return the matching books
	 */
	@Override
	public List<Book> findByBookName(String bookName) {
		return findByBookName(
			bookName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the books where bookName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookModelImpl</code>.
	 * </p>
	 *
	 * @param bookName the book name
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @return the range of matching books
	 */
	@Override
	public List<Book> findByBookName(String bookName, int start, int end) {
		return findByBookName(bookName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the books where bookName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookModelImpl</code>.
	 * </p>
	 *
	 * @param bookName the book name
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching books
	 */
	@Override
	public List<Book> findByBookName(
		String bookName, int start, int end,
		OrderByComparator<Book> orderByComparator) {

		return findByBookName(bookName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the books where bookName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookModelImpl</code>.
	 * </p>
	 *
	 * @param bookName the book name
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching books
	 */
	@Override
	public List<Book> findByBookName(
		String bookName, int start, int end,
		OrderByComparator<Book> orderByComparator, boolean useFinderCache) {

		bookName = Objects.toString(bookName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByBookName;
				finderArgs = new Object[] {bookName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByBookName;
			finderArgs = new Object[] {bookName, start, end, orderByComparator};
		}

		List<Book> list = null;

		if (useFinderCache) {
			list = (List<Book>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Book book : list) {
					if (!bookName.equals(book.getBookName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_BOOK_WHERE);

			boolean bindBookName = false;

			if (bookName.isEmpty()) {
				sb.append(_FINDER_COLUMN_BOOKNAME_BOOKNAME_3);
			}
			else {
				bindBookName = true;

				sb.append(_FINDER_COLUMN_BOOKNAME_BOOKNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BookModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindBookName) {
					queryPos.add(bookName);
				}

				list = (List<Book>)QueryUtil.list(
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
	 * Returns the first book in the ordered set where bookName = &#63;.
	 *
	 * @param bookName the book name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	@Override
	public Book findByBookName_First(
			String bookName, OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException {

		Book book = fetchByBookName_First(bookName, orderByComparator);

		if (book != null) {
			return book;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bookName=");
		sb.append(bookName);

		sb.append("}");

		throw new NoSuchBookException(sb.toString());
	}

	/**
	 * Returns the first book in the ordered set where bookName = &#63;.
	 *
	 * @param bookName the book name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book, or <code>null</code> if a matching book could not be found
	 */
	@Override
	public Book fetchByBookName_First(
		String bookName, OrderByComparator<Book> orderByComparator) {

		List<Book> list = findByBookName(bookName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last book in the ordered set where bookName = &#63;.
	 *
	 * @param bookName the book name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	@Override
	public Book findByBookName_Last(
			String bookName, OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException {

		Book book = fetchByBookName_Last(bookName, orderByComparator);

		if (book != null) {
			return book;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("bookName=");
		sb.append(bookName);

		sb.append("}");

		throw new NoSuchBookException(sb.toString());
	}

	/**
	 * Returns the last book in the ordered set where bookName = &#63;.
	 *
	 * @param bookName the book name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book, or <code>null</code> if a matching book could not be found
	 */
	@Override
	public Book fetchByBookName_Last(
		String bookName, OrderByComparator<Book> orderByComparator) {

		int count = countByBookName(bookName);

		if (count == 0) {
			return null;
		}

		List<Book> list = findByBookName(
			bookName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the books before and after the current book in the ordered set where bookName = &#63;.
	 *
	 * @param bookId the primary key of the current book
	 * @param bookName the book name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	@Override
	public Book[] findByBookName_PrevAndNext(
			long bookId, String bookName,
			OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException {

		bookName = Objects.toString(bookName, "");

		Book book = findByPrimaryKey(bookId);

		Session session = null;

		try {
			session = openSession();

			Book[] array = new BookImpl[3];

			array[0] = getByBookName_PrevAndNext(
				session, book, bookName, orderByComparator, true);

			array[1] = book;

			array[2] = getByBookName_PrevAndNext(
				session, book, bookName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Book getByBookName_PrevAndNext(
		Session session, Book book, String bookName,
		OrderByComparator<Book> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BOOK_WHERE);

		boolean bindBookName = false;

		if (bookName.isEmpty()) {
			sb.append(_FINDER_COLUMN_BOOKNAME_BOOKNAME_3);
		}
		else {
			bindBookName = true;

			sb.append(_FINDER_COLUMN_BOOKNAME_BOOKNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(BookModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindBookName) {
			queryPos.add(bookName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(book)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Book> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the books where bookName = &#63; from the database.
	 *
	 * @param bookName the book name
	 */
	@Override
	public void removeByBookName(String bookName) {
		for (Book book :
				findByBookName(
					bookName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(book);
		}
	}

	/**
	 * Returns the number of books where bookName = &#63;.
	 *
	 * @param bookName the book name
	 * @return the number of matching books
	 */
	@Override
	public int countByBookName(String bookName) {
		bookName = Objects.toString(bookName, "");

		FinderPath finderPath = _finderPathCountByBookName;

		Object[] finderArgs = new Object[] {bookName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BOOK_WHERE);

			boolean bindBookName = false;

			if (bookName.isEmpty()) {
				sb.append(_FINDER_COLUMN_BOOKNAME_BOOKNAME_3);
			}
			else {
				bindBookName = true;

				sb.append(_FINDER_COLUMN_BOOKNAME_BOOKNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindBookName) {
					queryPos.add(bookName);
				}

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

	private static final String _FINDER_COLUMN_BOOKNAME_BOOKNAME_2 =
		"book.bookName = ?";

	private static final String _FINDER_COLUMN_BOOKNAME_BOOKNAME_3 =
		"(book.bookName IS NULL OR book.bookName = '')";

	private FinderPath _finderPathWithPaginationFindByReaderName;
	private FinderPath _finderPathWithoutPaginationFindByReaderName;
	private FinderPath _finderPathCountByReaderName;

	/**
	 * Returns all the books where readerName = &#63;.
	 *
	 * @param readerName the reader name
	 * @return the matching books
	 */
	@Override
	public List<Book> findByReaderName(String readerName) {
		return findByReaderName(
			readerName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the books where readerName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookModelImpl</code>.
	 * </p>
	 *
	 * @param readerName the reader name
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @return the range of matching books
	 */
	@Override
	public List<Book> findByReaderName(String readerName, int start, int end) {
		return findByReaderName(readerName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the books where readerName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookModelImpl</code>.
	 * </p>
	 *
	 * @param readerName the reader name
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching books
	 */
	@Override
	public List<Book> findByReaderName(
		String readerName, int start, int end,
		OrderByComparator<Book> orderByComparator) {

		return findByReaderName(
			readerName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the books where readerName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookModelImpl</code>.
	 * </p>
	 *
	 * @param readerName the reader name
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching books
	 */
	@Override
	public List<Book> findByReaderName(
		String readerName, int start, int end,
		OrderByComparator<Book> orderByComparator, boolean useFinderCache) {

		readerName = Objects.toString(readerName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByReaderName;
				finderArgs = new Object[] {readerName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByReaderName;
			finderArgs = new Object[] {
				readerName, start, end, orderByComparator
			};
		}

		List<Book> list = null;

		if (useFinderCache) {
			list = (List<Book>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Book book : list) {
					if (!readerName.equals(book.getReaderName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_BOOK_WHERE);

			boolean bindReaderName = false;

			if (readerName.isEmpty()) {
				sb.append(_FINDER_COLUMN_READERNAME_READERNAME_3);
			}
			else {
				bindReaderName = true;

				sb.append(_FINDER_COLUMN_READERNAME_READERNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BookModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindReaderName) {
					queryPos.add(readerName);
				}

				list = (List<Book>)QueryUtil.list(
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
	 * Returns the first book in the ordered set where readerName = &#63;.
	 *
	 * @param readerName the reader name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	@Override
	public Book findByReaderName_First(
			String readerName, OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException {

		Book book = fetchByReaderName_First(readerName, orderByComparator);

		if (book != null) {
			return book;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("readerName=");
		sb.append(readerName);

		sb.append("}");

		throw new NoSuchBookException(sb.toString());
	}

	/**
	 * Returns the first book in the ordered set where readerName = &#63;.
	 *
	 * @param readerName the reader name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book, or <code>null</code> if a matching book could not be found
	 */
	@Override
	public Book fetchByReaderName_First(
		String readerName, OrderByComparator<Book> orderByComparator) {

		List<Book> list = findByReaderName(readerName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last book in the ordered set where readerName = &#63;.
	 *
	 * @param readerName the reader name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	@Override
	public Book findByReaderName_Last(
			String readerName, OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException {

		Book book = fetchByReaderName_Last(readerName, orderByComparator);

		if (book != null) {
			return book;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("readerName=");
		sb.append(readerName);

		sb.append("}");

		throw new NoSuchBookException(sb.toString());
	}

	/**
	 * Returns the last book in the ordered set where readerName = &#63;.
	 *
	 * @param readerName the reader name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book, or <code>null</code> if a matching book could not be found
	 */
	@Override
	public Book fetchByReaderName_Last(
		String readerName, OrderByComparator<Book> orderByComparator) {

		int count = countByReaderName(readerName);

		if (count == 0) {
			return null;
		}

		List<Book> list = findByReaderName(
			readerName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the books before and after the current book in the ordered set where readerName = &#63;.
	 *
	 * @param bookId the primary key of the current book
	 * @param readerName the reader name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	@Override
	public Book[] findByReaderName_PrevAndNext(
			long bookId, String readerName,
			OrderByComparator<Book> orderByComparator)
		throws NoSuchBookException {

		readerName = Objects.toString(readerName, "");

		Book book = findByPrimaryKey(bookId);

		Session session = null;

		try {
			session = openSession();

			Book[] array = new BookImpl[3];

			array[0] = getByReaderName_PrevAndNext(
				session, book, readerName, orderByComparator, true);

			array[1] = book;

			array[2] = getByReaderName_PrevAndNext(
				session, book, readerName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Book getByReaderName_PrevAndNext(
		Session session, Book book, String readerName,
		OrderByComparator<Book> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BOOK_WHERE);

		boolean bindReaderName = false;

		if (readerName.isEmpty()) {
			sb.append(_FINDER_COLUMN_READERNAME_READERNAME_3);
		}
		else {
			bindReaderName = true;

			sb.append(_FINDER_COLUMN_READERNAME_READERNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(BookModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindReaderName) {
			queryPos.add(readerName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(book)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Book> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the books where readerName = &#63; from the database.
	 *
	 * @param readerName the reader name
	 */
	@Override
	public void removeByReaderName(String readerName) {
		for (Book book :
				findByReaderName(
					readerName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(book);
		}
	}

	/**
	 * Returns the number of books where readerName = &#63;.
	 *
	 * @param readerName the reader name
	 * @return the number of matching books
	 */
	@Override
	public int countByReaderName(String readerName) {
		readerName = Objects.toString(readerName, "");

		FinderPath finderPath = _finderPathCountByReaderName;

		Object[] finderArgs = new Object[] {readerName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BOOK_WHERE);

			boolean bindReaderName = false;

			if (readerName.isEmpty()) {
				sb.append(_FINDER_COLUMN_READERNAME_READERNAME_3);
			}
			else {
				bindReaderName = true;

				sb.append(_FINDER_COLUMN_READERNAME_READERNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindReaderName) {
					queryPos.add(readerName);
				}

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

	private static final String _FINDER_COLUMN_READERNAME_READERNAME_2 =
		"book.readerName = ?";

	private static final String _FINDER_COLUMN_READERNAME_READERNAME_3 =
		"(book.readerName IS NULL OR book.readerName = '')";

	public BookPersistenceImpl() {
		setModelClass(Book.class);

		setModelImplClass(BookImpl.class);
		setModelPKClass(long.class);

		setTable(BookTable.INSTANCE);
	}

	/**
	 * Caches the book in the entity cache if it is enabled.
	 *
	 * @param book the book
	 */
	@Override
	public void cacheResult(Book book) {
		entityCache.putResult(BookImpl.class, book.getPrimaryKey(), book);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the books in the entity cache if it is enabled.
	 *
	 * @param books the books
	 */
	@Override
	public void cacheResult(List<Book> books) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (books.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Book book : books) {
			if (entityCache.getResult(BookImpl.class, book.getPrimaryKey()) ==
					null) {

				cacheResult(book);
			}
		}
	}

	/**
	 * Clears the cache for all books.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BookImpl.class);

		finderCache.clearCache(BookImpl.class);
	}

	/**
	 * Clears the cache for the book.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Book book) {
		entityCache.removeResult(BookImpl.class, book);
	}

	@Override
	public void clearCache(List<Book> books) {
		for (Book book : books) {
			entityCache.removeResult(BookImpl.class, book);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BookImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BookImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new book with the primary key. Does not add the book to the database.
	 *
	 * @param bookId the primary key for the new book
	 * @return the new book
	 */
	@Override
	public Book create(long bookId) {
		Book book = new BookImpl();

		book.setNew(true);
		book.setPrimaryKey(bookId);

		book.setCompanyId(CompanyThreadLocal.getCompanyId());

		return book;
	}

	/**
	 * Removes the book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookId the primary key of the book
	 * @return the book that was removed
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	@Override
	public Book remove(long bookId) throws NoSuchBookException {
		return remove((Serializable)bookId);
	}

	/**
	 * Removes the book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the book
	 * @return the book that was removed
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	@Override
	public Book remove(Serializable primaryKey) throws NoSuchBookException {
		Session session = null;

		try {
			session = openSession();

			Book book = (Book)session.get(BookImpl.class, primaryKey);

			if (book == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBookException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(book);
		}
		catch (NoSuchBookException noSuchEntityException) {
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
	protected Book removeImpl(Book book) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(book)) {
				book = (Book)session.get(
					BookImpl.class, book.getPrimaryKeyObj());
			}

			if (book != null) {
				session.delete(book);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (book != null) {
			clearCache(book);
		}

		return book;
	}

	@Override
	public Book updateImpl(Book book) {
		boolean isNew = book.isNew();

		if (!(book instanceof BookModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(book.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(book);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in book proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Book implementation " +
					book.getClass());
		}

		BookModelImpl bookModelImpl = (BookModelImpl)book;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (book.getCreateDate() == null)) {
			if (serviceContext == null) {
				book.setCreateDate(date);
			}
			else {
				book.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!bookModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				book.setModifiedDate(date);
			}
			else {
				book.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(book);
			}
			else {
				book = (Book)session.merge(book);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(BookImpl.class, bookModelImpl, false, true);

		if (isNew) {
			book.setNew(false);
		}

		book.resetOriginalValues();

		return book;
	}

	/**
	 * Returns the book with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the book
	 * @return the book
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	@Override
	public Book findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBookException {

		Book book = fetchByPrimaryKey(primaryKey);

		if (book == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBookException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return book;
	}

	/**
	 * Returns the book with the primary key or throws a <code>NoSuchBookException</code> if it could not be found.
	 *
	 * @param bookId the primary key of the book
	 * @return the book
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	@Override
	public Book findByPrimaryKey(long bookId) throws NoSuchBookException {
		return findByPrimaryKey((Serializable)bookId);
	}

	/**
	 * Returns the book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookId the primary key of the book
	 * @return the book, or <code>null</code> if a book with the primary key could not be found
	 */
	@Override
	public Book fetchByPrimaryKey(long bookId) {
		return fetchByPrimaryKey((Serializable)bookId);
	}

	/**
	 * Returns all the books.
	 *
	 * @return the books
	 */
	@Override
	public List<Book> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @return the range of books
	 */
	@Override
	public List<Book> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of books
	 */
	@Override
	public List<Book> findAll(
		int start, int end, OrderByComparator<Book> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of books
	 */
	@Override
	public List<Book> findAll(
		int start, int end, OrderByComparator<Book> orderByComparator,
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

		List<Book> list = null;

		if (useFinderCache) {
			list = (List<Book>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BOOK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BOOK;

				sql = sql.concat(BookModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Book>)QueryUtil.list(
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
	 * Removes all the books from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Book book : findAll()) {
			remove(book);
		}
	}

	/**
	 * Returns the number of books.
	 *
	 * @return the number of books
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BOOK);

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
		return "bookId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BOOK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BookModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the book persistence.
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

		_finderPathWithPaginationFindByAuthorName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAuthorName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"bookAuthor"}, true);

		_finderPathWithoutPaginationFindByAuthorName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAuthorName",
			new String[] {String.class.getName()}, new String[] {"bookAuthor"},
			true);

		_finderPathCountByAuthorName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAuthorName",
			new String[] {String.class.getName()}, new String[] {"bookAuthor"},
			false);

		_finderPathWithPaginationFindByBookName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBookName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"bookName"}, true);

		_finderPathWithoutPaginationFindByBookName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBookName",
			new String[] {String.class.getName()}, new String[] {"bookName"},
			true);

		_finderPathCountByBookName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBookName",
			new String[] {String.class.getName()}, new String[] {"bookName"},
			false);

		_finderPathWithPaginationFindByReaderName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByReaderName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"readerName"}, true);

		_finderPathWithoutPaginationFindByReaderName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByReaderName",
			new String[] {String.class.getName()}, new String[] {"readerName"},
			true);

		_finderPathCountByReaderName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByReaderName",
			new String[] {String.class.getName()}, new String[] {"readerName"},
			false);

		_setBookUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setBookUtilPersistence(null);

		entityCache.removeCache(BookImpl.class.getName());
	}

	private void _setBookUtilPersistence(BookPersistence bookPersistence) {
		try {
			Field field = BookUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, bookPersistence);
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

	private static final String _SQL_SELECT_BOOK = "SELECT book FROM Book book";

	private static final String _SQL_SELECT_BOOK_WHERE =
		"SELECT book FROM Book book WHERE ";

	private static final String _SQL_COUNT_BOOK =
		"SELECT COUNT(book) FROM Book book";

	private static final String _SQL_COUNT_BOOK_WHERE =
		"SELECT COUNT(book) FROM Book book WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "book.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Book exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Book exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BookPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}