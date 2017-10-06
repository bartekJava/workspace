package pl.altkom.hibernatejpa.model;

public enum GenreType {

	DRAMA("Drama"),
	TRAGEDY("Tragedy"),
	COMEDY("Comedy"),
	HORROR("Horror"),
	SATIRE("Satire"),
	TRAGICOMEDY("Tragicomedy"),
	FANTASY("Fantasy");
	
	
	String genreType;
	
	private GenreType(String genreType){
        this.genreType = genreType;
    }
	
	public String getGenreType(){
        return genreType;
    }

}
