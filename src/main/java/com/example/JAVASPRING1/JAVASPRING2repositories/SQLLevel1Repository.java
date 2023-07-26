package com.example.JAVASPRING1.JAVASPRING2repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SQLLevel1Repository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> bai1(Pageable pageable){
        int offset = pageable.getPageNumber() * pageable.getPageSize();
        int pageSize = pageable.getPageSize();
        String sql = "SELECT CONCAT(first_name, ' ', last_name) AS full_name FROM actor LIMIT ?, ?";
        return jdbcTemplate.queryForList(sql, offset, pageSize);
    }

    public List<Map<String,Object>> bai2(Pageable pageable){
        int offset = pageable.getPageNumber() * pageable.getPageSize();
        int pageSize = pageable.getPageSize();
        String sql = "SELECT title, rental_rate, replacement_cost FROM film LIMIT ?, ?";
        return jdbcTemplate.queryForList(sql, offset, pageSize);
    }
    public List<Map<String, Object>> bai3(){
        String sql = " SELECT f.title, count(rental_id) as rentals \n" +
                "FROM film f JOIN inventory i on f.film_id = i.film_id\n" +
                "\t\t\tJOIN rental r on i.inventory_id = r.inventory_id\n" +
                "GROUP BY title\n" +
                "ORDER BY rentals DESC\n" +
                "LIMIT 5;";
        return jdbcTemplate.queryForList(sql);
    }

    public List<Map<String,Object>> bai4(Pageable pageable){
        int offset = pageable.getPageNumber() * pageable.getPageSize();
        int pageSize = pageable.getPageSize();
        String sql =
                "SELECT c.category_id, c.name as name_category,\n" +
                "\t\tAVG(TIMESTAMPDIFF(hour, r.rental_date, r.return_date)) AS average_rental_duration\n" +
                "FROM category c LEFT JOIN film_category fc ON c.category_id = fc.category_id\n" +
                "\t\t\t\tLEFT JOIN film f ON fc.film_id = f.film_id\n" +
                "                LEFT JOIN inventory i ON f.film_id = i.film_id\n" +
                "                LEFT JOIN rental r ON i.inventory_id = r.inventory_id\n" +
                "GROUP BY c.category_id LIMIT ?, ?";
        return jdbcTemplate.queryForList(sql, offset, pageSize);
    }

    public List<Map<String,Object>> bai5(Pageable pageable){
        int offset = pageable.getPageNumber() * pageable.getPageSize();
        int pageSize = pageable.getPageSize();
        String sql = "SELECT\n" +
                "\t\tc.customer_id as customer_id,\n" +
                "\t\tconcat(c.first_name,' ',c.last_name) as customer_fullname,\n" +
                "\t\tconcat(a.address,', ',a.district,', ',ci.city) as address\n" +
                "FROM rental r   JOIN customer c ON c.customer_id = r.customer_id\n" +
                "\t\t\t\tJOIN address a ON c.address_id = a.address_id\n" +
                "\t\t\t\tJOIN city ci ON a.city_id = ci.city_id\n" +
                "WHERE year(r.rental_date) = 2005 AND month(r.rental_date) = 7\n" +
                "Group by customer_id, customer_fullname LIMIT ?, ?";
        return jdbcTemplate.queryForList(sql, offset, pageSize);
    }

    public List<Map<String, Object>> bai6(){
        String sql = " select st.store_id,\n" +
                "\t\tconcat(a.address,', ',a.district,', ',c.city) as store_address,\n" +
                "        sum(p.amount) as amount_2005\n" +
                "from payment p join staff sf on p.staff_id = sf.staff_id\n" +
                "\t\t\t\tjoin store st on  sf.store_id = st.store_id\n" +
                "                join address a on st.address_id = a.address_id\n" +
                "                join city c on a.city_id = c.city_id\n" +
                "where year(payment_date) = 2005\n" +
                "group by st.store_id;";
        return jdbcTemplate.queryForList(sql);
    }

    public List<Map<String, Object>> bai7(Pageable pageable){
        int offset = pageable.getPageNumber() * pageable.getPageSize();
        int pageSize = pageable.getPageSize();
        String sql = "select a.actor_id,\n" +
                "\t\tconcat(a.first_name,' ',a.last_name) as actor_name,\n" +
                "        count(film_id) as films\n" +
                "from actor a join film_actor fa on a.actor_id = fa.actor_id\n" +
                "Group by a.actor_id\n" +
                "Having films > 20" +
                " LIMIT ?, ?";
        return jdbcTemplate.queryForList(sql, offset, pageSize);
    }

    public List<Map<String, Object>> bai8(Pageable pageable){
        int offset = pageable.getPageNumber() * pageable.getPageSize();
        int pageSize = pageable.getPageSize();
        String sql = "select title, length, rating\n" +
                "from film where rating = 'PG-13'and length > 120" +
                " LIMIT ?, ?";
        return jdbcTemplate.queryForList(sql, offset, pageSize);
    }

}
