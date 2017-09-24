Klient postgres
---
Windows<br>
Należy pobrać i rozpakować psql.zip<br>
https://drive.google.com/uc?id=0ByVgko533JLjVk1sdVNBNUthLXc&export=download

Można też pobrać z oficjalnej strony postgresa<br>
https://www.postgresql.org/download/

Żeby utworzyć bazę
`psql -h ADRES_BAZY -U postgres -c 'create database NAZWA_BAZY;'`<br>
`psql -h 217.182.73.240 -U postgres -c 'create database marcinkrol;'`

Żeby się połączyć z bazą wpisujemy<br>
`psql -h ADRES_BAZY -U postgres NAZWA_BAZY`<br>
`psql -h 217.182.73.240 -U postgres marcinkrol` 


Podstawy sql
---
Utwórz tabelę<br>
`create table TABELA (NAZWA KOLUMNY TYP, ...);`<br>
`create table users(id bigserial primary key, login text, password text);`

Umieść rekord w tabeli<br>
`insert into TABELA(KOLUMNA, ...) values(WARTOŚĆ, ...);`<br>
`insert into users(login, password) values('marcin', 'tajne');`

Wyjmij rekordy z tabeli<br>
`select KOLUMNA, ... from users where WARUNEK;`<br>
`select login, password from users where login like 'marcin%';`<br>

Usuń rekordy z tabeli<br>
`delete from TABELA where WARUNEK;`<br>
`delete from users where password='tajne';`

Usuń tabelę<br>
`drop table NAZWA;`<br>
`drop table users;`<br>

Złączanie tabeli<br>
`select KOLUMNA, ... from TABELA1 join TABELA2 on KOLUMNA1=KOLUMNA2 where WARUNEK;`
`select shop_name, product_name from products p join shops s on p.shop_id=s.id where p.price > 10;`

Uaktualnienie rekordu<br>
`update TABELA set KOLUMNA=WARTOSC where WARUNEK;`<br>
`update users set login='kamil' where login='marcin';`<br>

Opcje zarządzania schematem Hibernate
---
For hbm2ddl.auto property the list of possible options is:
* validate: validate that the schema matches, make no changes to the schema of the database, you probably want this for production.
* update: update the schema to reflect the entities being persisted
* create: creates the schema necessary for your entities, destroying any previous data.
* create-drop: create the schema as in create above, but also drop the schema at the end of the session. This is great in early development or for testing.


Zadanie 1 [SQL]
------

1. Utwórz tabelę towns z kolumnami
* id bigserial primary key
* name text
* inhabitants_count int

2. Umieść w tabeli
* 'Warszawa' 200
* 'Wroclaw' 300
* 'Gdansk' 400
* 'Krakow' 500
* 'Opole' 600

3. Znajdź miasta z liczbą mieszkańców większą niż 300 i mniejszą niż 600

Zadanie 2 [SQL]
------

1. Utwórz tabelę users
`create table users(id bigserial primary key, login text, password text, town_id bigint references towns(id));`

2. Umieść w tabeli<br>
`insert into users(login, password, town_id) values('marcin', 'tajne', 1);`<br>
`insert into users(login, password, town_id) values('kamil', 'tajne', 1);`<br>
`insert into users(login, password, town_id) values('mariusz', 'tajne', 2);`<br>
`insert into users(login, password, town_id) values('tomek', 'tajne', 2);`<br>
`insert into users(login, password, town_id) values('radek', 'tajne', 3);`<br>

3. Wypisz użytkowników z Warszawy

Zadanie 3 [SQL]
---

1. Usuń tabele utworzone w poprzednich zadaniach 

Zadanie 4 [JPA]
------

1. Utwórz klasy Town i User odpowiadające tabelom z poprzednich zadań

2. Powtórz zadania 1 i 2 używając JPA, utwórz DAO

Zadanie 5 [JPA]
---

1. Utwórz klasy
* Shop(String name, String address)
* Product(String name, int price)

2. Napisz aplikację pozwalającą
* dodać sklep
* dodać i usunąć ze sklepu produkty
* wypisać wszystkie produkty dla danego sklepu
* wypisać produkty z przedziału cenowego
* sprawdzić w jakim sklepie znajduje się dany produkt
