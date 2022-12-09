package com.movie.compare.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.movie.compare.util.TestHelper;

public class WikiPage extends TestHelper {

	public WikiPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Release date']/../following-sibling::td//li")
	WebElement releaseDate;

	@FindBy(xpath = "//tbody//th[text()='Country']/following-sibling::td")
	WebElement countryOrigin;

	@FindBy(xpath = "//input[@id ='searchInput']")
	WebElement searchbox;

	@FindBy(xpath = "//input[@id='searchButton']")
	public WebElement searchbutton;

	public void enterMovieName(String movieName) {
		searchbox.sendKeys(movieName);

	}

	public String releaseText() {
		return releaseDate.getText();
	}

	public String countryText() {
		return countryOrigin.getText();
	}

}
