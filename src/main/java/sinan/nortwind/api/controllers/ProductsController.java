package sinan.nortwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sinan.nortwind.business.abstracts.ProductService;
import sinan.nortwind.core.utilities.results.DataResult;
import sinan.nortwind.core.utilities.results.Result;
import sinan.nortwind.entities.concretes.Product;
import sinan.nortwind.entities.dtos.ProductWithCategoryDto;

import javax.xml.crypto.Data;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	//@Autowired
	private final ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Product>> getAll() {
		return productService.getAll();
	}

	@GetMapping("/getAllPageable")
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		return productService.getAll(pageNo, pageSize);
	}

	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return productService.add(product);
	}

	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName) {
		return productService.getByProductName(productName);
	}

	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam String productName,@RequestParam int categoryId) {
		return productService.getByProductNameAndCategoryId(productName, categoryId);
	}

	@GetMapping("/getByProductNameOrCategoryId")
	public DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam String productName,@RequestParam int categoryId) {
		return productService.getByProductNameOrCategoryId(productName, categoryId);
	}

	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return productService.getByProductNameContains(productName);
	}

	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllSorted() {
		return productService.getAllSorted();
	}

	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return productService.getProductWithCategoryDetails();
	}

}
