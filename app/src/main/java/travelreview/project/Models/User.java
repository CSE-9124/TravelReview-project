package travelreview.project.Models;

public class User extends Model{
    private String username, name, phoneNumber, email, role, imagePath, password;
    private int age;
    
    // Constructors
    // For method login()
    public User(int id, String role) {
        super(id);
        this.role = role;
    }

    // For method getUserById()
    public User(int id, String username, String name, String phoneNumber, String email, String role, String imagePath, String password, int age) {
        super(id);
        this.username = username;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
        this.age = age;
        this.imagePath = imagePath;
        this.password = password;
    }

    // Getter & Settter
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getRole() {return role;}
    public void setRole(String role) {this.role = role;}

    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}

    public String getImagePath() {return imagePath;}
    public void setImagePath(String imagePath) {this.imagePath = imagePath;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
}
