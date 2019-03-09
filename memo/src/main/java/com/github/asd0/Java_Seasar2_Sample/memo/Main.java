package com.github.asd0.Java_Seasar2_Sample.memo;

import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.framework.util.StringUtil;

import com.github.asd0.Java_Seasar2_Sample.memo.service.SampleService;
import com.github.asd0.Java_Seasar2_Sample.memo.service.SampleService2;

public class Main {

	private static final String DI_CONFIG_PATH = "di-config.xml";

	public static void main(String args[]) {

		System.out.println(System.getProperties());


		System.out.println("Main Start\n");

		SingletonS2ContainerFactory.setConfigPath(DI_CONFIG_PATH);
		SingletonS2ContainerFactory.init();
		S2Container container = SingletonS2ContainerFactory.getContainer();
		showComponentList(container);
		System.out.println();

		SampleService sampleService = (SampleService) container.getComponent(SampleService.class);
		sampleService.serviceSample();

		SampleService2 sampleService2 = (SampleService2) container.getComponent(SampleService2.class);
		sampleService2.serviceSample();

		container.destroy();

		System.out.println("\nMain End");
	}

	/**
	 * 登録しているコンポートを表示する。
	 * @param container コンテナ
	 */
	private static void showComponentList(S2Container container) {
		for (int i = 0; i < container.getComponentDefSize(); i++) {
			String componentName = container.getComponentDef(i).getComponentName();
			Class className = container.getComponentDef(i).getComponentClass();
			if (StringUtil.isNotEmpty(componentName) && className != null) {
				System.out.println("コンポーネント：" + componentName + ", クラス名：" + className.toString());
			}
		}
	}
}
