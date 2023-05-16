package udlejning;

import java.time.LocalDate;

/**
 * Opretter en udlejning
 */
public class Rental {
    private int number;
    private int days;
    private LocalDate startDate;
    private double price;

    /**
     * Initaliserer en ny udlejning med nummeret, dage og pris
     * @param number nummeret op udlejningen
     * @param days antal dage udlejning varer
     * @param price pris pr dag
     */
    public Rental(int number, int days, double price, LocalDate startDate) {
        this.number = number;
        this.days = days;
        this.price = price;
        this.startDate = startDate;
    }

    /**
     * returnerer prisen pr dag
     * @return prisen pr dag
     */
    public double getPricePrDay() {
        return price;
    }

    /**
     * Registrerer prisen pr dag
     * @param days pris pr dag
     */
    public void setDays(int days) {
        this.days = days;
    }

    /**
     * Returnerer antal dage udlejningen varer
     * @return dage
     */
    public int getDays() {
        return days;
    }

    /**
     * Returnerer startdatoen på udlejningen
     * @return startdato
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Returnerer slutdatoen på udlejningen
     * @return slutdato
     */
    public LocalDate getEndDate() {
        return startDate.plusDays(days);
    }

    /**
     * Returnerer den totale pris for udlejningen
     * @return totalprisen
     */
    public double getTotalPrice() {
        return days * price;
    }
}
