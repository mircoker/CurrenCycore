package ink.akto.converter.currency.core.domain.usecases;

import ink.akto.converter.currency.core.domain.UseCasesContracts;
import ink.akto.converter.currency.core.repo.RepoContracts.IValuta;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Ruben on 30.08.2017.
 */
public class DefaultMainUseCase implements UseCasesContracts.IValutaConvertionUseCase<IValuta>
{
    @Override
    public double convertValuta(double number, @NotNull IValuta from, @NotNull IValuta to)
    {
        return ((to.getNominal()/to.getValue()) / (from.getNominal()/from.getValue())) * number;
    }
}
