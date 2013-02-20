/*
 * Copyright 2005-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.ws.jaxws.soapenc;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlSchema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;
import org.springframework.ws.jaxws.server.endpoint.support.NamespaceUtils;

/**
 * <p></p>
 *
 * @author Grzegorz Grzybek
 */
public class JwsJaxbContextFactory {

	private static Logger log = LoggerFactory.getLogger(JwsJaxbContextFactory.class.getName());

	/**
	 * <p>Creates {@link JAXBContext} using provided classes.</p>
	 * <p>see: com.sun.xml.bind.v2.ContextFactory.createContext(Class[], Map<String, Object>)</p>
	 * 
	 * @param classesToBeBound
	 * @param properties
	 * @return
	 */
	public static JAXBContext createContext(Class<?>[] classesToBeBound, Map<String, ?> properties) {
		return new JwsJaxbContext(classesToBeBound, properties);
	}

	/**
	 * <p>Determines mapped classes in the context path and invokes {@link #createContext(Class[], Map)}</p>
	 * <p>JAXB-RI uses {@code ObjectFactory} class and/or {@code jaxb.index} file</p>
	 * <p>see: com.sun.xml.bind.v2.ContextFactory.createContext(String, ClassLoader, Map<String, Object>)</p>
	 * 
	 * @param contextPath
	 * @param classLoader
	 * @param properties
	 * @return
	 * @throws IOException 
	 */
	public static JAXBContext createContext(String contextPath, ClassLoader classLoader, Map<String, ?> properties) throws IOException {
		Assert.notNull(contextPath, "The contextPath should not be null");

		PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver(classLoader);
		MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resourcePatternResolver);

		List<Class<?>> classes = new LinkedList<Class<?>>();
		// scan the package(s)
		String[] packages = StringUtils.tokenizeToStringArray(contextPath, ":");
		for (String pkg: packages) {
			log.trace("Scanning package: {}", pkg);
			Resource[] resources = resourcePatternResolver.getResources(ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + ClassUtils.convertClassNameToResourcePath(pkg) + "/*.class");
			for (Resource classResource: resources) {
				MetadataReader mdReader = metadataReaderFactory.getMetadataReader(classResource);
				Class<?> cls = ClassUtils.resolveClassName(mdReader.getClassMetadata().getClassName(), classLoader);
				if (cls.getSimpleName().equals("package-info")) {
					XmlSchema xmlSchema = AnnotationUtils.getAnnotation(cls.getPackage(), XmlSchema.class);
					String namespace = xmlSchema == null ? NamespaceUtils.packageNameToNamespace(cls.getPackage()) : xmlSchema.namespace();
					log.trace(" - found package-info: {}, namespace: {}", cls.getPackage().getName(), namespace);
				} else {
					log.trace(" - found class: {}", mdReader.getClassMetadata().getClassName());
					classes.add(cls);
				}
			}
		}

		return createContext(classes.toArray(new Class[0]), properties);
	}

	/**
	 * @param contextPath
	 * @param classLoader
	 * @return
	 * @throws IOException 
	 */
	public static JAXBContext createContext(String contextPath, ClassLoader classLoader) throws IOException {
		return createContext(contextPath, classLoader, Collections.<String, Object> emptyMap());
	}

}