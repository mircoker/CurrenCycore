package ink.akto.converter.currency.core.repo.models;

import ink.akto.converter.currency.core.repo.RepoContracts;
import ink.akto.converter.currency.core.repo.RepoContracts.IValuta;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

/**
 * Created by Ruben on 03.09.2017.
 */
public class ValutasRuntimeCashStrategy implements RepoContracts.IRuntimeCashStrategy<List<IValuta>, String>
{
    @NotNull private Map<String, List<IValuta>> valutas;

    public ValutasRuntimeCashStrategy(@NotNull Map<String, List<IValuta>> valutas) {
        this.valutas = valutas;
    }

    @Override
    public void save(@NotNull List<IValuta> object, @NotNull String s)
    {
        valutas.put(s, object);
    }

    @NotNull
    @Override
    public List<IValuta> restore(@NotNull String s)
    {
        return valutas.get(s);
    }
}
