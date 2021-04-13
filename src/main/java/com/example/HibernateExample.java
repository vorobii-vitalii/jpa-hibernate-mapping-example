package com.example;

import com.example.entity.Product;
import com.example.entity.ProductDetails;
import com.example.entity.ProductsDetailsName;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.UUID;

public class HibernateExample {

    private static Product getExampleProduct() {
        var product = new Product();

        product.setUuid(UUID.randomUUID().toString());
        product.setVersion(1L);
        product.setLastSeenInImportDate(LocalDate.now());

        return product;
    }

    private static ProductDetails getExampleProductDetails() {
        var productDetails = new ProductDetails();

        var productDetailsName = new ProductsDetailsName();

        productDetailsName.setName("Name");
        productDetailsName.setShortName("ShortName");

        productDetails.setDescription("Description");
        productDetails.setProductsDetailsName(productDetailsName);
        productDetails.setLocale("Locate");
        productDetails.setVersion(2L);

        return productDetails;
    }

    public static void main(String[] args) {

        SessionFactory sessionFactory =
                new Configuration()
                    .configure()
                    .buildSessionFactory();

        Session session = sessionFactory.openSession();

        var product = getExampleProduct();

        var productDetails = getExampleProductDetails();

        product.setProductDetails(productDetails);

        try {
            session.beginTransaction();

            session.save(product);

            System.out.println("Persisted product: " + product);
            System.out.println("Persisted product details: " + productDetails);

            session.remove(product);

            session.getTransaction().commit();
        }
        finally {
            session.close();
        }

        sessionFactory.close();
    }

}
