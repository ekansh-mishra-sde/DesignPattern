package BuilderExample2;

import BuilderExample1.Address;
import BuilderExample1.User;

import java.time.LocalDate;

public class Client {

    public static void main(String[] args) {
        User user = createUser();
        UserDTO dto = directBuild(UserDTO.getBuilder(),user);
        System.out.println(dto);
    }
    private static UserDTO directBuild(UserDTO.UserDTOBuilder builder, User user){
        return builder.withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withAddress(user.getAddress())
                .build();
    }

    public static User createUser(){
        User user = new User();
        user.setBirthday(LocalDate.of(1960,5,6));
        user.setFirstName("Ekansh");
        user.setLastName("Mishra");
        Address address = new Address();
        address.setHouseNumber("B-122");
        address.setStreet("4th cross street");
        address.setCity("Gr Noida,");
        address.setState("Uttar Pradesh");
        address.setZipcode("201310");
        user.setAddress(address);
        return user;
    }
}
