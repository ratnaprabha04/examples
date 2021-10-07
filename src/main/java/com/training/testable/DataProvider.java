package com.training.testable;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
	
	public List<String> getDataFromDB(){
		List<String> l = new ArrayList<>();
		l.add("real 1  ");
		l.add("real 2 ");
		l.add("real 3   ");
		return l;
	}

}
