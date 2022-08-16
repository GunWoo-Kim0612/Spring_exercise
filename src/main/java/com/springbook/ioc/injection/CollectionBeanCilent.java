package com.springbook.ioc.injection;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanCilent {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		

		
		  CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");
		  List<String> addressList = bean.getAddressList();
		  System.out.println("==============List================= ");

		  for(String address : addressList) {
			  System.out.println("List" + address);
		  }
		  
		  CollectionBean bean2 = (CollectionBean)factory.getBean("collectionBean");
		  Set<String> addressSet = bean2.getAddressSet();
		  
		  System.out.println("==============Set================= ");
		  for(String address2 : addressSet) { 
			  System.out.println("set" + address2); 
			  }
		 
		
		
		CollectionBean bean3 =  (CollectionBean)factory.getBean("collectionBean");
		Map<String, String> addressMap = bean3.getAddressMap();
		
		System.out.println("==============Map================= ");
		System.out.println("고길동에 대한 value = " + addressMap.get("고길동"));
		System.out.println("홍길동에 대한 value = " + addressMap.get("홍길동"));
		
		CollectionBean bean4 =  (CollectionBean)factory.getBean("collectionBean");

		Properties addressProps = (Properties)bean4.getAddressProps();
		System.out.println("==============Properties================= ");

		
		
		
		for(String key : addressProps.stringPropertyNames()){
			System.out.println("key : " + key + " value = "+ addressProps.get(key));
		}
		
		System.out.println("Mission 뭐한건데이게 ");
		addressMap.forEach((strKey, strVal) ->
		{
			System.out.println(strKey + ":" + strVal);
		});

		Iterator<String> keys = addressMap.keySet().iterator();
	      while( keys.hasNext() ){
	         String key = keys.next();
	         System.out.println( String.format("키 : %s, 값 : %s", key, addressMap.get(key)) );
	      }

		
	}

}
