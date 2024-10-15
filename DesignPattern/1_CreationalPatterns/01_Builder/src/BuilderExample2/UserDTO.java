package BuilderExample2;

import BuilderExample1.Address;

import java.time.LocalDate;
import java.time.Period;

public class UserDTO {
    private String name;
    private String address;
    private String age;

    public String getName(){
        return name;
    }

    private String getAddress(){
        return address;
    }
    public String getAge(){
        return age;
    }
    private void setName(String name){
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDTO :" +
                "name='" + name + '\'' +
                ", age='" + age + '\''+
                ", address='" + address;
    }
    // Get Builder instance
    public static UserDTOBuilder getBuilder(){
        return new UserDTOBuilder();
    }
    // builder class
    public static class UserDTOBuilder{
        private String firstName;
        private String lastName;
        private String age;
        private String address;
        private UserDTO userDTO;


        public UserDTOBuilder withFirstName(String fname){
            this.firstName = fname;
            return this;
        }
        public UserDTOBuilder withLastName(String lname){
            this.lastName = lname;
            return this;
        }
        public UserDTOBuilder withBirthday(LocalDate date){
            this.age = Integer.toString(Period.between(date,LocalDate.now()).getYears());
            return this;
        }
        public UserDTOBuilder withAddress(Address address){
            this.address = address.getHouseNumber()+ " " +address.getStreet()+"\n"+
                    address.getCity()
                    +","+
                    address.getState()+" "+
                    address.getZipcode();
            return this;
        }
        public UserDTO build(){
            this.userDTO = new UserDTO();
            userDTO.setName(firstName+" "+lastName);
            userDTO.setAddress(address);
            userDTO.setAge(age);
            return userDTO;
        }
        public UserDTO getUserDTO(){
            return this.userDTO;
        }

    }

}
