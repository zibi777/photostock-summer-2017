package pl.com.bottega.photostock.sales.infrastructure;

import pl.com.bottega.photostock.sales.model.Picture;
import pl.com.bottega.photostock.sales.model.Money;
import pl.com.bottega.photostock.sales.model.PictureRepository;

import java.util.*;


/**
 * Created by zbyszek on 2017-08-20.
 */
public class InMemoryPictureRepository implements PictureRepository {

    private static final Map<Long, Picture> REPO = new HashMap<>();
    //statyczny blok inicjalizujący:
    static {
        Set<String> tags = new HashSet<>();
        tags.add("kotki");
        Picture picture1 = new Picture(1L,Money.valueOf(10), true, tags);
        Picture picture2 = new Picture(2L, Money.valueOf(5), true, tags);
        Picture picture3 = new Picture(3L, Money.valueOf(15), true, tags);
        REPO.put(1L, picture1);
        REPO.put(2L, picture2);
        REPO.put(3L, picture3);

    }

    @Override
    public Picture get(Long number) {
        if (!REPO.containsKey(number))
            throw new IllegalArgumentException("No such object in repository");
        return REPO.get(number);
    }

    @Override
    public Optional<Picture> getOpiontal(Long number) {
       if (REPO.containsKey(number))
           return Optional.of(REPO.get(number));
       else
           return Optional.empty();
     }

    @Override
    public void save(Picture picture) {
        REPO.put(picture.getNumber(), picture);

    }


}
