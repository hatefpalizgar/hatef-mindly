package net.mindly.springboot.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Crypto")

public class Crypto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="Cryptocurrency")
	private String cryptocurrency;
	@Column(name="Amount")
	private BigDecimal amount;
	@Column(name="DateOfPurchase")
	private String dateOfPurchase;
	@Column(name="WalletLocation")
	private String walletLocation;
	@Column(name="currentMarketValue")
	private BigDecimal currentMarketValue;
	@Column(name="Option")
	private String option;
	
	public Crypto() {}
	
	public Crypto(String cryptocurrency, BigDecimal amount, String dateOfPurchase, String walletLocation,
			BigDecimal currentMarketValue, String option) {
		super();
		this.cryptocurrency = cryptocurrency;
		this.amount = amount;
		this.dateOfPurchase = dateOfPurchase;
		this.walletLocation = walletLocation;
		this.currentMarketValue = currentMarketValue;
		this.option = option;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCryptocurrency() {
		return cryptocurrency;
	}
	public void setCryptocurrency(String cryptocurrency) {
		this.cryptocurrency = cryptocurrency;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(String dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	public String getWalletLocation() {
		return walletLocation;
	}
	public void setWalletLocation(String walletLocation) {
		this.walletLocation = walletLocation;
	}
	public BigDecimal getCurrentMarketValue() {
		return currentMarketValue;
	}
	public void setCurrentMarketValue(BigDecimal currentMarketValue) {
		this.currentMarketValue = currentMarketValue;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}

	
	

}
