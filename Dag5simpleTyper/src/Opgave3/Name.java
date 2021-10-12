package Opgave3;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;

    public Name(String firstName, String middleName, String lastName){
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getMiddleName(){
        return middleName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName){
        this.middleName = middleName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getInit(){
        String initials = "" + firstName.charAt(0) + middleName.charAt(0) + lastName.charAt(0);
        return initials;
    }

    public String getUsername(){
        String firstTwo = firstName.substring(0, 2  );
        int lengthMiddle = middleName.length();
        String lastTwo = lastName.substring(lastName.length() - 2);
        return firstTwo.toUpperCase() + lengthMiddle + lastTwo.toLowerCase();
    }

}