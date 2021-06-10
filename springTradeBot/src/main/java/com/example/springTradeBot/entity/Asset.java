package com.example.springTradeBot.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "asset")
public class Asset {

	@EmbeddedId
	private AssetId assetId;

	private String initialAsset;

	private String currentAsset;

	private String volumePerTrade;

	public AssetId getAssetId() {
		return assetId;
	}

	public void setAssetId(AssetId assetId) {
		this.assetId = assetId;
	}

	public String getInitialAsset() {
		return initialAsset;
	}

	public void setInitialAsset(String initialAsset) {
		this.initialAsset = initialAsset;
	}

	public String getCurrentAsset() {
		return currentAsset;
	}

	public void setCurrentAsset(String currentAsset) {
		this.currentAsset = currentAsset;
	}

	public String getVolumePerTrade() {
		return volumePerTrade;
	}

	public void setVolumePerTrade(String volumePerTrade) {
		this.volumePerTrade = volumePerTrade;
	}

	@Override
	public String toString() {
		return "Asset [assetId=" + assetId + ", initialAsset=" + initialAsset + ", currentAsset=" + currentAsset
				+ ", volumePerTrade=" + volumePerTrade + "]";
	}

}
