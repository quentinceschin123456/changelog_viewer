package github;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

public class GitController {
	
	private String possesseurRepo;
	private String nomRepo;
	private String shaRepo;
	private ArrayList<GitCommit> commits;
	private static GitController INSTANCE = null;
	
	public String getPossesseurRepo() {
		return possesseurRepo;
	}
	public String getNomRepo() {
		return nomRepo;
	}
	public String getShaRepo() {
		return shaRepo;
	}
	public ArrayList<GitCommit> getCommits() {
		return commits;
	}
	public void setPossesseurRepo(String possesseurRepo) {
		this.possesseurRepo = possesseurRepo;
	}
	public void setNomRepo(String nomRepo) {
		this.nomRepo = nomRepo;
	}
	public void setShaRepo(String shaRepo) {
		this.shaRepo = shaRepo;
	}
	public void setCommits() {
		
		RestTemplate restTemplate = new RestTemplate();
    
		@SuppressWarnings("unchecked")
		List<LinkedHashMap<String,String>> restResult = restTemplate.getForObject(this.URLduRepo(), List.class);
	    
	    int position = restResult.size();
	    for(LinkedHashMap<String,String>  commit : restResult)
	    { 
	    	GitCommit thisCommit = new GitCommit();
	    	thisCommit.initializeCommit(commit, position);
	    	this.commits.add(thisCommit);
	    	position--;
	    }
	}
	
	private GitController (String possesseurRepo, String nomRepo, String shaRepo) {
		this.possesseurRepo = possesseurRepo;
		this.nomRepo = nomRepo;
		this.shaRepo = shaRepo;
	}
	
	/**
	 * Permet d'avoir l'instance unique du GitController
	 * @param possesseurRepo - Possesseur du repository (Ex : quentinceschin123456)
	 * @param nomRepo - Nom du repository (Ex : changelog_viewer)
	 * @param shaRepo - Suite de nombre ou nom de branche (Ex : develop)
	 * @return
	 */
	public static GitController getInstance(String possesseurRepo, String nomRepo, String shaRepo) {
		if (INSTANCE == null) {
			INSTANCE = new GitController(possesseurRepo, nomRepo, shaRepo); 
	    }
	    return INSTANCE;
	}
	
	public void afficherTousLesCommitsDansLaConsole() {
	    for(GitCommit commit : commits) {
	    	commit.afficherInformationsConsole();
	    	System.out.println("--");
	    }
	}
	
	private String URLduRepo() {
		return "https://api.github.com/repos/" + this.possesseurRepo + "/" + this.nomRepo + "/restResult?sha=" + this.shaRepo;
	}
}
