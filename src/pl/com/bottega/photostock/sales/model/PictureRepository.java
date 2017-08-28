package pl.com.bottega.photostock.sales.model;

import java.util.Optional;

/**
 * Created by zbyszek on 2017-08-20.
 */
public interface PictureRepository {
    //pobiera obiekt po identyfikatorze
    Picture get(Long number);

    Optional<Picture> getOpiontal (Long number);

    //zapis nowego lub aktualizacja istniejącego obiektu
    void save (Picture picture);



}
