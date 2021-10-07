package com.training.operators;

import io.reactivex.rxjava3.core.Observable;

public class DistinctUntilChanged {
	
	public static void main(String[] args) {
		
//		Observable<Integer> src = Observable.just(1, 1, 1, 2, 2, 3, 3, 2, 1, 1);
//		
//		src.skip(2).subscribe(s -> System.out.println("sub1 "+s));
//		
//		src.skip(2).subscribe(s -> System.out.println("sub2 "+s));
		
		Observable.just(1, 1, 1, 2, 2, 3, 3, 2, 1, 1)
		.distinctUntilChanged()
		.subscribe(i -> System.out.println("RECEIVED: " + i));
		}

}
