package com.temporintech.produtos.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PRODUCTS")
public class ProductModel implements Serializable{

	private static final long serialVersionUID = 1L;
}