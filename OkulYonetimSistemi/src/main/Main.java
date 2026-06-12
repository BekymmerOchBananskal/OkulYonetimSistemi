package main;
import database.DBInitializer;

public class Main {

	public static void main(String[] args) {
		
		DBInitializer.createTable();
		System.out.println("Program başlatıldı.");

	}

}
