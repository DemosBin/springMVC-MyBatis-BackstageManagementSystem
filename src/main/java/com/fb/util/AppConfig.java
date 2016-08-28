package com.fb.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Value("${root_dir:}")
    private String rootDir;

    @Value("${root_small_dir:}")
    private String rootSmallDir;

	@Value("${root_path:}")
	private String rootPath;

	@Value("${productNum:}")
	private String productNum;

	@Value("${productName:}")
	private String productName;

	@Value("${productUrl:}")
	private String productUrl;

	@Value("${description:}")
	private String description;

	@Value("${loginPage:}")
	private String loginPage;


	public String getRootDir() {
		return rootDir;
	}

	public void setRootDir(String rootDir) {
		this.rootDir = rootDir;
	}

	public String getRootSmallDir() {
		return rootSmallDir;
	}

	public void setRootSmallDir(String rootSmallDir) {
		this.rootSmallDir = rootSmallDir;
	}


	public String getProductNum() {
		return productNum;
	}

	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}

	public String getRootPath() {
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}
}
