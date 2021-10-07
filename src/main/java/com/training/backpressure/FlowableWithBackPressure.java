package com.training.backpressure;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FlowableWithBackPressure {
	
	public static void main(String[] args) {
		Flowable.range(1, 999_999_999)
		.map(MyItem::new)
		.observeOn(Schedulers.io())
		.subscribe(myItem -> {
		sleep(50);
		System.out.println("Received MyItem " + myItem.id);
		});
		sleep(Long.MAX_VALUE);
		}
	
	
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
