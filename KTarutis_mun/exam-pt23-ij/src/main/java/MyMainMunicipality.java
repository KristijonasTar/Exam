import lt.techin.municipality.IllegalCitizenException;
import lt.techin.municipality.Municipality;
import lt.techin.municipality.Person;
import lt.techin.municipality.PersonPredicate;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MyMainMunicipality implements Municipality {
    ArrayList<Person> citizens = new ArrayList<>();
    LocalDate now = LocalDate.now();
    LocalDate adult = LocalDate.of(2005, 11, 27);

    @Override
    public void registerCitizen(Person person) throws IllegalCitizenException {
         if (!citizens.contains(person)) {
            citizens.add(person);
        } else if ( person.getFirstName() == null || person.getLastName() == null
                 || person.getFirstName().isEmpty() || person.getLastName().isEmpty()
                 || person.getDateOfBirth() == null || person.getYearlyIncome() < 0
                 || person.getDateOfBirth().isAfter(now)) {
             throw new IllegalCitizenException(person);
         }
    }

    @Override
    public int getCitizenCount() {
        return citizens.size();
    }

    @Override
    public double getAverageCitizenIncome() {
        double total = 0;
        for (Person average : citizens) {
            total += average.getYearlyIncome();
        }
        return total / citizens.size();
    }

    @Override
    public boolean isRegisteredCitizen(Person person) {
        if (citizens.contains(person)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Person findOldestPerson() {
        return citizens.stream().min(Comparator.comparing(Person::getDateOfBirth)).get();

    }

    @Override
    public int countAdultCitizens() {
        return 0;
    }

    @Override
    public double totalIncomeInTaxes() {
        return 0;
    }

    @Override
    public Collection<Person> findCitizensBy(PersonPredicate personPredicate) {
        return null;
    }

    @Override
    public Collection<Person> getOrderedCitizens() {
        return null;
    }

    @Override
    public Map<Integer, List<Person>> groupByYearOfBirth() {
        return null;
    }
}
