package personal.rajit.service;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.rajit.controller.request_dto.ProductCategorySearchDto;
import personal.rajit.controller.request_dto.ProductCategorySearchDto;
import personal.rajit.entity.ProductCategory;
import personal.rajit.entity.ProductCategory;
import personal.rajit.entity.QProductCategory;
import personal.rajit.entity.QProductCategory;
import personal.rajit.repository.ProductCategoryRepository;
import personal.rajit.service.common.EntityValidationService;
import personal.rajit.service.predicate.ProductCategoryPredicate;

import java.util.List;

import static personal.rajit.service.predicate.ProductCategoryPredicate.makePredicate;

@Service
@AllArgsConstructor
public class ProductCategoryService {

    private final EntityManager entityManager;
    private final EntityValidationService entityValidationService;
    private final ProductCategoryRepository productCategoryRepository;


    @org.springframework.transaction.annotation.Transactional
    public ProductCategory saveProductCategory(ProductCategory productCategory) {
        return this.productCategoryRepository.save(productCategory);
    }

    @org.springframework.transaction.annotation.Transactional
    public ProductCategory updateProductCategory(ProductCategory productCategory) {
        var productCategoryDb = entityValidationService.validateProductCategory(productCategory.getId());
        productCategoryDb.setName(productCategory.getName());
        productCategoryDb.setImage(productCategory.getImage());
        productCategoryDb.setSlug(productCategory.getSlug());       
        productCategoryDb = productCategoryRepository.save(productCategoryDb);
        return productCategoryDb;
    }

    @org.springframework.transaction.annotation.Transactional
    public String deleteProductCategory(ProductCategory productCategory) {
        var productCategoryDb = entityValidationService.validateProductCategory(productCategory.getId());
        productCategoryDb.setEnabled(Boolean.FALSE);
        productCategoryRepository.save(productCategoryDb);
        return "ProductCategory deleted successfully";
    }

    public Page<ProductCategory> searchProductCategory(ProductCategorySearchDto productCategorySearchDto) {
        Predicate predicate = ProductCategoryPredicate.makePredicate(productCategorySearchDto);
        Pageable pageable = PageRequest.of(productCategorySearchDto.getPage(), productCategorySearchDto.getSize());
        final QProductCategory qProductCategory = QProductCategory.productCategory;
        var query = new JPAQuery<ProductCategory>(entityManager)
                .from(qProductCategory)
                .where(predicate)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(qProductCategory.createdDate.desc());
        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }

}
