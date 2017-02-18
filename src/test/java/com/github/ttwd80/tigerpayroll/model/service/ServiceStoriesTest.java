package com.github.ttwd80.tigerpayroll.model.service;

import static org.jbehave.core.reporters.Format.*;

import java.util.ArrayList;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

public class ServiceStoriesTest extends JUnitStories {
	@Override
	protected List<String> storyPaths() {
		final List<String> list = new ArrayList<>();
		list.add("com/github/ttwd80/tigerpayroll/model/service/UserDetailsServiceImpl.story");
		return list;
	}

	@Override
	public Configuration configuration() {
		final StoryReporterBuilder storyReporterBuilder = new StoryReporterBuilder();
		storyReporterBuilder.withDefaultFormats();
		storyReporterBuilder.withFormats(CONSOLE, HTML);
		final MostUsefulConfiguration configuration = new MostUsefulConfiguration();
		configuration.useStoryReporterBuilder(storyReporterBuilder);
		return configuration;
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		final List<Object> list = new ArrayList<>();
		list.add(new UserDetailsServiceImplSteps());
		return new InstanceStepsFactory(configuration(), list);
	}

}
