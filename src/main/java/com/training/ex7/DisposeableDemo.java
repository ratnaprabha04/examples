package com.training.ex7;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

public class DisposeableDemo {

	public static void main(String[] args) {
		Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);
		Disposable disposable = seconds.subscribe(l -> System.out.println("Receiver 1: " + l));
		// sleep 5 seconds
		sleep(5000);
		// dispose and stop emissions
		disposable.dispose();
		
		Disposable d2 = seconds.subscribe(l -> System.out.println("Receiver 2: " + l));
		// sleep 5 seconds to prove
		// there are no more emissions
		sleep(5000);
		
		
	}

	private static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
