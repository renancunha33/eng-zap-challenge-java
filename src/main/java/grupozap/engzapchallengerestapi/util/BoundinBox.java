package grupozap.engzapchallengerestapi.util;
/*
*
*  Classe com o BoudingBox, Somente getters
*
 */
public class BoundinBox {
    private float minlon;
    private float minlat;
    private float maxlon;
    private float maxlat;

    //getter Methods

    public float getMinlon() {
        return minlon = (float) -46.693419;
    }

    public float getMinlat() {
        return minlat = (float) -23.568704;
    }

    public float getMaxlon() {
        return maxlon = (float) -46.641146;
    }

    public float getMaxlat() {
        return maxlat = (float) -23.546686;
    }

}
