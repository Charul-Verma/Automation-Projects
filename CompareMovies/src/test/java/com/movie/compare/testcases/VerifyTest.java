package com.movie.compare.testcases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.movie.compare.pages.ImdbPage;
import com.movie.compare.pages.WikiPage;
import com.movie.compare.util.TestHelper;

public class VerifyTest extends TestHelper {

	WikiPage wiki;
	ImdbPage imdb;

	@BeforeSuite(alwaysRun = true)
	public void setUp() {
		initializaton();
		wiki = new WikiPage();
		imdb = new ImdbPage();
	}

	@Test
	public void TC01_CompareMovieDetails() throws ParseException {
		openURL("wikiurl");
		wiki.enterMovieName(properties.getProperty("moviename"));
		wiki.searchbutton.click();
		String releaseDateFromWiki = wiki.releaseText();
		System.out.println(releaseDateFromWiki);
		Date wikiDate = new SimpleDateFormat("dd MMMM yyyy").parse(releaseDateFromWiki);
		String countryOriginFromWiki = wiki.countryText();
		System.out.println(countryOriginFromWiki);

		openURL("imdburl");
		imdb.enterMovieName(properties.getProperty("moviename"));
		imdb.searchbutton.click();
		imdb.clickMovie(properties.getProperty("moviename")).click();
		String releaseDateFromImdb = imdb.releaseText();
		System.out.println(releaseDateFromImdb);
		Date imdbDate = new SimpleDateFormat("MMMM dd, yyyy").parse(releaseDateFromImdb.split("\\(")[0]);
		String countryOriginFromImdb = imdb.countryText();
		System.out.println(countryOriginFromImdb);

		Assert.assertEquals(countryOriginFromWiki, countryOriginFromImdb);
		Assert.assertTrue(wikiDate.equals(imdbDate));
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		tearDownMain();
	}

}
