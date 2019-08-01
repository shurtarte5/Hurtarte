package com.natareno.hurtarte;

public class User {

    private int id;
    private String name;
    private String lastName;
    private String mail;
    private int favorite;


    //aqui agregue el atributo favorite(a los 2 constructores)


    public User(String name, String lastName, String mail, int favorite) {
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.favorite=favorite;
    }

    public User(int id, String name, String lastName, String mail, int favorite){
        this(name,lastName,mail,favorite);
        this.id=id;


    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
