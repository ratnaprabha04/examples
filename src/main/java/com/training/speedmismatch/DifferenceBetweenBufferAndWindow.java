package com.training.speedmismatch;

import io.reactivex.rxjava3.core.Observable;

public class DifferenceBetweenBufferAndWindow {

	public static void main(String[] args) {
		Observable.range(1, 50)
		.buffer(8)
		.subscribe(s -> System.out.println(s.getClass().getName()));
		
		System.out.println("_________________________________");
		
		Observable.range(1, 50)
		.window(8)
		.subscribe(s -> System.out.println(s.getClass().getName()));

	}
	
	

}
