package com.training.ex7;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

public class HotDisposable {
	
//	public static void main(String[] args) {
//		ConnectableObservable<Integer> rInts =
//		Observable.interval(300, TimeUnit.MILLISECONDS).map(i -> randomInt()).publish();
//		rInts.subscribe(i -> System.out.println("Observer 1: " + i));
//		rInts.subscribe(i -> System.out.println("Observer 2: " + i));
//		rInts.connect();
//		
//		
//		sleep(2000);
//		}

	public static void main(String[] args) {
		ConnectableObservable<Long> ints = Observable.interval(300, TimeUnit.MILLISECONDS).publish();
		Observable<Integer> rInts = ints.map(i -> randomInt());
		
		
		Disposable d1 = rInts.subscribe(i -> System.out.println("Observer 1: " + i));
		Disposable d2 = rInts.subscribe(i -> System.out.println("Observer 2: " + i));
		
		Disposable dCon = ints.connect();
		
		sleep(2000);
		
		d1.dispose();
		
		sleep(2000);
		
		d2.dispose();
		
		dCon.dispose();
		
		rInts.subscribe(i -> System.out.println("Observer 3: " + i));
		
		sleep(2000);
	}

	public static int randomInt() {
		return ThreadLocalRandom.current().nextInt(100000);
	}
	
	private static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	//v2
	
	
}
