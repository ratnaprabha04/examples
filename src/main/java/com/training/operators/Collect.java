package com.training.operators;

import java.util.HashSet;

import io.reactivex.rxjava3.core.Observable;

public class Collect {
	
	public static void main(String[] args) {
		Observable.just("Alpha", "Beta", "Gamma", "Beta")
		.collect(HashSet<String>::new, HashSet::add)
		.subscribe(s -> System.out.println("Received: " + s));
		}

}
