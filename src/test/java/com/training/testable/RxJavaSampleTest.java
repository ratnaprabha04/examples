package com.training.testable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.reactivex.rxjava3.observers.TestObserver;

class RxJavaSampleTest {

	@Test
	void testBuildPipeline() throws Exception {
		//AAA
		//Arrange
		Sample objectUnderTest = new Sample();
		DataProvider mockProvider = Mockito.mock(DataProvider.class);
		objectUnderTest.setProvider(mockProvider);
		List<String> testData = new ArrayList<>();
		testData.add("one");
		testData.add("four");
		testData.add("three");
		
		Mockito.when(mockProvider.getDataFromDB()).thenReturn(testData);
		
		TestObserver<Integer> testObserver = new TestObserver<>();
		assertFalse(testObserver.hasSubscription());
		//Act
		objectUnderTest.buildPipeLine().subscribe(testObserver);
		//Assert
		assertTrue(testObserver.hasSubscription());
		
		testObserver.await();
		
		testObserver.assertComplete();
		
		testObserver.assertValueCount(3);
		
		testObserver.assertValues(6,8,10);
		
	}

}
