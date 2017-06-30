/**
 * 
 */
package com.globemart.pricing.service;

import com.globemart.pricing.pojo.ProductPrice;
import com.globemart.pricing.service.impl.PricingServiceImpl;

/**
 * The Service interface 
 * Also see {@link PricingServiceImpl}
 * 
 * @author Kartik Raina
 *
 */
public interface IPricingService {

	/**
	 * This method returns Json String of {@link ProductPrice} by sending the
	 * product id through a Rest request to Product Catalogue Service.
	 * 
	 * @param id
	 *            of the product that has to be searched
	 * 
	 * @return Json String of {@link ProductPrice}
	 */
	String getProductPriceById(Long id);

	/**
	 * This method returns Json String of {@link ProductPrice} List by sending
	 * the product name through a Rest request to Product Catalogue Service.
	 * 
	 * @param productName
	 *            of the product that has to be searched
	 * @return Json String of {@link ProductPrice} List
	 */
	String getProductPriceByName(String productName);

}
