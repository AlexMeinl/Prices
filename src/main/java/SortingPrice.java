import java.util.*;
import java.util.stream.Collectors;

public class SortingPrice {

    public List<Price> getSortingPrice(Collection<Price> oldPrice, Collection<Price> newPrice)
    {
        if (oldPrice.isEmpty())
            return null;

        if (newPrice.isEmpty())
            return new ArrayList<>(oldPrice);

        List<Price> list = new ArrayList<>(oldPrice);
        List<Price> newPrices = newPrice.stream().sorted(Comparator.comparing(Price::getBegin)).collect(Collectors.toList());

        for (final Price price : newPrices)
        {
            List<Price> oldList = list.stream().filter((p) -> p.equals(price)).sorted(Comparator.comparing(Price::getBegin))
                                                                                  .collect(Collectors.toList());
            list.removeAll(oldList);

            if (oldList.isEmpty())
                list.add(price);

            for (int i = 0; i < oldList.size(); i++)
            {
                if (price.getValue() != oldList.get(i).getValue() && price.getBegin().after(oldList.get(i).getBegin()))
                {
                    if (isBetween(oldList.get(i), price))
                    {
                        Price result = new Price(oldList.get(i));
                        oldList.get(i).setEnd(price.getBegin());
                        result.setBegin(price.getEnd());
                        list.add(result);
                        list.add(oldList.get(i));
                        list.add(price);
                    }
                    else
                    {
                        if (oldList.get(i).getEnd().after(price.getBegin()))
                        {
                            oldList.get(i).setEnd(price.getBegin());
                            list.add(oldList.get(i));
                            list.add(price);
                        }
                        else {
                            list.add(oldList.get(i));
                            if (i + 1 == oldList.size())
                             list.add(price);
                        }
                    }
                }
                else {
                    Price result = new Price(oldList.get(i));
                    oldList.get(i).setEnd(price.getEnd());
                    oldList.get(i).setValue(price.getValue());
                    result.setBegin(price.getEnd());
                    list.add(oldList.get(i));
                    list.add(result);
                }
            }
        }
        return list.stream().sorted((p, p1) -> !p.equals(p1)
                            ? p.getProduct_code().compareTo(p1.getProduct_code())
                            : p.getBegin().compareTo(p1.getBegin()))
                            .collect(Collectors.toList());
    }

    private boolean isBetween(Price oldPrice, Price newPrice)
    {
         return newPrice.getBegin().after(oldPrice.getBegin()) && newPrice.getEnd().before(oldPrice.getEnd());
    }
}
