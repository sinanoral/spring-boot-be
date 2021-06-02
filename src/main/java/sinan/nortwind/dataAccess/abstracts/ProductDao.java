package sinan.nortwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sinan.nortwind.entities.concretes.Product;
import sinan.nortwind.entities.dtos.ProductWithCategoryDto;

import java.util.List;


public interface ProductDao extends JpaRepository<Product, Integer> {
    Product getByProductName(String productName);

    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    List<Product> getByCategory_CategoryIdIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    @Query("from Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);

    @Query("select new sinan.nortwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) from  Category c inner join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();

    //select * from products where product_name=bisey and categoryId=bisey
}
