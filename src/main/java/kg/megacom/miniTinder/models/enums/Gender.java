package kg.megacom.miniTinder.models.enums;

public enum Gender {
    MALE("Мужчина"),
    FEMALE("Женщина"),
    OTHER("Чужой");

    private String val;

    Gender(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "val='" + val + '\'' +
                '}';
    }
}
