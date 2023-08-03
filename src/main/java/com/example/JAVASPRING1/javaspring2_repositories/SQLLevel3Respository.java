package com.example.JAVASPRING1.javaspring2_repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SQLLevel3Respository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String,Object>> bai1(Pageable pageable){
        int offset = pageable.getPageSize() * pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        String sql = "select concat(a.first_name,' ',a.last_name) as actor_name, c.name as category_name,\n" +
                "\t\tavg(timestampdiff(hour, r.rental_date, r.return_date)) as avg_rental_duration\n" +
                "from actor a join film_actor fa on a.actor_id = fa.actor_id\n" +
                "\t\t\tjoin film_category fc on fa.film_id = fc.film_id\n" +
                "            join category c on fc.category_id = c.category_id\n" +
                "            join inventory i on fc.film_id = i.film_id\n" +
                "            join rental r on i.inventory_id = r.inventory_id\n" +
                "group by actor_name, category_name\n" +
                "having count(distinct fc.film_id) > 0\n" +
                "LIMIT ?, ?";
        return jdbcTemplate.queryForList(sql, offset, pageSize);
    }

    public List<Map<String,Object>> bai2(Pageable pageable){
        int offset = pageable.getPageSize() * pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        String sql = "select a.actor_id, concat(a.first_name,' ', a.last_name) as actor_name\n" +
                "from actor a join film_actor fa on a.actor_id = fa.actor_id\n" +
                "\t\t\tjoin film f on f.film_id = fa.film_id\n" +
                "where f.rating = 'R' and a.actor_id not in (\n" +
                "\t\t\t\t\t\t\t\t\t\t\tselect a.actor_id\n" +
                "\t\t\t\t\t\t\t\t\t\t\tfrom actor a join film_actor fa on a.actor_id = fa.actor_id\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t join film f on fa.film_id = f.film_id\n" +
                "\t\t\t\t\t\t\t\t\t\t\twhere f.rating = 'G'\n" +
                "\t\t\t\t\t\t\t\t\t\t\tgroup by a.actor_id)\n" +
                "group by actor_id " +
                "LIMIT ?, ?";
        return jdbcTemplate.queryForList(sql, offset, pageSize);
    }

    public List<Map<String,Object>> bai3(Pageable pageable){
        int offset = pageable.getPageSize() * pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        String sql = "select c.customer_id,\n" +
                "\t\tconcat(c.first_name,' ',c.last_name) as customer_name,\n" +
                "        count(distinct r.inventory_id) as inventor_count,\n" +
                "        sum(p.amount) as total_rental_fee\n" +
                "from customer c join rental r on c.customer_id = r.customer_id\n" +
                "\t\t\t\tjoin payment p on r.rental_id = p.rental_id\n" +
                "GROUP BY c.customer_id, date(r.rental_date)\n" +
                "having count(r.inventory_id) > 5 " +
                "LIMIT ?, ?";
        return jdbcTemplate.queryForList(sql, offset, pageSize);
    }

    public List<Map<String,Object>> bai5(Pageable pageable){
        int offset = pageable.getPageSize() * pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        String sql = "select f.film_id, f.title ,\n" +
                "\t\tconcat(c.first_name,' ',c.last_name) as customer_name,\n" +
                "        count(*) as rental_count\n" +
                "from film f join inventory i on f.film_id = i.film_id\n" +
                "\t\t\tjoin rental r on i.inventory_id = r.inventory_id\n" +
                "            join customer c on r.customer_id = c.customer_id\n" +
                "where date(r.rental_date)  = '2005-05-25'\n" +
                "group by f.film_id, c.customer_id\n" +
                "having count(*)>1 " +
                "LIMIT ?, ?";
        return jdbcTemplate.queryForList(sql, offset, pageSize);
    }

    public List<Map<String,Object>> bai6(Pageable pageable){
        int offset = pageable.getPageSize() * pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        String sql = "select concat(a1.first_name,' ',a1.last_name) as actor1_name,\n" +
                "\t   concat(a2.first_name,' ',a2.last_name) as actor2_name,\n" +
                "       count(distinct fa1.film_id) as number_films\n" +
                "from actor a1 join film_actor fa1 on a1.actor_id = fa1.actor_id\n" +
                "\t\t\t  join film_actor fa2 on fa1.film_id = fa2.film_id and fa1.actor_id <> fa2.actor_id\n" +
                "              join actor a2 on fa2.actor_id = a2.actor_id\n" +
                "group by actor1_name, actor2_name " +
                "LIMIT ?, ?";
        return jdbcTemplate.queryForList(sql, offset, pageSize);
    }

    public List<Map<String,Object>> bai7(Pageable pageable){
        int offset = pageable.getPageSize() * pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        String sql = "select c.customer_id, concat(c.first_name,' ',c.last_name) as customer_name,\n" +
                "\t\tcount(distinct i.film_id) as number_films\n" +
                "from customer c join rental r on c.customer_id = r.customer_id\n" +
                "\t\t\t\tjoin inventory i on r.inventory_id = i.inventory_id\n" +
                "                join film_category fc on i.film_id = fc.film_id\n" +
                "group by c.customer_id\n" +
                "having count(distinct fc.category_id) = (select count(*) from category) " +
                "LIMIT ?, ?";
        return jdbcTemplate.queryForList(sql, offset, pageSize);
    }

    public List<Map<String,Object>> bai8(Pageable pageable){
        int offset = pageable.getPageSize() * pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        String sql = "select f.film_id, f.title , count( rental_id) as number_rentals\n" +
                "from film f join inventory i on f.film_id = i.film_id \n" +
                "\t\t\tjoin rental r on i.inventory_id = r.inventory_id\n" +
                "where r.customer_id not in (\n" +
                "\t\t\t\t\t\t\t-- id các khách hàng đã thuê phim có xếp hạng G\n" +
                "\t\t\t\t\t\t\tselect distinct customer_id \n" +
                "\t\t\t\t\t\t\tfrom rental r join inventory i on r.inventory_id = i.inventory_id\n" +
                "\t\t\t\t\t\t\t\t\t\t  join film f on i.film_id = f.film_id\n" +
                "\t\t\t\t\t\t\twhere rating = 'G')\n" +
                "group by f.film_id\n" +
                "having number_rentals > 100 " +
                "LIMIT ?, ?";
        return jdbcTemplate.queryForList(sql, offset, pageSize);
    }

    public List<Map<String,Object>> bai9(Pageable pageable){
        int offset = pageable.getPageSize() * pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        String sql = "select c.customer_id, concat(c.first_name,' ',c.last_name) as customer_name\n" +
                "from customer c join rental r on c.customer_id = r.customer_id \n" +
                "\t\t\t\tjoin inventory i on r.inventory_id = i.inventory_id\n" +
                "                join film_category fc on i.film_id = fc.film_id\n" +
                "where NOT EXISTS (\n" +
                "\t\t\t\tselect 1 from rental r2 join inventory i2 on r2.inventory_id = i2.inventory_id\n" +
                "\t\t\t\t\t\t\t\t\t\tjoin film_category fc2 on i2.film_id = fc2.film_id\n" +
                "\t\t\t\twhere r2.customer_id = c.customer_id and fc2.category_id = fc.category_id and r2.rental_date < r.rental_date\n" +
                "                )\n" +
                "and c.customer_id in  (\n" +
                "\t\t\t\t-- khách hàng thuê phim dài hơn 3 giờ\n" +
                "\t\t\t\tselect c.customer_id\n" +
                "\t\t\t\tfrom customer c join rental r on c.customer_id = r.customer_id\n" +
                "\t\t\t\t\t\t\t\tjoin inventory i on r.inventory_id = i.inventory_id\n" +
                "\t\t\t\t\t\t\t\tjoin film f on i.film_id = f.film_id\n" +
                "\t\t\t\twhere f.length <= 180\n" +
                "\t\t\t\tgroup by c.customer_id\n" +
                "\t\t\t\torder by c.customer_id)\n" +
                "group by c.customer_id " +
                "LIMIT ?, ?";
        return jdbcTemplate.queryForList(sql, offset, pageSize);
    }

    public List<Map<String,Object>> bai10(Pageable pageable){
        int offset = pageable.getPageSize() * pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        String sql = "select a.actor_id, concat(a.first_name,' ',a.last_name) as actor_name\n" +
                "from actor a join film_actor fa on a.actor_id = fa.actor_id\n" +
                "\t\t\tjoin film f on fa.film_id = f.film_id\n" +
                "where f.rating = 'PG-13' AND f.length > 120\n" +
                "\t\t\t\t\t\tAND a.actor_id in ( select a.actor_id \n" +
                "\t\t\t\t\t\t\t\t\t\t\tfrom actor a join film_actor fa on a.actor_id = fa.actor_id\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tjoin film f on fa.film_id = f.film_id\n" +
                "\t\t\t\t\t\t\t\t\t\t\twhere rating = 'R' and f.length <90\n" +
                "\t\t\t\t\t\t\t\t\t\t\t)\n" +
                "group by a.actor_id " +
                "LIMIT ?, ?";
        return jdbcTemplate.queryForList(sql, offset, pageSize);
    }
}
