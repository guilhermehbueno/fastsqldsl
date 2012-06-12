package com.fastsql.sql.builder.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class App {
	
	public static List<Integer> mescla(List<Integer> lista1, List<Integer> lista2){
		List<Integer> all = new ArrayList<Integer>(lista1);
		all.addAll(lista2);
		List<Integer> result = new ArrayList<Integer>();
		int exec = all.size();
		
		for (int i = 0; i < exec; i++) {
			Integer menor = null;
			for (Integer integer : all) {
				if(menor==null){
					menor = integer;
				}
				
				if(menor>integer){
					menor = integer;
				}
			}
			result.add(menor);
			all.remove(menor);
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		a.add(5);
		a.add(4);
		a.add(3);
		
		List<Integer> b = new ArrayList<Integer>();
		b.add(2);
		b.add(1);
		b.add(0);
		
		List<Integer> result = mescla(a, b);
		
		System.out.println(StringUtils.join(result,", "));
	}
	

}
