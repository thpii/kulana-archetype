/*
 * Copyright 2013 Telegraph Hill (http://www.thpii.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kulana.demo.gui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.kulana.core.foundation.utils.HTML;
import com.kulana.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.kulana.core.gui.AbstractPage;

public class GmailHomePage extends AbstractPage 
{
	@FindBy(xpath="//a[@guidedhelpid]")
	public ExtendedWebElement loggedUser;
	
	public GmailHomePage(WebDriver driver) 
	{
		super(driver);
		setPageAbsoluteURL("https://mail.google.com/mail/u/0/#inbox");
	}
	
	public String getUser()
	{
		assertElementPresent(loggedUser);
		return loggedUser.getAttribute(HTML.TITLE);
	}
}