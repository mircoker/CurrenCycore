package ink.akto.converter.currency.core;

import ink.akto.converter.currency.core.CoreContracts.IMainTreadExecutor;
import ink.akto.converter.currency.core.CoreContracts.IThreadsManager;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Ruben on 29.08.2017.
 */
public class ThreadsManager implements IThreadsManager
{
    private static final ThreadsManager instance = new ThreadsManager();

    /**
     * Use this method just for init when program starts, then use dependency injection
     * @param mainTreadExecutor
     * @return ThreadsManager
     */
    public static ThreadsManager init(@NotNull IMainTreadExecutor mainTreadExecutor)
    {
        instance.setMainThreadExecutor(mainTreadExecutor);
        return instance;
    }

    private ExecutorService executorService;
    private IMainTreadExecutor mainTreadExecutor;

    private ThreadsManager()
    {
        executorService = Executors.newFixedThreadPool(10);
    }


    @Override
    public @NotNull CoreContracts.IMainTreadExecutor getMainTreadExecutor() {
        return mainTreadExecutor;
    }

    @Override
    public void executeInDemonThread(@NotNull Runnable runnable)
    {
        executorService.execute(runnable);
    }

    @Override
    public void setMainThreadExecutor(@NotNull IMainTreadExecutor executor)
    {
        this.mainTreadExecutor = executor;
    }
}