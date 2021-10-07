package com.training.speedmismatch;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class TimeBasedWindowing {

	public static void main(String[] args) {
		Observable.interval(300, TimeUnit.MILLISECONDS)
		.map(i -> (i + 1) * 300)
		.window(1, TimeUnit.SECONDS)
		.flatMapSingle(obs -> obs.reduce("", (total, next) ->
		total + (total.equals("") ? "" : "|") + next))
		.subscribe(System.out::println);
		sleep(5000);
		}
	
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
