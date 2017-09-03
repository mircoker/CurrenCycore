package ink.akto.converter.currency.core.repo;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Ruben on 25.08.2017.
 */
@Root(name = "Valute")
class CBRValute implements RepoContracts.ICBRValute
{
    @Attribute (name = "ID") private String id;
    @Element(name = "NumCode") private int numCode;
    @Element(name = "CharCode") private String charCode;
    @Element(name = "Nominal") private int nominal;
    @Element(name = "Name") private String name;
    @Element(name = "Value") private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumCode() {
        return numCode;
    }

    public void setNumCode(int numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
