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

package com.liferay.bookify.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Bookify_Reader&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Reader
 * @generated
 */
public class ReaderTable extends BaseTable<ReaderTable> {

	public static final ReaderTable INSTANCE = new ReaderTable();

	public final Column<ReaderTable, Long> readerId = createColumn(
		"readerId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ReaderTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ReaderTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ReaderTable, String> readerName = createColumn(
		"readerName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReaderTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private ReaderTable() {
		super("Bookify_Reader", ReaderTable::new);
	}

}