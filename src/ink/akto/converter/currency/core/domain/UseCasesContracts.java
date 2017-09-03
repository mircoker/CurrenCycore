package ink.akto.converter.currency.core.domain;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Ruben on 30.08.2017.
 */
public interface UseCasesContracts
{
    interface IUseCase {}

    interface IValutaConvertionUseCase<VALUTA_TYPE> extends IUseCase
    {
        double convertValuta(double number, @NotNull VALUTA_TYPE from, @NotNull VALUTA_TYPE to);
    }

}
