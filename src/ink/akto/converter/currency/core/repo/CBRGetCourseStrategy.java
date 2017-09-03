package ink.akto.converter.currency.core.repo;

import ink.akto.converter.currency.core.repo.RepoContracts.ICBRValute;
import ink.akto.converter.currency.core.repo.RepoContracts.IGetCourseStrategy;
import ink.akto.converter.currency.core.repo.RepoContracts.IValuta;
import org.jetbrains.annotations.NotNull;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Ruben on 29.08.2017.
 */
public class CBRGetCourseStrategy implements IGetCourseStrategy<IValuta>
{
    private static volatile IValuta mainValuta = new Valuta(643, "RUB",
            1, "Русский рубль", 1, 643);

    @NotNull
    @Override
    public synchronized List<IValuta> getValutasBlocking() throws Exception
    {
        URL url = new URL("http://www.cbr.ru/scripts/XML_daily.asp");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        Serializer serializer = new Persister();
        CBRValutasList valutaList = serializer.read(CBRValutasList.class, urlConnection.getInputStream());

        NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);

        ArrayList<IValuta> list = new ArrayList<>();
        for (int i = 0; i < valutaList.getValutas().size(); i++)
        {
            ICBRValute valute = valutaList.getValutas().get(i);
            IValuta newValuta = new Valuta(valute.getNumCode(), valute.getCharCode(),
                    valute.getNominal(), valute.getName(), format.parse(valute.getValue()).doubleValue(),
                    getMainValuta().getNumCode());
            list.add(newValuta);
        }
        list.add(mainValuta);

        return list;
    }

    @NotNull
    @Override
    public IValuta getMainValuta()
    {
        return mainValuta;
    }
}