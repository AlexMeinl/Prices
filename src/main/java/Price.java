import java.text.SimpleDateFormat;
import java.util.Date;

public class Price {

    private long id;
    private String product_code;
    private Integer number;
    private int depart;
    private Date begin;
    private Date end;
    private long value;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public long getId() {
        return id;
    }

    public String getProduct_code() {
        return product_code;
    }

    public Integer getNumber() {
        return number;
    }

    public Price(long id, String product_code, Integer number, int depart, Date begin, Date end, long value) {
        this.id = id;
        this.product_code = product_code;
        this.number = number;
        this.depart = depart;
        this.begin = begin;
        this.end = end;
        this.value = value;
    }

    public Price(Price price)
    {
        this.id = price.id;
        this.product_code = price.product_code;
        this.number = price.number;
        this.depart = price.depart;
        this.begin = price.begin;
        this.end = price.end;
        this.value = price.value;
    }

    public int getDepart() {
        return depart;
    }

    public Date getBegin() {
        return begin;
    }

    public Date getEnd() {
        return end;
    }

    public long getValue() {
        return value;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;

        Price price = (Price) o;

        if (number != price.number) return false;
        if (depart != price.depart) return false;
        return product_code.equals(price.product_code);
    }

    @Override
    public int hashCode() {
        int result = product_code.hashCode();
        result = 31 * result + number.hashCode();
        result = 31 * result + depart;
        return result;
    }

    @Override
    public String toString() {
        return "Price{" +
                "product_code='" + product_code + '\'' +
                ", number=" + number +
                ", depart=" + depart +
                ", begin=" + dateFormat.format(begin) +
                ", end=" + dateFormat.format(end) +
                ", value=" + value +
                '}';
    }
}
