package java17.ex01;

import java.util.function.Function;

import org.junit.Test;

import java17.data.Account;
import java17.data.Person;


/**
 * Exercice 01 - java.util.function.Function
 */
public class Function_01_Test {

    /******** PART 1 - Integer -> Person *******/

    // tag::intToPerson[]
    // TODO Compléter la définition de cette fonction
    // TODO Cette fonction permet de transformer un entier en objet Person
    // TODO le prenom sera de la forme "first_<ENTIER>"
    // TODO le nom sera de la forme "last_<ENTIER>"
    // TODO l'age sera de la forme "<ENTIER>"
    // TODO le mot de passe sera de la forme "pass_<ENTIER>"
    private Function<Integer, Person> intToPerson = entier -> {
        Person person = new Person();
        person.setAge(entier);
        person.setFirstname("first_"+entier);
        person.setLastname("last_"+entier);
        person.setPassword("pass_"+entier);
        return person;
    };

    public Function<Integer, Person> getIntToPerson() {
        return intToPerson;
    }

    public void setIntToPerson(Function<Integer, Person> intToPerson) {
        this.intToPerson = intToPerson;
    }
    // end::intToPerson[]

    @Test
    public void test_intToPerson() throws Exception {

        // TODO invoquer la fonction intToPerson avec en paramètre l'entier 10.
        Person result = null;

        result = getIntToPerson().apply(10);
        assert result.getFirstname().equals("first_10");
        assert result.getLastname().equals("last_10");
        assert result.getAge().equals(10);
        assert result.getPassword().equals("pass_10");
    }

    /******** PART 2 - Person -> Account *******/

    // tag::personToAccount[]
    // TODO Compléter la définition de cette fonction
    // TODO la propriété owner est valorisé avec la personne en paramètre
    // TODO la propriété balance est valorisé à 1000
    private Function<Person, Account> personToAccount = person -> {
        Account account = new Account();
        account.setOwner(person);
        account.setBalance(1000);
        return account;
    };

    public Function<Person, Account> getPersonToAccount() {
        return personToAccount;
    }

    public void setPersonToAccount(Function<Person, Account> personToAccount) {
        this.personToAccount = personToAccount;
    }
    // end::personToAccount[]

    @Test
    public void test_personToAccount() throws Exception {

        Person person = new Person("Jules", "France", 10, "pass");

        // TODO invoquer la fonction personToAccount
        Account result = null;

        result = getPersonToAccount().apply(person);
        assert result.getOwner().equals(person);
        assert result.getBalance().equals(1000);
    }
}