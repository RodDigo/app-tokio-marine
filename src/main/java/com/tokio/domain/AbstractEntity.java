package com.tokio.domain;

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class AbstractEntity<I extends Serializable> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected I id;
}
