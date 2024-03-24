1-) film tablosunda film uzunluğu length sütununda gösterilmektedir. Uzunluğu ortalama film 
uzunluğundan fazla kaç tane film vardır?

select count(*) from film
where
length >
(
select avg(length) from film
);

2-) film tablosunda en yüksek rental_rate değerine sahip kaç tane film vardır?

select count(*) from film

where
rental_rate = (select max(rental_rate) from film)


3-) film tablosunda en düşük rental_rate ve en düşün replacement_cost değerlerine sahip filmleri 
sıralayınız.


select *
from film
where
film_id = any

            (select film_id from film
            where
             rental_rate = (select min(rental_rate) from film)
             and
             replacement_cost = (select min(replacement_cost) from film)
            )
order by rental_rate, replacement_cost asc;


4-) payment tablosunda en fazla sayıda alışveriş yapan müşterileri(customer) sıralayınız.



select distinct(customer_id), count(customer_id) from payment
where
customer_id = any (select customer_id from payment
)

                      group by customer_id
                      order by count(customer_id) desc;