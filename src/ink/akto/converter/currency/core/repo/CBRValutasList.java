package ink.akto.converter.currency.core.repo;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Ruben on 25.08.2017.
 */
@Root(name = "ValCurs")
public class CBRValutasList
{
    @Attribute(name = "Date") private String date;
    @Attribute(name = "name") private String name;

    @ElementList(entry="Valute", inline=true/*, required=false*/)
    private List<CBRValute> valutas;

    public List<CBRValute> getValutas() {
        return valutas;
    }

    public void setValutas(List<CBRValute> valutas) {
        this.valutas = valutas;
    }
}