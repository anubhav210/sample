package com.div.sample;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;

@Table(name = "shop")
@Entity
@Builder
public class Shop {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column
	String shopName;

	@OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
	Set<Product> product;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;

	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

}
