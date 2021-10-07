package com.training.ex1;

import io.reactivex.rxjava3.core.Observable;

public class ObservableCreateUsingEmitter {
	public static void main(String[] args) {
		Observable<String> source = Observable.create(emitter -> {
			emitter.onNext("Alpha");
			emitter.onNext("Beta");
			emitter.onNext("Gamma");
			emitter.onComplete();
		});
		source.subscribe(s -> System.out.println("RECEIVED: " + s));
	}

}
