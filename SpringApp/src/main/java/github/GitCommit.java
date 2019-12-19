package github;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitCommit {
	
	private String auteur;
	private String dateCommit;
	private String htmlUrl;
	private String message;
	private int position;
	private String sha;
	
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDateCommit() {
		return dateCommit;
	}
	public void setDateCommit(String dateCommit) {
		this.dateCommit = dateCommit;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getHtmlUrl() {
		return htmlUrl;
	}
	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}	
	public String getSha() {
		return sha;
	}
	public void setSha(String sha) {
		this.sha = sha;
	}
	
	
	public void initializeCommit(LinkedHashMap<String,String>  commit, int... position) {

		String commitInformations = commit.entrySet().toString();
    	this.auteur = extractAuteur(commitInformations);
    	this.dateCommit = extractDate(commitInformations);
    	this.htmlUrl = extractHtmlUrl(commitInformations);
    	this.message = extractMessage(commitInformations);
		this.position = position.length == 0 ? -1 : position[0];
    	this.sha = extractSha(commitInformations);
	}
	
	private String extractAuteur (String commitInformation) {
		return commitInformation.substring(commitInformation.indexOf("author={name=")).split("=")[2].split(", email")[0];
	}
	
	private String extractDate (String commitInformation) {
		return commitInformation.substring(commitInformation.indexOf("date=")).split("=")[1].split("}, committer")[0];
	}
	
	private String extractHtmlUrl (String commitInformation) {
		return commitInformation.substring(commitInformation.indexOf("html_url=")).split("=")[1].split(", comments_url")[0];
	}
	
	private String extractMessage (String commitInformation) {
		return commitInformation.substring(commitInformation.indexOf("message=")).split("=")[1].split(", tree")[0];
	}
	
	private String extractSha (String commitInformation) {
		return commitInformation.substring(commitInformation.indexOf("sha=")).split("=")[1].split(", node_id")[0];
	}
	
	public void afficherInformationsConsole() {
		System.out.println("Position/Rang = " + this.getPosition());
		System.out.println("Auteur = " + this.getAuteur());
    	System.out.println("Date = " + this.getDateCommit());
    	System.out.println("HtmlUrl = " + this.getHtmlUrl());
    	System.out.println("Message = " + this.getMessage());
    	System.out.println("Sha = " + this.getSha());
	}
}