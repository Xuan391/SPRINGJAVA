package com.example.JAVASPRING1.JAVASPRING2repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SQLLevel4Repository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void bai1(){
        String sql = "UPDATE film AS f\n" +
                "JOIN (\n" +
                "    SELECT f.film_id \n" +
                "    FROM film f\n" +
                "    JOIN inventory i ON f.film_id = i.film_id\n" +
                "    JOIN rental r ON i.inventory_id = r.inventory_id\n" +
                "    GROUP BY f.film_id\n" +
                "    HAVING COUNT(DISTINCT r.rental_id) > 10\n" +
                ") AS subquery ON f.film_id = subquery.film_id\n" +
                "SET f.rental_rate = f.rental_rate * 110 / 100;";

        jdbcTemplate.update(sql);
    }

    public void bai2(){
        String sql = "update film f join (\n" +
                "\t\t\t\t\tselect f.film_id\n" +
                "                    from film f join inventory i on f.film_id = i.film_id \n" +
                "\t\t\t\t\t\t\t\tjoin rental r on i.inventory_id = r.inventory_id\n" +
                "\t\t\t\t\tgroup by f.film_id\n" +
                "\t\t\t\t\thaving count(r.rental_id) > 5) sub on f.film_id = sub.film_id\n" +
                "set f.length = f.length * 1.05;";
        jdbcTemplate.update(sql);
    }

    public void bai3(){
        String sql = "update film f join(\n" +
                "\t\t\t\t\tselect f.film_id \n" +
                "\t\t\t\t\tfrom film f join film_category fc on f.film_id =  fc.film_id\n" +
                "\t\t\t\t\t\t\t\tjoin category c on fc.category_id = c.category_id\n" +
                "\t\t\t\t\twhere c.name = 'Action' and f.release_year < 2005) sub on f.film_id = sub.film_id\n" +
                "set f.rental_rate = f.rental_rate * 1.2;";
        jdbcTemplate.update(sql);
    }

    public void bai4(){
        String sql = "update customer c join (\n" +
                "\t\t\t\t\t\t-- id khách hàng thuê phim từ danh mục Horror vào tháng 10 năm 2022\n" +
                "\t\t\t\t\t\tselect c.customer_id\n" +
                "\t\t\t\t\t\tfrom customer c join rental r on c.customer_id = r.customer_id\n" +
                "\t\t\t\t\t\t\t\t\t\tjoin inventory i on r.inventory_id = i.inventory_id\n" +
                "\t\t\t\t\t\t\t\t\t\tjoin film_category fc on i.film_id = fc.film_id\n" +
                "\t\t\t\t\t\t\t\t\t\tjoin category ca on fc.category_id = ca.category_id\n" +
                "\t\t\t\t\t\twhere ca.name = 'Horror' and month(r.rental_date) = 10 and year(r.rental_date) = 2022 ) as sub\n" +
                "                        on c.customer_id = sub.customer_id\n" +
                "set c.email = concat(c.email, ' ', 'Horror');";
        jdbcTemplate.update(sql);
    }

    public void bai5(){
        String sql = "update film f join (\n" +
                "\t\t\t\t\t\t-- id film được hơn 10 khách hàng thuê\n" +
                "\t\t\t\t\t\tselect f.film_id\n" +
                "\t\t\t\t\t\tfrom film f join inventory i on f.film_id = i.film_id \n" +
                "\t\t\t\t\t\t\t\t\tjoin rental r on i.inventory_id = r.inventory_id\n" +
                "\t\t\t\t\t\tgroup by f.film_id\n" +
                "\t\t\t\t\t\thaving count(distinct r.customer_id) > 10 ) sub\n" +
                "                        on f.film_id = sub.film_id\n" +
                "set f.rental_rate = case\n" +
                "\t\t\t\t\t\twhen f.rental_rate * 1.05 <= 4.00 then f.rental_rate * 1.05\n" +
                "                        else 4.00\n" +
                "\t\t\t\t\tend;";
        jdbcTemplate.update(sql);
    }

    public void bai6(){
        String sql = "update film f join(\n" +
                "\t\t\t\t\tselect film_id from film where rating = 'PG-13' and length > 120\n" +
                "                    ) sub on f.film_id = sub.film_id\n" +
                "set rental_rate = 3.50;";
        jdbcTemplate.update(sql);
    }

    public void bai7(){
        String sql = "UPDATE film f join (\n" +
                "\t\t\t\t\tselect f.film_id\n" +
                "                    from film f join film_category fc on f.film_id = fc.film_id\n" +
                "\t\t\t\t\t\t\t\tjoin category c on fc.category_id = c.category_id\n" +
                "\t\t\t\t\twhere c.name = 'Sci-Fi' and f.release_year = 2010 ) sub\n" +
                "                    on f.film_id = sub.film_id\n" +
                "SET rental_duration = length;";
        jdbcTemplate.update(sql);
    }

    public void bai8(){
        String sql = "update customer c1 join customer c2 on c1.last_name =c2.last_name and c1.customer_id <> c2.customer_id\n" +
                "\t\t\t\t   join address ad1 on c1.address_id = ad1.address_id\n" +
                "                   join address ad2 on c2.address_id = ad2.address_id\n" +
                "set ad1.address = concat(ad1.address, 'samecity')\n" +
                "where ad1.city_id = ad2.city_id;";
        jdbcTemplate.update(sql);
    }

    public void bai9(){
        String sql = "update film f join (\n" +
                "\t\t\t\t\tselect f.film_id \n" +
                "                    from film f join film_category fc on f.film_id = fc.film_id\n" +
                "\t\t\t\t\t\t\t\tjoin category c on fc.category_id = c.category_id\n" +
                "\t\t\t\t\twhere c.name = 'Comedy' and f.release_year >= 2007\n" +
                "\t\t\t\t\t) sub on f.film_id = sub.film_id\n" +
                "set rental_rate = rental_rate * 0.85;";
        jdbcTemplate.update(sql);
    }

    public void bai10(){
        String sql = "update film f join (\n" +
                "\t\t\t\t\tselect film_id from film where rating = 'G' and length < 60\n" +
                "\t\t\t\t\t) sub on f.film_id = sub.film_id\n" +
                "set rental_rate = 1.50;";
        jdbcTemplate.update(sql);
    }
}
