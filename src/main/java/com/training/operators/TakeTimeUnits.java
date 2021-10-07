package com.training.operators;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class TakeTimeUnits {

	public static void main(String[] args) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("ss:SSS");
		System.out.println(LocalDateTime.now().format(f));
		Observable.interval(300, TimeUnit.MILLISECONDS).take(2, TimeUnit.SECONDS)
				.subscribe(i -> System.out.println(LocalDateTime.now().format(f) + " RECEIVED: " + i));
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
