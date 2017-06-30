/**
 * 
 */
package com.globemart.pricing.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The POJO class that is showed as JSON String to represent data.
 * 
 * @author kartik.raina
 *
 */
public class ProductPrice {

	String name;

	Float price;

	@JsonIgnore
	String description;

	@JsonIgnore
	String type;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductPrice [name=" + name + ", price=" + price + "]";
	}

}
