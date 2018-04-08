package com.mehta.common.vo;

import java.io.Serializable;

public class ProductsBenefitsVo implements Serializable {
	private static final long serialVersionUID = 2161143300635722029L;
	private Integer id;
	private Integer principalProductId;
	private Integer benefitsId;
	private Boolean isCompulsory;
	private Integer minimumEntryAge;
	private Integer maximumEntryAge;
	private Double amountOfCover;
	private Double minBeneficiaryAge;
	private Double maxBenefeciaryAge;
	private Integer maxNumOfBenefeciary;
	private Double minPremiumCover;
	private Double maxPremiumCover;
	private Double midRangePremiumCover;
	private Double lifetimePremiumCover;
	private Boolean isLifeCoverReducable;
	private Double minAmtCover;
	private Double maxAamtCover;
	private Boolean terminationOn65thBday;
	private Double maxTermAgeForBenefit;
	private Boolean isAnnualRenewable;
	private Double premiumImpact;
	private Double rateOfReturn;

	public ProductsBenefitsVo() {
		super();
	}

	public ProductsBenefitsVo(Integer id) {
		super();
		this.id = id;
	}

	public ProductsBenefitsVo(Integer principalProductId, Integer benefitsId, Boolean isCompulsory,
			Integer minimumEntryAge, Integer maximumEntryAge, Double amountOfCover, Double minBeneficiaryAge,
			Double maxBenefeciaryAge, Integer maxNumOfBenefeciary, Double minPremiumCover, Double maxPremiumCover,
			Double midRangePremiumCover, Double lifetimePremiumCover, Boolean isLifeCoverReducable, Double minAmtCover,
			Double maxAamtCover, Boolean terminationOn65thBday, Double maxTermAgeForBenefit, Boolean isAnnualRenewable,
			Double premiumImpact, Double rateOfReturn) {
		super();
		this.principalProductId = principalProductId;
		this.benefitsId = benefitsId;
		this.isCompulsory = isCompulsory;
		this.minimumEntryAge = minimumEntryAge;
		this.maximumEntryAge = maximumEntryAge;
		this.amountOfCover = amountOfCover;
		this.minBeneficiaryAge = minBeneficiaryAge;
		this.maxBenefeciaryAge = maxBenefeciaryAge;
		this.maxNumOfBenefeciary = maxNumOfBenefeciary;
		this.minPremiumCover = minPremiumCover;
		this.maxPremiumCover = maxPremiumCover;
		this.midRangePremiumCover = midRangePremiumCover;
		this.lifetimePremiumCover = lifetimePremiumCover;
		this.isLifeCoverReducable = isLifeCoverReducable;
		this.minAmtCover = minAmtCover;
		this.maxAamtCover = maxAamtCover;
		this.terminationOn65thBday = terminationOn65thBday;
		this.maxTermAgeForBenefit = maxTermAgeForBenefit;
		this.isAnnualRenewable = isAnnualRenewable;
		this.premiumImpact = premiumImpact;
		this.rateOfReturn = rateOfReturn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPrincipalProductId() {
		return principalProductId;
	}

	public void setPrincipalProductId(Integer principalProductId) {
		this.principalProductId = principalProductId;
	}

	public Integer getBenefitsId() {
		return benefitsId;
	}

	public void setBenefitsId(Integer benefitsId) {
		this.benefitsId = benefitsId;
	}

	public Boolean getIsCompulsory() {
		return isCompulsory;
	}

	public void setIsCompulsory(Boolean isCompulsory) {
		this.isCompulsory = isCompulsory;
	}

	public Integer getMinimumEntryAge() {
		return minimumEntryAge;
	}

	public void setMinimumEntryAge(Integer minimumEntryAge) {
		this.minimumEntryAge = minimumEntryAge;
	}

	public Integer getMaximumEntryAge() {
		return maximumEntryAge;
	}

	public void setMaximumEntryAge(Integer maximumEntryAge) {
		this.maximumEntryAge = maximumEntryAge;
	}

	public Double getAmountOfCover() {
		return amountOfCover;
	}

	public void setAmountOfCover(Double amountOfCover) {
		this.amountOfCover = amountOfCover;
	}

	public Double getMinBeneficiaryAge() {
		return minBeneficiaryAge;
	}

	public void setMinBeneficiaryAge(Double minBeneficiaryAge) {
		this.minBeneficiaryAge = minBeneficiaryAge;
	}

	public Double getMaxBenefeciaryAge() {
		return maxBenefeciaryAge;
	}

	public void setMaxBenefeciaryAge(Double maxBenefeciaryAge) {
		this.maxBenefeciaryAge = maxBenefeciaryAge;
	}

	public Integer getMaxNumOfBenefeciary() {
		return maxNumOfBenefeciary;
	}

	public void setMaxNumOfBenefeciary(Integer maxNumOfBenefeciary) {
		this.maxNumOfBenefeciary = maxNumOfBenefeciary;
	}

	public Double getMinPremiumCover() {
		return minPremiumCover;
	}

	public void setMinPremiumCover(Double minPremiumCover) {
		this.minPremiumCover = minPremiumCover;
	}

	public Double getMaxPremiumCover() {
		return maxPremiumCover;
	}

	public void setMaxPremiumCover(Double maxPremiumCover) {
		this.maxPremiumCover = maxPremiumCover;
	}

	public Double getMidRangePremiumCover() {
		return midRangePremiumCover;
	}

	public void setMidRangePremiumCover(Double midRangePremiumCover) {
		this.midRangePremiumCover = midRangePremiumCover;
	}

	public Double getLifetimePremiumCover() {
		return lifetimePremiumCover;
	}

	public void setLifetimePremiumCover(Double lifetimePremiumCover) {
		this.lifetimePremiumCover = lifetimePremiumCover;
	}

	public Boolean getIsLifeCoverReducable() {
		return isLifeCoverReducable;
	}

	public void setIsLifeCoverReducable(Boolean isLifeCoverReducable) {
		this.isLifeCoverReducable = isLifeCoverReducable;
	}

	public Double getMinAmtCover() {
		return minAmtCover;
	}

	public void setMinAmtCover(Double minAmtCover) {
		this.minAmtCover = minAmtCover;
	}

	public Double getMaxAamtCover() {
		return maxAamtCover;
	}

	public void setMaxAamtCover(Double maxAamtCover) {
		this.maxAamtCover = maxAamtCover;
	}

	public Boolean getTerminationOn65thBday() {
		return terminationOn65thBday;
	}

	public void setTerminationOn65thBday(Boolean terminationOn65thBday) {
		this.terminationOn65thBday = terminationOn65thBday;
	}

	public Double getMaxTermAgeForBenefit() {
		return maxTermAgeForBenefit;
	}

	public void setMaxTermAgeForBenefit(Double maxTermAgeForBenefit) {
		this.maxTermAgeForBenefit = maxTermAgeForBenefit;
	}

	public Boolean getIsAnnualRenewable() {
		return isAnnualRenewable;
	}

	public void setIsAnnualRenewable(Boolean isAnnualRenewable) {
		this.isAnnualRenewable = isAnnualRenewable;
	}

	public Double getPremiumImpact() {
		return premiumImpact;
	}

	public void setPremiumImpact(Double premiumImpact) {
		this.premiumImpact = premiumImpact;
	}

	public Double getRateOfReturn() {
		return rateOfReturn;
	}

	public void setRateOfReturn(Double rateOfReturn) {
		this.rateOfReturn = rateOfReturn;
	}

}
