package tatim.william.application.product.composition;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import tatim.william.domain.product.ProductComposition;

@ApplicationScoped
public class ProductCompositionRepository implements PanacheRepository<ProductComposition> {
}
