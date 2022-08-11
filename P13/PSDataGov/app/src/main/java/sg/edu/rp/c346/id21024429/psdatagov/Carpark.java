package sg.edu.rp.c346.id21024429.psdatagov;

public class Carpark {

    private String number;
    private String lots;
    private String lotsAvailable;

    public Carpark(String number, String lots, String lotsAvailable){
        this.number = number;
        this.lots = lots;
        this.lotsAvailable = lotsAvailable;
    }

    public String getNumber() {
        return number;
    }

    public String getLots() {
        return lots;
    }

    public String getLotsAvailable() {
        return lotsAvailable;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setLots(String lots) {
        this.lots = lots;
    }

    public void setLotsAvailable(String lotsAvailable) {
        this.lotsAvailable = lotsAvailable;
    }


    @Override
    public String toString() {
        return "Carpark\n" +
                "Carpark Number: " + number + "\n" +
                "Number of Lots: " + lots + "\n" +
                "Number of Available Lots: " + lotsAvailable;
    }
}
