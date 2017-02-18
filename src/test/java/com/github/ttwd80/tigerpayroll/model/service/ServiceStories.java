package com.github.ttwd80.tigerpayroll.model.service;

import java.util.ArrayList;
import java.util.List;

import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

public class ServiceStories extends JUnitStories {
	@Override
	protected List<String> storyPaths() {
		final List<String> list = new ArrayList<>();
		list.add("com/github/ttwd80/tigerpayroll/model/service/UserDetailsServiceImpl.story");
		return list;
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		final List<Object> stepInstances = new ArrayList<>();
		stepInstances.add(new UserDetailsServiceImplSteps());
		final MostUsefulConfiguration configuration = new MostUsefulConfiguration();
		return new InstanceStepsFactory(configuration, stepInstances);
	}

}
