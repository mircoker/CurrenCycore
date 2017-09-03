package ink.akto.converter.currency.core;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Ruben on 25.08.2017.
 */
public interface CoreContracts
{
    interface IManager{}

    interface IThreadsManager extends IManager
    {
        @NotNull IMainTreadExecutor getMainTreadExecutor();
        void executeInDemonThread(@NotNull Runnable runnable);
        void setMainThreadExecutor(@NotNull IMainTreadExecutor executor);
    }

    interface IMainTreadExecutor
    {
        void execute(@NotNull Runnable runnable);
        void executeDelayed(@NotNull Runnable runnable, long ms);
    }

    interface ICoreLibVersion
    {
        @NotNull String getVersion();
    }
}
