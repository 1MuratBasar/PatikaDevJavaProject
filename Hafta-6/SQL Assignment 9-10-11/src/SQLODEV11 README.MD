Aşağıdaki sorgu senaryolarını dvdrental örnek veri tabanı üzerinden gerçekleştiriniz.
--------------------------------------------------------------------------------------------------------
1-)actor ve customer tablolarında bulunan first_name sütunları için tüm verileri sıralayalım.


(select first_name from actor)
union
(select first_name from customer)

order by first_name asc;

--------------------------------------------------------------------------------------------------------
2-) actor ve customer tablolarında bulunan first_name sütunları için kesişen verileri sıralayalım.

(select first_name from actor)
intersect
(select first_name from customer)

order by first_name asc;
--------------------------------------------------------------------------------------------------------
3-) actor ve customer tablolarında bulunan first_name sütunları için ilk tabloda bulunan ancak 
ikinci tabloda bulunmayan verileri sıralayalım.

(select first_name from actor)
except
(select first_name from customer)

order by first_name asc;
--------------------------------------------------------------------------------------------------------
4-) İlk 3 sorguyu tekrar eden veriler için de yapalım.

(select first_name from actor)
union all
(select first_name from customer)

order by first_name asc;

(select first_name from actor)
intersect all
(select first_name from customer)

order by first_name asc;


(select first_name from actor)
except all
(select first_name from customer)

order by first_name asc;
--------------------------------------------------------------------------------------------------------