1--test veritabanınızda employee isimli sütun bilgileri id(INTEGER), name VARCHAR(50), birthday DATE, email VARCHAR(100) olan bir tablo oluşturalım.

create table employee (

    id Integer PRIMARY KEY,
    name varchar (50),
    birthday date,
    email varchar (100)
);


2--Oluşturduğumuz employee tablosuna 'Mockaroo' servisini kullanarak 50 adet veri ekleyelim.

insert into employee (id, name, birthday, email) values (1, 'Townsend', '1918-07-03', 'tvarley0@alexa.com');
insert into employee (id, name, birthday, email) values (2, 'Patin', '1921-12-20', 'ptimpany1@ustream.tv');
insert into employee (id, name, birthday, email) values (3, 'Fernanda', '2009-01-25', null);
insert into employee (id, name, birthday, email) values (4, 'Shurlock', '1940-09-07', 'sspeechley3@bloglines.com');
insert into employee (id, name, birthday, email) values (5, 'Lynnelle', '1903-12-18', null);
insert into employee (id, name, birthday, email) values (6, 'Rici', '1901-09-30', null);
insert into employee (id, name, birthday, email) values (7, 'Aura', null, 'awort6@nhs.uk');
insert into employee (id, name, birthday, email) values (8, 'Jeanelle', null, 'jbathow7@omniture.com');
insert into employee (id, name, birthday, email) values (9, 'Mikael', null, 'mgierhard8@hud.gov');
insert into employee (id, name, birthday, email) values (10, 'Ivor', '1935-10-13', 'ibaddeley9@surveymonkey.com');
insert into employee (id, name, birthday, email) values (11, 'Clemens', '1924-06-30', 'cvogeleina@yolasite.com');
insert into employee (id, name, birthday, email) values (12, 'Patricio', '1911-04-25', 'plidgeyb@slideshare.net');
insert into employee (id, name, birthday, email) values (13, 'Fawnia', null, 'fbeacroftc@utexas.edu');
insert into employee (id, name, birthday, email) values (14, 'Jonathan', null, 'jborleased@edublogs.org');
insert into employee (id, name, birthday, email) values (15, 'Akim', '1962-07-09', 'apedronie@bloomberg.com');
insert into employee (id, name, birthday, email) values (16, 'Sibley', '1911-07-24', 'scoldhamf@irs.gov');
insert into employee (id, name, birthday, email) values (17, 'Lanita', null, 'lohallorang@feedburner.com');
insert into employee (id, name, birthday, email) values (18, 'Penelope', '1922-06-29', 'pgomersalh@dedecms.com');
insert into employee (id, name, birthday, email) values (19, 'Vance', '1925-03-18', 'valyutini@ning.com');
insert into employee (id, name, birthday, email) values (20, 'Nick', '2016-01-23', 'nbellringerj@cdc.gov');
insert into employee (id, name, birthday, email) values (21, 'Lia', '2016-07-06', 'lpickersailk@skype.com');
insert into employee (id, name, birthday, email) values (22, 'Cecilio', '1962-02-28', 'cdarnodyl@netscape.com');
insert into employee (id, name, birthday, email) values (23, 'Bernete', '1981-11-23', 'bdrinnanm@mlb.com');
insert into employee (id, name, birthday, email) values (24, 'Lila', '1983-09-28', 'lmeganyn@uiuc.edu');
insert into employee (id, name, birthday, email) values (25, 'Magnum', null, 'mperellio@sfgate.com');
insert into employee (id, name, birthday, email) values (26, 'Papagena', null, 'pverrillsp@discuz.net');
insert into employee (id, name, birthday, email) values (27, 'Crysta', null, 'ckemmq@vk.com');
insert into employee (id, name, birthday, email) values (28, 'Vic', '1909-05-05', 'vresider@craigslist.org');
insert into employee (id, name, birthday, email) values (29, 'Joann', null, 'jshreevess@ifeng.com');
insert into employee (id, name, birthday, email) values (30, 'Susann', '2013-12-16', 'sscrivenst@etsy.com');
insert into employee (id, name, birthday, email) values (31, 'Linus', null, 'lickeringillu@tmall.com');
insert into employee (id, name, birthday, email) values (32, 'Lewes', '1915-12-17', 'lmaharryv@princeton.edu');
insert into employee (id, name, birthday, email) values (33, 'Cindi', '2011-09-18', null);
insert into employee (id, name, birthday, email) values (34, 'Camille', '1938-10-30', 'cchezellex@boston.com');
insert into employee (id, name, birthday, email) values (35, 'Louisa', '1907-10-08', 'lvedyashkiny@house.gov');
insert into employee (id, name, birthday, email) values (36, 'Dusty', '2003-07-22', 'dfattoriniz@google.pl');
insert into employee (id, name, birthday, email) values (37, 'Danya', '1991-06-09', 'drudinger10@npr.org');
insert into employee (id, name, birthday, email) values (38, 'Rhianna', null, 'rhowison11@quantcast.com');
insert into employee (id, name, birthday, email) values (39, 'Selby', '1938-10-11', 'ssallows12@dailymail.co.uk');
insert into employee (id, name, birthday, email) values (40, 'Nikolaos', '2016-03-27', 'njeannon13@time.com');
insert into employee (id, name, birthday, email) values (41, 'Stillmann', '2006-02-12', 'showel14@geocities.com');
insert into employee (id, name, birthday, email) values (42, 'Arv', null, null);
insert into employee (id, name, birthday, email) values (43, 'Linnell', '1929-03-30', 'lavraam16@topsy.com');
insert into employee (id, name, birthday, email) values (44, 'Nicki', '1970-12-01', 'nstarsmore17@taobao.com');
insert into employee (id, name, birthday, email) values (45, 'Erskine', null, null);
insert into employee (id, name, birthday, email) values (46, 'Igor', '1938-07-20', 'iwonfor19@ask.com');
insert into employee (id, name, birthday, email) values (47, 'Reinold', '1964-05-23', 'rblaby1a@berkeley.edu');
insert into employee (id, name, birthday, email) values (48, 'Etty', '2009-10-14', 'edearing1b@guardian.co.uk');
insert into employee (id, name, birthday, email) values (49, 'Gui', '1901-11-02', 'gyackiminie1c@cloudflare.com');
insert into employee (id, name, birthday, email) values (50, 'Cherida', '1900-03-10', 'ctatford1d@guardian.co.uk');

3--Sütunların her birine göre diğer sütunları güncelleyecek 5 adet UPDATE işlemi yapalım.

(ister normalde satıra göre update yapılması gerekli ben her iki şekilde de ekliyorum.)

SATIRA GÖRE UPDATE
--------------------------------------------------------------------------------------
UPDATE employee
SET
name = 'UPDATED',
birthday = '01.01.1900',
email = 'harika@san.com'
where
name ILIKE 'A%'
returning *;
----------------------------------------------------------------------------------------

UPDATE employee
SET
name = 'Guncellendi',
birthday = '09.09.2000',
email = 'mukemmel@san.com'
where
id not between '10' and '50'
returning *;
----------------------------------------------------------------------------------------
UPDATE employee
SET
name = 'dogumgunleriguncel',
birthday = '05.05.1980',
email = 'verygood@san.com'
where
birthday > '01.01.1990'
returning *;
----------------------------------------------------------------------------------------

UPDATE employee
SET
name = 'emailupdate',
birthday = '12.03.1970',
email = 'email@san.com'
where
email is NULL
returning *;

----------------------------------------------------------------------------------------
UPDATE employee
SET
name = 'conditions',
birthday = '05.07.1950',
email = 'guzel@san.com'
where
id > 25
and name ILIKE '%a'
returning *;
----------------------------------------------------------------------------------------
SÜTUNA GÖRE UPDATE
----------------------------------------------------------------------------------------
UPDATE employee
SET
name ='Murat'
where
name = name;
----------------------------------------------------------------------------------------
UPDATE employee
SET
id ='1'
where
id = id;
----------------------------------------------------------------------------------------
UPDATE employee
SET
birthday ='01.05.2001'
where
birthday = birthday;
----------------------------------------------------------------------------------------
4--Sütunların her birine göre ilgili satırı silecek 5 adet DELETE işlemi yapalım.

delete from employee
where
id > 45
returning *;
----------------------------------------------------------------------------------------
delete from employee
where
email LIKE ('%t%t%')
returning *;
----------------------------------------------------------------------------------------
delete from employee
where
birthday not between '01.01.1901' and '01.01.2000'  
returning *;
----------------------------------------------------------------------------------------
delete from employee
where
name ILIKE 'a%'
and
id>30
returning *;
----------------------------------------------------------------------------------------
delete from employee
where
email LIKE '%@%'
returning *;