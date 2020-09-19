package net.mindly.springboot.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Crypto")

public class Crypto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "Cryptocurrency")
	private String cryptocurrency;
	@Column(name = "Amount")
	private BigDecimal amount;
	@Column(name = "DateOfPurchase")
	private String dateOfPurchase;
	@Column(name = "WalletLocation")
	private String walletLocation;
	@Column(name = "currentMarketValue")
	private BigDecimal currentMarketValue;
	@Column(name = "Option")
	private String option;

}
