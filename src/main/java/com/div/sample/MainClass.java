package com.div.sample;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainClass {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Shop shop = Shop.builder().shopName("CLICH").build();
		Set<Product> prods = new HashSet<>();
		prods.add(Product.builder().productName("Bill").id(1).shop(shop).build());
		shop.setProduct(prods);

		session.saveOrUpdate(shop);
//		System.out.println(shop.getId());

//		Product product = Product.builder().shop(Shop.builder().id(4).build()).productName("Mango").build();
//		session.save(product);

		transaction.commit();
//		System.out.println(shop.getId());

	}

}
