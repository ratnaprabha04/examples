package com.training.speedmismatch;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class TimeBasedBuffering {
	
	public static void main(String[] args) {
		Observable.interval(300, TimeUnit.MILLISECONDS)
		.map(i -> (i + 1) * 300)
		.buffer(1, TimeUnit.SECONDS)
		.subscribe(System.out::println);
		sleep(4000);
		}
	
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
