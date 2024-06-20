package com.temporintech.produtos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.temporintech.produtos.repositories.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;
}