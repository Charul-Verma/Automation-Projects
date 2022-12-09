package com.movie.compare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.movie.compare.util.TestHelper;

public class ImdbPage extends TestHelper {

	public ImdbPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@data-testid='title-details-section']//a[text()='Release date']//..//li//a")
	WebElement releaseDate;

	@FindBy(xpath = "//div[@data-testid='title-details-section']//button[text()='Country of origin']//..//li//a")
	WebElement countryOrigin;

	@FindBy(id = "suggestion-search")
	WebElement searchbox;

	@FindBy(id = "iconContext-magnify")
	public WebElement searchbutton;

	public WebElement clickMovie(String movieName) {
		return driver.findElement(By.xpath(
				"//section[@data-testid='find-results-section-title']//a[contains(text(),'" + movieName + "" + "')]"));
	}

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
