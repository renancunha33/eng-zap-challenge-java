package grupozap.engzapchallengerestapi.model;
/*
 *
 *  Classe model construtora de PricingInfos
 *
 */
public class PricingInfos {
    private String yearlyIptu;
    private String price;
    private String businessType;
    private String monthlyCondoFee;
    private String period; //alguns registros necessitam desse campo
    private String rentalTotalPrice; //alguns registros necessitam desse campo

    // Getter Methods

    public String getYearlyIptu() {
        return yearlyIptu;
    }

    public String getPrice() {
        return price;
    }

    public String getBusinessType() {
        return businessType;
    }

    public String getMonthlyCondoFee() {
        return monthlyCondoFee;
    }

    public String getPeriod() {
        return period;
    }

    public String getRentalTotalPrice() {
        return rentalTotalPrice;
    }

    // Setter Methods

    public void setYearlyIptu( String yearlyIptu ) {
        this.yearlyIptu = yearlyIptu;
    }

    public void setPrice( String price ) {
        this.price = price;
    }

    public void setBusinessType( String businessType ) {
        this.businessType = businessType;
    }

    public void setMonthlyCondoFee( String monthlyCondoFee ) {
        this.monthlyCondoFee = monthlyCondoFee;
    }

    public void setPeriod( String period ) {
        this.period = period;
    }

    public void setRentalTotalPrice(String rentalTotalPrice) {
        this.rentalTotalPrice = rentalTotalPrice;
    }
}
