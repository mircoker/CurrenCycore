package ink.akto.converter.currency.core.repo;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ruben on 30.08.2017.
 */
public interface RepoContracts
{
    interface IMVPModel{}
    interface IStrategy {}

    interface IMainModel extends IMVPModel
    {
        @NotNull List<IValuta> updateValutasBlocking() throws Exception;
        @NotNull List<IValuta> getCashedValutas() throws Exception;
    }

    interface IGetCourseStrategy<VALUTA_TYPE> extends IStrategy
    {
        @NotNull List<VALUTA_TYPE> getValutasBlocking() throws Exception;
        @NotNull VALUTA_TYPE getMainValuta();
    }

    interface ISaveStrategy<TYPE, IDENTIFIER> extends IStrategy
    {
        void save(@NotNull TYPE object, @NotNull IDENTIFIER identifier) throws Exception;
        @NotNull TYPE restore(@NotNull IDENTIFIER identifier) throws Exception;
    }

    interface IRuntimeCashStrategy<TYPE, IDENTIFIER> extends IStrategy
    {
        void save(@NotNull TYPE object, @NotNull IDENTIFIER identifier);
        @NotNull TYPE restore(@NotNull IDENTIFIER identifier);
    }


    interface ICBRValute extends Serializable
    {
        String getId();
        void setId(String id);
        int getNumCode();
        void setNumCode(int numCode);
        String getCharCode();
        void setCharCode(String charCode);
        int getNominal();
        void setNominal(int nominal);
        String getName();
        void setName(String name);
        String getValue();
        void setValue(String value);
    }

    interface IValuta extends Serializable
    {
        int getNumCode();
        void setNumCode(int numCode);
        @NotNull String getCharCode();
        void setCharCode(@NotNull String charCode);
        int getNominal();
        void setNominal(int nominal);
        @NotNull String getName();
        void setName(@NotNull String name);
        double getValue();
        void setValue(double value);
        int getAssociatedValutaNumCode();
        void setAssociatedValutaNumCode(int code);
    }
}