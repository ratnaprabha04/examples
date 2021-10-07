package com.training.operators;

import io.reactivex.rxjava3.core.Observable;

public class StartWithArray {
	
	public static void main(String[] args) {
		Observable<String> menu =
		Observable.just("Coffee", "Tea", "Espresso", "Latte");
		//print menu
		menu.startWithArray("COFFEE SHOP MENU", "----------------")
		.subscribe(System.out::println);
		}

}
