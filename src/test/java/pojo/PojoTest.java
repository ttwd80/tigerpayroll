package pojo;

import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.Scanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import com.google.common.base.Predicate;
import com.mysema.query.types.path.EntityPathBase;

public class PojoTest {

	final String packageName = "com.github.ttwd80.tigerpayroll.model.entity";

	@Test
	public void testEntities() throws Exception {
		final Set<Class<?>> classes = listClasses(packageName, Object.class);
		for (final Class<?> c : classes) {
			processEntity(c);
		}
	}

	private void processEntity(final Class<?> c) throws Exception {
		System.out.println(c.getName());
		processConstructors(c);
	}

	private void processConstructors(final Class<?> c) throws Exception {
		final Constructor<?>[] ctors = c.getConstructors();
		for (final Constructor<?> ctor : ctors) {
			final Class<?>[] paramTypes = ctor.getParameterTypes();
			final Object[] params = createParams(paramTypes);
			ctor.newInstance(params);
		}
	}

	private Object[] createParams(final Class<?>[] paramTypes) {
		final int c = paramTypes.length;
		final Object[] params = new Object[c];
		for (int i = 0; i < c; i++) {
			params[i] = createValue(paramTypes[i]);
		}
		return params;
	}

	private Object createValue(final Class<?> c) {
		if (c.isPrimitive()) {
			return createPrimitive(c);
		} else {
			return null;
		}
	}

	private Object createPrimitive(final Class<?> c) {
		if (c == int.class) {
			return Integer.valueOf(0);
		} else if (c == long.class) {
			return Long.valueOf(0);
		} else if (c == boolean.class) {
			return Boolean.FALSE;
		} else if (c == float.class) {
			return Float.valueOf(0.00f);
		} else if (c == double.class) {
			return Double.valueOf(0.00d);
		} else if (c == char.class) {
			return Character.valueOf(' ');
		} else if (c == byte.class) {
			return " ".getBytes()[0];
		} else {
			throw new RuntimeException("unknown class = " + c.getName());
		}
	}

	@Test
	public void testQueryDsl() {
		final Set<Class<?>> classes = listClasses(packageName, EntityPathBase.class);
		for (final Class<?> c : classes) {
			System.out.println(c.getName());
		}
	}

	private <T> Set<Class<?>> listClasses(final String packageName, final Class<T> baseClass) {
		final ClassLoader[] classLoaders = new ClassLoader[2];
		classLoaders[0] = ClasspathHelper.contextClassLoader();
		classLoaders[1] = ClasspathHelper.staticClassLoader();

		final String filterRegex = FilterBuilder.prefix(packageName);
		final FilterBuilder filterBuilder = new FilterBuilder();
		final Predicate<String> filter = filterBuilder.include(filterRegex);
		final Scanner subTypeScanner = new SubTypesScanner(false);
		final Scanner resourceScanner = new ResourcesScanner();
		final ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();

		final Collection<URL> urls = ClasspathHelper.forClassLoader(classLoaders);
		configurationBuilder.setScanners(subTypeScanner, resourceScanner);
		configurationBuilder.setUrls(urls);
		configurationBuilder.filterInputsBy(filter);
		final Reflections reflections = new Reflections(configurationBuilder);
		final Set<Class<? extends T>> set = reflections.getSubTypesOf(baseClass);
		final Set<Class<?>> result = new LinkedHashSet<>(set);
		return result;

	}
}
