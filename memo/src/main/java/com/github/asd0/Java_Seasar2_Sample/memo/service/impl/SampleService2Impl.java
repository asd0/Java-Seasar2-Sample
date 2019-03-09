package com.github.asd0.Java_Seasar2_Sample.memo.service.impl;

import com.github.asd0.Java_Seasar2_Sample.memo.service.SampleService2;

public class SampleService2Impl implements SampleService2 {

	@Override
	public boolean serviceSample() {
		System.out.println("DIできたかな？SampleService2");
		return true;
	}

}
