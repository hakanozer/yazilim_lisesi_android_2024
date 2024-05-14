package com.works.project.models;

public class User {
    private long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private String image;
    private String token;

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public String getUsername() { return username; }
    public void setUsername(String value) { this.username = value; }

    public String getEmail() { return email; }
    public void setEmail(String value) { this.email = value; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String value) { this.firstName = value; }

    public String getLastName() { return lastName; }
    public void setLastName(String value) { this.lastName = value; }

    public String getGender() { return gender; }
    public void setGender(String value) { this.gender = value; }

    public String getImage() { return image; }
    public void setImage(String value) { this.image = value; }

    public String getToken() { return token; }
    public void setToken(String value) { this.token = value; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", image='" + image + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}

