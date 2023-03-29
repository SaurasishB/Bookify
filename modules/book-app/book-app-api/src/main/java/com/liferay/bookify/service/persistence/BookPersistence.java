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

import com.liferay.bookify.exception.NoSuchBookException;
import com.liferay.bookify.model.Book;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the book service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookUtil
 * @generated
 */
@ProviderType
public interface BookPersistence extends BasePersistence<Book> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BookUtil} to access the book persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the books where bookAuthor = &#63;.
	 *
	 * @param bookAuthor the book author
	 * @return the matching books
	 */
	public java.util.List<Book> findByAuthorName(String bookAuthor);

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
	public java.util.List<Book> findByAuthorName(
		String bookAuthor, int start, int end);

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
	public java.util.List<Book> findByAuthorName(
		String bookAuthor, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator);

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
	public java.util.List<Book> findByAuthorName(
		String bookAuthor, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first book in the ordered set where bookAuthor = &#63;.
	 *
	 * @param bookAuthor the book author
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	public Book findByAuthorName_First(
			String bookAuthor,
			com.liferay.portal.kernel.util.OrderByComparator<Book>
				orderByComparator)
		throws NoSuchBookException;

	/**
	 * Returns the first book in the ordered set where bookAuthor = &#63;.
	 *
	 * @param bookAuthor the book author
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book, or <code>null</code> if a matching book could not be found
	 */
	public Book fetchByAuthorName_First(
		String bookAuthor,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator);

	/**
	 * Returns the last book in the ordered set where bookAuthor = &#63;.
	 *
	 * @param bookAuthor the book author
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	public Book findByAuthorName_Last(
			String bookAuthor,
			com.liferay.portal.kernel.util.OrderByComparator<Book>
				orderByComparator)
		throws NoSuchBookException;

	/**
	 * Returns the last book in the ordered set where bookAuthor = &#63;.
	 *
	 * @param bookAuthor the book author
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book, or <code>null</code> if a matching book could not be found
	 */
	public Book fetchByAuthorName_Last(
		String bookAuthor,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator);

	/**
	 * Returns the books before and after the current book in the ordered set where bookAuthor = &#63;.
	 *
	 * @param bookId the primary key of the current book
	 * @param bookAuthor the book author
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	public Book[] findByAuthorName_PrevAndNext(
			long bookId, String bookAuthor,
			com.liferay.portal.kernel.util.OrderByComparator<Book>
				orderByComparator)
		throws NoSuchBookException;

	/**
	 * Removes all the books where bookAuthor = &#63; from the database.
	 *
	 * @param bookAuthor the book author
	 */
	public void removeByAuthorName(String bookAuthor);

	/**
	 * Returns the number of books where bookAuthor = &#63;.
	 *
	 * @param bookAuthor the book author
	 * @return the number of matching books
	 */
	public int countByAuthorName(String bookAuthor);

	/**
	 * Returns all the books where bookName = &#63;.
	 *
	 * @param bookName the book name
	 * @return the matching books
	 */
	public java.util.List<Book> findByBookName(String bookName);

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
	public java.util.List<Book> findByBookName(
		String bookName, int start, int end);

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
	public java.util.List<Book> findByBookName(
		String bookName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator);

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
	public java.util.List<Book> findByBookName(
		String bookName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first book in the ordered set where bookName = &#63;.
	 *
	 * @param bookName the book name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	public Book findByBookName_First(
			String bookName,
			com.liferay.portal.kernel.util.OrderByComparator<Book>
				orderByComparator)
		throws NoSuchBookException;

	/**
	 * Returns the first book in the ordered set where bookName = &#63;.
	 *
	 * @param bookName the book name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book, or <code>null</code> if a matching book could not be found
	 */
	public Book fetchByBookName_First(
		String bookName,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator);

	/**
	 * Returns the last book in the ordered set where bookName = &#63;.
	 *
	 * @param bookName the book name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	public Book findByBookName_Last(
			String bookName,
			com.liferay.portal.kernel.util.OrderByComparator<Book>
				orderByComparator)
		throws NoSuchBookException;

	/**
	 * Returns the last book in the ordered set where bookName = &#63;.
	 *
	 * @param bookName the book name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book, or <code>null</code> if a matching book could not be found
	 */
	public Book fetchByBookName_Last(
		String bookName,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator);

	/**
	 * Returns the books before and after the current book in the ordered set where bookName = &#63;.
	 *
	 * @param bookId the primary key of the current book
	 * @param bookName the book name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	public Book[] findByBookName_PrevAndNext(
			long bookId, String bookName,
			com.liferay.portal.kernel.util.OrderByComparator<Book>
				orderByComparator)
		throws NoSuchBookException;

	/**
	 * Removes all the books where bookName = &#63; from the database.
	 *
	 * @param bookName the book name
	 */
	public void removeByBookName(String bookName);

	/**
	 * Returns the number of books where bookName = &#63;.
	 *
	 * @param bookName the book name
	 * @return the number of matching books
	 */
	public int countByBookName(String bookName);

	/**
	 * Returns all the books where readerName = &#63;.
	 *
	 * @param readerName the reader name
	 * @return the matching books
	 */
	public java.util.List<Book> findByReaderName(String readerName);

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
	public java.util.List<Book> findByReaderName(
		String readerName, int start, int end);

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
	public java.util.List<Book> findByReaderName(
		String readerName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator);

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
	public java.util.List<Book> findByReaderName(
		String readerName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first book in the ordered set where readerName = &#63;.
	 *
	 * @param readerName the reader name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	public Book findByReaderName_First(
			String readerName,
			com.liferay.portal.kernel.util.OrderByComparator<Book>
				orderByComparator)
		throws NoSuchBookException;

	/**
	 * Returns the first book in the ordered set where readerName = &#63;.
	 *
	 * @param readerName the reader name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book, or <code>null</code> if a matching book could not be found
	 */
	public Book fetchByReaderName_First(
		String readerName,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator);

	/**
	 * Returns the last book in the ordered set where readerName = &#63;.
	 *
	 * @param readerName the reader name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book
	 * @throws NoSuchBookException if a matching book could not be found
	 */
	public Book findByReaderName_Last(
			String readerName,
			com.liferay.portal.kernel.util.OrderByComparator<Book>
				orderByComparator)
		throws NoSuchBookException;

	/**
	 * Returns the last book in the ordered set where readerName = &#63;.
	 *
	 * @param readerName the reader name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book, or <code>null</code> if a matching book could not be found
	 */
	public Book fetchByReaderName_Last(
		String readerName,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator);

	/**
	 * Returns the books before and after the current book in the ordered set where readerName = &#63;.
	 *
	 * @param bookId the primary key of the current book
	 * @param readerName the reader name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	public Book[] findByReaderName_PrevAndNext(
			long bookId, String readerName,
			com.liferay.portal.kernel.util.OrderByComparator<Book>
				orderByComparator)
		throws NoSuchBookException;

	/**
	 * Removes all the books where readerName = &#63; from the database.
	 *
	 * @param readerName the reader name
	 */
	public void removeByReaderName(String readerName);

	/**
	 * Returns the number of books where readerName = &#63;.
	 *
	 * @param readerName the reader name
	 * @return the number of matching books
	 */
	public int countByReaderName(String readerName);

	/**
	 * Caches the book in the entity cache if it is enabled.
	 *
	 * @param book the book
	 */
	public void cacheResult(Book book);

	/**
	 * Caches the books in the entity cache if it is enabled.
	 *
	 * @param books the books
	 */
	public void cacheResult(java.util.List<Book> books);

	/**
	 * Creates a new book with the primary key. Does not add the book to the database.
	 *
	 * @param bookId the primary key for the new book
	 * @return the new book
	 */
	public Book create(long bookId);

	/**
	 * Removes the book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookId the primary key of the book
	 * @return the book that was removed
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	public Book remove(long bookId) throws NoSuchBookException;

	public Book updateImpl(Book book);

	/**
	 * Returns the book with the primary key or throws a <code>NoSuchBookException</code> if it could not be found.
	 *
	 * @param bookId the primary key of the book
	 * @return the book
	 * @throws NoSuchBookException if a book with the primary key could not be found
	 */
	public Book findByPrimaryKey(long bookId) throws NoSuchBookException;

	/**
	 * Returns the book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookId the primary key of the book
	 * @return the book, or <code>null</code> if a book with the primary key could not be found
	 */
	public Book fetchByPrimaryKey(long bookId);

	/**
	 * Returns all the books.
	 *
	 * @return the books
	 */
	public java.util.List<Book> findAll();

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
	public java.util.List<Book> findAll(int start, int end);

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
	public java.util.List<Book> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator);

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
	public java.util.List<Book> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Book>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the books from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of books.
	 *
	 * @return the number of books
	 */
	public int countAll();

}