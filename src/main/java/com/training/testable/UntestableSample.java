package com.training.testable;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class UntestableSample {

	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		
		l.add("real 1  ");
		l.add("real 2 ");
		l.add("real 3   ");
		
		Observable
		.fromIterable(l)
		.map(s -> s.length())
		.map(i -> i * 2)
		.subscribe(System.out::println);

	}

}
