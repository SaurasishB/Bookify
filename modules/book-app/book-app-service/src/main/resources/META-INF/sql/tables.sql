create table Bookify_Book (
	bookId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	readerName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	bookName VARCHAR(75) null,
	bookAuthor VARCHAR(75) null,
	bookPublicationDate DATE null,
	readerId LONG
);

create table Bookify_Reader (
	readerId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	readerName VARCHAR(75) null,
	createDate DATE null
);