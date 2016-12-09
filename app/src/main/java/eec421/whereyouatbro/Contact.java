package eec421.whereyouatbro;

/**
 * Created by HanSolo on 11/1/2016.
 */

public class Contact {
    private String Name,Address;

    public Contact (String Name, String Address){
        this.setName(Name);
        this.setAddress(Address);

    }

    private void setAddress(String address) { Address = address; }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }
}
