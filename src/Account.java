public class Account {
    private String username;
    private String password;
    private int amount;

    public Account(){
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getAmount(){
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
