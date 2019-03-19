public class Publicatie {
    private String PMID;
    private String titel;
    private String datum;

    public String getPMID() {
        return PMID;
    }

    public void setPMID(String PMID) {
        this.PMID = PMID;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        return String.format("%-12s" + "%-12s" + getTitel() + "\n", getPMID(), getDatum());
    }
}
