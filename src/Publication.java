public class Publication {
    private String PMID;
    private String title;
    private String datum;

    public String getPMID() {
        return PMID;
    }

    public void setPMID(String PMID) {
        this.PMID = PMID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        return String.format("%-12s" + "%-12s" + getTitle() + "\n", getPMID(), getDatum());
    }
}
