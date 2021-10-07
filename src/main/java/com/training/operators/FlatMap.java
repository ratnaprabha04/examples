package com.training.operators;

import io.reactivex.rxjava3.core.Observable;

public class FlatMap {
	
	
	public static void main(String[] args) {
		Observable<String> source =
		Observable.just("Alpha", "Beta", "Gamma");
		source.flatMap(s -> Observable.fromArray(s.split("")))
		.subscribe(System.out::println);
		}

}
