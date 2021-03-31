package src;

public class Localizacao {
    private String coordenadaLatitude;
    private String coordenadaLongitude;
    
    public Localizacao(String coordenadaLatitude, String coordenadaLongitude) {
        this.coordenadaLatitude = coordenadaLatitude;
        this.coordenadaLongitude = coordenadaLongitude;
    }

    public String getCoordenadaLatitude() {
        return coordenadaLatitude;
    }

    public void setCoordenadaLatitude(String coordenadaLatitude) {
        this.coordenadaLatitude = coordenadaLatitude;
    }

    public String getCoordenadaLongitude() {
        return coordenadaLongitude;
    }

    public void setCoordenadaLongitude(String coordenadaLongitude) {
        this.coordenadaLongitude = coordenadaLongitude;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((coordenadaLatitude == null) ? 0 : coordenadaLatitude.hashCode());
        result = prime * result + ((coordenadaLongitude == null) ? 0 : coordenadaLongitude.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Localizacao other = (Localizacao) obj;
        if (coordenadaLatitude == null) {
            if (other.coordenadaLatitude != null)
                return false;
        } else if (!coordenadaLatitude.equals(other.coordenadaLatitude))
            return false;
        if (coordenadaLongitude == null) {
            if (other.coordenadaLongitude != null)
                return false;
        } else if (!coordenadaLongitude.equals(other.coordenadaLongitude))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s,%s", this.getCoordenadaLatitude(), this.coordenadaLongitude);
    }
}
