package com.training.backpressure;

import io.reactivex.rxjava3.core.Observable;

public class NoNeedForBackPressure {
	
	public static void main(String[] args) {
		Observable.range(1, 999_999_999)
		.map(MyItem::new)
		.subscribe(myItem -> {
		sleep(50);
		System.out.println("Received MyItem " + myItem.id);
		});
		}
	
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
