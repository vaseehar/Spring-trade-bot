package com.example.springTradeBot.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AssetId implements Serializable {

	private int userId;

	private String assetName;

	public AssetId() {

	}

	public AssetId(int userId, String assetName) {
		super();
		this.userId = userId;
		this.assetName = assetName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	@Override
	public String toString() {
		return "AssetId [userId=" + userId + ", assetName=" + assetName + "]";
	}

}
