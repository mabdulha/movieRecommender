package Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import Utils.Serialiser;
import asg.cliche.Command;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import Controller.MovieRecommenderAPI;
import Model.Movie;
import Model.User;
import Utils.Serialiser;
import Utils.XMLSerializer;

public class Main {
	
	public MovieRecommenderAPI movieRecommender;
	
	public Main() throws Exception {
	File datastore= new File("datastore.xml");
	  Serialiser serialiser = new XMLSerializer(datastore);
	  
	  movieRecommender = new MovieRecommenderAPI(serialiser);
	  if (datastore.isFile())
	  {
		  movieRecommender.load();
	  }
	  else 
	  {
	 movieRecommender.prime();
	 }
	  
	  
	  
	}
}
