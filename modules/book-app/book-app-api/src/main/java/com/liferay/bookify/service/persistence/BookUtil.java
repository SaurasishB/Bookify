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

import com.liferay.bookify.model.Book;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the book service. This utility wraps <code>com.liferay.bookify.service.persistence.impl.BookPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookPersistence
 * @generated
 */
public class BookUtil {

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
	public static void clearCache(Book book) {
		getPersistence().clearCache(book);
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
	public static Map<Serializable, Book> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Book> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Book> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Book> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Book> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Book update(Book book) {
		return getPersistence().update(book);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Book update(Book book, ServiceContext serviceContext) {
		return getPersistence().update(book, serviceContext);
	}

	/**
	 * Returns all the books where bookAuthor = &#63;.
	 *
	 * @param bookAuthor the book author
	 * @return the matching books
	 */
	public static List<Book> findByAuthorName(String bookAuthor) {
		return getPersistence().findByAuthorName(bookAuthor);
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
	public static List<Book> findByAuthorName(
		String bookAuthor, int start, int end) {

		return getPersistence().findByAuthorName(bookAuthor, start, end);
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
	public static List<Book> findByAuthorName(
		String bookAuthor, int start, int end,
		OrderByComparator<Book> orderByComparator) {

		return getPersistence().findByAuthorName(
			bookAuthor, start, end, orderByComparator);
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
	public static List<Book> findByAuthorName(
		String bookAuthor, int start, int end,
		OrderByComparator<Book> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByAuthorName(
			bookAuthor, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first book in the ordered set where bookAuthor = &#63;.
	 *
	 * @param bookAuthor the book author
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	public static Book findByAuthorName_First(
			String bookAuthor, OrderByComparator<Book> orderByComparator)
		throws com.liferay.bookify.exception.NoSuchBookException {

		return getPersistence().findByAuthorName_First(
			bookAuthor, orderByComparator);
	}

	/**
	 * Returns the first book in the ordered set where bookAuthor = &#63;.
	 *
	 * @param bookAuthor the book author
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book, or <code>null</code> if a matching book could not be found
	 */
	public static Book fetchByAuthorName_First(
		String bookAuthor, OrderByComparator<Book> orderByComparator) {

		return getPersistence().fetchByAuthorName_First(
			bookAuthor, orderByComparator);
	}

	/**
	 * Returns the last book in the ordered set where bookAuthor = &#63;.
	 *
	 * @param bookAuthor the book author
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	public static Book findByAuthorName_Last(
			String bookAuthor, OrderByComparator<Book> orderByComparator)
		throws com.liferay.bookify.exception.NoSuchBookException {

		return getPersistence().findByAuthorName_Last(
			bookAuthor, orderByComparator);
	}

	/**
	 * Returns the last book in the ordered set where bookAuthor = &#63;.
	 *
	 * @param bookAuthor the book author
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book, or <code>null</code> if a matching book could not be found
	 */
	public static Book fetchByAuthorName_Last(
		String bookAuthor, OrderByComparator<Book> orderByComparator) {

		return getPersistence().fetchByAuthorName_Last(
			bookAuthor, orderByComparator);
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
	public static Book[] findByAuthorName_PrevAndNext(
			long bookId, String bookAuthor,
			OrderByComparator<Book> orderByComparator)
		throws com.liferay.bookify.exception.NoSuchBookException {

		return getPersistence().findByAuthorName_PrevAndNext(
			bookId, bookAuthor, orderByComparator);
	}

	/**
	 * Removes all the books where bookAuthor = &#63; from the database.
	 *
	 * @param bookAuthor the book author
	 */
	public static void removeByAuthorName(String bookAuthor) {
		getPersistence().removeByAuthorName(bookAuthor);
	}

	/**
	 * Returns the number of books where bookAuthor = &#63;.
	 *
	 * @param bookAuthor the book author
	 * @return the number of matching books
	 */
	public static int countByAuthorName(String bookAuthor) {
		return getPersistence().countByAuthorName(bookAuthor);
	}

	/**
	 * Returns all the books where bookName = &#63;.
	 *
	 * @param bookName the book name
	 * @return the matching books
	 */
	public static List<Book> findByBookName(String bookName) {
		return getPersistence().findByBookName(bookName);
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
	public static List<Book> findByBookName(
		String bookName, int start, int end) {

		return getPersistence().findByBookName(bookName, start, end);
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
	public static List<Book> findByBookName(
		String bookName, int start, int end,
		OrderByComparator<Book> orderByComparator) {

		return getPersistence().findByBookName(
			bookName, start, end, orderByComparator);
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
	public static List<Book> findByBookName(
		String bookName, int start, int end,
		OrderByComparator<Book> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByBookName(
			bookName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first book in the ordered set where bookName = &#63;.
	 *
	 * @param bookName the book name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	public static Book findByBookName_First(
			String bookName, OrderByComparator<Book> orderByComparator)
		throws com.liferay.bookify.exception.NoSuchBookException {

		return getPersistence().findByBookName_First(
			bookName, orderByComparator);
	}

	/**
	 * Returns the first book in the ordered set where bookName = &#63;.
	 *
	 * @param bookName the book name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book, or <code>null</code> if a matching book could not be found
	 */
	public static Book fetchByBookName_First(
		String bookName, OrderByComparator<Book> orderByComparator) {

		return getPersistence().fetchByBookName_First(
			bookName, orderByComparator);
	}

	/**
	 * Returns the last book in the ordered set where bookName = &#63;.
	 *
	 * @param bookName the book name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	public static Book findByBookName_Last(
			String bookName, OrderByComparator<Book> orderByComparator)
		throws com.liferay.bookify.exception.NoSuchBookException {

		return getPersistence().findByBookName_Last(
			bookName, orderByComparator);
	}

	/**
	 * Returns the last book in the ordered set where bookName = &#63;.
	 *
	 * @param bookName the book name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book, or <code>null</code> if a matching book could not be found
	 */
	public static Book fetchByBookName_Last(
		String bookName, OrderByComparator<Book> orderByComparator) {

		return getPersistence().fetchByBookName_Last(
			bookName, orderByComparator);
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
	public static Book[] findByBookName_PrevAndNext(
			long bookId, String bookName,
			OrderByComparator<Book> orderByComparator)
		throws com.liferay.bookify.exception.NoSuchBookException {

		return getPersistence().findByBookName_PrevAndNext(
			bookId, bookName, orderByComparator);
	}

	/**
	 * Removes all the books where bookName = &#63; from the database.
	 *
	 * @param bookName the book name
	 */
	public static void removeByBookName(String bookName) {
		getPersistence().removeByBookName(bookName);
	}

	/**
	 * Returns the number of books where bookName = &#63;.
	 *
	 * @param bookName the book name
	 * @return the number of matching books
	 */
	public static int countByBookName(String bookName) {
		return getPersistence().countByBookName(bookName);
	}

	/**
	 * Returns all the books where readerName = &#63;.
	 *
	 * @param readerName the reader name
	 * @return the matching books
	 */
	public static List<Book> findByReaderName(String readerName) {
		return getPersistence().findByReaderName(readerName);
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
	public static List<Book> findByReaderName(
		String readerName, int start, int end) {

		return getPersistence().findByReaderName(readerName, start, end);
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
	public static List<Book> findByReaderName(
		String readerName, int start, int end,
		OrderByComparator<Book> orderByComparator) {

		return getPersistence().findByReaderName(
			readerName, start, end, orderByComparator);
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
	public static List<Book> findByReaderName(
		String readerName, int start, int end,
		OrderByComparator<Book> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByReaderName(
			readerName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first book in the ordered set where readerName = &#63;.
	 *
	 * @param readerName the reader name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	public static Book findByReaderName_First(
			String readerName, OrderByComparator<Book> orderByComparator)
		throws com.liferay.bookify.exception.NoSuchBookException {

		return getPersistence().findByReaderName_First(
			readerName, orderByComparator);
	}

	/**
	 * Returns the first book in the ordered set where readerName = &#63;.
	 *
	 * @param readerName the reader name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book, or <code>null</code> if a matching book could not be found
	 */
	public static Book fetchByReaderName_First(
		String readerName, OrderByComparator<Book> orderByComparator) {

		return getPersistence().fetchByReaderName_First(
			readerName, orderByComparator);
	}

	/**
	 * Returns the last book in the ordered set where readerName = &#63;.
	 *
	 * @param readerName the reader name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	public static Book findByReaderName_Last(
			String readerName, OrderByComparator<Book> orderByComparator)
		throws com.liferay.bookify.exception.NoSuchBookException {

		return getPersistence().findByReaderName_Last(
			readerName, orderByComparator);
	}

	/**
	 * Returns the last book in the ordered set where readerName = &#63;.
	 *
	 * @param readerName the reader name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book, or <code>null</code> if a matching book could not be found
	 */
	public static Book fetchByReaderName_Last(
		String readerName, OrderByComparator<Book> orderByComparator) {

		return getPersistence().fetchByReaderName_Last(
			readerName, orderByComparator);
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
	public static Book[] findByReaderName_PrevAndNext(
			long bookId, String readerName,
			OrderByComparator<Book> orderByComparator)
		throws com.liferay.bookify.exception.NoSuchBookException {

		return getPersistence().findByReaderName_PrevAndNext(
			bookId, readerName, orderByComparator);
	}

	/**
	 * Removes all the books where readerName = &#63; from the database.
	 *
	 * @param readerName the reader name
	 */
	public static void removeByReaderName(String readerName) {
		getPersistence().removeByReaderName(readerName);
	}

	/**
	 * Returns the number of books where readerName = &#63;.
	 *
	 * @param readerName the reader name
	 * @return the number of matching books
	 */
	public static int countByReaderName(String readerName) {
		return getPersistence().countByReaderName(readerName);
	}

	/**
	 * Caches the book in the entity cache if it is enabled.
	 *
	 * @param book the book
	 */
	public static void cacheResult(Book book) {
		getPersistence().cacheResult(book);
	}

	/**
	 * Caches the books in the entity cache if it is enabled.
	 *
	 * @param books the books
	 */
	public static void cacheResult(List<Book> books) {
		getPersistence().cacheResult(books);
	}

	/**
	 * Creates a new book with the primary key. Does not add the book to the database.
	 *
	 * @param bookId the primary key for the new book
	 * @return the new book
	 */
	public static Book create(long bookId) {
		return getPersistence().create(bookId);
	}

	/**
	 * Removes the book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookId the primary key of the book
	 * @return the book that was removed
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	public static Book remove(long bookId)
		throws com.liferay.bookify.exception.NoSuchBookException {

		return getPersistence().remove(bookId);
	}

	public static Book updateImpl(Book book) {
		return getPersistence().updateImpl(book);
	}

	/**
	 * Returns the book with the primary key or throws a <code>NoSuchBookException</code> if it could not be found.
	 *
	 * @param bookId the primary key of the book
	 * @return the book
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	public static Book findByPrimaryKey(long bookId)
		throws com.liferay.bookify.exception.NoSuchBookException {

		return getPersistence().findByPrimaryKey(bookId);
	}

	/**
	 * Returns the book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookId the primary key of the book
	 * @return the book, or <code>null</code> if a book with the primary key could not be found
	 */
	public static Book fetchByPrimaryKey(long bookId) {
		return getPersistence().fetchByPrimaryKey(bookId);
	}

	/**
	 * Returns all the books.
	 *
	 * @return the books
	 */
	public static List<Book> findAll() {
		return getPersistence().findAll();
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
	public static List<Book> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Book> findAll(
		int start, int end, OrderByComparator<Book> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Book> findAll(
		int start, int end, OrderByComparator<Book> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the books from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of books.
	 *
	 * @return the number of books
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BookPersistence getPersistence() {
		return _persistence;
	}

	private static volatile BookPersistence _persistence;

}