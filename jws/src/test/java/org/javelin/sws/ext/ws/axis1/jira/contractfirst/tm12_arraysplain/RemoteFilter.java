/**
 * RemoteFilter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.javelin.sws.ext.ws.axis1.jira.contractfirst.tm12_arraysplain;

@SuppressWarnings("all")
public class RemoteFilter extends org.javelin.sws.ext.ws.axis1.jira.contractfirst.tm12_arraysplain.AbstractNamedRemoteEntity implements java.io.Serializable {
	private java.lang.String author;

	private java.lang.String description;

	private java.lang.String project;

	private java.lang.String xml;

	public RemoteFilter() {
	}

	public RemoteFilter(java.lang.String id, java.lang.String name, java.lang.String author, java.lang.String description, java.lang.String project,
			java.lang.String xml) {
		super(id, name);
		this.author = author;
		this.description = description;
		this.project = project;
		this.xml = xml;
	}

	/**
	 * Gets the author value for this RemoteFilter.
	 * 
	 * @return author
	 */
	public java.lang.String getAuthor() {
		return author;
	}

	/**
	 * Sets the author value for this RemoteFilter.
	 * 
	 * @param author
	 */
	public void setAuthor(java.lang.String author) {
		this.author = author;
	}

	/**
	 * Gets the description value for this RemoteFilter.
	 * 
	 * @return description
	 */
	public java.lang.String getDescription() {
		return description;
	}

	/**
	 * Sets the description value for this RemoteFilter.
	 * 
	 * @param description
	 */
	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	/**
	 * Gets the project value for this RemoteFilter.
	 * 
	 * @return project
	 */
	public java.lang.String getProject() {
		return project;
	}

	/**
	 * Sets the project value for this RemoteFilter.
	 * 
	 * @param project
	 */
	public void setProject(java.lang.String project) {
		this.project = project;
	}

	/**
	 * Gets the xml value for this RemoteFilter.
	 * 
	 * @return xml
	 */
	public java.lang.String getXml() {
		return xml;
	}

	/**
	 * Sets the xml value for this RemoteFilter.
	 * 
	 * @param xml
	 */
	public void setXml(java.lang.String xml) {
		this.xml = xml;
	}

	private java.lang.Object __equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof RemoteFilter))
			return false;
		RemoteFilter other = (RemoteFilter) obj;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (__equalsCalc != null) {
			return (__equalsCalc == obj);
		}
		__equalsCalc = obj;
		boolean _equals;
		_equals = super.equals(obj) && ((this.author == null && other.getAuthor() == null) || (this.author != null && this.author.equals(other.getAuthor())))
				&& ((this.description == null && other.getDescription() == null) || (this.description != null && this.description.equals(other.getDescription())))
				&& ((this.project == null && other.getProject() == null) || (this.project != null && this.project.equals(other.getProject())))
				&& ((this.xml == null && other.getXml() == null) || (this.xml != null && this.xml.equals(other.getXml())));
		__equalsCalc = null;
		return _equals;
	}

	private boolean __hashCodeCalc = false;

	public synchronized int hashCode() {
		if (__hashCodeCalc) {
			return 0;
		}
		__hashCodeCalc = true;
		int _hashCode = super.hashCode();
		if (getAuthor() != null) {
			_hashCode += getAuthor().hashCode();
		}
		if (getDescription() != null) {
			_hashCode += getDescription().hashCode();
		}
		if (getProject() != null) {
			_hashCode += getProject().hashCode();
		}
		if (getXml() != null) {
			_hashCode += getXml().hashCode();
		}
		__hashCodeCalc = false;
		return _hashCode;
	}

}
