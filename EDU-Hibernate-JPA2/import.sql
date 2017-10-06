insert 
    into
        ITEM
        (ITEM_ID, AVAILIBLE, ISBN, TITLE) 
    values
        ('1', 'Y', '9781932394887', 'Java Persistence with Hibernate'),
	('2', 'Y', '978-1-449-33437-6', 'Just Hibernate');


insert 
    into
        BOOK
        (PUBLISH_YEAR, ITEM_ID) 
    values
        ('2006-10-1', '1'),
	('2014-06-27', '2');


insert 
    into
        AUTHOR
        (AUTHOR_ID, FIRST_NAME, LAST_NAME) 
    values
        ('1', 'Christian', 'Bauer'),
	('2', 'Gavin', 'King'),
	('3', 'Madhusudhan', 'Konda');


insert 
    into
        AUTHOR_BOOK
        (AUTHOR_ID, ITEM_ID) 
    values
        ('1', '1'),
	('2', '1'),
	('3', '2');

insert 
    into
        BORROWER
        (id, FIRST_NAME, LAST_NAME, SSN) 
    values
        ('1', 'John', 'Doe', '70010100111');