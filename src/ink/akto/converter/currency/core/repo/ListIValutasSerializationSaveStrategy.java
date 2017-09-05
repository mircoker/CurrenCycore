package ink.akto.converter.currency.core.repo;

import ink.akto.converter.currency.core.repo.RepoContracts.ISaveStrategy;
import ink.akto.converter.currency.core.repo.RepoContracts.IValuta;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ruben on 04.09.2017.
 */
public class ListIValutasSerializationSaveStrategy implements ISaveStrategy<List<IValuta>, String>
{

    private @NotNull SerializationSaveStrategy strategy;

    public ListIValutasSerializationSaveStrategy(@NotNull SerializationSaveStrategy strategy)
    {
        this.strategy = strategy;
    }

    @Override
    public void save(@NotNull List<IValuta> object, @NotNull String s) throws Exception
    {
        strategy.save((Serializable)object, s);
    }

    @NotNull
    @Override
    public List<IValuta> restore(@NotNull String s) throws Exception {
        return (List<IValuta>) strategy.restore(s);
    }
}
