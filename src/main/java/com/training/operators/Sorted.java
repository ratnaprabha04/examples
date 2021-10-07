package com.training.operators;

import io.reactivex.rxjava3.core.Observable;

public class Sorted {
	
	public static void main(String[] args) {
		Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
		.sorted()
		.subscribe(System.out::print);
		}

}
