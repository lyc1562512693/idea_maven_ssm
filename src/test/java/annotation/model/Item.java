package annotation.model;

import annotation.Name;
import annotation.Type;
import org.codehaus.jackson.annotate.JsonSubTypes;

public class Item {
    @Name(value = "phone")
    public String name;
    @Type(value = 3)
    public int type;
    public int price;
    public String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
