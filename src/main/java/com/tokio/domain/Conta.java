package com.tokio.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Conta extends AbstractEntity<Integer> {
	
	private Double valor;
	private String  titular;

}
