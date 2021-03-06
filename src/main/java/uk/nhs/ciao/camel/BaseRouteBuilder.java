package uk.nhs.ciao.camel;

import org.apache.camel.builder.RouteBuilder;

/**
 * Abstract class which provides base / helper methods for route builder implementations
 */
public abstract class BaseRouteBuilder extends RouteBuilder {
	private String internalRoutePrefix;
	
	/**
	 * Path prefix added to all generated internal route URLs (to ensure uniqueness)
	 * @return Internal route prefix value
	 */
	public String getInternalRoutePrefix() {
		return internalRoutePrefix;
	}
	
	/**
	 * Path prefix added to all generated internal route URLs (to ensure uniqueness)
	 * @param internalRoutePrefix Internal route prefix value
	 */
	public void setInternalRoutePrefix(final String internalRoutePrefix) {
		this.internalRoutePrefix = internalRoutePrefix;
	}
	
	protected String internalUri(final String scheme, final String path) {
		final StringBuilder builder = new StringBuilder(scheme).append(":");
		if (internalRoutePrefix != null && !internalRoutePrefix.isEmpty()) {
			builder.append(internalRoutePrefix).append("/");
		}
		builder.append(path);
		return builder.toString();
	}
	
	protected String internalDirectUri(final String path) {
		return internalUri("direct", path);
	}
	
	protected String internalSedaUri(final String path) {
		return internalUri("seda", path);
	}
}
