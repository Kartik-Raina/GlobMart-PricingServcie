/**
 * 
 */
package com.globemart.pricing.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.globemart.pricing.interfaces.ApplicationConstants;
import com.globemart.pricing.pojo.ProductPrice;
import com.globemart.pricing.service.IPricingService;

/**
 * This class implements {@link IPricingService}}
 * 
 * @author Kartik Raina
 *
 */
@Service
public class PricingServiceImpl implements IPricingService {

	@Autowired
	private Environment env;

	private RestTemplate restTemplate = new RestTemplate();

	private ObjectMapper objectMapper = new ObjectMapper();

	private static final Logger logger = LoggerFactory.getLogger(PricingServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.globemart.pricing.service.IPricingService#getProductPriceById(java.
	 * lang.Long)
	 */
	@Override
	public String getProductPriceById(Long productId) {
		try {
			String result = restTemplate
					.getForObject(env.getProperty(ApplicationConstants.PRODUCT_CATALOGUE_SERVCIE_BASE_PATH_PROPERTY)
							+ env.getProperty(ApplicationConstants.PRODUCT_CATALOGUE_SERVCIE_PRODUCT_BY_ID_PROPERTY)
							+ productId, String.class);
			if (result != null) {
				return objectMapper.writerWithDefaultPrettyPrinter()
						.writeValueAsString(objectMapper.readValue(result, ProductPrice.class));

			}

		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.globemart.pricing.service.IPricingService#getProductPriceByName(java.
	 * lang.String)
	 */
	@Override
	public String getProductPriceByName(String productName) {
		try {
			ResponseEntity<ProductPrice[]> responseEntity = restTemplate
					.getForEntity(env.getProperty(ApplicationConstants.PRODUCT_CATALOGUE_SERVCIE_BASE_PATH_PROPERTY)
							+ env.getProperty(ApplicationConstants.PRODUCT_CATALOGUE_SERVCIE_PRODUCT_BY_NAME_PROPERTY)
							+ productName, ProductPrice[].class);

			return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseEntity.getBody());

		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
		}

		return null;
	}

}
