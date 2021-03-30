package grupozap.engzapchallengerestapi.model;
/*
 *
 *  Classe model construtora de geoLocation
 *
 */
public class GeoLocation {
    private String precision;
    Location LocationObject;


    // Getter Methods

    public String getPrecision() {
        return precision;
    }

    public Location getLocation() {
        return LocationObject;
    }

    // Setter Methods

    public void setPrecision( String precision ) {
        this.precision = precision;
    }

    public void setLocation( Location locationObject ) {
        this.LocationObject = locationObject;
    }
}
