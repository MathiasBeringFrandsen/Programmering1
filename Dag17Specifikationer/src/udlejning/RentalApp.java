package udlejning;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class RentalApp {
    public static void main(String[] args) {
        LocalDate dat1 = LocalDate.now();
        Rental r1 = new Rental(34, 14, 400, LocalDate.of(2021, 11, 1));
        Rental r2 = new Rental(35, 31, 1000, dat1.plusMonths(10));

        System.out.println("Total pris for udlejning af r1: " + r1.getTotalPrice());
        System.out.println("Sidste udlejningsdag for r1: " + r1.getEndDate());
        System.out.println("Dagen før r1 skal udlejes: " + r1.getStartDate().minusDays(1));

        System.out.println();

        System.out.println("Total pris for udlejning af r2: " + r2.getTotalPrice());
        System.out.println("Sidste udlejningsdag for r2: " + r2.getEndDate());
        System.out.println("Dagen før r2 skal udlejes: " + r2.getStartDate().minusDays(1));

        System.out.println();
        Period period = r1.getStartDate().until(r2.getStartDate());
        long days = period.getDays();
        long months = period.getMonths();
        long years = period.getYears();

        System.out.println("Fra første udljenig til anden udlejning er der " + years + " år " + months + " måneder "
                + days + " dage");

        System.out.println();

        System.out.println("Dage mellem de to udlejninger: " + ChronoUnit.DAYS.between(r1.getStartDate(), r2.getStartDate()));
    }
}
