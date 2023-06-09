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

package com.liferay.bookify.model.impl;

import com.liferay.bookify.model.Book;
import com.liferay.bookify.model.BookModel;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Book service. Represents a row in the &quot;Bookify_Book&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>BookModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BookImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookImpl
 * @generated
 */
@JSON(strict = true)
public class BookModelImpl extends BaseModelImpl<Book> implements BookModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a book model instance should use the <code>Book</code> interface instead.
	 */
	public static final String TABLE_NAME = "Bookify_Book";

	public static final Object[][] TABLE_COLUMNS = {
		{"bookId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"readerName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"bookName", Types.VARCHAR}, {"bookAuthor", Types.VARCHAR},
		{"bookPublicationDate", Types.TIMESTAMP}, {"readerId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("bookId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("readerName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("bookName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("bookAuthor", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("bookPublicationDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("readerId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Bookify_Book (bookId LONG not null primary key,groupId LONG,companyId LONG,readerName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,bookName VARCHAR(75) null,bookAuthor VARCHAR(75) null,bookPublicationDate DATE null,readerId LONG)";

	public static final String TABLE_SQL_DROP = "drop table Bookify_Book";

	public static final String ORDER_BY_JPQL = " ORDER BY book.bookName ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Bookify_Book.bookName ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long BOOKAUTHOR_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long BOOKNAME_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long READERNAME_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public BookModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _bookId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBookId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bookId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Book.class;
	}

	@Override
	public String getModelClassName() {
		return Book.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Book, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Book, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Book, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Book)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Book, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Book, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Book)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Book, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Book, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Book, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Book, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Book, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Book, Object>>();
		Map<String, BiConsumer<Book, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Book, ?>>();

		attributeGetterFunctions.put("bookId", Book::getBookId);
		attributeSetterBiConsumers.put(
			"bookId", (BiConsumer<Book, Long>)Book::setBookId);
		attributeGetterFunctions.put("groupId", Book::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Book, Long>)Book::setGroupId);
		attributeGetterFunctions.put("companyId", Book::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Book, Long>)Book::setCompanyId);
		attributeGetterFunctions.put("readerName", Book::getReaderName);
		attributeSetterBiConsumers.put(
			"readerName", (BiConsumer<Book, String>)Book::setReaderName);
		attributeGetterFunctions.put("createDate", Book::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Book, Date>)Book::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Book::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate", (BiConsumer<Book, Date>)Book::setModifiedDate);
		attributeGetterFunctions.put("bookName", Book::getBookName);
		attributeSetterBiConsumers.put(
			"bookName", (BiConsumer<Book, String>)Book::setBookName);
		attributeGetterFunctions.put("bookAuthor", Book::getBookAuthor);
		attributeSetterBiConsumers.put(
			"bookAuthor", (BiConsumer<Book, String>)Book::setBookAuthor);
		attributeGetterFunctions.put(
			"bookPublicationDate", Book::getBookPublicationDate);
		attributeSetterBiConsumers.put(
			"bookPublicationDate",
			(BiConsumer<Book, Date>)Book::setBookPublicationDate);
		attributeGetterFunctions.put("readerId", Book::getReaderId);
		attributeSetterBiConsumers.put(
			"readerId", (BiConsumer<Book, Long>)Book::setReaderId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getBookId() {
		return _bookId;
	}

	@Override
	public void setBookId(long bookId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_bookId = bookId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	@JSON
	@Override
	public String getReaderName() {
		if (_readerName == null) {
			return "";
		}
		else {
			return _readerName;
		}
	}

	@Override
	public void setReaderName(String readerName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_readerName = readerName;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalReaderName() {
		return getColumnOriginalValue("readerName");
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getBookName() {
		if (_bookName == null) {
			return "";
		}
		else {
			return _bookName;
		}
	}

	@Override
	public void setBookName(String bookName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_bookName = bookName;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalBookName() {
		return getColumnOriginalValue("bookName");
	}

	@JSON
	@Override
	public String getBookAuthor() {
		if (_bookAuthor == null) {
			return "";
		}
		else {
			return _bookAuthor;
		}
	}

	@Override
	public void setBookAuthor(String bookAuthor) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_bookAuthor = bookAuthor;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalBookAuthor() {
		return getColumnOriginalValue("bookAuthor");
	}

	@JSON
	@Override
	public Date getBookPublicationDate() {
		return _bookPublicationDate;
	}

	@Override
	public void setBookPublicationDate(Date bookPublicationDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_bookPublicationDate = bookPublicationDate;
	}

	@JSON
	@Override
	public long getReaderId() {
		return _readerId;
	}

	@Override
	public void setReaderId(long readerId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_readerId = readerId;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Book.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Book toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Book>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BookImpl bookImpl = new BookImpl();

		bookImpl.setBookId(getBookId());
		bookImpl.setGroupId(getGroupId());
		bookImpl.setCompanyId(getCompanyId());
		bookImpl.setReaderName(getReaderName());
		bookImpl.setCreateDate(getCreateDate());
		bookImpl.setModifiedDate(getModifiedDate());
		bookImpl.setBookName(getBookName());
		bookImpl.setBookAuthor(getBookAuthor());
		bookImpl.setBookPublicationDate(getBookPublicationDate());
		bookImpl.setReaderId(getReaderId());

		bookImpl.resetOriginalValues();

		return bookImpl;
	}

	@Override
	public Book cloneWithOriginalValues() {
		BookImpl bookImpl = new BookImpl();

		bookImpl.setBookId(this.<Long>getColumnOriginalValue("bookId"));
		bookImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		bookImpl.setCompanyId(this.<Long>getColumnOriginalValue("companyId"));
		bookImpl.setReaderName(
			this.<String>getColumnOriginalValue("readerName"));
		bookImpl.setCreateDate(this.<Date>getColumnOriginalValue("createDate"));
		bookImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		bookImpl.setBookName(this.<String>getColumnOriginalValue("bookName"));
		bookImpl.setBookAuthor(
			this.<String>getColumnOriginalValue("bookAuthor"));
		bookImpl.setBookPublicationDate(
			this.<Date>getColumnOriginalValue("bookPublicationDate"));
		bookImpl.setReaderId(this.<Long>getColumnOriginalValue("readerId"));

		return bookImpl;
	}

	@Override
	public int compareTo(Book book) {
		int value = 0;

		value = getBookName().compareTo(book.getBookName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Book)) {
			return false;
		}

		Book book = (Book)object;

		long primaryKey = book.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Book> toCacheModel() {
		BookCacheModel bookCacheModel = new BookCacheModel();

		bookCacheModel.bookId = getBookId();

		bookCacheModel.groupId = getGroupId();

		bookCacheModel.companyId = getCompanyId();

		bookCacheModel.readerName = getReaderName();

		String readerName = bookCacheModel.readerName;

		if ((readerName != null) && (readerName.length() == 0)) {
			bookCacheModel.readerName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			bookCacheModel.createDate = createDate.getTime();
		}
		else {
			bookCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			bookCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			bookCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		bookCacheModel.bookName = getBookName();

		String bookName = bookCacheModel.bookName;

		if ((bookName != null) && (bookName.length() == 0)) {
			bookCacheModel.bookName = null;
		}

		bookCacheModel.bookAuthor = getBookAuthor();

		String bookAuthor = bookCacheModel.bookAuthor;

		if ((bookAuthor != null) && (bookAuthor.length() == 0)) {
			bookCacheModel.bookAuthor = null;
		}

		Date bookPublicationDate = getBookPublicationDate();

		if (bookPublicationDate != null) {
			bookCacheModel.bookPublicationDate = bookPublicationDate.getTime();
		}
		else {
			bookCacheModel.bookPublicationDate = Long.MIN_VALUE;
		}

		bookCacheModel.readerId = getReaderId();

		return bookCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Book, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Book, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Book, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Book)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Book>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Book.class, ModelWrapper.class);

	}

	private long _bookId;
	private long _groupId;
	private long _companyId;
	private String _readerName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _bookName;
	private String _bookAuthor;
	private Date _bookPublicationDate;
	private long _readerId;

	public <T> T getColumnValue(String columnName) {
		Function<Book, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Book)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("bookId", _bookId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("readerName", _readerName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("bookName", _bookName);
		_columnOriginalValues.put("bookAuthor", _bookAuthor);
		_columnOriginalValues.put("bookPublicationDate", _bookPublicationDate);
		_columnOriginalValues.put("readerId", _readerId);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("bookId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("readerName", 8L);

		columnBitmasks.put("createDate", 16L);

		columnBitmasks.put("modifiedDate", 32L);

		columnBitmasks.put("bookName", 64L);

		columnBitmasks.put("bookAuthor", 128L);

		columnBitmasks.put("bookPublicationDate", 256L);

		columnBitmasks.put("readerId", 512L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Book _escapedModel;

}