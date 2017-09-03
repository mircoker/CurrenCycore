package ink.akto.converter.currency.core.repo.models;

import ink.akto.converter.currency.core.repo.RepoContracts;
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
    @NotNull private RepoContracts.IRuntimeCashStrategy<List<IValuta>, String> runtimeCashStrategy;
    @NotNull protected String saveIdentifier;

    public MainModel(@NotNull IGetCourseStrategy<IValuta> getCourseStrategy,
                     @NotNull ISaveStrategy<List<IValuta>, String> saveStrategy,
                     @NotNull RepoContracts.IRuntimeCashStrategy<List<IValuta>, String> cashStrategy)
    {
        this.getCourseStrategy = getCourseStrategy;
        this.saveStrategy = saveStrategy;
        this.runtimeCashStrategy = cashStrategy;
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
        runtimeCashStrategy.save(list, saveIdentifier);
        return list;
    }

    @Override
    public @NotNull List<IValuta> getRuntimeCashingValutas() {
        return runtimeCashStrategy.restore(saveIdentifier);
    }
}
