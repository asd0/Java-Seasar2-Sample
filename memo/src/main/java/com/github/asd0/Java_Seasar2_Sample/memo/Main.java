package com.github.asd0.Java_Seasar2_Sample.memo;

import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;

public class Main {

	private static final String DI_CONFIG_PATH = "com/github/asd0/Java_Seasar2_Sample/memo/di-config.xml";

	public static void main(String args[]) {

		System.out.println("Main Start\n");

		SingletonS2ContainerFactory.setConfigPath(DI_CONFIG_PATH);
		SingletonS2ContainerFactory.init();
		S2Container container = SingletonS2ContainerFactory.getContainer();
		SampleService component = (SampleService) container.getComponent(SampleService.class);

		component.serviceSample();

		container.destroy();

		System.out.println("\nMain End");
	}
}
