package ink.akto.converter.currency.core.repo.models;

import ink.akto.converter.currency.core.repo.RepoContracts.IGetCourseStrategy;
import ink.akto.converter.currency.core.repo.RepoContracts.IMainModel;
import ink.akto.converter.currency.core.repo.RepoContracts.ISaveStrategy;
import ink.akto.converter.currency.core.repo.RepoContracts.IValuta;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by Ruben on 30.08.2017.
 */
public class MainModel implements IMainModel
{
    @NotNull private IGetCourseStrategy<IValuta> getCourseStrategy;
    @NotNull private ISaveStrategy<List<IValuta>, String> saveStrategy;
    @NotNull protected String saveIdentifier;

    public MainModel(@NotNull IGetCourseStrategy<IValuta> getCourseStrategy,
                     @NotNull ISaveStrategy<List<IValuta>, String> saveStrategy)
    {
        this.getCourseStrategy = getCourseStrategy;
        this.saveStrategy = saveStrategy;
        saveIdentifier = "valutas";
    }

    @NotNull
    @Override
    public synchronized List<IValuta> updateValutasBlocking() throws Exception
    {
        List<IValuta> list;

        try
        {
            list = getCourseStrategy.getValutasBlocking();
            try
            {
                saveStrategy.save(list, saveIdentifier);
            }
                catch (Exception e)
            {
                e.printStackTrace();
            }
        }
            catch (Exception e)
        {
            e.printStackTrace();
        }

        list = saveStrategy.restore(saveIdentifier);
        return list;
    }

    @Override
    @NotNull
    public List<IValuta> getCashedValutas() throws Exception
    {
        return saveStrategy.restore(saveIdentifier);
    }
}
