/**
 * 
 */
package com.globemart.pricing;

import static org.junit.Assert.assertNotNull;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.globemart.pricing.service.IPricingService;

/**
 * Test case for Glob Mart Pricing Service NOTE: Please uncomment the @Test
 * annotations only when GlobMart Product Catalogue Service is up and running
 * and some data already exists
 * 
 * @author kartik.raina
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

	@Autowired
	private IPricingService pricingService;

	private String productName = "Sony Bravia LED";
	private Long productId = 1L;

	// @Test
	public void testSearchByName() {
		System.out.println("Search of product price by product name: " + productName);
		assertNotNull(pricingService.getProductPriceByName(productName));
	}

	// @Test
	public void testSearchById() {
		System.out.println("Searching of product price by product id: " + productId);
		assertNotNull(pricingService.getProductPriceById(productId));
	}
}
