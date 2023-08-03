package com.example.JAVASPRING1.javaspring2_repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SQLLevel2Repository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> bai1(Pageable pageable){
        int offset = pageable.getPageSize() * pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        String sql = "(SELECT c.customer_id, CONCAT(c.first_name, ' ', c.last_name) AS customer_name, " +
                "SUM(p.amount) AS total_revenue, c.store_id " +
                "FROM customer c " +
                "JOIN payment p ON c.customer_id = p.customer_id " +
                "WHERE c.store_id = 1 " +
                "GROUP BY c.customer_id, customer_name, c.store_id " +
                "ORDER BY total_revenue DESC " +
                "LIMIT 10) " +
                "UNION " +
                "(SELECT c.customer_id, CONCAT(c.first_name, ' ', c.last_name) AS customer_name, " +
                "SUM(p.amount) AS total_revenue, c.store_id " +
                "FROM customer c " +
                "JOIN payment p ON c.customer_id = p.customer_id " +
                "WHERE c.store_id = 2 " +
                "GROUP BY c.customer_id, customer_name, c.store_id " +
                "ORDER BY total_revenue DESC " +
                "LIMIT 10) " +
                "LIMIT ?, ?";
        return jdbcTemplate.queryForList(sql,offset,pageSize);
    }

    public List<Map<String, Object>> bai2(Pageable pageable){
        int offset = pageable.getPageSize() * pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        String sql = "SELECT c.customer_id, concat(first_name,', ',last_name) as customer_name, c.email\n" +
                "FROM customer c\n" +
                "WHERE NOT exists(\n" +
                "\t-- trả về các category không ở trông truy vấn con\n" +
                "\tselect * from category \n" +
                "    where category_id NOT IN (\n" +
                "\t\t-- trả về các category mà khách hàng đã thuê từ bảng rental\n" +
                "\t\tSELECT distinct fa.category_id\n" +
                "        FROM rental r JOIN inventory i on r.inventory_id = i.inventory_id\n" +
                "\t\t\t\t\t\tJOIN film_category fa on i.film_id = fa.film_id\n" +
                "                        where r.customer_id = c.customer_id -- đảm bảo rằng chỉ có dữ liệu liên quan đến khách hàng cụ thể được lấy\n" +
                "    )\n" +
                ") " +
                "LIMIT ?, ?";
        return jdbcTemplate.queryForList(sql,offset,pageSize);
    }

    public List<Map<String, Object>> bai3(Pageable pageable){
        int offset = pageable.getPageSize() * pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        String sql = "select title \n" +
                "from film \n" +
                "where film_id IN (\n" +
                "\t\t\t\t\tSelect i.film_id \n" +
                "\t\t\t\t\tfrom rental r join inventory i on r.inventory_id = i.inventory_id\n" +
                "                    where return_date is null\n" +
                "\t\t\t\t\t)" +
                "LIMIT ?,?";
        return jdbcTemplate.queryForList(sql,offset,pageSize);
    }

    public List<Map<String, Object>> bai4(Pageable pageable){
        int offset = pageable.getPageSize() * pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        String sql = "select a.actor_id, concat(a.first_name,' ', a.last_name) as actor_name " +
                "from actor a join ( " +
                "    select fa.actor_id, count(distinct fc.category_id) as category_count " +
                "    from film_actor fa join film_category fc on fa.film_id = fc.film_id " +
                "    group by fa.actor_id " +
                ") b on a.actor_id = b.actor_id " +
                "where b.category_count = (select count(distinct category_id) from category) " +
                "LIMIT ?, ?";
        return jdbcTemplate.queryForList(sql,offset,pageSize);
    }

    public List<Map<String, Object>> bai5(Pageable pageable){
        int offset = pageable.getPageSize() * pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        String sql = "SELECT c.customer_id, c.first_name, c.last_name, COUNT(*) as rental_count " +
                "FROM customer c " +
                "JOIN rental r1 ON c.customer_id = r1.customer_id " +
                "JOIN rental r2 ON r1.customer_id = r2.customer_id AND r1.rental_id <> r2.rental_id AND r1.rental_date = r2.rental_date " +
                "JOIN inventory i ON r1.inventory_id = i.inventory_id " +
                "GROUP BY c.customer_id " +
                "HAVING rental_count > 1 " +
                "LIMIT ?, ?";
        return jdbcTemplate.queryForList(sql,offset,pageSize);
    }

    public List<Map<String, Object>> bai6(Pageable pageable){
        int offset = pageable.getPageSize() * pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        String sql = "SELECT a.actor_id, CONCAT(a.first_name, ' ', a.last_name) as actor_fullname, SUM(p.amount) as actor_amount " +
                "FROM actor a " +
                "JOIN film_actor fa ON a.actor_id = fa.actor_id " +
                "JOIN inventory i ON fa.film_id = i.film_id " +
                "JOIN rental r ON i.inventory_id = r.inventory_id " +
                "JOIN payment p ON r.rental_id = p.rental_id " +
                "GROUP BY a.actor_id " +
                "LIMIT ?, ?";
        return jdbcTemplate.queryForList(sql,offset,pageSize);
    }

    public List<Map<String, Object>> bai7(Pageable pageable){
        int offset = pageable.getPageSize() * pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        String sql = "select a.actor_id, concat(a.first_name,' ',a.last_name) as actor_name, f.rating as film_rating " +
                "from actor a join film_actor fa on a.actor_id = fa.actor_id" +
                "            join film f on fa.film_id = f.film_id " +
                "where f.rating = 'R' and a.actor_id not in (select fa.actor_id " +
                "                                               from film f join film_actor fa on f.film_id = fa.film_id " +
                "                                               where f.rating = 'G'" +
                "                                               group by actor_id)" +
                "group by a.actor_id LIMIT ?, ?";
        return jdbcTemplate.queryForList(sql,offset,pageSize);
    }

    public List<Map<String, Object>> bai8(Pageable pageable){
        int offset = pageable.getPageSize() * pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        String sql = "SELECT f.film_id, f.title, COUNT(DISTINCT r.customer_id) as customer_rentals " +
                "FROM film f " +
                "JOIN inventory i ON f.film_id = i.film_id " +
                "JOIN rental r ON i.inventory_id = r.inventory_id " +
                "GROUP BY f.film_id " +
                "HAVING customer_rentals > 50 " +
                "LIMIT ?, ?";
        return jdbcTemplate.queryForList(sql,offset,pageSize);
    }

    public List<Map<String, Object>> bai9(Pageable pageable){
        int offset = pageable.getPageSize() * pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        String sql = "select c.customer_id, concat(c.first_name,' ', c.last_name) as customer_name\n" +
                "from customer c join rental r on c.customer_id = r.customer_id\n" +
                "\t\t\t\tjoin inventory i on r.inventory_id = i.inventory_id\n" +
                "                join film_category fc on i.film_id = fc.film_id\n" +
                "                left join ( select r.customer_id, fa.category_id \n" +
                "\t\t\t\t\t\t\tfrom rental r join inventory i on r.inventory_id = i.inventory_id\n" +
                "\t\t\t\t\t\t\tjoin film_category fa on i.film_id = fa.film_id\n" +
                "\t\t\t\t\t\t\tgroup by customer_id, fa.category_id) as ra\n" +
                "                            on c.customer_id = ra.customer_id and fc.category_id = ra.category_id\n" +
                "where ra.customer_id is null " +
                "LIMIT ?, ?";
        return jdbcTemplate.queryForList(sql,offset,pageSize);
    }

    public List<Map<String, Object>> bai10(Pageable pageable){
        int offset = pageable.getPageSize() * pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        String sql = "select film_id , title \n" +
                "from film f\n" +
                "where not exists (\n" +
                "\t\t\t\t\tselect * from customer\n" +
                "\t\t\t\t\twhere customer_id not in (\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tselect customer_id \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tfrom rental r join inventory i on r.inventory_id = i.inventory_id\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tjoin film_category fc on i.film_id = fc.film_id\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tjoin category c on fc.category_id = c.category_id\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twhere c.name = 'Action' and f.film_id = fc.film_id\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tgroup by customer_id)\n" +
                "\t\t\t\t  )" +
                "LIMIT ?, ?";
        return jdbcTemplate.queryForList(sql,offset,pageSize);
    }
}
