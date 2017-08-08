import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@RunWith(JUnit4.class)
public class SortingPriceTest {

    private final SortingPrice sortingPrice =  new SortingPrice();
    private List<Price> list = new ArrayList<>();
    private List<Price> newPrice = new ArrayList<>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    @Before
    public void setListsForTest(){
        try {
            list.add(new Price(0, "1234567", 1, 1, dateFormat.parse("22.01.1990 20:00:00"), dateFormat.parse("22.01.1991 20:00:00"), 10000));
            list.add(new Price(0, "1234567", 1, 1, dateFormat.parse("20.01.1990 20:00:00"), dateFormat.parse("22.01.1990 20:00:00"), 10000));
            list.add(new Price(1, "1234567", 2, 1, dateFormat.parse("22.01.1990 20:00:00"), dateFormat.parse("22.04.1990 10:00:00"), 100));
            list.add(new Price(2, "1234567", 1, 2, dateFormat.parse("22.01.1991 20:00:00"), dateFormat.parse("22.05.1991 20:00:00"), 10));
            list.add(new Price(3, "66556", 1, 1, dateFormat.parse("22.01.1990 20:00:00"), dateFormat.parse("22.01.1991 20:00:00"), 100));
            list.add(new Price(4, "66556", 2, 1, dateFormat.parse("22.07.1990 20:00:00"), dateFormat.parse("22.08.1991 20:00:00"), 10000));
            list.add(new Price(5, "7777712", 1, 1, dateFormat.parse("22.01.1990 20:00:00"), dateFormat.parse("22.01.1991 20:00:00"), 100));
            list.add(new Price(6, "7777712", 2, 1, dateFormat.parse("22.07.1990 20:00:00"), dateFormat.parse("22.12.1990 20:00:00"), 10000));
            newPrice.add(new Price(7, "1234567", 1, 1, dateFormat.parse("22.01.1990 20:00:00"), dateFormat.parse("22.03.1990 20:00:00"), 500));
            newPrice.add(new Price(8, "1234567", 1, 1, dateFormat.parse("22.04.1990 20:00:00"), dateFormat.parse("22.02.1991 20:00:00"), 600));
            newPrice.add(new Price(9, "1234567", 2, 1, dateFormat.parse("22.04.1990 20:00:00"), dateFormat.parse("22.07.1990 20:00:00"), 300));
            newPrice.add(new Price(10, "1234567", 2, 1, dateFormat.parse("22.06.1990 20:00:00"), dateFormat.parse("22.08.1991 20:00:00"), 500));
            newPrice.add(new Price(11, "66556", 2, 1, dateFormat.parse("22.08.1990 20:00:00"), dateFormat.parse("22.10.1991 20:00:00"), 500));
            newPrice.add(new Price(11, "7777712", 3, 1, dateFormat.parse("22.02.1990 20:00:00"), dateFormat.parse("22.10.1991 20:00:00"), 500));
        }catch (ParseException e)
        {
            e.printStackTrace();
        }

    }

    @Test
    public void getSortingPrice() throws Exception {

        List<Price> result = sortingPrice.getSortingPrice(list, newPrice);
        for (Price price : result)
            System.out.println(price);
    }

}