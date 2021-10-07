package com.training.backpressure;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NeedForBackPressure {
	
	public static void main(String[] args) {
		Observable.range(1, 100)
		.map(MyItem::new)
		.observeOn(Schedulers.io())
		.subscribe(myItem -> {
		sleep(50);
		System.out.println("Received MyItem " + myItem.id);
		});
		
		
		sleep(10000);
		}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
