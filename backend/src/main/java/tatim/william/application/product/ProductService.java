package tatim.william.application.product;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import tatim.william.application.product.dtos.ProductRequest;
import tatim.william.application.product.dtos.ProductResponse;
import tatim.william.domain.product.Product;

import java.util.List;

@ApplicationScoped
public class ProductService {
    @Inject
    ProductRepository repository;
    @Inject
    ProductMapper mapper;


    @Transactional
    public ProductResponse update(ProductRequest dto, Long productId){
        var product = getByIdOrThrow(productId);
        mapper.updateEntity(dto, product);
        repository.persist(product);
        return mapper.toDto(product);

    }

    @Transactional
    public  void delete(Long productId){
        var product = getByIdOrThrow(productId);
        repository.delete(product);
    }

    public ProductResponse get(Long id){
        return mapper.toDto(getByIdOrThrow(id));
    }


    public List<ProductResponse> list(){
        var products = repository.findAll();
        return products
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public Product getByIdOrThrow(Long id){
        return repository.findByIdOptional(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("O produto não existe")
                );
    }



}
