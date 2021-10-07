package com.training.operators;

import io.reactivex.rxjava3.core.Observable;

public class DefaultIfEmpty {
	
	public static void main(String[] args) {
		Observable<String> items = Observable.just("Alpha", "Beta");
		items.filter(s -> s.startsWith("Z"))
		.defaultIfEmpty("None")
		.subscribe(System.out::println);
		}

}
