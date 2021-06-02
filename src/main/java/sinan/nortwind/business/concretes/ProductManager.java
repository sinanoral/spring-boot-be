package sinan.nortwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import sinan.nortwind.business.abstracts.ProductService;
import sinan.nortwind.core.utilities.results.DataResult;
import sinan.nortwind.core.utilities.results.Result;
import sinan.nortwind.core.utilities.results.SuccessDataResult;
import sinan.nortwind.core.utilities.results.SuccessResult;
import sinan.nortwind.dataAccess.abstracts.ProductDao;
import sinan.nortwind.entities.concretes.Product;
import sinan.nortwind.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService{

	private final ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}
	
	@Override
	public DataResult<List<Product>> getAll() {
		return new SuccessDataResult<>(this.productDao.findAll(), "Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<>(this.productDao.findAll(pageable).getContent(), "Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "productName");
		return new SuccessDataResult<>(this.productDao.findAll(sort), "Data listelendi");
	}

	@Override
	public Result add(Product product) {
		productDao.save(product);
		return new SuccessResult("Urun eklendi");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<>(this.productDao.getByProductName(productName), "Data listelendi");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<>(this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<>(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<>(this.productDao.getByCategory_CategoryIdIn(categories), "Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<>(this.productDao.getByProductNameContains(productName), "Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<>(this.productDao.getByProductNameStartsWith(productName), "Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<>(this.productDao.getByNameAndCategory(productName, categoryId), "Data listelendi");
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return new SuccessDataResult<>(this.productDao.getProductWithCategoryDetails(), "Data listelendi");
	}

}
