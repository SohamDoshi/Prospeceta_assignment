package com.masai.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Entry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@JsonProperty("API")
	private String api;

	@JsonProperty("Link")
	private String link;

	@JsonProperty("Description")
	private String description;

	@JsonProperty("Auth")
	private String auth;

	@JsonProperty("Https")
	private boolean HTTPS;

	@JsonProperty("Cors")
	private String cors;

	@JsonProperty("Category")
	private String category;
}
