package tatim.william.application.product;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import tatim.william.domain.product.Product;

import java.util.List;

@ApplicationScoped
class ProductRepository implements PanacheRepository<Product> {
    List<Product> findAllProductsWhitCompositions(){
        return find("""
                    SELECT DISTINCT p
                    FROM Product
                    JOIN FETCH p.compositions pc
                    JOIN FETCH pc.rawMaterial
                """).list();
    }
}
