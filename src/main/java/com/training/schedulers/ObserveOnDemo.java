package com.training.schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ObserveOnDemo {

	public static void main(String[] args) {
		Observable.just("WHISKEY/27653/TANGO",
				"6555/BRAVO","232352/5675675/FOXTROT")
				.subscribeOn(Schedulers.io()) //Starts on I/O scheduler
				.flatMap(s -> Observable.fromArray(s.split("/")))
				.observeOn(Schedulers.computation()) //Switches to
				// computation scheduler
				.filter(s -> s.matches("[0-9]+"))
				.map(Integer::valueOf)
				.reduce((total, next) -> total + next)
				.subscribe(i -> System.out.println("Received " + i +
				" on thread " + Thread.currentThread().getName()));
				sleep(1000);

	}
	
	
	
	
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
