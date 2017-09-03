package ink.akto.converter.currency.core.repo;

import ink.akto.converter.currency.core.repo.RepoContracts.IValuta;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Ruben on 30.08.2017.
 */
public class Valuta implements IValuta
{
    private int numCode;
    private String charCode;
    private int nominal;
    private String name;
    private double value;
    private int associatedValutaNumCode;

    public Valuta(int numCode,
                  @NotNull String charCode,
                  int nominal,
                  @NotNull String name,
                  double value,
                  @NotNull int associatedValutaNumCode)
    {
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
        this.associatedValutaNumCode = associatedValutaNumCode;
    }

    @Override
    public int getNumCode() {
        return numCode;
    }

    @Override
    public void setNumCode(int numCode) {
        this.numCode = numCode;
    }

    @NotNull
    @Override
    public String getCharCode() {
        return charCode;
    }

    @Override
    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    @Override
    public int getNominal() {
        return nominal;
    }

    @Override
    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    @NotNull
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public int getAssociatedValutaNumCode() {
        return associatedValutaNumCode;
    }

    @Override
    public void setAssociatedValutaNumCode(int associatedValuta) {
        this.associatedValutaNumCode = associatedValutaNumCode;
    }
}
