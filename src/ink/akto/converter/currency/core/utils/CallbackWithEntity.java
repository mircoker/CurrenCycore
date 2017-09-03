package ink.akto.converter.currency.core.utils;

/**
 * Created by Ruben on 01.09.2017.
 */
public interface CallbackWithEntity<ENTITY>
{
    void onCallback(ENTITY entity);
}
