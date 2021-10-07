package com.training.schedulers;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

import io.reactivex.rxjava3.core.Observable;

public class BeforeParallel {

	public static void main(String[] args) {
		Observable.range(1, 10)
			.map(i -> intenseCalculation(i))
			.subscribe(i -> System.out.println("Received " + i + " " + LocalTime.now()));
	}

	
	
	
	
	
	public static <T> T intenseCalculation(T value) {
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
