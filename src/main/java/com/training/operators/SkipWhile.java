package com.training.operators;

import io.reactivex.rxjava3.core.Observable;

public class SkipWhile {
	
	public static void main(String[] args) {
		Observable.range(1, 100)
		.skipWhile(i -> i <= 95)
		.subscribe(i -> System.out.println("RECEIVED: " + i));
		}

}
