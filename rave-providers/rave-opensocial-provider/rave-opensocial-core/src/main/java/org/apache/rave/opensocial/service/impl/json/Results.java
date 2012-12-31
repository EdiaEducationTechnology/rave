
package org.apache.rave.opensocial.service.impl.json;

import java.util.List;

import org.apache.rave.portal.model.Address;
import org.apache.rave.portal.model.Organization;
import org.apache.rave.portal.model.PersonProperty;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results implements org.apache.rave.portal.model.Person{
   	private String _charset_;
   	private Number _created;
   	private String _createdBy;
   	private String _id;
   	private Number _lastModified;
   	private String _lastModifiedBy;
   	private String _path;
   	private String firstName;
   	private String lastName;
   	private String reference;
   	private String targetUserId;

 	public String get_charset_(){
		return this._charset_;
	}
	public void set_charset_(String _charset_){
		this._charset_ = _charset_;
	}
 	public Number get_created(){
		return this._created;
	}
	public void set_created(Number _created){
		this._created = _created;
	}
 	public String get_createdBy(){
		return this._createdBy;
	}
	public void set_createdBy(String _createdBy){
		this._createdBy = _createdBy;
	}
 	public String get_id(){
		return this._id;
	}
	public void set_id(String _id){
		this._id = _id;
	}
 	public Number get_lastModified(){
		return this._lastModified;
	}
	public void set_lastModified(Number _lastModified){
		this._lastModified = _lastModified;
	}
 	public String get_lastModifiedBy(){
		return this._lastModifiedBy;
	}
	public void set_lastModifiedBy(String _lastModifiedBy){
		this._lastModifiedBy = _lastModifiedBy;
	}
 	public String get_path(){
		return this._path;
	}
	public void set_path(String _path){
		this._path = _path;
	}
 	public String getFirstName(){
		return this.firstName;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
 	public String getLastName(){
		return this.lastName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
 	public String getReference(){
		return this.reference;
	}
	public void setReference(String reference){
		this.reference = reference;
	}
 	
 	public String getTargetUserId(){
		return this.targetUserId;
	}
	public void setTargetUserId(String targetUserId){
		this.targetUserId = targetUserId;
	}
	@Override
	public String toString() {
		return "Results [_charset_=" + _charset_ + ", _created=" + _created
				+ ", _createdBy=" + _createdBy + ", _id=" + _id
				+ ", _lastModified=" + _lastModified + ", _lastModifiedBy="
				+ _lastModifiedBy + ", _path=" + _path + ", firstName="
				+ firstName + ", lastName=" + lastName + ", reference="
				+ reference + ", targetUserId=" + targetUserId + "]";
	}
	@Override
	public String getId() {
		return targetUserId;
	}
	@Override
	public void setId(String userId) {
		this.targetUserId = userId;
		
	}
	@Override
	public String getUsername() {
		return this.firstName;
		
	}
	@Override
	public void setUsername(String username) {
		this.firstName = username;
		
	}
	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getDisplayName() {
		return this.firstName;
	}
	@Override
	public void setDisplayName(String displayName) {
		this.firstName = displayName;
		
	}
	@Override
	public String getAboutMe() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setAboutMe(String aboutMe) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getPreferredName() {
		return this.firstName;
	}
	@Override
	public void setPreferredName(String preferredName) {
		this.firstName = preferredName;
		
	}
	@Override
	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setStatus(String status) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getAdditionalName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setAdditionalName(String additionalName) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getFamilyName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setFamilyName(String familyName) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getGivenName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setGivenName(String givenName) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getHonorificPrefix() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setHonorificPrefix(String honorificPrefix) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getHonorificSuffix() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setHonorificSuffix(String honorificSuffix) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Address> getAddresses() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setAddresses(List<Address> addresses) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<PersonProperty> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setProperties(List<PersonProperty> properties) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Organization> getOrganizations() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setOrganizations(List<Organization> organizations) {
		// TODO Auto-generated method stub
		
	}
}
