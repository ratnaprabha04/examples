package com.training.schedulers;

import java.util.concurrent.ThreadLocalRandom;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MultipleObserversSameThread {
	
	public static void main(String[] args) {
		Observable<Integer> lengths =
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
		.subscribeOn(Schedulers.computation())
		.map(MultipleObserversSameThread::intenseCalculation)
		.map(String::length)
		.publish()
		.autoConnect(2);
		lengths.subscribe(i -> System.out.println("Received " + i +
		" on thread " + Thread.currentThread().getName()));
		lengths.subscribe(i -> System.out.println("Received " + i +
		" on thread " + Thread.currentThread().getName()));
		sleep(10000);
		}
	
	
	private static <T> T intenseCalculation(T value) {
		sleep(ThreadLocalRandom.current().nextInt(3000));
		return value;
	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
