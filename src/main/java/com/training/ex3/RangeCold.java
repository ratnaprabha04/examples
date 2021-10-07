package com.training.ex3;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class RangeCold {
	public static void main(String[] args) {
		Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);
		// Observer 1
		seconds.subscribe(l -> System.out.println("Observer 1: " + l));
		// sleep 3 seconds
		sleep(3000);
		// Observer 2
		seconds.subscribe(l -> System.out.println("Observer 2: " + l));
		// sleep 3 seconds
		sleep(3000);
	}

	private static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
