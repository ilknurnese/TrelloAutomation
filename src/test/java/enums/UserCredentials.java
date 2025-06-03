package enums;

public enum UserCredentials {
    user_mustafa("orkidecloud@gmail.com", "Aurora20"),
    user_ayse("", ""),
    user_maryam("user3@example.com", "password3"),
    user_faruk("user4@example.com", "password4"),
    user_baris("user5@example.com", "password5");

    private final String email;
    private final String password;

    UserCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
