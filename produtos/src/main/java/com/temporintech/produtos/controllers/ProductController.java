package com.temporintech.produtos.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.temporintech.produtos.dtos.ProducRecordtDTO;
import com.temporintech.produtos.models.ProductModel;
import com.temporintech.produtos.repositories.ProductRepository;

import jakarta.validation.Valid;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@PostMapping("/products")
	public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProducRecordtDTO producRecordtDTO) {
		var productModel = new ProductModel();
		BeanUtils.copyProperties(producRecordtDTO, productModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
	}

	@GetMapping("/products")
	public ResponseEntity<List<ProductModel>> getAllProduct() {
		return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id") UUID id) {
		Optional<ProductModel> product = productRepository.findById(id);
		if (product.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");

		return ResponseEntity.status(HttpStatus.OK).body(product.get());
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id,
			@RequestBody @Valid ProducRecordtDTO producRecordtDTO) {
		Optional<ProductModel> product = productRepository.findById(id);
		if (product.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");

		var productModel = product.get();
		BeanUtils.copyProperties(producRecordtDTO, productModel);
		return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
	}
}