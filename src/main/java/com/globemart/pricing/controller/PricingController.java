/**
 * 
 */
package com.globemart.pricing.controller;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.globemart.pricing.interfaces.ApplicationConstants;
import com.globemart.pricing.service.IPricingService;

/**
 * Controller class of Pricing Service
 * 
 * @author Kartik Raina
 *
 */
@RestController
public class PricingController {

	@Autowired
	IPricingService pricingService;

	@Autowired
	Environment env;

	@GetMapping("/product/pricing/name/{name}")
	ResponseEntity<String> getByNameProductPrice(@PathVariable(value = "name") String productName) {
		String result = pricingService.getProductPriceByName(productName);
		return result != null ? new ResponseEntity<String>(result, HttpStatus.OK)
				: new ResponseEntity<String>(MessageFormat.format(
						(String) env.getProperty(ApplicationConstants.ERROR_MESSAGE_BY_NAME_PROPERTY), productName),
						HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/product/pricing/id/{id}")
	ResponseEntity<String> getByIdProductPrice(@PathVariable(value = "id") Long productId) {
		String result = pricingService.getProductPriceById(productId);
		return result != null ? new ResponseEntity<String>(result, HttpStatus.OK)
				: new ResponseEntity<String>(
						MessageFormat.format(
								(String) env.getProperty(ApplicationConstants.ERROR_MESSAGE_BY_ID_PROPERTY), productId),
						HttpStatus.BAD_REQUEST);
	}
}
