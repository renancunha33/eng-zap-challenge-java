package grupozap.engzapchallengerestapi.model;
/*
 *
 *  Classe model construtora de Adress
 *
 */

public class Address {
    private String city;
    private String neighborhood;
    GeoLocation GeoLocationObject;


    // Getter Methods

    public String getCity() {
        return city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public GeoLocation getGeoLocation() {
        return GeoLocationObject;
    }

    // Setter Methods

    public void setCity( String city ) {
        this.city = city;
    }

    public void setNeighborhood( String neighborhood ) {
        this.neighborhood = neighborhood;
    }

    public void setGeoLocation( GeoLocation geoLocationObject ) {
        this.GeoLocationObject = geoLocationObject;
    }
}
