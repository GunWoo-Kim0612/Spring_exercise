package com.springbook.ioc.injection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CollectionBean {
	private List<String> addressList;
	private Set<String> addressSet;
	private Map<String, String> addressMap;
	private Properties  addressProps;
	
}
