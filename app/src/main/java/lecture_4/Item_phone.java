package lecture_4;

public class Item_phone {
    private String phone_name;
    private String phone_number;
    public Item_phone(String name, String number) {
        this.phone_name = name;
        this.phone_number = number;
    }
    public String getItemName() {
        return this.phone_name;
    }
    public String getItemNumber() {
        return phone_number;
    }
}