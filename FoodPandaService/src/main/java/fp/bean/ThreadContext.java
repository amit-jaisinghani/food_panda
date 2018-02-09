package fp.bean;

public class ThreadContext {

    private static ThreadLocal<Context> threadLocal = new ThreadLocal<>();

    public static Context getThreadLocalContext() {
        return threadLocal.get();
    }

    public static void setThreadLocalContext(Context context) {
        threadLocal.set(context);
    }

    public static void destroyContext(){
        threadLocal.remove();
    }

}
