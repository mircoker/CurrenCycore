package ink.akto.converter.currency.core.repo;

import ink.akto.converter.currency.core.repo.RepoContracts.ISaveStrategy;
import org.jetbrains.annotations.NotNull;

import java.io.*;

/**
 * Created by Ruben on 30.08.2017.
 */
public class SerializationSaveStrategy implements ISaveStrategy<Serializable, String>
{
    @NotNull File cashDir;

    public SerializationSaveStrategy(@NotNull File cashDir)
    {
        this.cashDir = cashDir;
    }

    @Override
    public void save(@NotNull Serializable valutas, @NotNull String identifier) throws Exception
    {
        FileOutputStream outputStream = new FileOutputStream(new File(cashDir, identifier));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(valutas);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    @NotNull
    @Override
    public Serializable restore(@NotNull String identifier) throws Exception
    {
        FileInputStream inputStream = new FileInputStream(new File(cashDir, identifier));
        ObjectInputStream objectInputStream= new ObjectInputStream(inputStream);
//        List<IValuta> valutas = (List<IValuta>) objectInputStream.readObject();
        Object valutas = objectInputStream.readObject();
        objectInputStream.close();
        return (Serializable) valutas;
    }
}
