package br.com.cariuska.financialAPI.util;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;

public class ModelConvert {
	

	public static <E, T> E convertModelMapper(T source, Type destinationType){
		
		E model = null;
		if (source != null && destinationType != null) {

			ModelMapper modelMapper = new ModelMapper();
			model = modelMapper.map(source, destinationType);
		}
		return model;
	}
	
	public static <E, T> List<E> convertModelMapper(List<T> source, Type destinationType){
		
		List<E> model = null;
		if (source != null && destinationType != null) {

			ModelMapper modelMapper = new ModelMapper();
			model = modelMapper.map(source, destinationType);
		}
		return model;
	}

}
