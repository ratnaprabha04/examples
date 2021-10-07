package com.training.ex6;

import io.reactivex.rxjava3.core.Completable;

public class CompletableDemo {

	public static void main(String[] args) {
		Completable.fromRunnable(
				() -> runProcess())
		.subscribe(() -> System.out.println("Done!"));
	}

	private static void runProcess() {
		// run process here
	}

}
