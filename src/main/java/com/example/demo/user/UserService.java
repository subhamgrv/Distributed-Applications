package com.example.demo.user;

import com.example.demo.products.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<User> UserList = new ArrayList<User>();



    public UserService(){
        UserList.add(new User(1,"Aisha","Khan","aisha.khan@example.com", new Address("Hauptstraße 12",10115,"Berlin","Germany")));
        UserList.add(new User(2,"Lukas","Meyer","lukas.meyer@example.com", new Address("Bahnhofstraße 7",80331,"Munich","Germany")));
        UserList.add(new User(3,"Sara","Rossi","sara.rossi@example.com", new Address("Via Roma 25",20121,"Milan","Italy")));
        UserList.add(new User(4,"Noah","Dubois","noah.dubois@example.com", new Address("Rue de Rivoli 88",75001,"Paris","France")));
        UserList.add(new User(5,"Emilia","Nowak","emilia.nowak@example.com", new Address("ul. Długa 3",80001,"Gdańsk","Poland")));


    }



    public List<User> getall(){
        return  UserList;
    }

    public  User findById(int id){
        for (User p : UserList){
            if(p.getId()== id) {
                return p;
            }
        }

        return null;
    }


    public User addnewUser(int id, String firstname, String lastname, String Email , String Street, int zip, String City, String Country){
        User user = new User(id,firstname,lastname,Email,new Address(Street, zip, City, Country));
        UserList.add(user);
    return user; }

}
