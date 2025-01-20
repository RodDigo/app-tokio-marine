package com.tokio.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.tokio.domain.AbstractEntity;

public class AbstractController {

	ModelMapper modelMapper = new ModelMapper();

	protected <D, T> D convertToDTO(final T model, final Class<D> dtoClass) {
		return model != null ? modelMapper.map(model, dtoClass) : null;
	}

	protected <D, E extends AbstractEntity<I>, I extends Serializable> E convertToEntity(final D dto,
			final Class<E> entityClass) {
		return modelMapper.map(dto, entityClass);
	}


	protected <D, E> List<E> converToEntitys(final Class<E> entityClass, List<D> dtos) {

		List<E> entityClasses = new ArrayList<E>();
		dtos.forEach(d -> {
			modelMapper.map(d, entityClass);
		});
		return entityClasses;
	}

	protected <E, D> List<D> converToDtos(Class<D> dto, final List<E> entityClasses) {
		List<D> dtos = new ArrayList<D>();
		entityClasses.forEach(e -> { 
			dtos.add(modelMapper.map(e, dto)); 
		});
		return dtos;
	}

}
