package grupozap.engzapchallengerestapi.model;
/*
 *
 *  Classe model construtora de Contrato
 *
 */
import java.util.ArrayList;

public class Contrato {
    private float usableAreas;
    private String listingType;
    private String createdAt;
    private String listingStatus;
    private String id;
    private float parkingSpaces;
    private String updatedAt;
    private boolean owner;
    ArrayList<Object> images = new ArrayList<Object>();
    Address AddressObject;
    private float bathrooms;
    private float bedrooms;
    PricingInfos PricingInfosObject;


    // Getter Methods

    public float getUsableAreas() {
        return usableAreas;
    }

    public String getListingType() {
        return listingType;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getListingStatus() {
        return listingStatus;
    }

    public String getId() {
        return id;
    }

    public float getParkingSpaces() {
        return parkingSpaces;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public boolean getOwner() {return owner;}

    public Address getAddress() {
        return AddressObject;
    }

    public float getBathrooms() {
        return bathrooms;
    }

    public float getBedrooms() {
        return bedrooms;
    }

    public PricingInfos getPricingInfos() {
        return PricingInfosObject;
    }

    public ArrayList<Object> getImages() {return images;}

    // Setter Methods

    public void setUsableAreas( float usableAreas ) {
        this.usableAreas = usableAreas;
    }

    public void setListingType( String listingType ) {
        this.listingType = listingType;
    }

    public void setCreatedAt( String createdAt ) {
        this.createdAt = createdAt;
    }

    public void setListingStatus( String listingStatus ) {
        this.listingStatus = listingStatus;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public void setParkingSpaces( float parkingSpaces ) {
        this.parkingSpaces = parkingSpaces;
    }

    public void setUpdatedAt( String updatedAt ) {
        this.updatedAt = updatedAt;
    }

    public void setOwner( boolean owner ) {
        this.owner = owner;
    }

    public void setAddress( Address addressObject ) {
        this.AddressObject = addressObject;
    }

    public void setBathrooms( float bathrooms ) {
        this.bathrooms = bathrooms;
    }

    public void setBedrooms( float bedrooms ) {
        this.bedrooms = bedrooms;
    }

    public void setPricingInfos( PricingInfos pricingInfosObject ) {
        this.PricingInfosObject = pricingInfosObject;
    }

    public void setImages(ArrayList<Object> images) {this.images = images;}
}
