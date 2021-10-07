package com.training.ex5;

import io.reactivex.rxjava3.core.Observable;

public class BeforeCallable {

	public static void main(String[] args) {
		Observable.just(1).map(i -> i / 0).subscribe(i -> System.out.println("RECEIVED: " + i),
				e -> System.out.println("Error captured: " + e));
	}

}
