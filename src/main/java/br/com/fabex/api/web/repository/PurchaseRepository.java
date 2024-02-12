package br.com.fabex.api.web.repository;

import br.com.fabex.api.web.model.Purchase;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class PurchaseRepository {

    private final JdbcTemplate jdbc;

    public void save(Purchase purchase) {
        String sql = "INSERT INTO purchase(product, price) VALUES (?, ?)";
        this.jdbc.update(sql, purchase.getProduct(), purchase.getPrice());
    }

    public List<Purchase> findAll() {
        String sql = "SELECT * FROM purchase";
        RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
            Purchase rowObject = new Purchase();
            rowObject.setId(r.getLong("id"));
            rowObject.setProduct(r.getString("product"));
            rowObject.setPrice(r.getBigDecimal("price"));
            return rowObject;
        };

        return jdbc.query(sql, purchaseRowMapper);
    }
}
