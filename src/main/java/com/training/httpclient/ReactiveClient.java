package com.training.httpclient;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ReactiveClient {

	public static void main(String[] args) throws Exception {
		
		//long start = System.currentTimeMillis();
		
		Observable.range(0, 10)
			.flatMap(num -> Observable.just(num)
										.subscribeOn(Schedulers.io())
										.map(i -> NonReactiveClient.getStockQuoteJson(i)))
			
			.subscribe(System.out::println);
		
//		for(int i=0;i<10;i++) {
//			String json = getStockQuoteJson(i);
//			System.out.println(json);
//		}
//		
		
		Thread.sleep(11000);
		//long stop = System.currentTimeMillis();
		//System.out.println("Time taken: "+(stop - start)+" ms.");

	}

}
