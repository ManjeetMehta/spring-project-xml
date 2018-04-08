package com.mehta.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.jcs.JCS;
import org.apache.commons.jcs.access.CacheAccess;

public class JcsExample {
	
	public static void main(String[] args) {
		try {
				CacheAccess<Object, Object> cache = JCS.getInstance("default");
				
				List<Object> cityList = new ArrayList<Object>(0);
				for (int i = 1; i <= 10; i++){
					cityList.add(new City("N" + i, "C" + i, i));
				}
				cache.put(1, cityList);
				System.out.println("\n\nsuccessfully data stored in cache : " + cache.get(1));
				
				
				List<Object> cityList1 = new ArrayList<Object>(0);
				for (int j = 100; j <= 150; j++){
					cityList1.add(new City("N" + j, "C" + j, j));
				}
				cache.put('a', cityList1);
				System.out.println("\n\nsuccessfully data stored in cache : " + cache.get(1));
				System.out.println("successfully data stored in cache : " + cache.get('a'));
				
				List<Object> cityList2 = new ArrayList<Object>(0);
				cityList2.addAll(cityList1);
				cityList2.addAll(cityList);
				cache.put("a", cityList2);
				
				System.out.println("\n\nsuccessfully data stored in cache : " + cache.get(1));
				System.out.println("successfully data stored in cache : " + cache.get('a'));
				System.out.println("successfully data stored in cache : " + cache.get("a"));
				
				System.out.println("successfully data stored in cache : " + cache.getStats());
		} catch (Exception e) {
			System.out.println("Exception while putting data in cache :" + e);
		}finally{System.runFinalization();}
	}
	
}


class City implements Serializable {
	public String name;
	public String country;
	public int population;
	static FileInputStream fileInputStream = null;
	static File file = new File("/home/satyaprakash/abc.txt");
	byte[] bFile;

	public City(String name, String country, int population) {
		this.name = name;
		this.country = country;
		this.population = population;
		try {
			bFile = new byte[(int) file.length()];
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return String.format("Name : " + name + ", Country : " + country + ", Population : " + population
				+ ", file Data : " + bFile.length);
	}
}