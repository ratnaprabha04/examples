package com.training.operators;

import io.reactivex.rxjava3.core.Observable;

public class ToList {
	
	public static void main(String[] args) {
		Observable.just("Alpha", "Beta", "Gamma")
		.toList()
		.subscribe(s -> System.out.println("Received: " + s));
		}


}
